package io.github.hexagonnico.undergroundjungle.mixin;

import io.github.hexagonnico.undergroundjungle.UndergroundJungle;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.item.ItemEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Mixin class for {@link ItemEntity}.
 * Used to make temple tools blast proof.
 *
 * @author Nico
 */
@Mixin(ItemEntity.class)
@SuppressWarnings("unused")
public class ItemEntityMixin {

    /**
     * Returns false if the damage source is {@link DamageTypeTags#IS_EXPLOSION} and the item is a temple tool.
     *
     * @param damageSource Damage source
     * @param damage Damage amount
     * @param callbackInfo Mixin callback info
     */
    @SuppressWarnings("ConstantConditions")
    @Inject(at = @At("HEAD"), method = "hurt", cancellable = true)
    public void hurt(DamageSource damageSource, float damage, CallbackInfoReturnable<Boolean> callbackInfo) {
        if((Object) this instanceof ItemEntity itemEntity) {
            if(!itemEntity.getItem().isEmpty() && (
                itemEntity.getItem().is(UndergroundJungle.TEMPLE_PICKAXE.get()) ||
                    itemEntity.getItem().is(UndergroundJungle.TEMPLE_SWORD.get()) ||
                    itemEntity.getItem().is(UndergroundJungle.TEMPLE_AXE.get()) ||
                    itemEntity.getItem().is(UndergroundJungle.TEMPLE_SHOVEL.get()) ||
                    itemEntity.getItem().is(UndergroundJungle.TEMPLE_HOE.get())
            ) && damageSource.is(DamageTypeTags.IS_EXPLOSION)) {
                callbackInfo.setReturnValue(false);
            }
        }
    }
}