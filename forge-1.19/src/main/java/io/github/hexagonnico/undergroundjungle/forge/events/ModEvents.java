package io.github.hexagonnico.undergroundjungle.forge.events;

import io.github.hexagonnico.undergroundjungle.RegistryManager;
import io.github.hexagonnico.undergroundjungle.entities.JungleZombie;
import io.github.hexagonnico.undergroundjungle.entities.MossySkeleton;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Forge events running on the mod event bus.
 *
 * @author Nico
 */
@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = "underground_jungle", bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {

    /**
     * Creates attributes for entities.
     *
     * @param event Attribute creation event
     */
    @SubscribeEvent
    public static void createAttributes(EntityAttributeCreationEvent event) {
        event.put(RegistryManager.JUNGLE_ZOMBIE.get(), JungleZombie.createAttributes().build());
        event.put(RegistryManager.MOSSY_SKELETON.get(), MossySkeleton.createAttributes().build());
    }
}
