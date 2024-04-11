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
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public interface ModRegistry {

    <T extends Item> Supplier<T> registerItem(String name, Supplier<T> supplier);

    default Supplier<Item> registerItem(String name, Item.Properties properties) {
        return this.registerItem(name, () -> new Item(properties));
    }

    default Supplier<Item> registerItem(String name) {
        return this.registerItem(name, new Item.Properties());
    }

    <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> supplier);

    default Supplier<BlockItem> registerBlockItem(String name, Supplier<? extends Block> block) {
        return this.registerItem(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    default <T extends Block> Supplier<T> registerBlockAndItem(String name, Supplier<T> supplier) {
        Supplier<T> block = this.registerBlock(name, supplier);
        this.registerBlockItem(name, block);
        return block;
    }

    default Supplier<Block> registerBlockAndItem(String name, BlockBehaviour.Properties properties) {
        return this.registerBlockAndItem(name, () -> new Block(properties));
    }

    default Supplier<Block> registerBlockVariantAndItem(String name, Supplier<? extends Block> base) {
        return this.registerBlockAndItem(name, () -> new Block(BlockBehaviour.Properties.copy(base.get())));
    }

    default <T extends Block> Supplier<T> registerBlockVariantAndItem(String name, Function<BlockBehaviour.Properties, T> constructor, Supplier<? extends Block> base) {
        return this.registerBlockAndItem(name, () -> constructor.apply(BlockBehaviour.Properties.copy(base.get())));
    }

    <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String name, BiFunction<BlockPos, BlockState, T> blockEntity, Supplier<? extends Block> block);

    <T extends Entity> Supplier<EntityType<T>> registerEntity(String name, EntityType.Builder<T> builder);

    default Supplier<SpawnEggItem> registerSpawnEgg(String name, Supplier<EntityType<? extends Mob>> entity, int primaryColor, int secondaryColor) {
        return this.registerItem(name, () -> new SpawnEggItem(entity.get(), primaryColor, secondaryColor, new Item.Properties()));
    }

    void register();
}
