package io.github.hexagonnico.undergroundjungle;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.function.Supplier;

public abstract class AbstractRegistry {

    private final HashMap<String, Supplier<Item>> items = new HashMap<>();
    private final HashMap<String, Supplier<Block>> blocks = new HashMap<>();

    public final void addItem(String name, Supplier<Item> item) {
        this.items.put(name, this.registerItem(name, item));
    }

    protected abstract Supplier<Item> registerItem(String name, Supplier<Item> item);

    public final void addBlock(String name, Supplier<Block> block) {
        this.blocks.put(name, this.registerBlock(name, block));
    }

    protected abstract Supplier<Block> registerBlock(String name, Supplier<Block> block);

    public final void addBlockAndItem(String name, Supplier<Block> block) {
        this.addBlock(name, block);
        this.addItem(name, () -> new BlockItem(this.getBlock(name), new Item.Properties()));
    }

    public final Item getItem(String name) {
        return this.items.get(name).get();
    }

    public final Block getBlock(String name) {
        return this.blocks.get(name).get();
    }

    protected abstract void registerAll();
}
