package io.github.hexagonnico.undergroundjungle.forge;

import io.github.hexagonnico.undergroundjungle.AbstractRegistry;
import io.github.hexagonnico.undergroundjungle.CommonInitializer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * Forge implementation of the registry.
 *
 * @author Nico
 */
public class ForgeRegistry extends AbstractRegistry {

    /** Blocks deferred register */
    private final DeferredRegister<Block> blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, CommonInitializer.MOD_ID);
    /** Items deferred register */
    private final DeferredRegister<Item> items = DeferredRegister.create(ForgeRegistries.ITEMS, CommonInitializer.MOD_ID);
    /** Block entities deferred register */
    private final DeferredRegister<BlockEntityType<?>> blockEntities = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, CommonInitializer.MOD_ID);
    /** Entities deferred register */
    private final DeferredRegister<EntityType<?>> entities = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, CommonInitializer.MOD_ID);

    @Override
    protected Supplier<Item> registerItem(String name, Supplier<Item> item) {
        return this.items.register(name, item);
    }

    @Override
    protected Supplier<Block> registerBlock(String name, Supplier<Block> block) {
        return this.blocks.register(name, block);
    }

    @Override
    public void addBlockEntityAndItem(String name, Supplier<Block> block, BiFunction<BlockPos, BlockState, BlockEntity> blockEntity) {
        // Override the behaviour for rendering block entity items with forge
        this.addItem(name, () -> new BlockEntityItem(this.getBlock(name), blockEntity::apply, new Item.Properties()));
        this.addBlockEntity(name, block, blockEntity);
    }

    @Override
    @SuppressWarnings("DataFlowIssue")
    protected Supplier<BlockEntityType<?>> registerBlockEntity(String name, Supplier<Block> block, BiFunction<BlockPos, BlockState, BlockEntity> blockEntity) {
        // Must be done like this because BlockEntitySupplier is inaccessible in the common module
        return this.blockEntities.register(name, () -> BlockEntityType.Builder.of(blockEntity::apply, block.get()).build(null));
    }

    @Override
    protected Supplier<EntityType<? extends Entity>> registerEntity(String name, Supplier<EntityType<? extends Entity>> entityType) {
        return this.entities.register(name, entityType);
    }

    @Override
    public void registerAll() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        this.blocks.register(eventBus);
        this.items.register(eventBus);
        this.blockEntities.register(eventBus);
        this.entities.register(eventBus);
    }
}
