package io.github.hexagonnico.undergroundjungle.items;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

/**
 * Mod tool tier. Class needed to implement {@link Tier}.
 *
 * @author Nico
 */
public class ModToolTier implements Tier {

    /** Temple tools tier */
    public static final ModToolTier TEMPLE = new ModToolTier(256, 14.0f, 3.0f, 4, 20);
    /** Special jungle tools tier */
    public static final ModToolTier JUNGLE = new ModToolTier(128, 13.0f, 2.5f, 4, 12);

    /** Tool durability */
    private final int uses;
    /** Tool base mining speed */
    private final float speed;
    /** Tool base attack damage */
    private final float attackDamageBonus;
    /** Pickaxe mining level */
    private final int level;
    /** Enchantment value */
    private final int enchantmentValue;
    /** Anvil repair ingredient */
    private final Supplier<Ingredient> repairIngredient;

    /**
     * Constructs a mod tool tier.
     *
     * @param uses Tool durability
     * @param speed Tool base mining speed
     * @param attackDamageBonus Tool base attack damage
     * @param level Pickaxe mining level
     * @param enchantmentValue Enchantment value
     * @param repairIngredient Anvil repair ingredient
     */
    public ModToolTier(int uses, float speed, float attackDamageBonus, int level, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.level = level;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }

    /**
     * Constructs a mod tool tier.
     *
     * @param uses Tool durability
     * @param speed Tool base mining speed
     * @param attackDamageBonus Tool base attack damage
     * @param level Pickaxe mining level
     * @param enchantmentValue Enchantment value
     */
    public ModToolTier(int uses, float speed, float attackDamageBonus, int level, int enchantmentValue) {
        this(uses, speed, attackDamageBonus, level, enchantmentValue, () -> Ingredient.EMPTY);
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamageBonus;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
