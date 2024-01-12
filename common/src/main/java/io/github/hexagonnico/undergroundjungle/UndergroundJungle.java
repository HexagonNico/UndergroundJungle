package io.github.hexagonnico.undergroundjungle;

import io.github.hexagonnico.undergroundjungle.blocks.*;
import io.github.hexagonnico.undergroundjungle.entities.JungleZombie;
import io.github.hexagonnico.undergroundjungle.entities.MossySkeleton;
import io.github.hexagonnico.undergroundjungle.items.ModAxeItem;
import io.github.hexagonnico.undergroundjungle.items.ModHoeItem;
import io.github.hexagonnico.undergroundjungle.items.ModPickaxeItem;
import io.github.hexagonnico.undergroundjungle.items.ModToolTier;
import io.github.phantomloader.library.ModEntryPoint;
import io.github.phantomloader.library.registry.ModRegistry;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.function.Supplier;

public final class UndergroundJungle {

    private static final ModRegistry REGISTRY = ModRegistry.instantiate("underground_jungle");

    public static final Supplier<MudGrassBlock> JUNGLE_GRASS = REGISTRY.registerBlockAndItem("jungle_grass", () -> new MudGrassBlock(BlockBehaviour.Properties.copy(Blocks.MUD).color(MaterialColor.GRASS).sound(SoundType.GRASS).randomTicks()));
    public static final Supplier<Block> TEMPLE_BRICKS = REGISTRY.registerBlockAndItem("temple_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().color(MaterialColor.TERRACOTTA_BROWN).sound(SoundType.STONE).strength(30.0f, 1200.0f)));
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
    public static final Supplier<JungleVinesBlock> JUNGLE_VINES = REGISTRY.registerBlockAndItem("jungle_vines", () -> new JungleVinesBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.CAVE_VINES)));
    public static final Supplier<JungleVinesPlantBlock> JUNGLE_VINES_PLANT = REGISTRY.registerBlock("jungle_vines_plant", () -> new JungleVinesPlantBlock(BlockBehaviour.Properties.copy(JUNGLE_VINES.get()).lightLevel(JungleVinesPlantBlock.lightLevel(8))));

    public static final Supplier<Item> TEMPLE_KEY = REGISTRY.registerItem("temple_key", new Item.Properties().stacksTo(1));

    public static final Supplier<SwordItem> TEMPLE_SWORD = REGISTRY.registerItem("temple_sword", () -> new SwordItem(ModToolTier.TEMPLE, 3, -2.4f, new Item.Properties()));
    public static final Supplier<ShovelItem> TEMPLE_SHOVEL = REGISTRY.registerItem("temple_shovel", () -> new ShovelItem(ModToolTier.TEMPLE, 1.5f, -3.0f, new Item.Properties()));
    public static final Supplier<PickaxeItem> TEMPLE_PICKAXE = REGISTRY.registerItem("temple_pickaxe", () -> new ModPickaxeItem(ModToolTier.TEMPLE, 1, -2.8f, new Item.Properties()));
    public static final Supplier<AxeItem> TEMPLE_AXE = REGISTRY.registerItem("temple_axe", () -> new ModAxeItem(ModToolTier.TEMPLE, 5.0f, -3.0f, new Item.Properties()));
    public static final Supplier<HoeItem> TEMPLE_HOE = REGISTRY.registerItem("temple_hoe", () -> new ModHoeItem(ModToolTier.TEMPLE, -3, 0.0f, new Item.Properties()));

    public static final Supplier<BlockEntityType<TempleChestBlockEntity>> TEMPLE_CHEST_ENTITY = REGISTRY.registerBlockEntity("temple_chest", TempleChestBlockEntity::new, TEMPLE_CHEST);

    public static final Supplier<EntityType<JungleZombie>> JUNGLE_ZOMBIE = REGISTRY.registerEntity("jungle_zombie", EntityType.Builder.of(JungleZombie::new, MobCategory.MONSTER).sized(0.6f, 1.95f).clientTrackingRange(8));
    public static final Supplier<EntityType<MossySkeleton>> MOSSY_SKELETON = REGISTRY.registerEntity("mossy_skeleton", EntityType.Builder.of(MossySkeleton::new, MobCategory.MONSTER).sized(0.6f, 1.99f).clientTrackingRange(8));

    public static final Supplier<SpawnEggItem> JUNGLE_ZOMBIE_SPAWN_EGG = REGISTRY.registerSpawnEgg("jungle_zombie_spawn_egg", JUNGLE_ZOMBIE::get, 44975, 9945732);
    public static final Supplier<SpawnEggItem> MOSSY_SKELETON_SPAWN_EGG = REGISTRY.registerSpawnEgg("mossy_skeleton_spawn_egg", MOSSY_SKELETON::get, 12698049, 7969893);

    public static String modId() {
        return REGISTRY.mod;
    }

    @ModEntryPoint
    public static void register() {
        REGISTRY.register();
    }
}
