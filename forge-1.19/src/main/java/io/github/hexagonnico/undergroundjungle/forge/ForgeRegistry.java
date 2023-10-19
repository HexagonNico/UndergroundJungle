package io.github.hexagonnico.undergroundjungle.forge;

import io.github.hexagonnico.undergroundjungle.ModRegistry;
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
public class ForgeRegistry implements ModRegistry {

    /** Blocks deferred register */
    private final DeferredRegister<Block> blocks = DeferredRegister.create(ForgeRegistries.BLOCKS, "underground_jungle");
    /** Items deferred register */
    private final DeferredRegister<Item> items = DeferredRegister.create(ForgeRegistries.ITEMS, "underground_jungle");
    /** Block entities deferred register */
    private final DeferredRegister<BlockEntityType<?>> blockEntities = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, "underground_jungle");
    /** Entities deferred register */
    private final DeferredRegister<EntityType<?>> entities = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, "underground_jungle");

    @Override
    public <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        return this.blocks.register(name, block);
    }

    @Override
    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        return this.items.register(name, item);
    }

    @Override
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String name, Supplier<? extends Block> block, BiFunction<BlockPos, BlockState, T> blockEntity) {
        return this.blockEntities.register(name, () -> BlockEntityType.Builder.of(blockEntity::apply, block.get()).build(null));
    }

    @Override
    public <T extends Entity> Supplier<EntityType<T>> registerEntity(String name, EntityType.Builder<T> builder) {
        return this.entities.register(name, () -> builder.build(name));
    }

    @Override
    public void register() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        this.blocks.register(eventBus);
        this.items.register(eventBus);
        this.blockEntities.register(eventBus);
        this.entities.register(eventBus);
    }
}
