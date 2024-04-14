package io.github.hexagonnico.undergroundjungle;

import io.github.hexagonnico.undergroundjungle.blocks.*;
import io.github.hexagonnico.undergroundjungle.entities.JungleZombie;
import io.github.hexagonnico.undergroundjungle.entities.MossySkeleton;
import io.github.hexagonnico.undergroundjungle.items.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.ServiceLoader;
import java.util.function.Supplier;

public final class UndergroundJungle {

    public static final String MOD_ID = "underground_jungle";

    private static final ModRegistry REGISTRY = ServiceLoader.load(ModRegistry.class).findFirst().orElseThrow();

    public static final Supplier<MudGrassBlock> JUNGLE_GRASS = REGISTRY.registerBlockAndItem("jungle_grass", () -> new MudGrassBlock(BlockBehaviour.Properties.copy(Blocks.MUD).mapColor(MapColor.GRASS).sound(SoundType.GRASS).randomTicks()));
    public static final Supplier<Block> TEMPLE_BRICKS = REGISTRY.registerBlockAndItem("temple_bricks", BlockBehaviour.Properties.of().requiresCorrectToolForDrops().mapColor(MapColor.TERRACOTTA_BROWN).sound(SoundType.STONE).strength(30.0f, 1200.0f));
    public static final Supplier<Block> CRACKED_TEMPLE_BRICKS = REGISTRY.registerBlockVariantAndItem("cracked_temple_bricks", TEMPLE_BRICKS);
    public static final Supplier<Block> MOSSY_TEMPLE_BRICKS = REGISTRY.registerBlockVariantAndItem("mossy_temple_bricks", TEMPLE_BRICKS);
    public static final Supplier<Block> CHISELED_TEMPLE_BRICKS = REGISTRY.registerBlockVariantAndItem("chiseled_temple_bricks", TEMPLE_BRICKS);
    public static final Supplier<Block> TEMPLE_BRICK_TILES = REGISTRY.registerBlockVariantAndItem("temple_brick_tiles", TEMPLE_BRICKS);
    public static final Supplier<StairBlock> TEMPLE_BRICK_STAIRS = REGISTRY.registerBlockAndItem("temple_brick_stairs", () -> new ModStairBlock(TEMPLE_BRICKS.get()));
    public static final Supplier<SlabBlock> TEMPLE_BRICK_SLAB = REGISTRY.registerBlockVariantAndItem("temple_brick_slab", SlabBlock::new, TEMPLE_BRICKS);
    public static final Supplier<WallBlock> TEMPLE_BRICK_WALL = REGISTRY.registerBlockVariantAndItem("temple_brick_wall", WallBlock::new, TEMPLE_BRICKS);
    public static final Supplier<StairBlock> TEMPLE_BRICK_TILE_STAIRS = REGISTRY.registerBlockAndItem("temple_brick_tile_stairs", () -> new ModStairBlock(TEMPLE_BRICK_TILES.get()));
    public static final Supplier<SlabBlock> TEMPLE_BRICK_TILE_SLAB = REGISTRY.registerBlockVariantAndItem("temple_brick_tile_slab", SlabBlock::new, TEMPLE_BRICK_TILES);
    public static final Supplier<WallBlock> TEMPLE_BRICK_TILE_WALL = REGISTRY.registerBlockVariantAndItem("temple_brick_tile_wall", WallBlock::new, TEMPLE_BRICK_TILES);
    public static final Supplier<TempleChestBlock> TEMPLE_CHEST = REGISTRY.registerBlockAndItem("temple_chest", () -> new TempleChestBlock(BlockBehaviour.Properties.copy(TEMPLE_BRICKS.get()).strength(-1.0f, 3600000.0f).noLootTable()));
    public static final Supplier<JungleVinesBlock> JUNGLE_VINES = REGISTRY.registerBlockAndItem("jungle_vines", () -> new JungleVinesBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.CAVE_VINES)));
    public static final Supplier<JungleVinesPlantBlock> JUNGLE_VINES_PLANT = REGISTRY.registerBlock("jungle_vines_plant", () -> new JungleVinesPlantBlock(BlockBehaviour.Properties.copy(JUNGLE_VINES.get()).lightLevel(JungleVinesPlantBlock.lightLevel(8))));

    public static final Supplier<Item> TEMPLE_KEY = REGISTRY.registerItem("temple_key", new Item.Properties().stacksTo(1));
    public static final Supplier<Item> JUNGLE_SPORES = REGISTRY.registerItem("jungle_spores");

    public static final Supplier<SwordItem> TEMPLE_SWORD = REGISTRY.registerItem("temple_sword", () -> new SwordItem(ModToolTier.TEMPLE, 3, -2.4f, new Item.Properties()));
    public static final Supplier<ShovelItem> TEMPLE_SHOVEL = REGISTRY.registerItem("temple_shovel", () -> new ShovelItem(ModToolTier.TEMPLE, 1.5f, -3.0f, new Item.Properties()));
    public static final Supplier<ModPickaxeItem> TEMPLE_PICKAXE = REGISTRY.registerItem("temple_pickaxe", () -> new ModPickaxeItem(ModToolTier.TEMPLE, 1, -2.8f, new Item.Properties()));
    public static final Supplier<ModAxeItem> TEMPLE_AXE = REGISTRY.registerItem("temple_axe", () -> new ModAxeItem(ModToolTier.TEMPLE, 5.0f, -3.0f, new Item.Properties()));
    public static final Supplier<ModHoeItem> TEMPLE_HOE = REGISTRY.registerItem("temple_hoe", () -> new ModHoeItem(ModToolTier.TEMPLE, -3, 0.0f, new Item.Properties()));
    public static final Supplier<AxeOfRegrowthItem> AXE_OF_REGROWTH = REGISTRY.registerItem("axe_of_regrowth", () -> new AxeOfRegrowthItem(ModToolTier.JUNGLE, 5.0f, -3.0f, new Item.Properties()));
    public static final Supplier<ModSwordItem> BLADE_OF_THE_JUNGLE = REGISTRY.registerItem("blade_of_the_jungle", () -> new ModSwordItem(ModToolTier.JUNGLE, 3, -2.4f, new Item.Properties()));

    public static final Supplier<BlockEntityType<TempleChestBlockEntity>> TEMPLE_CHEST_ENTITY = REGISTRY.registerBlockEntity("temple_chest", TempleChestBlockEntity::new, TEMPLE_CHEST);

    public static final Supplier<EntityType<JungleZombie>> JUNGLE_ZOMBIE = REGISTRY.registerEntity("jungle_zombie", EntityType.Builder.of(JungleZombie::new, MobCategory.MONSTER).sized(0.6f, 1.95f).clientTrackingRange(8));
    public static final Supplier<EntityType<MossySkeleton>> MOSSY_SKELETON = REGISTRY.registerEntity("mossy_skeleton", EntityType.Builder.of(MossySkeleton::new, MobCategory.MONSTER).sized(0.6f, 1.99f).clientTrackingRange(8));

    public static final Supplier<SpawnEggItem> JUNGLE_ZOMBIE_SPAWN_EGG = REGISTRY.registerSpawnEgg("jungle_zombie_spawn_egg", JUNGLE_ZOMBIE::get, 44975, 9945732);
    public static final Supplier<SpawnEggItem> MOSSY_SKELETON_SPAWN_EGG = REGISTRY.registerSpawnEgg("mossy_skeleton_spawn_egg", MOSSY_SKELETON::get, 12698049, 7969893);

    public static void init() {
        REGISTRY.register();
    }
}
