package io.github.hexagonnico.undergroundjungle.forge;

import io.github.hexagonnico.undergroundjungle.AbstractRegistry;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ForgeRegistry extends AbstractRegistry {

    private final DeferredRegister<Block> blocksRegister = DeferredRegister.create(ForgeRegistries.BLOCKS, ForgeInitializer.MOD_ID);
    private final DeferredRegister<Item> itemsRegister = DeferredRegister.create(ForgeRegistries.ITEMS, ForgeInitializer.MOD_ID);

    @Override
    protected Supplier<Item> registerItem(String name, Supplier<Item> item) {
        return this.itemsRegister.register(name, item);
    }

    @Override
    protected Supplier<Block> registerBlock(String name, Supplier<Block> block) {
        return this.blocksRegister.register(name, block);
    }

    @Override
    public void registerAll() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        this.blocksRegister.register(eventBus);
        this.itemsRegister.register(eventBus);
    }
}
