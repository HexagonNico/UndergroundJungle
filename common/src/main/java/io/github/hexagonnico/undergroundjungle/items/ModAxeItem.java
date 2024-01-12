package io.github.hexagonnico.undergroundjungle.items;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;

/**
 * Mod axe class.
 * This class is only needed because the constructor in {@link AxeItem} has protected access for no reason.
 *
 * @author Nico
 */
public class ModAxeItem extends AxeItem {

    /**
     * Constructs an axe.
     *
     * @param tier Tool tier
     * @param baseDamage Base attack damage
     * @param baseSpeed Base attack speed
     * @param properties Item properties
     */
    public ModAxeItem(Tier tier, float baseDamage, float baseSpeed, Properties properties) {
        super(tier, baseDamage, baseSpeed, properties);
    }
}
