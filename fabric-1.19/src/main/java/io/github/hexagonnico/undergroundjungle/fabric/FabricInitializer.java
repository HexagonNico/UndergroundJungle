package io.github.hexagonnico.undergroundjungle.fabric;

import io.github.hexagonnico.undergroundjungle.RegistryManager;
import net.fabricmc.api.ModInitializer;

public class FabricInitializer implements ModInitializer {

    @Override
    public void onInitialize() {
        RegistryManager.register();
    }
}
