package io.github.hexagonnico.undergroundjungle.forge.mixin;

import io.github.hexagonnico.undergroundjungle.blocks.TempleChestBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

/**
 * Mixin class needed to override forge's {@link BlockEntity#getCapability(Capability, Direction)} method.
 * Prevents the temple chest from interacting with hoppers.
 *
 * @author Nico
 */
@Mixin(TempleChestBlockEntity.class)
@SuppressWarnings("unused")
public class TempleChestBlockEntityMixin extends BlockEntity {

    /**
     * Override constructor.
     *
     * @param blockEntityType Block entity type
     * @param blockPos Block pos
     * @param blockState Block state
     */
    public TempleChestBlockEntityMixin(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        return LazyOptional.empty();
    }
}
