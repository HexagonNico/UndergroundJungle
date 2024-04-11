package io.github.hexagonnico.undergroundjungle.mixin;

import com.mojang.datafixers.util.Pair;
import io.github.hexagonnico.undergroundjungle.PlatformHelper;
import io.github.hexagonnico.undergroundjungle.UndergroundJungle;
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

    private static final Climate.Parameter TEMPERATURE = Climate.Parameter.span(0.4f, 1.0f);
    private static final Climate.Parameter HUMIDITY = Climate.Parameter.span(0.4f, 1.0f);
    private static final Climate.Parameter CONTINENTALNESS = Climate.Parameter.span(0.5f, 1.0f);
    private static final Climate.Parameter EROSION = Climate.Parameter.span(-1.0f, 1.0f);
    private static final Climate.Parameter DEPTH = Climate.Parameter.span(0.2f, 0.9f);
    private static final Climate.Parameter WEIRDNESS = Climate.Parameter.span(0.0f, 1.0f);

    /**
     * Adds the underground jungle biome to the overworld biome manager.
     *
     * @param consumer Climate parameters and biome key consumer
     * @param ci Mixin callback info
     */
    @Inject(at = @At("RETURN"), method = "addUndergroundBiomes")
    public void addUndergroundBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, CallbackInfo ci) {
        if(!PlatformHelper.isModLoaded("terrablender")) {
            ResourceKey<Biome> undergroundJungleKey = ResourceKey.create(Registries.BIOME, new ResourceLocation(UndergroundJungle.MOD_ID, "underground_jungle"));
            Climate.ParameterPoint undergroundJungleClimate = Climate.parameters(TEMPERATURE, HUMIDITY, CONTINENTALNESS, EROSION, DEPTH, WEIRDNESS, 0.0f);
            consumer.accept(Pair.of(undergroundJungleClimate, undergroundJungleKey));
        }
    }
}