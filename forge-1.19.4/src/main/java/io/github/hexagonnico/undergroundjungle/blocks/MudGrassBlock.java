package io.github.hexagonnico.undergroundjungle.blocks;

import io.github.hexagonnico.undergroundjungle.UndergroundJungleBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.SnowLayerBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.lighting.LayerLightEngine;
import org.jetbrains.annotations.NotNull;

public class MudGrassBlock extends Block implements BonemealableBlock {

    private final ResourceKey<ConfiguredFeature<?, ?>> bonemealFeature;

    public MudGrassBlock(Properties properties, ResourceKey<ConfiguredFeature<?, ?>> bonemealFeature) {
        super(properties);
        this.bonemealFeature = bonemealFeature;
    }

    @Override
    @SuppressWarnings("deprecation")
    public void randomTick(@NotNull BlockState currentState, ServerLevel world, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if(world.isAreaLoaded(pos, 3)) {
            if(world.getMaxLocalRawBrightness(pos.above()) >= 9) {
                BlockState defaultState = this.defaultBlockState();
                for(int i = 0; i < 4; i++) {
                    BlockPos nextPos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                    if(world.getBlockState(nextPos).is(Blocks.MUD) && canPropagate(defaultState, world, nextPos)) {
                        world.setBlockAndUpdate(nextPos, defaultState);
                    }
                }
            }
            if(!canBeGrass(currentState, world, pos)) {
                world.setBlockAndUpdate(pos, Blocks.MUD.defaultBlockState());
            }
        }
    }

    private static boolean canPropagate(BlockState blockState, LevelReader world, BlockPos pos) {
        return canBeGrass(blockState, world, pos) && !world.getFluidState(pos.above()).is(FluidTags.WATER);
    }

    private static boolean canBeGrass(BlockState blockState, LevelReader world, BlockPos pos) {
        BlockPos posAbove = pos.above();
        BlockState blockStateAbove = world.getBlockState(posAbove);
        if (blockStateAbove.is(Blocks.SNOW) && blockStateAbove.getValue(SnowLayerBlock.LAYERS) == 1) {
            return true;
        } else if (blockStateAbove.getFluidState().getAmount() == 8) {
            return false;
        } else {
            return LayerLightEngine.getLightBlockInto(world, blockState, pos, blockStateAbove, posAbove, Direction.UP, blockStateAbove.getLightBlock(world, posAbove)) < world.getMaxLightLevel();
        }
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader world, BlockPos pos, @NotNull BlockState state, boolean bool) {
        return world.getBlockState(pos.above()).isAir();
    }

    @Override
    public boolean isBonemealSuccess(@NotNull Level world, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        return true;
    }

    @Override
    public void performBonemeal(@NotNull ServerLevel world, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        Registry<ConfiguredFeature<?, ?>> registry = world.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE);
        ChunkGenerator chunkGenerator = world.getChunkSource().getGenerator();
        for(int x = -3; x <= 3; x++) {
            for(int y = -1; y <= 1; y++) {
                for(int z = -3; z <= 3; z++) {
                    BlockPos offsetPos = pos.offset(x, y, z);
                    if(random.nextBoolean() && world.getBlockState(offsetPos).is(BlockTags.DIRT) && world.getBlockState(offsetPos.above()).isAir()) {
                        registry.getHolder(this.bonemealFeature).ifPresent(feature -> feature.value().place(world, chunkGenerator, random, offsetPos.above()));
                    }
                }
            }
        }
    }
}
