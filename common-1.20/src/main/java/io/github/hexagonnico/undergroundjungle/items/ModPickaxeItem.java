package io.github.hexagonnico.undergroundjungle.items;

import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

/**
 * Mod pickaxe class.
 * This class is only needed because the constructor in {@link PickaxeItem} has protected access for no reason.
 *
 * @author Nico
 */
public class ModPickaxeItem extends PickaxeItem {

    /**
     * Constructs a pickaxe.
     *
     * @param tier Tool tier
     * @param baseDamage Base attack damage
     * @param baseSpeed Base attack speed
     * @param properties Item properties
     */
    public ModPickaxeItem(Tier tier, int baseDamage, float baseSpeed, Properties properties) {
        super(tier, baseDamage, baseSpeed, properties);
    }
}
