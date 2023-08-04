package io.github.hexagonnico.undergroundjungle;

import io.github.hexagonnico.undergroundjungle.blocks.MudGrassBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class UndergroundJungleBlocks {

    private static final DeferredRegister<Block> REGISTER = DeferredRegister.create(Registries.BLOCK, UndergroundJungleMod.ID);

    public static final RegistryObject<Block> JUNGLE_GRASS = REGISTER.register("jungle_grass", () -> new MudGrassBlock(BlockBehaviour.Properties.copy(Blocks.MUD).color(MaterialColor.GRASS).sound(SoundType.GRASS).randomTicks()));
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

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}
