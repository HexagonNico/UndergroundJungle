package io.github.hexagonnico.undergroundjungle.blocks;

import com.mojang.serialization.MapCodec;
import io.github.hexagonnico.undergroundjungle.UndergroundJungle;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/**
 * Block representing the tip of jungle vines.
 *
 * @author Nico
 */
public class JungleVinesBlock extends GrowingPlantHeadBlock {

    public static final MapCodec<JungleVinesBlock> CODEC = simpleCodec(JungleVinesBlock::new);

    /**
     * Constructs a jungle vines block.
     *
     * @param properties Block behaviour properties
     */
    public JungleVinesBlock(Properties properties) {
        super(properties, Direction.DOWN, CaveVines.SHAPE, false, 0.1);
    }

    @Override
    protected @NotNull MapCodec<? extends GrowingPlantHeadBlock> codec() {
        return CODEC;
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
        return UndergroundJungle.JUNGLE_VINES_PLANT.get();
    }
}