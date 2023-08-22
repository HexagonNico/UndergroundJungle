package io.github.hexagonnico.undergroundjungle.entities;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class SporesZombie extends Zombie {

    public SporesZombie(EntityType<? extends Zombie> type, Level world) {
        super(type, world);
    }

    @Override
    public boolean doHurtTarget(@NotNull Entity target) {
        boolean flag = super.doHurtTarget(target);
        if(flag && this.getLevel().getRandom().nextFloat() < 0.2f && this.getMainHandItem().isEmpty() && target instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 60), this);
        }
        return flag;
    }
}
