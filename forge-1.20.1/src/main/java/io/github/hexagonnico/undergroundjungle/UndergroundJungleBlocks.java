package io.github.hexagonnico.undergroundjungle;

import io.github.hexagonnico.undergroundjungle.blocks.JungleVinesBlock;
import io.github.hexagonnico.undergroundjungle.blocks.JungleVinesPlantBlock;
import io.github.hexagonnico.undergroundjungle.blocks.MudGrassBlock;
import io.github.hexagonnico.undergroundjungle.blocks.TempleChestBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class UndergroundJungleBlocks {

    private static final DeferredRegister<Block> REGISTER = DeferredRegister.create(Registries.BLOCK, UndergroundJungleMod.ID);

    public static final RegistryObject<Block> JUNGLE_GRASS = REGISTER.register("jungle_grass", () -> new MudGrassBlock(BlockBehaviour.Properties.copy(Blocks.MUD).mapColor(MapColor.GRASS).sound(SoundType.GRASS).randomTicks(), "jungle_vegetation"));
    public static final RegistryObject<Block> TEMPLE_BRICKS = REGISTER.register("temple_bricks", () -> new Block(BlockBehaviour.Properties.of().requiresCorrectToolForDrops().mapColor(MapColor.TERRACOTTA_BROWN).sound(SoundType.STONE).strength(30.0f, 1200.0f)));
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
    public static final RegistryObject<Block> GLOWING_MUSHROOM = REGISTER.register("glowing_mushroom", () -> new MushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).lightLevel(state -> 7).hasPostProcess((state, getter, pos) -> true), ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(UndergroundJungleMod.ID, "huge_glowing_mushroom"))));
    public static final RegistryObject<Block> GLOWING_MUSHROOM_BLOCK = REGISTER.register("glowing_mushroom_block", () -> new HugeMushroomBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLUE).strength(0.2F).sound(SoundType.WOOD).lightLevel(state -> 10)));
    public static final RegistryObject<Block> MUSHROOM_TALL_GRASS = REGISTER.register("mushroom_tall_grass", () -> new TallGrassBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XYZ)));
    public static final RegistryObject<Block> MUSHROOM_GRASS = REGISTER.register("mushroom_grass", () -> new MudGrassBlock(BlockBehaviour.Properties.copy(JUNGLE_GRASS.get()).mapColor(MapColor.COLOR_BLUE), "mushroom_vegetation"));
    public static final RegistryObject<Block> JUNGLE_VINES_PLANT = REGISTER.register("jungle_vines_plant", () -> new JungleVinesPlantBlock(BlockBehaviour.Properties.of().noCollission().instabreak().sound(SoundType.CAVE_VINES), JungleVinesBlock.Type.REGULAR));
    public static final RegistryObject<Block> JUNGLE_VINES = REGISTER.register("jungle_vines", () -> new JungleVinesBlock(BlockBehaviour.Properties.copy(JUNGLE_VINES_PLANT.get()), JungleVinesBlock.Type.REGULAR));
    public static final RegistryObject<Block> MUSHROOM_VINES_PLANT = REGISTER.register("mushroom_vines_plant", () -> new JungleVinesPlantBlock(BlockBehaviour.Properties.copy(JUNGLE_VINES_PLANT.get()), JungleVinesBlock.Type.MUSHROOM));
    public static final RegistryObject<Block> MUSHROOM_VINES = REGISTER.register("mushroom_vines", () -> new JungleVinesBlock(BlockBehaviour.Properties.copy(MUSHROOM_VINES_PLANT.get()), JungleVinesBlock.Type.MUSHROOM));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}
