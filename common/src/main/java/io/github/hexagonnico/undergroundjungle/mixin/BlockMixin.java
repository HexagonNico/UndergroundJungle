package io.github.hexagonnico.undergroundjungle.mixin;

import io.github.hexagonnico.undergroundjungle.UndergroundJungle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Block.class)
@SuppressWarnings("unused")
public class BlockMixin {

    @Inject(at = @At("HEAD"), method = "playerDestroy", cancellable = true)
    public void playerDestroy(Level world, Player player, BlockPos pos, BlockState block, BlockEntity entity, ItemStack item, CallbackInfo callbackInfo) {
        if(item.is(UndergroundJungle.AXE_OF_REGROWTH.get()) && this.isValidLog(block) && world.getBlockState(pos.below()).is(BlockTags.DIRT)) {
            ResourceLocation saplingKey = new ResourceLocation(BuiltInRegistries.BLOCK.getKey(block.getBlock()).toString().replace("log", "sapling"));
            if(BuiltInRegistries.BLOCK.containsKey(saplingKey)) {
                world.setBlockAndUpdate(pos, BuiltInRegistries.BLOCK.get(saplingKey).defaultBlockState());
                world.playSound(null, pos, SoundEvents.BONE_MEAL_USE, SoundSource.BLOCKS, 1.0f, 1.0f);
            }
        }
    }

    private boolean isValidLog(BlockState block) {
        return block.is(BlockTags.LOGS)
            && block.hasProperty(RotatedPillarBlock.AXIS)
            && block.getValue(RotatedPillarBlock.AXIS).equals(Direction.Axis.Y);
    }
}
