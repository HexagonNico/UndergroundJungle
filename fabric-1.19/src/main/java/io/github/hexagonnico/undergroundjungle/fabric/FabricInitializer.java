package io.github.hexagonnico.undergroundjungle.fabric;

import io.github.hexagonnico.undergroundjungle.RegistryManager;
import io.github.hexagonnico.undergroundjungle.entities.JungleZombie;
import io.github.hexagonnico.undergroundjungle.entities.MossySkeleton;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

/**
 * Fabric mod initializer.
 *
 * @author Nico
 */
public class FabricInitializer implements ModInitializer {

    @Override
    public void onInitialize() {
        RegistryManager.register();
        FabricDefaultAttributeRegistry.register(RegistryManager.MOSSY_SKELETON.get(), MossySkeleton.createAttributes());
        FabricDefaultAttributeRegistry.register(RegistryManager.JUNGLE_ZOMBIE.get(), JungleZombie.createAttributes());
    }
}
