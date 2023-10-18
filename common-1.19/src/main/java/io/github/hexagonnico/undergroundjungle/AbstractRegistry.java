package io.github.hexagonnico.undergroundjungle;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * Abstracts a registry across different mod loaders.
 * The forge and the fabric loaders should implement the abstract methods to provide their own way of registering things.
 * Used in {@link CommonInitializer#init(AbstractRegistry)}.
 *
 * @author Nico
 */
public abstract class AbstractRegistry {

    /** HashMap containing registered items */
    private final HashMap<String, Supplier<Item>> items = new HashMap<>();
    /** HashMap containing registered blocks */
    private final HashMap<String, Supplier<Block>> blocks = new HashMap<>();
    /** HashMap containing registered block entity types */
    private final HashMap<String, Supplier<BlockEntityType<?>>> blockEntities = new HashMap<>();
    /** HashMap containing registered generic entities */
    private final HashMap<String, Supplier<EntityType<? extends Entity>>> entities = new HashMap<>();

    /**
     * Adds an {@link Item} to the registry.
     * Added items can be retrieved with {@link AbstractRegistry#getItem(String)}.
     *
     * @param name The item's registry name
     * @param item A supplier returning the item
     */
    public void addItem(String name, Supplier<Item> item) {
        this.items.put(name, this.registerItem(name, item));
    }

    /**
     * Registers an {@link Item}.
     * Mod loaders must implement this method to provide their way of registering items.
     * Called by {@link AbstractRegistry#addItem(String, Supplier)}.
     *
     * @param name The item's registry name
     * @param item A supplier returning the item
     * @return A supplier returning the registered item
     */
    protected abstract Supplier<Item> registerItem(String name, Supplier<Item> item);

    /**
     * Adds a {@link Block} to the registry.
     * Added blocks can be retrieved with {@link AbstractRegistry#getBlock(String)}.
     *
     * @param name The block's registry name
     * @param block A supplier returning the block
     */
    public void addBlock(String name, Supplier<Block> block) {
        this.blocks.put(name, this.registerBlock(name, block));
    }

    /**
     * Registers a {@link Block}.
     * Mod loaders must implement this method to provide their way of registering blocks.
     * Called by {@link AbstractRegistry#addBlock(String, Supplier)}.
     *
     * @param name The block's registry name
     * @param block A supplier returning the block
     * @return A supplier returning the registered block
     */
    protected abstract Supplier<Block> registerBlock(String name, Supplier<Block> block);

    /**
     * Adds a {@link Block} and a {@link BlockItem} to the registry with the same registry name.
     * Calls {@link AbstractRegistry#addBlock(String, Supplier)} and {@link AbstractRegistry#addItem(String, Supplier)}.
     *
     * @param name The block and the item's registry name
     * @param block A supplier returning the block
     */
    public void addBlockAndItem(String name, Supplier<Block> block) {
        this.addBlock(name, block);
        this.addItem(name, () -> new BlockItem(this.getBlock(name), new Item.Properties()));
    }

    /**
     * Adds a {@link BlockEntityType} and the corresponding {@link Block} to the registry.
     * Added block entities can be retrieved with {@link AbstractRegistry#getBlockEntity(String)}.
     *
     * @param name The block and the block entity's registry name
     * @param block A supplier returning the block
     * @param blockEntity The block entity's constructor
     */
    public void addBlockEntity(String name, Supplier<Block> block, BiFunction<BlockPos, BlockState, BlockEntity> blockEntity) {
        this.addBlock(name, block);
        this.blockEntities.put(name, this.registerBlockEntity(name, block, blockEntity));
    }

    /**
     * Adds a {@link BlockEntityType}, the corresponding {@link Block} and an {@link Item} with the same registry name to the registry.
     * Calls {@link AbstractRegistry#addBlockAndItem(String, Supplier)} before registering the block entity.
     *
     * @param name The block entity, the block, and the item's registry name
     * @param block A supplier returning the block
     * @param blockEntity The block entity's constructor
     */
    public void addBlockEntityAndItem(String name, Supplier<Block> block, BiFunction<BlockPos, BlockState, BlockEntity> blockEntity) {
        this.addBlockAndItem(name, block);
        this.blockEntities.put(name, this.registerBlockEntity(name, block, blockEntity));
    }

    /**
     * Registers a {@link BlockEntityType}.
     * Mod loaders must implement this method to provide their way of registering block entities.
     * Called by {@link AbstractRegistry#addBlockEntity(String, Supplier, BiFunction)}.
     *
     * @param name The block entity's registry name
     * @param block A supplier returning the block corresponding to the block entity
     * @param blockEntity The block entity's constructor
     * @return A supplier returning the registered block entity type
     */
    protected abstract Supplier<BlockEntityType<?>> registerBlockEntity(String name, Supplier<Block> block, BiFunction<BlockPos, BlockState, BlockEntity> blockEntity);

    /**
     * Adds an {@link EntityType} to the registry.
     * Added entities can be retrieved with {@link AbstractRegistry#getEntity(String)}.
     *
     * @param name The entity's registry name
     * @param builder The entity type builder
     */
    public void addEntity(String name, EntityType.Builder<? extends Entity> builder) {
        this.entities.put(name, this.registerEntity(name, () -> builder.build(name)));
    }

    /**
     * Adds an {@link EntityType} and a {@link SpawnEggItem} to the registry.
     * Added mobs can be retrieved with {@link AbstractRegistry#getEntity(String)}.
     *
     * @param name The mob's registry name
     * @param builder The entity type builder
     * @param spawnEggPrimaryColor The spawn egg's primary color
     * @param spawnEggSecondaryColor The spawn egg's secondary color
     */
    @SuppressWarnings("unchecked")
    public void addEntity(String name, EntityType.Builder<? extends Mob> builder, int spawnEggPrimaryColor, int spawnEggSecondaryColor) {
        this.addEntity(name, builder);
        this.addItem(name + "_spawn_egg", () -> new SpawnEggItem((EntityType<? extends Mob>) this.getEntity(name), spawnEggPrimaryColor, spawnEggSecondaryColor, new Item.Properties()));
    }

    /**
     * Registers an {@link EntityType}.
     * Mod loaders must implement this method to provide their way of registering entities.
     * Called by {@link AbstractRegistry#addEntity(String, EntityType.Builder)}.
     *
     * @param name The entity's registry name
     * @param entityType A supplier returning the entity type
     * @return A supplier returning the registered entity type
     */
    protected abstract Supplier<EntityType<? extends Entity>> registerEntity(String name, Supplier<EntityType<? extends Entity>> entityType);

    /**
     * Gets a registered item with the given registry name.
     *
     * @param name The item's registry name
     * @return The requested item
     * @throws IllegalStateException if there is no registered item with the given name
     */
    public final Item getItem(String name) {
        return get(name, this.items);
    }

    /**
     * Gets a registered block with the given registry name.
     *
     * @param name The block's registry name
     * @return The requested block
     * @throws IllegalStateException if there is no registered block with the given name
     */
    public final Block getBlock(String name) {
        return get(name, this.blocks);
    }

    /**
     * Gets a registered block entity with the given registry name.
     *
     * @param name The block entity's registry name
     * @return The requested block entity
     * @throws IllegalStateException if there is no registered block entity with the given name
     */
    public final BlockEntityType<?> getBlockEntity(String name) {
        return get(name, this.blockEntities);
    }

    /**
     * Gets a registered entity with the given registry name.
     *
     * @param name The entity's registry name
     * @return The requested entity
     * @throws IllegalStateException if there is no registered entity with the given name
     */
    public final EntityType<?> getEntity(String name) {
        return get(name, this.entities);
    }

    /**
     * Utility method to get a registry object from the given registry.
     *
     * @param name The registry name
     * @param map The registry
     * @return The requested object
     * @param <T> Type of the registry object
     * @throws IllegalStateException if there is no registered object with the given name
     */
    private static <T> T get(String name, HashMap<String, Supplier<T>> map) {
        if(map.containsKey(name)) {
            return map.get(name).get();
        }
        throw new IllegalStateException("No registry entry with name " + name);
    }

    /**
     * Method to call at the end of the registration phase to finalize the registration.
     */
    public abstract void registerAll();
}
