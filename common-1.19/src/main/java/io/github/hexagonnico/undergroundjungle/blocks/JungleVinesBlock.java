package io.github.hexagonnico.undergroundjungle.blocks;

import io.github.hexagonnico.undergroundjungle.RegistryManager;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class JungleVinesBlock extends GrowingPlantHeadBlock {

    public JungleVinesBlock(Properties properties) {
        super(properties, Direction.DOWN, CaveVines.SHAPE, false, 0.1);
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
        return RegistryManager.JUNGLE_VINES_PLANT.get();
    }
}