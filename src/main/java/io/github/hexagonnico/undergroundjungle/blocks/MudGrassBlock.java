package io.github.hexagonnico.undergroundjungle.blocks;

import io.github.hexagonnico.undergroundjungle.UndergroundJungleBlocks;
import io.github.hexagonnico.undergroundjungle.UndergroundJungleFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import org.jetbrains.annotations.NotNull;

public class MudGrassBlock extends Block implements BonemealableBlock {

    public MudGrassBlock(Properties properties) {
        super(properties);
    }

    @Override
    @SuppressWarnings("deprecation")
    public void randomTick(@NotNull BlockState currentState, ServerLevel world, @NotNull BlockPos pos, @NotNull RandomSource random) {
        if(world.isAreaLoaded(pos, 3)) {
            if(world.getMaxLocalRawBrightness(pos.above()) >= 9) {
                BlockState defaultState = this.defaultBlockState();
                for(int i = 0; i < 4; i++) {
                    BlockPos nextPos = pos.offset(random.nextInt(3) - 1, random.nextInt(5) - 3, random.nextInt(3) - 1);
                    if(world.getBlockState(nextPos).is(Blocks.MUD) && world.getBlockState(nextPos.above()).isAir()) {
                        world.setBlockAndUpdate(nextPos, defaultState);
                    }
                }
            }
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
        BlockState blockState = world.getBlockState(pos);
        Registry<ConfiguredFeature<?, ?>> registry = world.registryAccess().registryOrThrow(Registries.CONFIGURED_FEATURE);
        if(blockState.is(UndergroundJungleBlocks.JUNGLE_GRASS.get())) {
            for(int x = -3; x <= 3; x++) {
                for(int y = -1; y <= 1; y++) {
                    for(int z = -3; z <= 3; z++) {
                        BlockPos offsetPos = pos.offset(x, y, z);
                        if(random.nextBoolean() && world.getBlockState(offsetPos).is(BlockTags.DIRT) && world.getBlockState(offsetPos.above()).isAir()) {
                            this.place(registry, UndergroundJungleFeatures.JUNGLE_VEGETATION, world, random, offsetPos.above());
                        }
                    }
                }
            }
        }
        // TODO: Else if... is mushroom grass
    }

    private void place(Registry<ConfiguredFeature<?, ?>> registry, ResourceKey<ConfiguredFeature<?, ?>> resourceKey, ServerLevel world, RandomSource random, BlockPos pos) {
        ChunkGenerator chunkGenerator = world.getChunkSource().getGenerator();
        registry.getHolder(resourceKey).ifPresent(feature -> feature.value().place(world, chunkGenerator, random, pos));
    }
}
