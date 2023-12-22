package io.github.hexagonnico.undergroundjungle.fabric;

import io.github.hexagonnico.undergroundjungle.Platform;
import net.fabricmc.loader.api.FabricLoader;

public class FabricPlatform implements Platform {

    @Override
    public boolean isModLoaded(String mod) {
        return FabricLoader.getInstance().isModLoaded(mod);
    }
}
