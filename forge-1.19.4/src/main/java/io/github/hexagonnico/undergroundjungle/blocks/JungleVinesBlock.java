package io.github.hexagonnico.undergroundjungle.blocks;

import io.github.hexagonnico.undergroundjungle.UndergroundJungleBlocks;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class JungleVinesBlock extends GrowingPlantHeadBlock {

    private final Type type;

    public JungleVinesBlock(Properties properties, Type type) {
        super(properties, Direction.DOWN, CaveVines.SHAPE, false, 0.1);
        this.type = type;
    }

    @Override
    protected int getBlocksToGrowWhenBonemealed(@NotNull RandomSource random) {
        return 1;
    }

    @Override
    protected boolean canGrowInto(BlockState blockState) {
        return blockState.isAir();
    }

    @Override
    protected @NotNull Block getBodyBlock() {
        return switch (this.type) {
            case REGULAR -> UndergroundJungleBlocks.JUNGLE_VINES_PLANT.get();
            case MUSHROOM -> UndergroundJungleBlocks.MUSHROOM_VINES_PLANT.get();
        };
    }

    public enum Type {
        REGULAR,
        MUSHROOM
    }
}