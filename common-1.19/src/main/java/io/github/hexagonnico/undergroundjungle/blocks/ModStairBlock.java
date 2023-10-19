package io.github.hexagonnico.undergroundjungle.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModStairBlock extends StairBlock {

    public ModStairBlock(Block referenceBlock) {
        super(referenceBlock.defaultBlockState(), BlockBehaviour.Properties.copy(referenceBlock));
    }
}
