package io.github.hexagonnico.undergroundjungle.forge;

import io.github.hexagonnico.undergroundjungle.Platform;
import net.minecraftforge.fml.ModList;

public class ForgePlatform implements Platform {

    @Override
    public boolean isModLoaded(String mod) {
        return ModList.get().isLoaded(mod);
    }
}
