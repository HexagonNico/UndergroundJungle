package io.github.hexagonnico.undergroundjungle.forge.events;

import io.github.hexagonnico.undergroundjungle.UndergroundJungle;
import io.github.hexagonnico.undergroundjungle.entities.JungleZombie;
import io.github.hexagonnico.undergroundjungle.entities.MossySkeleton;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = UndergroundJungle.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventHandler {

    @SubscribeEvent
    public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(UndergroundJungle.JUNGLE_ZOMBIE.get(), JungleZombie.createAttributes().build());
        event.put(UndergroundJungle.MOSSY_SKELETON.get(), MossySkeleton.createAttributes().build());
    }
}
