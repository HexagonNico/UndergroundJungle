package io.github.hexagonnico.undergroundjungle.forge;

import io.github.hexagonnico.undergroundjungle.ModRegistry;
import io.github.hexagonnico.undergroundjungle.UndergroundJungle;
import io.github.hexagonnico.undergroundjungle.forge.items.BlockEntityItem;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class ForgeModRegistry implements ModRegistry {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UndergroundJungle.MOD_ID);
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UndergroundJungle.MOD_ID);
    private static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, UndergroundJungle.MOD_ID);
    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, UndergroundJungle.MOD_ID);

    @Override
    public <T extends Item> Supplier<T> registerItem(String name, Supplier<T> supplier) {
        return ITEMS.register(name, supplier);
    }

    @Override
    public <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> supplier) {
        return BLOCKS.register(name, supplier);
    }

    @Override
    public Supplier<BlockItem> registerBlockItem(String name, Supplier<? extends Block> supplier) {
        return this.registerItem(name, () -> {
            Block block = supplier.get();
            if(block instanceof EntityBlock) {
                return new BlockEntityItem(block, new Item.Properties());
            }
            return new BlockItem(block, new Item.Properties());
        });
    }

    @Override
    @SuppressWarnings("DataFlowIssue")
    public <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String name, BiFunction<BlockPos, BlockState, T> blockEntity, Supplier<? extends Block> block) {
        return BLOCK_ENTITIES.register(name, () -> BlockEntityType.Builder.of(blockEntity::apply, block.get()).build(null));
    }

    @Override
    public <T extends Entity> Supplier<EntityType<T>> registerEntity(String name, EntityType.Builder<T> builder) {
        return ENTITIES.register(name, () -> builder.build(name));
    }

    @Override
    public Supplier<SpawnEggItem> registerSpawnEgg(String name, Supplier<EntityType<? extends Mob>> entity, int primaryColor, int secondaryColor) {
        return this.registerItem(name, () -> new ForgeSpawnEggItem(entity, primaryColor, secondaryColor, new Item.Properties()));
    }

    @Override
    public void register() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ITEMS.register(eventBus);
        BLOCKS.register(eventBus);
        BLOCK_ENTITIES.register(eventBus);
        ENTITIES.register(eventBus);
    }
}
