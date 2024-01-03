package io.github.hexagonnico.undergroundjungle.events;

import io.github.hexagonnico.undergroundjungle.UndergroundJungle;
import io.github.hexagonnico.undergroundjungle.entities.JungleZombie;
import io.github.hexagonnico.undergroundjungle.entities.MossySkeleton;
import io.github.phantomloader.library.events.ModEventHandler;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;

import java.util.function.BiConsumer;

public class ModEvents implements ModEventHandler {

    @Override
    public void registerEntityAttributes(BiConsumer<EntityType<? extends LivingEntity>, AttributeSupplier.Builder> event) {
        event.accept(UndergroundJungle.JUNGLE_ZOMBIE.get(), JungleZombie.createAttributes());
        event.accept(UndergroundJungle.MOSSY_SKELETON.get(), MossySkeleton.createAttributes());
    }
}
