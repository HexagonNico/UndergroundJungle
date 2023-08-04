package io.github.hexagonnico.undergroundjungle.blocks;

import io.github.hexagonnico.undergroundjungle.UndergroundJungleBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
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
    public void performBonemeal(@NotNull ServerLevel world, RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        for(int i = 0; i < random.nextInt(16) + 16; i++) {
            BlockPos nextPos = pos.offset(random.nextInt(10) - 5, random.nextInt(5) - 3, random.nextInt(10) - 5);
            BlockState stateBelow = world.getBlockState(nextPos.below());
            if((stateBelow.is(Blocks.MUD) || stateBelow.is(UndergroundJungleBlocks.JUNGLE_GRASS.get())) && world.getBlockState(nextPos).isAir()) {
                int choice = random.nextInt(4);
                if(choice == 0) {
                    world.setBlockAndUpdate(nextPos, Blocks.TALL_GRASS.defaultBlockState());
                    world.setBlockAndUpdate(nextPos.above(), Blocks.TALL_GRASS.defaultBlockState().setValue(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER));
                } else if(choice == 1) {
                    world.setBlockAndUpdate(nextPos, Blocks.LARGE_FERN.defaultBlockState());
                    world.setBlockAndUpdate(nextPos.above(), Blocks.LARGE_FERN.defaultBlockState().setValue(DoublePlantBlock.HALF, DoubleBlockHalf.UPPER));
                } else if(choice == 2) {
                    world.setBlockAndUpdate(nextPos, Blocks.FERN.defaultBlockState());
                } else {
                    world.setBlockAndUpdate(nextPos, Blocks.GRASS.defaultBlockState());
                }
            }
        }
    }
}
