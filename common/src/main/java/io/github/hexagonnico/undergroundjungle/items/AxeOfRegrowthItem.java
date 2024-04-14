package io.github.hexagonnico.undergroundjungle.items;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class AxeOfRegrowthItem extends ModAxeItem {

    public AxeOfRegrowthItem(Tier tier, float baseDamage, float baseSpeed, Properties properties) {
        super(tier, baseDamage, baseSpeed, properties);
    }

    @Override
    public void appendHoverText(@NotNull ItemStack item, @Nullable Level world, @NotNull List<Component> tooltip, @NotNull TooltipFlag flag) {
        tooltip.add(1, Component.translatable("description.underground_jungle.axe_of_regrowth").withStyle(ChatFormatting.GRAY));
        super.appendHoverText(item, world, tooltip, flag);
    }
}
