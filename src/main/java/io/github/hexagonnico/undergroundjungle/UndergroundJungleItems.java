package io.github.hexagonnico.undergroundjungle;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class UndergroundJungleItems {

    private static final DeferredRegister<Item> REGISTER = DeferredRegister.create(Registries.ITEM, UndergroundJungleMod.ID);

    public static final RegistryObject<BlockItem> JUNGLE_GRASS = REGISTER.register("jungle_grass", () -> new BlockItem(UndergroundJungleBlocks.JUNGLE_GRASS.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}
