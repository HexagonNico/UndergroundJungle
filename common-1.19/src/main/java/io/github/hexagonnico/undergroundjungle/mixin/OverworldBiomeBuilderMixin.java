package io.github.hexagonnico.undergroundjungle.mixin;

import com.mojang.datafixers.util.Pair;
import io.github.hexagonnico.undergroundjungle.PlatformHelper;
import io.github.hexagonnico.undergroundjungle.worldgen.UndergroundJungleClimate;
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

/**
 * Mixin class for {@link OverworldBiomeBuilder}.
 * Used to make the underground jungle biome generate in the overworld.
 *
 * @author Nico
 */
@Mixin(OverworldBiomeBuilder.class)
@SuppressWarnings("unused")
public class OverworldBiomeBuilderMixin {

    /**
     * Adds the underground jungle biome to the overworld biome manager.
     *
     * @param consumer Climate parameters and biome key consumer
     * @param ci Mixin callback info
     */
    @Inject(at = @At("RETURN"), method = "addUndergroundBiomes")
    public void addUndergroundBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, CallbackInfo ci) {
        if(!PlatformHelper.isModLoaded("terrablender")) {
            ResourceKey<Biome> undergroundJungleKey = ResourceKey.create(Registries.BIOME, new ResourceLocation("underground_jungle", "underground_jungle"));
            Climate.ParameterPoint undergroundJungleClimate = Climate.parameters(
                UndergroundJungleClimate.TEMPERATURE,
                UndergroundJungleClimate.HUMIDITY,
                UndergroundJungleClimate.CONTINENTALNESS,
                UndergroundJungleClimate.EROSION,
                UndergroundJungleClimate.DEPTH,
                UndergroundJungleClimate.WEIRDNESS,
                0.0f
            );
            consumer.accept(Pair.of(undergroundJungleClimate, undergroundJungleKey));
        }
    }
}