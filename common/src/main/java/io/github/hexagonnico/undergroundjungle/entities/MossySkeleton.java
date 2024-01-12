package io.github.hexagonnico.undergroundjungle.entities;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

/**
 * Mossy skeleton entity extending the default skeleton.
 * This class cannot extend {@link net.minecraft.world.entity.monster.AbstractSkeleton} because it contains package-protected abstract methods.
 *
 * @author Nico
 */
public class MossySkeleton extends Skeleton {

    /**
     * Constructs the entity.
     *
     * @param type Entity type
     * @param world World
     */
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
