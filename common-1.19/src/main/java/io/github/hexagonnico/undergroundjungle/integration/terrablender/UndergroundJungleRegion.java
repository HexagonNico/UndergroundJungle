package io.github.hexagonnico.undergroundjungle.integration.terrablender;

import com.mojang.datafixers.util.Pair;
import io.github.hexagonnico.undergroundjungle.worldgen.UndergroundJungleClimate;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;
import terrablender.api.Region;
import terrablender.api.RegionType;
import terrablender.api.VanillaParameterOverlayBuilder;

import java.util.function.Consumer;

public class UndergroundJungleRegion extends Region {

    private static final ResourceKey<Biome> UNDERGROUND_JUNGLE_BIOME = ResourceKey.create(Registries.BIOME, new ResourceLocation("underground_jungle", "underground_jungle"));

    public UndergroundJungleRegion() {
        super(new ResourceLocation("underground_jungle", "region"), RegionType.OVERWORLD, 1);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        VanillaParameterOverlayBuilder vanillaParameterOverlayBuilder = new VanillaParameterOverlayBuilder();
        new ParameterUtils.ParameterPointListBuilder()
            .temperature(UndergroundJungleClimate.TEMPERATURE)
            .humidity(UndergroundJungleClimate.HUMIDITY)
            .continentalness(UndergroundJungleClimate.CONTINENTALNESS)
            .erosion(UndergroundJungleClimate.EROSION)
            .depth(UndergroundJungleClimate.DEPTH)
            .weirdness(UndergroundJungleClimate.WEIRDNESS)
            .build().forEach(point -> vanillaParameterOverlayBuilder.add(point, UNDERGROUND_JUNGLE_BIOME));
        vanillaParameterOverlayBuilder.build().forEach(mapper);
    }
}
