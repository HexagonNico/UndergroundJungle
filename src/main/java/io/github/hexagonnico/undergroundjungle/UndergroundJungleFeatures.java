package io.github.hexagonnico.undergroundjungle;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class UndergroundJungleFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> JUNGLE_VEGETATION = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(UndergroundJungleMod.ID, "jungle_vegetation"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> HUGE_GLOWING_MUSHROOM = ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(UndergroundJungleMod.ID, "huge_glowing_mushroom"));
}
