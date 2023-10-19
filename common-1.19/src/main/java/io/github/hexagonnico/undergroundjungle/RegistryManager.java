package io.github.hexagonnico.undergroundjungle;

import io.github.hexagonnico.undergroundjungle.blocks.*;
import io.github.hexagonnico.undergroundjungle.entities.JungleZombie;
import io.github.hexagonnico.undergroundjungle.entities.MossySkeleton;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

import java.util.ServiceLoader;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public final class RegistryManager {

    private static final ModRegistry REGISTRY = ServiceLoader.load(ModRegistry.class).findFirst().orElseThrow();

    public static final Supplier<MudGrassBlock> JUNGLE_GRASS = registerBlock("jungle_grass", () -> new MudGrassBlock(BlockBehaviour.Properties.copy(Blocks.MUD).color(MaterialColor.GRASS).sound(SoundType.GRASS).randomTicks(), "jungle_vegetation"));
    public static final Supplier<Block> TEMPLE_BRICKS = registerBlock("temple_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().color(MaterialColor.TERRACOTTA_BROWN).sound(SoundType.STONE).strength(30.0f, 1200.0f)));
    public static final Supplier<Block> CRACKED_TEMPLE_BRICKS = registerBlockVariant("cracked_temple_bricks", TEMPLE_BRICKS);
    public static final Supplier<Block> MOSSY_TEMPLE_BRICKS = registerBlockVariant("mossy_temple_bricks", TEMPLE_BRICKS);
    public static final Supplier<Block> CHISELED_TEMPLE_BRICKS = registerBlockVariant("chiseled_temple_bricks", TEMPLE_BRICKS);
    public static final Supplier<Block> TEMPLE_BRICK_TILES = registerBlockVariant("temple_brick_tiles", TEMPLE_BRICKS);
    public static final Supplier<StairBlock> TEMPLE_BRICK_STAIRS = registerStairs("temple_brick_stairs", TEMPLE_BRICKS);
    public static final Supplier<SlabBlock> TEMPLE_BRICK_SLAB = registerSlab("temple_brick_slab", TEMPLE_BRICKS);
    public static final Supplier<WallBlock> TEMPLE_BRICK_WALL = registerWall("temple_brick_wall", TEMPLE_BRICKS);
    public static final Supplier<StairBlock> TEMPLE_BRICK_TILE_STAIRS = registerStairs("temple_brick_tile_stairs", TEMPLE_BRICK_TILES);
    public static final Supplier<SlabBlock> TEMPLE_BRICK_TILE_SLAB = registerSlab("temple_brick_tile_slab", TEMPLE_BRICK_TILES);
    public static final Supplier<WallBlock> TEMPLE_BRICK_TILE_WALL = registerWall("temple_brick_tile_wall", TEMPLE_BRICK_TILES);
    public static final Supplier<TempleChestBlock> TEMPLE_CHEST = registerBlock("temple_chest", () -> new TempleChestBlock(BlockBehaviour.Properties.copy(TEMPLE_BRICKS.get()).strength(-1.0f, 3600000.0f).noLootTable()));
    public static final Supplier<JungleVinesPlantBlock> JUNGLE_VINES_PLANT = registerBlock("jungle_vines_plant", () -> new JungleVinesPlantBlock(BlockBehaviour.Properties.of(Material.PLANT).noCollission().instabreak().sound(SoundType.CAVE_VINES)));
    public static final Supplier<JungleVinesBlock> JUNGLE_VINES = registerBlock("jungle_vines", () -> new JungleVinesBlock(BlockBehaviour.Properties.copy(JUNGLE_VINES_PLANT.get())));

    public static final Supplier<Item> TEMPLE_KEY = registerItem("temple_key", () -> new Item(new Item.Properties().stacksTo(1)));

    public static final Supplier<BlockItem> JUNGLE_GRASS_ITEM = registerBlockItem("jungle_grass", JUNGLE_GRASS);
    public static final Supplier<BlockItem> TEMPLE_BRICKS_ITEM = registerBlockItem("temple_bricks", TEMPLE_BRICKS);
    public static final Supplier<BlockItem> CRACKED_TEMPLE_BRICKS_ITEM = registerBlockItem("cracked_temple_bricks", CRACKED_TEMPLE_BRICKS);
    public static final Supplier<BlockItem> MOSSY_TEMPLE_BRICKS_ITEM = registerBlockItem("mossy_temple_bricks", MOSSY_TEMPLE_BRICKS);
    public static final Supplier<BlockItem> CHISELED_TEMPLE_BRICKS_ITEM = registerBlockItem("chiseled_temple_bricks", CHISELED_TEMPLE_BRICKS);
    public static final Supplier<BlockItem> TEMPLE_BRICK_TILES_ITEM = registerBlockItem("temple_brick_tiles", TEMPLE_BRICK_TILES);
    public static final Supplier<BlockItem> TEMPLE_BRICK_STAIRS_ITEM = registerBlockItem("temple_brick_stairs", TEMPLE_BRICK_STAIRS);
    public static final Supplier<BlockItem> TEMPLE_BRICK_SLAB_ITEM = registerBlockItem("temple_brick_slab", TEMPLE_BRICK_SLAB);
    public static final Supplier<BlockItem> TEMPLE_BRICK_WALL_ITEM = registerBlockItem("temple_brick_wall", TEMPLE_BRICK_WALL);
    public static final Supplier<BlockItem> TEMPLE_BRICK_TILE_STAIRS_ITEM = registerBlockItem("temple_brick_tile_stairs", TEMPLE_BRICK_TILE_STAIRS);
    public static final Supplier<BlockItem> TEMPLE_BRICK_TILE_SLAB_ITEM = registerBlockItem("temple_brick_tile_slab", TEMPLE_BRICK_TILE_SLAB);
    public static final Supplier<BlockItem> TEMPLE_BRICK_TILE_WALL_ITEM = registerBlockItem("temple_brick_tile_wall", TEMPLE_BRICK_TILE_WALL);
    public static final Supplier<BlockItem> TEMPLE_CHEST_ITEM = registerBlockItem("temple_chest", TEMPLE_CHEST);
    public static final Supplier<BlockItem> JUNGLE_VINES_ITEM = registerBlockItem("jungle_vines", JUNGLE_VINES);

    public static final Supplier<BlockEntityType<TempleChestBlockEntity>> TEMPLE_CHEST_ENTITY = registerBlockEntity("temple_chest", TEMPLE_CHEST, TempleChestBlockEntity::new);

//    public static final Supplier<EntityType<JungleZombie>> JUNGLE_ZOMBIE = registerEntity("jungle_zombie", EntityType.Builder.of(JungleZombie::new, MobCategory.MONSTER).sized(0.6f, 1.95f).clientTrackingRange(8));
//    public static final Supplier<EntityType<MossySkeleton>> MOSSY_SKELETON = registerEntity("mossy_skeleton", EntityType.Builder.of(MossySkeleton::new, MobCategory.MONSTER).sized(0.6f, 1.99f).clientTrackingRange(8));
//
//    public static final Supplier<SpawnEggItem> JUNGLE_ZOMBIE_SPAWN_EGG = registerSpawnEgg("jungle_zombie_spawn_egg", JUNGLE_ZOMBIE, 44975, 9945732);
//    public static final Supplier<SpawnEggItem> MOSSY_SKELETON_SPAWN_EGG = registerSpawnEgg("mossy_skeleton_spawn_egg", MOSSY_SKELETON, 12698049, 7969893);

    public static <T extends Block> Supplier<T> registerBlock(String name, Supplier<T> block) {
        return REGISTRY.registerBlock(name, block);
    }

    public static Supplier<Block> registerBlockVariant(String name, Supplier<? extends Block> base) {
        return REGISTRY.registerBlock(name, () -> new Block(BlockBehaviour.Properties.copy(base.get())));
    }

    public static Supplier<StairBlock> registerStairs(String name, Supplier<? extends Block> base) {
        return REGISTRY.registerBlock(name, () -> new ModStairBlock(base.get()));
    }

    public static Supplier<SlabBlock> registerSlab(String name, Supplier<? extends Block> base) {
        return REGISTRY.registerBlock(name, () -> new SlabBlock(BlockBehaviour.Properties.copy(base.get())));
    }

    public static Supplier<WallBlock> registerWall(String name, Supplier<? extends Block> base) {
        return REGISTRY.registerBlock(name, () -> new WallBlock(BlockBehaviour.Properties.copy(base.get())));
    }

    public static <T extends Item> Supplier<T> registerItem(String name, Supplier<T> item) {
        return REGISTRY.registerItem(name, item);
    }

    public static Supplier<BlockItem> registerBlockItem(String name, Supplier<? extends Block> block) {
        return REGISTRY.registerItem(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static <T extends BlockEntity> Supplier<BlockEntityType<T>> registerBlockEntity(String name, Supplier<? extends Block> block, BiFunction<BlockPos, BlockState, T> blockEntity) {
        return REGISTRY.registerBlockEntity(name, block, blockEntity);
    }

    public static <T extends Entity> Supplier<EntityType<T>> registerEntity(String name, EntityType.Builder<T> builder) {
        return REGISTRY.registerEntity(name, builder);
    }

    public static <T extends Mob> Supplier<SpawnEggItem> registerSpawnEgg(String name, Supplier<EntityType<T>> entity, int primaryColor, int secondaryColor) {
        return REGISTRY.registerItem(name, () -> new SpawnEggItem(entity.get(), primaryColor, secondaryColor, new Item.Properties()));
    }

    public static void register() {
        REGISTRY.register();
    }
}
