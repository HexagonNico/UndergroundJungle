package io.github.hexagonnico.undergroundjungle.forge;

import io.github.hexagonnico.undergroundjungle.PlatformHelper;
import net.minecraftforge.fml.ModList;

public class ForgePlatform implements PlatformHelper.Platform {

    @Override
    public String platformName() {
        return "Forge";
    }

    @Override
    public boolean isModLoaded(String mod) {
        return ModList.get().isLoaded(mod);
    }
}
