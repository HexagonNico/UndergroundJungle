package io.github.hexagonnico.undergroundjungle.entities;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SporesSkeleton extends AbstractSkeleton {

    public SporesSkeleton(EntityType<? extends AbstractSkeleton> type, Level world) {
        super(type, world);
    }

    @Override
    protected @NotNull SoundEvent getStepSound() {
        return SoundEvents.STRAY_STEP;
    }

    @Override
    protected @NotNull AbstractArrow getArrow(@NotNull ItemStack itemStack, float f) {
        AbstractArrow abstractArrow = super.getArrow(itemStack, f);
        if(abstractArrow instanceof Arrow arrow) {
            arrow.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 100));
        }
        return abstractArrow;
    }
}
