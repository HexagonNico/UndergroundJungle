package io.github.hexagonnico.undergroundjungle;

import io.github.hexagonnico.undergroundjungle.blocks.TempleChestBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class UndergroundJungleBlockEntities {

    private static final DeferredRegister<BlockEntityType<?>> REGISTER = DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, UndergroundJungleMod.ID);

    public static final RegistryObject<BlockEntityType<TempleChestBlockEntity>> TEMPLE_CHEST = REGISTER.register("temple_chest", () -> BlockEntityType.Builder.of(TempleChestBlockEntity::new, UndergroundJungleBlocks.TEMPLE_CHEST.get()).build(null));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}
