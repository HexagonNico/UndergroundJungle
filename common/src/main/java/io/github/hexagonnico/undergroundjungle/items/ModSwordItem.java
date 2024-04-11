package io.github.hexagonnico.undergroundjungle.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModSwordItem extends SwordItem {

    public ModSwordItem(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack item, @Nullable Level world, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        tooltip.add(1, Component.translatable("description.underground_jungle.blade_of_the_jungle").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(item, world, tooltip, flag);
    }

    @Override
    public boolean hurtEnemy(@NotNull ItemStack item, @NotNull LivingEntity target, @NotNull LivingEntity player) {
        if(player.level().getRandom().nextFloat() < 0.1f) {
            target.addEffect(new MobEffectInstance(MobEffects.POISON, 240, 0));
        }
        return super.hurtEnemy(item, target, player);
    }
}
