package io.github.hexagonnico.undergroundjungle.items;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;

/**
 * Mod hoe class.
 * This class is only needed because the constructor in {@link AxeItem} has protected access for no reason.
 *
 * @author Nico
 */
public class ModHoeItem extends HoeItem {

    /**
     * Constructs a hoe.
     *
     * @param tier Tool tier
     * @param baseDamage Base attack damage
     * @param baseSpeed Base attack speed
     * @param properties Item properties
     */
    public ModHoeItem(Tier tier, int baseDamage, float baseSpeed, Properties properties) {
        super(tier, baseDamage, baseSpeed, properties);
    }
}
