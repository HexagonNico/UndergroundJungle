package io.github.hexagonnico.undergroundjungle.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

/**
 * Mod stairs class.
 * This class is only needed because the constructor in {@link StairBlock} has protected access for no reason.
 *
 * @author Nico
 */
public class ModStairBlock extends StairBlock {

    /**
     * Constructs a stair block.
     *
     * @param referenceBlock Base block for stairs
     */
    public ModStairBlock(Block referenceBlock) {
        super(referenceBlock.defaultBlockState(), BlockBehaviour.Properties.copy(referenceBlock));
    }
}
