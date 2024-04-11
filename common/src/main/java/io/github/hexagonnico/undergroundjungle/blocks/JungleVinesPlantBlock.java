package io.github.hexagonnico.undergroundjungle.blocks;

import io.github.hexagonnico.undergroundjungle.UndergroundJungle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.ParticleUtils;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CaveVines;
import net.minecraft.world.level.block.GrowingPlantBodyBlock;
import net.minecraft.world.level.block.GrowingPlantHeadBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.NotNull;

import java.util.function.ToIntFunction;

/**
 * Block representing the body of jungle vines.
 *
 * @author Nico
 */
public class JungleVinesPlantBlock extends GrowingPlantBodyBlock {

    /** Spores block state property */
    private static final BooleanProperty SPORES = BooleanProperty.create("spores");

    /**
     * Constructs a jungle vines block.
     *
     * @param properties Block behaviour properties
     */
    public JungleVinesPlantBlock(Properties properties) {
        super(properties, Direction.DOWN, CaveVines.SHAPE, false);
        this.registerDefaultState(this.defaultBlockState().setValue(SPORES, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(SPORES);
    }

    @Override
    protected @NotNull GrowingPlantHeadBlock getHeadBlock() {
        return UndergroundJungle.JUNGLE_VINES.get();
    }

    @Override
    @SuppressWarnings("deprecation")
    public @NotNull InteractionResult use(@NotNull BlockState state, @NotNull Level world, @NotNull BlockPos pos, @NotNull Player player, @NotNull InteractionHand hand, @NotNull BlockHitResult result) {
        if(state.getValue(SPORES)) {
            world.playSound(null, pos, SoundEvents.CAVE_VINES_PICK_BERRIES, SoundSource.BLOCKS, 1.0f, 1.0f);
            ParticleUtils.spawnParticlesOnBlockFaces(world, pos, ParticleTypes.HAPPY_VILLAGER, UniformInt.of(-2, 2));
            state = state.setValue(SPORES, false);
            world.setBlock(pos, state, 2);
            world.gameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Context.of(player, state));
            if(world.getRandom().nextBoolean()) {
                Block.popResource(world, pos, new ItemStack(UndergroundJungle.JUNGLE_SPORES.get(), 1));
            }
            return InteractionResult.sidedSuccess(world.isClientSide());
        }
        return InteractionResult.PASS;
    }

    /**
     * Utility function used to provide the block's light level.
     *
     * @param max Light level when the vines have spores
     * @return A {@link ToIntFunction} to be used by {@link net.minecraft.world.level.block.state.BlockBehaviour.Properties#lightLevel(ToIntFunction)}
     */
    public static ToIntFunction<BlockState> lightLevel(int max) {
        return state -> state.getValue(SPORES) ? max : 0;
    }

    @Override
    public void performBonemeal(@NotNull ServerLevel world, @NotNull RandomSource random, @NotNull BlockPos pos, @NotNull BlockState state) {
        if(random.nextBoolean()) {
            world.setBlock(pos, state.setValue(SPORES, true), 2);
        }
        super.performBonemeal(world, random, pos, state);
    }
}
