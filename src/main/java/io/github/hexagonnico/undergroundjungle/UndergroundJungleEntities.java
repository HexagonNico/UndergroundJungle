package io.github.hexagonnico.undergroundjungle;

import io.github.hexagonnico.undergroundjungle.entities.JungleSkeleton;
import io.github.hexagonnico.undergroundjungle.entities.JungleZombie;
import io.github.hexagonnico.undergroundjungle.entities.SporesSkeleton;
import io.github.hexagonnico.undergroundjungle.entities.SporesZombie;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class UndergroundJungleEntities {

    private static final DeferredRegister<EntityType<?>> REGISTER = DeferredRegister.create(Registries.ENTITY_TYPE, UndergroundJungleMod.ID);

    public static final RegistryObject<EntityType<JungleSkeleton>> JUNGLE_SKELETON = REGISTER.register("jungle_skeleton", () -> EntityType.Builder.of(JungleSkeleton::new, MobCategory.MONSTER).sized(0.6f, 1.99f).clientTrackingRange(8).build("jungle_skeleton"));
    public static final RegistryObject<EntityType<JungleZombie>> JUNGLE_ZOMBIE = REGISTER.register("jungle_zombie", () -> EntityType.Builder.of(JungleZombie::new, MobCategory.MONSTER).sized(0.6f, 1.95f).clientTrackingRange(8).build("jungle_zombie"));
    public static final RegistryObject<EntityType<SporesSkeleton>> SPORES_SKELETON = REGISTER.register("spores_skeleton", () -> EntityType.Builder.of(SporesSkeleton::new, MobCategory.MONSTER).sized(0.6f, 1.99f).clientTrackingRange(8).build("spores_skeleton"));
    public static final RegistryObject<EntityType<SporesZombie>> SPORES_ZOMBIE = REGISTER.register("spores_zombie", () -> EntityType.Builder.of(SporesZombie::new, MobCategory.MONSTER).sized(0.6f, 1.95f).clientTrackingRange(8).build("spores_zombie"));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}
