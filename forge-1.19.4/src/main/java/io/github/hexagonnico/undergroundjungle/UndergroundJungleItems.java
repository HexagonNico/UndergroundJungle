package io.github.hexagonnico.undergroundjungle;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class UndergroundJungleItems {

    private static final DeferredRegister<Item> REGISTER = DeferredRegister.create(Registries.ITEM, UndergroundJungleMod.ID);

    public static final RegistryObject<BlockItem> JUNGLE_GRASS = REGISTER.register("jungle_grass", () -> new BlockItem(UndergroundJungleBlocks.JUNGLE_GRASS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> TEMPLE_BRICKS = REGISTER.register("temple_bricks", () -> new BlockItem(UndergroundJungleBlocks.TEMPLE_BRICKS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> CRACKED_TEMPLE_BRICKS = REGISTER.register("cracked_temple_bricks", () -> new BlockItem(UndergroundJungleBlocks.CRACKED_TEMPLE_BRICKS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> MOSSY_TEMPLE_BRICKS = REGISTER.register("mossy_temple_bricks", () -> new BlockItem(UndergroundJungleBlocks.MOSSY_TEMPLE_BRICKS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> CHISELED_TEMPLE_BRICKS = REGISTER.register("chiseled_temple_bricks", () -> new BlockItem(UndergroundJungleBlocks.CHISELED_TEMPLE_BRICKS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> TEMPLE_BRICK_TILES = REGISTER.register("temple_brick_tiles", () -> new BlockItem(UndergroundJungleBlocks.TEMPLE_BRICK_TILES.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> TEMPLE_BRICK_STAIRS = REGISTER.register("temple_brick_stairs", () -> new BlockItem(UndergroundJungleBlocks.TEMPLE_BRICK_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> TEMPLE_BRICK_SLAB = REGISTER.register("temple_brick_slab", () -> new BlockItem(UndergroundJungleBlocks.TEMPLE_BRICK_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> TEMPLE_BRICK_WALL = REGISTER.register("temple_brick_wall", () -> new BlockItem(UndergroundJungleBlocks.TEMPLE_BRICK_WALL.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> TEMPLE_BRICK_TILE_STAIRS = REGISTER.register("temple_brick_tile_stairs", () -> new BlockItem(UndergroundJungleBlocks.TEMPLE_BRICK_TILE_STAIRS.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> TEMPLE_BRICK_TILE_SLAB = REGISTER.register("temple_brick_tile_slab", () -> new BlockItem(UndergroundJungleBlocks.TEMPLE_BRICK_TILE_SLAB.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> TEMPLE_BRICK_TILE_WALL = REGISTER.register("temple_brick_tile_wall", () -> new BlockItem(UndergroundJungleBlocks.TEMPLE_BRICK_TILE_WALL.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> TEMPLE_CHEST = REGISTER.register("temple_chest", () -> new BlockItem(UndergroundJungleBlocks.TEMPLE_CHEST.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> GLOWING_MUSHROOM = REGISTER.register("glowing_mushroom", () -> new BlockItem(UndergroundJungleBlocks.GLOWING_MUSHROOM.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> GLOWING_MUSHROOM_BLOCK = REGISTER.register("glowing_mushroom_block", () -> new BlockItem(UndergroundJungleBlocks.GLOWING_MUSHROOM_BLOCK.get(), new Item.Properties()));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}
