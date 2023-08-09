package io.github.hexagonnico.undergroundjungle;

import io.github.hexagonnico.undergroundjungle.blocks.MudGrassBlock;
import io.github.hexagonnico.undergroundjungle.blocks.TempleChestBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class UndergroundJungleBlocks {

    private static final DeferredRegister<Block> REGISTER = DeferredRegister.create(Registries.BLOCK, UndergroundJungleMod.ID);

    public static final RegistryObject<Block> JUNGLE_GRASS = REGISTER.register("jungle_grass", () -> new MudGrassBlock(BlockBehaviour.Properties.copy(Blocks.MUD).color(MaterialColor.GRASS).sound(SoundType.GRASS).randomTicks(), ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(UndergroundJungleMod.ID, "jungle_vegetation"))));
    public static final RegistryObject<Block> TEMPLE_BRICKS = REGISTER.register("temple_bricks", () -> new Block(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().color(MaterialColor.TERRACOTTA_BROWN).sound(SoundType.STONE).strength(30.0f, 1200.0f)));
    public static final RegistryObject<Block> CRACKED_TEMPLE_BRICKS = REGISTER.register("cracked_temple_bricks", () -> new Block(BlockBehaviour.Properties.copy(TEMPLE_BRICKS.get())));
    public static final RegistryObject<Block> MOSSY_TEMPLE_BRICKS = REGISTER.register("mossy_temple_bricks", () -> new Block(BlockBehaviour.Properties.copy(TEMPLE_BRICKS.get())));
    public static final RegistryObject<Block> CHISELED_TEMPLE_BRICKS = REGISTER.register("chiseled_temple_bricks", () -> new Block(BlockBehaviour.Properties.copy(TEMPLE_BRICKS.get())));
    public static final RegistryObject<Block> TEMPLE_BRICK_TILES = REGISTER.register("temple_brick_tiles", () -> new Block(BlockBehaviour.Properties.copy(TEMPLE_BRICKS.get())));
    public static final RegistryObject<Block> TEMPLE_BRICK_STAIRS = REGISTER.register("temple_brick_stairs", () -> new StairBlock(() -> TEMPLE_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.copy(TEMPLE_BRICKS.get())));
    public static final RegistryObject<Block> TEMPLE_BRICK_SLAB = REGISTER.register("temple_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(TEMPLE_BRICKS.get())));
    public static final RegistryObject<Block> TEMPLE_BRICK_WALL = REGISTER.register("temple_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(TEMPLE_BRICKS.get())));
    public static final RegistryObject<Block> TEMPLE_BRICK_TILE_STAIRS = REGISTER.register("temple_brick_tile_stairs", () -> new StairBlock(() -> TEMPLE_BRICK_TILES.get().defaultBlockState(), BlockBehaviour.Properties.copy(TEMPLE_BRICK_TILES.get())));
    public static final RegistryObject<Block> TEMPLE_BRICK_TILE_SLAB = REGISTER.register("temple_brick_tile_slab", () -> new SlabBlock(BlockBehaviour.Properties.copy(TEMPLE_BRICK_TILES.get())));
    public static final RegistryObject<Block> TEMPLE_BRICK_TILE_WALL = REGISTER.register("temple_brick_tile_wall", () -> new WallBlock(BlockBehaviour.Properties.copy(TEMPLE_BRICK_TILES.get())));
    public static final RegistryObject<Block> TEMPLE_CHEST = REGISTER.register("temple_chest", () -> new TempleChestBlock(BlockBehaviour.Properties.copy(TEMPLE_BRICKS.get()).strength(-1.0F, 3600000.0F).noLootTable()));
    public static final RegistryObject<Block> GLOWING_MUSHROOM = REGISTER.register("glowing_mushroom", () -> new MushroomBlock(BlockBehaviour.Properties.of(Material.PLANT, MaterialColor.COLOR_BLUE).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).lightLevel(state -> 7).hasPostProcess((state, getter, pos) -> true), ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(UndergroundJungleMod.ID, "huge_glowing_mushroom"))));
    public static final RegistryObject<Block> GLOWING_MUSHROOM_BLOCK = REGISTER.register("glowing_mushroom_block", () -> new HugeMushroomBlock(BlockBehaviour.Properties.of(Material.WOOD, MaterialColor.COLOR_BLUE).strength(0.2F).sound(SoundType.WOOD).lightLevel(state -> 10)));
    public static final RegistryObject<Block> MUSHROOM_TALL_GRASS = REGISTER.register("mushroom_tall_grass", () -> new TallGrassBlock(BlockBehaviour.Properties.of(Material.REPLACEABLE_PLANT).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)));
    public static final RegistryObject<Block> MUSHROOM_GRASS = REGISTER.register("mushroom_grass", () -> new MudGrassBlock(BlockBehaviour.Properties.copy(JUNGLE_GRASS.get()).color(MaterialColor.COLOR_BLUE), ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(UndergroundJungleMod.ID, "mushroom_vegetation"))));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}
