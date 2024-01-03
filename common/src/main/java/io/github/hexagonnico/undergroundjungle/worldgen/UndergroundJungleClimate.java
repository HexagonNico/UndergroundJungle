package io.github.hexagonnico.undergroundjungle.worldgen;

import net.minecraft.world.level.biome.Climate;

public class UndergroundJungleClimate {

    public static final Climate.Parameter TEMPERATURE = Climate.Parameter.span(0.4f, 1.0f);
    public static final Climate.Parameter HUMIDITY = Climate.Parameter.span(0.4f, 1.0f);
    public static final Climate.Parameter CONTINENTALNESS = Climate.Parameter.span(0.5f, 1.0f);
    public static final Climate.Parameter EROSION = Climate.Parameter.span(-1.0f, 1.0f);
    public static final Climate.Parameter DEPTH = Climate.Parameter.span(0.2f, 0.9f);
    public static final Climate.Parameter WEIRDNESS = Climate.Parameter.span(0.0f, 1.0f);
}
