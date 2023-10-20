package io.github.hexagonnico.undergroundjungle;

import io.github.hexagonnico.undergroundjungle.blocks.ModStairBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * Interface used to implement a mod registry.
 * Different mod loaders should implement this interface to provide their own way of registering things.
 * The registry should also be added to {@code META-INF/services} for it to be used in {@link RegistryManager}.
 *
 * @author Nico
 */
public interface ModRegistry {

    /**
     * Registers a {@link Block}.
     *
     * @param name The block's registry name
     * @param block A supplier returning the block to register
     * @return A supplier returning the registered block
     * @param <T> The block's class
     */
    <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block);

    /**
     * Registers an {@link Item}.
     *
     * @param name The item's registry name
     * @param item A supplier returning the item to register
     * @return A supplier returning the registered item
     * @param <T> The item's class
     */
    <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item);

    /**
     * Registers a {@link BlockItem} from the given block.
     *
     * @param name The item's registry name
     * @param block The block on which this item is based
     * @return A supplier returning the registered item
     */
    default Supplier<BlockItem> registerBlockItem(String name, Supplier<? extends Block> block) {
        return this.registerItem(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    /**
     * Registers a {@link Block} and a {@link BlockItem}.
     * Combines {@link ModRegistry#registerBlock(String, Supplier)} and {@link ModRegistry#registerBlockItem(String, Supplier)}.
     *
     * @param name The block and the item's registry name
     * @param block A supplier returning the block to register
     * @return A supplier returning the registered block
     * @param <T> The block's class
     */
    default <T extends Block> Supplier<T> registerBlockAndItem(String name, Supplier<T> block) {
        block = this.registerBlock(name, block);
        this.registerBlockItem(name, block);
        return block;
    }

    /**
     * Registers a {@link Block} by copying another one and optionally a {@link BlockItem}.
     *
     * @param name The block and the item's registry name
     * @param base The block on which this one is based
     * @param registerItem If true, this method will also register an item using {@link ModRegistry#registerBlockItem(String, Supplier)}
     * @return A supplier returning the registered block
     */
    default Supplier<Block> registerBlockVariant(String name, Supplier<? extends Block> base, boolean registerItem) {
        Supplier<Block> block = this.registerBlock(name, () -> new Block(BlockBehaviour.Properties.copy(base.get())));
        if(registerItem) {
            this.registerBlockItem(name, block);
        }
        return block;
    }

    /**
     * Registers a {@link Block} by copying another one and a {@link BlockItem}.
     *
     * @param name The block and the item's registry name
     * @param base The block on which this one is based
     * @return A supplier returning the registered block
     */
    default Supplier<Block> registerBlockVariant(String name, Supplier<? extends Block> base) {
        return this.registerBlockVariant(name, base, true);
    }

    /**
     * Registers a {@link StairBlock} and optionally a {@link BlockItem}.
     *
     * @param name The block and the item's registry name
     * @param base The block on which this {@code StairBlock} is based
     * @param registerItem If true, this method will also register an item using {@link ModRegistry#registerBlockItem(String, Supplier)}
     * @return A supplier returning the registered block
     */
    default Supplier<StairBlock> registerStairs(String name, Supplier<? extends Block> base, boolean registerItem) {
        Supplier<StairBlock> stairs = this.registerBlock(name, () -> new ModStairBlock(base.get()));
        if(registerItem) {
            this.registerBlockItem(name, stairs);
        }
        return stairs;
    }

    /**
     * Registers a {@link StairBlock} and a {@link BlockItem}.
     *
     * @param name The block and the item's registry name
     * @param base The block on which this {@code StairBlock} is based
     * @return A supplier returning the registered block
     */
    default Supplier<StairBlock> registerStairs(String name, Supplier<? extends Block> base) {
        return this.registerStairs(name, base, true);
    }

    /**
     * Registers a {@link SlabBlock} and optionally a {@link BlockItem}.
     *
     * @param name The block and the item's registry name
     * @param base The block on which this {@code SlabBlock} is based
     * @param registerItem If true, this method will also register an item using {@link ModRegistry#registerBlockItem(String, Supplier)}
     * @return A supplier returning the registered block
     */
    default Supplier<SlabBlock> registerSlab(String name, Supplier<? extends Block> base, boolean registerItem) {
        Supplier<SlabBlock> slab = this.registerBlock(name, () -> new SlabBlock(BlockBehaviour.Properties.copy(base.get())));
        if(registerItem) {
            this.registerBlockItem(name, slab);
        }
        return slab;
    }

    /**
     * Registers a {@link SlabBlock} and a {@link BlockItem}.
     *
     * @param name The block and the item's registry name
     * @param base The block on which this {@code SlabBlock} is based
     * @return A supplier returning the registered block
     */
    default Supplier<SlabBlock> registerSlab(String name, Supplier<? extends Block> base) {
        return this.registerSlab(name, base, true);
    }

    /**
     * Registers a {@link WallBlock} and optionally a {@link BlockItem}.
     *
     * @param name The block and the item's registry name
     * @param base The block on which this {@code WallBlock} is based
     * @param registerItem If true, this method will also register an item using {@link ModRegistry#registerBlockItem(String, Supplier)}
     * @return A supplier returning the registered block
     */
    default Supplier<WallBlock> registerWall(String name, Supplier<? extends Block> base, boolean registerItem) {
        Supplier<WallBlock> wall = this.registerBlock(name, () -> new WallBlock(BlockBehaviour.Properties.copy(base.get())));
        if(registerItem) {
            this.registerBlockItem(name, wall);
        }
        return wall;
    }

    /**
     * Registers a {@link WallBlock} and a {@link BlockItem}.
     *
     * @param name The block and the item's registry name
     * @param base The block on which this {@code WallBlock} is based
     * @return A supplier returning the registered block
     */
    default Supplier<WallBlock> registerWall(String name, Supplier<? extends Block> base) {
        return this.registerWall(name, base, true);
    }

    /**
     * Registers a {@link BlockEntityType}.
     *
     * @param name The block entity's registry name
     * @param block The block on which this block entity is based
     * @param blockEntity The block entity's constructor
     * @return A supplier returning the registered block entity
     * @param <T> The block entity's class
     */
    <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String name, Supplier<? extends Block> block, BiFunction<BlockPos, BlockState, T> blockEntity);

    /**
     * Registers a {@link BlockItem} for a block entity.
     * The default implementation just invokes {@link ModRegistry#registerBlockItem(String, Supplier)}, but different mod loaders may require to change this to provide an item renderer.
     *
     * @param name The item's registry name
     * @param block The block on which this item is based
     * @param blockEntity The block entity on which this item is based
     * @return A supplier returning the registered item
     */
    default Supplier<BlockItem> registerBlockEntityItem(String name, Supplier<? extends Block> block, BiFunction<BlockPos, BlockState, ? extends BlockEntity> blockEntity) {
        return this.registerBlockItem(name, block);
    }

    /**
     * Registers a {@link BlockEntityType} and a {@link BlockItem}.
     * Combines {@link ModRegistry#registerBlockEntity(String, Supplier, BiFunction)} and {@link ModRegistry#registerBlockEntityItem(String, Supplier, BiFunction)}.
     * Note that this method should not be used if the block has been registered with {@link ModRegistry#registerBlockAndItem(String, Supplier)}.
     *
     * @param name The block entity and the item's registry name
     * @param block The block on which the block entity and the item are based
     * @param blockEntity The block entity's constructor
     * @return A supplier returning the registered block entity
     * @param <T> The block entity's class
     */
    default <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntityAndItem(String name, Supplier<? extends Block> block, BiFunction<BlockPos, BlockState, T> blockEntity) {
        Supplier<BlockEntityType<T>> blockEntityType = this.registerBlockEntity(name, block, blockEntity);
        this.registerBlockEntityItem(name, block, blockEntity);
        return blockEntityType;
    }

    /**
     * Registers an {@link EntityType}.
     *
     * @param name The entity's registry name
     * @param builder The entity type builder
     * @return A supplier returning the registered entity
     * @param <T> The entity's class
     */
    <T extends Entity> Supplier<EntityType<T>> registerEntity(String name, EntityType.Builder<T> builder);

    /**
     * Registers a {@link SpawnEggItem} for the given entity.
     *
     * @param name The item's registry name
     * @param entity A supplier returning the entity spawned by this spawn egg
     * @param primaryColor The spawn egg's primary color
     * @param secondaryColor The spawn egg's secondary color
     * @return A supplier returning the registered item
     * @param <T> The entity's class
     */
    default <T extends Mob> Supplier<SpawnEggItem> registerSpawnEgg(String name, Supplier<EntityType<T>> entity, int primaryColor, int secondaryColor) {
        return this.registerItem(name, () -> new SpawnEggItem(entity.get(), primaryColor, secondaryColor, new Item.Properties()));
    }

    /**
     * Finalizes the registration process by registering all the objects added to the registry.
     * Called from {@link RegistryManager#register()}.
     */
    void register();
}
