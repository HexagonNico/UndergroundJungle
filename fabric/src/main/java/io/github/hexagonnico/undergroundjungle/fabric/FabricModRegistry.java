package io.github.hexagonnico.undergroundjungle.fabric;

import io.github.hexagonnico.undergroundjungle.ModRegistry;
import io.github.hexagonnico.undergroundjungle.UndergroundJungle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class FabricModRegistry implements ModRegistry {

    private ResourceLocation identifier(String name) {
        return new ResourceLocation(UndergroundJungle.MOD_ID, name);
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> supplier) {
        T item = Registry.register(BuiltInRegistries.ITEM, this.identifier(name), supplier.get());
        return () -> item;
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> supplier) {
        T block = Registry.register(BuiltInRegistries.BLOCK, this.identifier(name), supplier.get());
        return () -> block;
    }

    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String name, BiFunction<BlockPos, BlockState, T> blockEntity, Supplier<? extends Block> block) {
        BlockEntityType<T> blockEntityType = Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, this.identifier(name), BlockEntityType.Builder.of(blockEntity::apply, block.get()).build(null));
        return () -> blockEntityType;
    }

    @Override
    public <T extends Entity> Supplier<EntityType<T>> registerEntity(String name, EntityType.Builder<T> builder) {
        EntityType<T> entityType = Registry.register(BuiltInRegistries.ENTITY_TYPE, this.identifier(name), builder.build(name));
        return () -> entityType;
    }

    @Override
    public void register() {

    }
}
