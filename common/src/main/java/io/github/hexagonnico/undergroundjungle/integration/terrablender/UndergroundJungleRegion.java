package io.github.hexagonnico.undergroundjungle.integration.terrablender;

import com.mojang.datafixers.util.Pair;
import io.github.hexagonnico.undergroundjungle.UndergroundJungle;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;

import java.util.function.Consumer;

public class UndergroundJungleRegion extends Region {

    private static final ResourceKey<Biome> UNDERGROUND_JUNGLE_BIOME = ResourceKey.create(Registries.BIOME, new ResourceLocation(UndergroundJungle.MOD_ID, "underground_jungle"));

    public UndergroundJungleRegion() {
        super(new ResourceLocation(UndergroundJungle.MOD_ID, "region"), RegionType.OVERWORLD, 1);
    }

    @Override
    public void addBiomes(Registry<Biome> registry, Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> mapper) {
        this.addModifiedVanillaOverworldBiomes(mapper, builder -> builder.replaceBiome(Biomes.LUSH_CAVES, UNDERGROUND_JUNGLE_BIOME));
    }
}
