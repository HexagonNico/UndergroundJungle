package io.github.hexagonnico.undergroundjungle.mixin;

import com.mojang.datafixers.util.Pair;
import io.github.hexagonnico.undergroundjungle.UndergroundJungleMod;
import io.github.hexagonnico.undergroundjungle.util.ClimateParameters;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.biome.OverworldBiomeBuilder;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Consumer;

@SuppressWarnings("unused")
@Mixin(OverworldBiomeBuilder.class)
public class OverworldBiomeBuilderMixin {

    @Inject(at = @At("RETURN"), method = "addUndergroundBiomes")
    public void addUndergroundBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, CallbackInfo ci) {
        ResourceKey<Biome> undergroundJungleKey = ResourceKey.create(Registries.BIOME, new ResourceLocation(UndergroundJungleMod.ID, "underground_jungle"));
        Climate.ParameterPoint undergroundJungleClimate = Climate.parameters(
            Climate.Parameter.span(ClimateParameters.UNDERGROUND_JUNGLE_TEMPERATURE_MIN, ClimateParameters.UNDERGROUND_JUNGLE_TEMPERATURE_MAX),
            Climate.Parameter.span(ClimateParameters.UNDERGROUND_JUNGLE_HUMIDITY_MIN, ClimateParameters.UNDERGROUND_JUNGLE_HUMIDITY_MAX),
            Climate.Parameter.span(ClimateParameters.UNDERGROUND_JUNGLE_CONTINENTALNESS_MIN, ClimateParameters.UNDERGROUND_JUNGLE_CONTINENTALNESS_MAX),
            Climate.Parameter.span(ClimateParameters.UNDERGROUND_JUNGLE_EROSION_MIN, ClimateParameters.UNDERGROUND_JUNGLE_EROSION_MAX),
            Climate.Parameter.span(ClimateParameters.UNDERGROUND_JUNGLE_DEPTH_MIN, ClimateParameters.UNDERGROUND_JUNGLE_DEPTH_MAX),
            Climate.Parameter.span(ClimateParameters.UNDERGROUND_JUNGLE_WEIRDNESS_MIN, ClimateParameters.UNDERGROUND_JUNGLE_WEIRDNESS_MAX),
            0.0f
        );
        consumer.accept(Pair.of(undergroundJungleClimate, undergroundJungleKey));
        ResourceKey<Biome> mushroomCaveKey = ResourceKey.create(Registries.BIOME, new ResourceLocation(UndergroundJungleMod.ID, "mushroom_cave"));
        Climate.ParameterPoint mushroomCaveClimate = Climate.parameters(
            Climate.Parameter.span(ClimateParameters.MUSHROOM_CAVE_TEMPERATURE_MIN, ClimateParameters.MUSHROOM_CAVE_TEMPERATURE_MAX),
            Climate.Parameter.span(ClimateParameters.MUSHROOM_CAVE_HUMIDITY_MIN, ClimateParameters.MUSHROOM_CAVE_HUMIDITY_MAX),
            Climate.Parameter.span(ClimateParameters.MUSHROOM_CAVE_CONTINENTALNESS_MIN, ClimateParameters.MUSHROOM_CAVE_CONTINENTALNESS_MAX),
            Climate.Parameter.span(ClimateParameters.MUSHROOM_CAVE_EROSION_MIN, ClimateParameters.MUSHROOM_CAVE_EROSION_MAX),
            Climate.Parameter.span(ClimateParameters.MUSHROOM_CAVE_DEPTH_MIN, ClimateParameters.MUSHROOM_CAVE_DEPTH_MAX),
            Climate.Parameter.span(ClimateParameters.MUSHROOM_CAVE_WEIRDNESS_MIN, ClimateParameters.MUSHROOM_CAVE_WEIRDNESS_MAX),
            0.0f
        );
        consumer.accept(Pair.of(mushroomCaveClimate, mushroomCaveKey));
    }
}