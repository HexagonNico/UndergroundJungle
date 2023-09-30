package io.github.hexagonnico.undergroundjungle;

import io.github.hexagonnico.undergroundjungle.entities.MossySkeleton;
import io.github.hexagonnico.undergroundjungle.entities.JungleZombie;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class UndergroundJungleEntities {

    private static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(Registries.ENTITY_TYPE, UndergroundJungleMod.ID);

    public static final RegistryObject<EntityType<MossySkeleton>> MOSSY_SKELETON = register("mossy_skeleton", EntityType.Builder.of(MossySkeleton::new, MobCategory.MONSTER).sized(0.6f, 1.99f).clientTrackingRange(8));
    public static final RegistryObject<EntityType<JungleZombie>> JUNGLE_ZOMBIE = register("jungle_zombie", EntityType.Builder.of(JungleZombie::new, MobCategory.MONSTER).sized(0.6f, 1.95f).clientTrackingRange(8));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> register(String name, EntityType.Builder<T> builder) {
        return REGISTER.register(name, () -> builder.build(name));
    }
}
