package io.github.hexagonnico.undergroundjungle.mixin;

import com.mojang.datafixers.util.Pair;
import io.github.hexagonnico.undergroundjungle.UndergroundJungleBiomes;
import net.minecraft.resources.ResourceKey;
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

//    private static final Climate.ParameterPoint TEST_PARAMETERS = Climate.parameters(
//        Climate.Parameter.span(-1.0F, 1.0F),
//        Climate.Parameter.span(-1.0F, 1.0F),
//        Climate.Parameter.span(0.7F, 1.0F),
//        Climate.Parameter.span(
//            Climate.Parameter.span(-1.0F, -0.78F),
//            Climate.Parameter.span(-0.78F, -0.375F)
//        ),
//        Climate.Parameter.span(0.2F, 0.9F),
//        Climate.Parameter.span(-1.0F, 1.0F),
//        0.0F
//    );
//
//    @Inject(at = @At("RETURN"), method = "addUndergroundBiomes")
//    public void addUndergroundBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, CallbackInfo ci) {
//        consumer.accept(Pair.of(TEST_PARAMETERS, UndergroundJungleBiomes.TEST_BIOME.getKey()));
//    }
}