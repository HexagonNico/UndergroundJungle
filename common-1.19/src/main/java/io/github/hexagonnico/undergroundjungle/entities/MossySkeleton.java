package io.github.hexagonnico.undergroundjungle.entities;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class MossySkeleton extends Skeleton {

    public static AttributeSupplier.Builder attributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 20.0)
            .add(Attributes.FOLLOW_RANGE, 32.0)
            .add(Attributes.MOVEMENT_SPEED, 0.25)
            .add(Attributes.ATTACK_DAMAGE, 3.0)
            .add(Attributes.KNOCKBACK_RESISTANCE, 0.0)
            .add(Attributes.ARMOR, 0.0)
            .add(Attributes.SPAWN_REINFORCEMENTS_CHANCE, 0.0);
    }

    public MossySkeleton(EntityType<? extends Skeleton> type, Level world) {
        super(type, world);
    }

    @Override
    public boolean isFreezeConverting() {
        return false;
    }

    @Override
    public boolean canBeAffected(MobEffectInstance effect) {
        if(effect.getEffect().equals(MobEffects.POISON)) {
            return false;
        }
        return super.canBeAffected(effect);
    }

    @Override
    protected @NotNull AbstractArrow getArrow(@NotNull ItemStack itemStack, float f) {
        AbstractArrow abstractArrow = super.getArrow(itemStack, f);
        if(abstractArrow instanceof Arrow arrow) {
            arrow.addEffect(new MobEffectInstance(MobEffects.POISON, 120));
        }
        return abstractArrow;
    }
}
