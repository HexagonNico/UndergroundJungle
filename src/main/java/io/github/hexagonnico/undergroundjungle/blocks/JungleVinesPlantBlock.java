package io.github.hexagonnico.undergroundjungle.blocks;

import io.github.hexagonnico.undergroundjungle.UndergroundJungleBlocks;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import org.jetbrains.annotations.NotNull;

public class JungleVinesPlantBlock extends GrowingPlantBodyBlock {

    public JungleVinesPlantBlock(Properties properties) {
        super(properties, Direction.DOWN, CaveVines.SHAPE, false);
    }

    @Override
    protected @NotNull GrowingPlantHeadBlock getHeadBlock() {
        return (GrowingPlantHeadBlock) UndergroundJungleBlocks.JUNGLE_VINES.get();
    }
}
