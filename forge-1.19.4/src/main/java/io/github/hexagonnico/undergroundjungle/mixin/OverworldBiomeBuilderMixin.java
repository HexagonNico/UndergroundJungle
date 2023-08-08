package io.github.hexagonnico.undergroundjungle.mixin;

import com.mojang.datafixers.util.Pair;
import io.github.hexagonnico.undergroundjungle.UndergroundJungleMod;
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
            Climate.Parameter.span(0.4f, 1.0f),
            Climate.Parameter.span(0.4f, 1.0f),
            Climate.Parameter.span(0.5f, 1.0f),
            Climate.Parameter.span(-1.0f, 1.0f),
            Climate.Parameter.span(0.0f, 0.7f),
            Climate.Parameter.span(-1.0f, 1.0f),
            0.0f
        );
        consumer.accept(Pair.of(undergroundJungleClimate, undergroundJungleKey));
    }
}