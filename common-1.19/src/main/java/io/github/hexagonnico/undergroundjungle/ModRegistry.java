package io.github.hexagonnico.undergroundjungle;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public interface ModRegistry {

    <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block);

    <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item);

    <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String name, Supplier<? extends Block> block, BiFunction<BlockPos, BlockState, T> blockEntity);

    <T extends Entity> Supplier<EntityType<T>> registerEntity(String name, EntityType.Builder<T> builder);

    void register();
}
