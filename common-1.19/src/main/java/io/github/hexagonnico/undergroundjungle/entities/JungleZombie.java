package io.github.hexagonnico.undergroundjungle.entities;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/**
 * Jungle zombie entity extending the default zombie.
 *
 * @author Nico
 */
public class JungleZombie extends Zombie {

    /**
     * Constructs the entity.
     *
     * @param type Entity type
     * @param world World
     */
    public JungleZombie(EntityType<? extends Zombie> type, Level world) {
        super(type, world);
    }

    @Override
    public boolean canBeAffected(MobEffectInstance effect) {
        if(effect.getEffect().equals(MobEffects.POISON)) {
            return false;
        }
        return super.canBeAffected(effect);
    }

    @Override
    public boolean doHurtTarget(@NotNull Entity target) {
        boolean flag = super.doHurtTarget(target);
        if(flag && this.getRandom().nextFloat() < 0.2f && this.getMainHandItem().isEmpty() && target instanceof LivingEntity livingEntity) {
            livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 60), this);
        }
        return flag;
    }

    @Override
    protected @NotNull ItemStack getSkull() {
        return ItemStack.EMPTY;
    }
}
