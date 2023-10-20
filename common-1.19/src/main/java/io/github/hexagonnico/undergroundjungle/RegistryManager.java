package io.github.hexagonnico.undergroundjungle;

import io.github.hexagonnico.undergroundjungle.blocks.*;
import io.github.hexagonnico.undergroundjungle.entities.JungleZombie;
import io.github.hexagonnico.undergroundjungle.entities.MossySkeleton;
import io.github.hexagonnico.undergroundjungle.items.ModAxeItem;
import io.github.hexagonnico.undergroundjungle.items.ModHoeItem;
import io.github.hexagonnico.undergroundjungle.items.ModPickaxeItem;
import io.github.hexagonnico.undergroundjungle.items.ModToolTier;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.ServiceLoader;
import java.util.function.Supplier;

/**
 * Mod registry manager.
 * Abstracts the registration process across different mod loaders.
 *
 * @author Nico
 */
public final class RegistryManager {

    /** The mod registry of the current loader */
    private static final ModRegistry REGISTRY = ServiceLoader.load(ModRegistry.class).findFirst().orElseThrow();

    public static final Supplier<MudGrassBlock> JUNGLE_GRASS = REGISTRY.registerBlockAndItem("jungle_grass", () -> new MudGrassBlock(BlockBehaviour.Properties.copy(Blocks.MUD).color(MaterialColor.GRASS).sound(SoundType.GRASS).randomTicks()));
    public static final Supplier<Block> TEMPLE_BRICKS = REGISTRY.registerBlockAndItem("temple_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().color(MaterialColor.TERRACOTTA_BROWN).sound(SoundType.STONE).strength(30.0f, 1200.0f)));
    public static final Supplier<Block> CRACKED_TEMPLE_BRICKS = REGISTRY.registerBlockVariant("cracked_temple_bricks", TEMPLE_BRICKS);
    public static final Supplier<Block> MOSSY_TEMPLE_BRICKS = REGISTRY.registerBlockVariant("mossy_temple_bricks", TEMPLE_BRICKS);
    public static final Supplier<Block> CHISELED_TEMPLE_BRICKS = REGISTRY.registerBlockVariant("chiseled_temple_bricks", TEMPLE_BRICKS);
    public static final Supplier<Block> TEMPLE_BRICK_TILES = REGISTRY.registerBlockVariant("temple_brick_tiles", TEMPLE_BRICKS);
    public static final Supplier<StairBlock> TEMPLE_BRICK_STAIRS = REGISTRY.registerStairs("temple_brick_stairs", TEMPLE_BRICKS);
    public static final Supplier<SlabBlock> TEMPLE_BRICK_SLAB = REGISTRY.registerSlab("temple_brick_slab", TEMPLE_BRICKS);
    public static final Supplier<WallBlock> TEMPLE_BRICK_WALL = REGISTRY.registerWall("temple_brick_wall", TEMPLE_BRICKS);
    public static final Supplier<StairBlock> TEMPLE_BRICK_TILE_STAIRS = REGISTRY.registerStairs("temple_brick_tile_stairs", TEMPLE_BRICK_TILES);
    public static final Supplier<SlabBlock> TEMPLE_BRICK_TILE_SLAB = REGISTRY.registerSlab("temple_brick_tile_slab", TEMPLE_BRICK_TILES);
    public static final Supplier<WallBlock> TEMPLE_BRICK_TILE_WALL = REGISTRY.registerWall("temple_brick_tile_wall", TEMPLE_BRICK_TILES);
    public static final Supplier<TempleChestBlock> TEMPLE_CHEST = REGISTRY.registerBlock("temple_chest", () -> new TempleChestBlock(BlockBehaviour.Properties.copy(TEMPLE_BRICKS.get()).strength(-1.0f, 3600000.0f).noLootTable()));
    public static final Supplier<JungleVinesPlantBlock> JUNGLE_VINES_PLANT = REGISTRY.registerBlock("jungle_vines_plant", () -> new JungleVinesPlantBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.CAVE_VINES)));
    public static final Supplier<JungleVinesBlock> JUNGLE_VINES = REGISTRY.registerBlockAndItem("jungle_vines", () -> new JungleVinesBlock(BlockBehaviour.Properties.copy(JUNGLE_VINES_PLANT.get())));

    public static final Supplier<Item> TEMPLE_KEY = REGISTRY.registerItem("temple_key", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final Supplier<SwordItem> TEMPLE_SWORD = REGISTRY.registerItem("temple_sword", () -> new SwordItem(ModToolTier.TEMPLE, 3, -2.4f, new Item.Properties()));
    public static final Supplier<ShovelItem> TEMPLE_SHOVEL = REGISTRY.registerItem("temple_shovel", () -> new ShovelItem(ModToolTier.TEMPLE, 1.5f, -3.0f, new Item.Properties()));
    public static final Supplier<PickaxeItem> TEMPLE_PICKAXE = REGISTRY.registerItem("temple_pickaxe", () -> new ModPickaxeItem(ModToolTier.TEMPLE, 1, -2.8f, new Item.Properties()));
    public static final Supplier<AxeItem> TEMPLE_AXE = REGISTRY.registerItem("temple_axe", () -> new ModAxeItem(ModToolTier.TEMPLE, 5.0f, -3.0f, new Item.Properties()));
    public static final Supplier<HoeItem> TEMPLE_HOE = REGISTRY.registerItem("temple_hoe", () -> new ModHoeItem(ModToolTier.TEMPLE, -3, 0.0f, new Item.Properties()));

    public static final Supplier<BlockEntityType<TempleChestBlockEntity>> TEMPLE_CHEST_ENTITY = REGISTRY.registerBlockEntityAndItem("temple_chest", TEMPLE_CHEST, TempleChestBlockEntity::new);

    public static final Supplier<EntityType<JungleZombie>> JUNGLE_ZOMBIE = REGISTRY.registerEntity("jungle_zombie", EntityType.Builder.of(JungleZombie::new, MobCategory.MONSTER).sized(0.6f, 1.95f).clientTrackingRange(8));
    public static final Supplier<EntityType<MossySkeleton>> MOSSY_SKELETON = REGISTRY.registerEntity("mossy_skeleton", EntityType.Builder.of(MossySkeleton::new, MobCategory.MONSTER).sized(0.6f, 1.99f).clientTrackingRange(8));

    public static final Supplier<SpawnEggItem> JUNGLE_ZOMBIE_SPAWN_EGG = REGISTRY.registerSpawnEgg("jungle_zombie_spawn_egg", JUNGLE_ZOMBIE, 44975, 9945732);
    public static final Supplier<SpawnEggItem> MOSSY_SKELETON_SPAWN_EGG = REGISTRY.registerSpawnEgg("mossy_skeleton_spawn_egg", MOSSY_SKELETON, 12698049, 7969893);

    /**
     * Finalizes the registration process by registering all the objects added to the registry.
     * Different mod loaders should call this method from their initializer.
     */
    public static void register() {
        REGISTRY.register();
    }
}
