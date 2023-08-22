package io.github.hexagonnico.undergroundjungle.blocks;

import io.github.hexagonnico.undergroundjungle.UndergroundJungleBlocks;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import org.jetbrains.annotations.NotNull;

public class JungleVinesPlantBlock extends GrowingPlantBodyBlock {

    private final JungleVinesBlock.Type type;

    public JungleVinesPlantBlock(Properties properties, JungleVinesBlock.Type type) {
        super(properties, Direction.DOWN, CaveVines.SHAPE, false);
        this.type = type;
    }

    @Override
    protected @NotNull GrowingPlantHeadBlock getHeadBlock() {
        return switch (this.type) {
            case REGULAR -> (GrowingPlantHeadBlock) UndergroundJungleBlocks.JUNGLE_VINES.get();
            case MUSHROOM -> (GrowingPlantHeadBlock) UndergroundJungleBlocks.MUSHROOM_VINES.get();
        };
    }
}
