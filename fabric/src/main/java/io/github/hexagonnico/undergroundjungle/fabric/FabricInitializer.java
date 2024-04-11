package io.github.hexagonnico.undergroundjungle.fabric;

import io.github.hexagonnico.undergroundjungle.UndergroundJungle;
import io.github.hexagonnico.undergroundjungle.entities.JungleZombie;
import io.github.hexagonnico.undergroundjungle.entities.MossySkeleton;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;

public class FabricInitializer implements ModInitializer {

    @Override
    public void onInitialize() {
        UndergroundJungle.init();
        FabricDefaultAttributeRegistry.register(UndergroundJungle.JUNGLE_ZOMBIE.get(), JungleZombie.createAttributes());
        FabricDefaultAttributeRegistry.register(UndergroundJungle.MOSSY_SKELETON.get(), MossySkeleton.createAttributes());
    }
}
