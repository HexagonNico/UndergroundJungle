package io.github.hexagonnico.undergroundjungle.fabric;

import io.github.hexagonnico.undergroundjungle.PlatformHelper;
import net.fabricmc.loader.api.FabricLoader;

public class FabricPlatform implements PlatformHelper.Platform {

    @Override
    public String platformName() {
        return "Fabric";
    }

    @Override
    public boolean isModLoaded(String mod) {
        return FabricLoader.getInstance().isModLoaded(mod);
    }
}
