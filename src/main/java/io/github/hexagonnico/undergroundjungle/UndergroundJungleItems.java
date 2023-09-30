package io.github.hexagonnico.undergroundjungle;

import io.github.hexagonnico.undergroundjungle.blocks.TempleChestBlockEntity;
import io.github.hexagonnico.undergroundjungle.items.BlockEntityItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class UndergroundJungleItems {

    private static final DeferredRegister<Item> REGISTER = DeferredRegister.create(Registries.ITEM, UndergroundJungleMod.ID);

    public static final ForgeTier TOOLS_TIER = new ForgeTier(4, 64, 12.0f, 3.0f, 20, Tags.Blocks.NEEDS_NETHERITE_TOOL, () -> Ingredient.EMPTY);

    public static final RegistryObject<Item> TEMPLE_KEY = REGISTER.register("temple_key", () -> new Item(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> TEMPLE_SWORD = REGISTER.register("temple_sword", () -> new SwordItem(TOOLS_TIER, 3, -2.4f, new Item.Properties()));
    public static final RegistryObject<Item> TEMPLE_SHOVEL = REGISTER.register("temple_shovel", () -> new ShovelItem(TOOLS_TIER, 1.5f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> TEMPLE_PICKAXE = REGISTER.register("temple_pickaxe", () -> new PickaxeItem(TOOLS_TIER, 1, -2.8f, new Item.Properties()));
    public static final RegistryObject<Item> TEMPLE_AXE = REGISTER.register("temple_axe", () -> new AxeItem(TOOLS_TIER, 5.0f, -3.0f, new Item.Properties()));
    public static final RegistryObject<Item> TEMPLE_HOE = REGISTER.register("temple_hoe", () -> new HoeItem(TOOLS_TIER, -3, 0.0f, new Item.Properties()));
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
    public static final RegistryObject<BlockItem> TEMPLE_CHEST = REGISTER.register("temple_chest", () -> new BlockEntityItem(UndergroundJungleBlocks.TEMPLE_CHEST.get(), TempleChestBlockEntity::new, new Item.Properties()));
    public static final RegistryObject<BlockItem> JUNGLE_VINES = REGISTER.register("jungle_vines", () -> new BlockItem(UndergroundJungleBlocks.JUNGLE_VINES.get(), new Item.Properties()));
    public static final RegistryObject<Item> MOSSY_SKELETON_SPAWN_EGG = REGISTER.register("mossy_skeleton_spawn_egg", () -> new ForgeSpawnEggItem(UndergroundJungleEntities.MOSSY_SKELETON, 12698049, 7969893, new Item.Properties()));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}
