package io.github.hexagonnico.undergroundjungle.fabric;

import io.github.hexagonnico.undergroundjungle.UndergroundJungle;
import io.github.hexagonnico.undergroundjungle.fabric.renderers.BlockEntityItemRenderer;
import io.github.hexagonnico.undergroundjungle.renderers.JungleZombieRenderer;
import io.github.hexagonnico.undergroundjungle.renderers.MossySkeletonRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.world.item.CreativeModeTabs;

public class FabricClientInitializer implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(listener -> listener.accept(UndergroundJungle.TEMPLE_BRICKS.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(listener -> listener.accept(UndergroundJungle.TEMPLE_BRICKS.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(listener -> listener.accept(UndergroundJungle.CRACKED_TEMPLE_BRICKS.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(listener -> listener.accept(UndergroundJungle.MOSSY_TEMPLE_BRICKS.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(listener -> listener.accept(UndergroundJungle.CHISELED_TEMPLE_BRICKS.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(listener -> listener.accept(UndergroundJungle.TEMPLE_BRICK_TILES.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(listener -> listener.accept(UndergroundJungle.TEMPLE_BRICK_STAIRS.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(listener -> listener.accept(UndergroundJungle.TEMPLE_BRICK_SLAB.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(listener -> listener.accept(UndergroundJungle.TEMPLE_BRICK_WALL.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(listener -> listener.accept(UndergroundJungle.TEMPLE_BRICK_TILE_STAIRS.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(listener -> listener.accept(UndergroundJungle.TEMPLE_BRICK_TILE_SLAB.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(listener -> listener.accept(UndergroundJungle.TEMPLE_BRICK_TILE_WALL.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(listener -> listener.accept(UndergroundJungle.JUNGLE_GRASS.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(listener -> listener.accept(UndergroundJungle.JUNGLE_VINES.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(listener -> listener.accept(UndergroundJungle.TEMPLE_CHEST.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(listener -> listener.accept(UndergroundJungle.TEMPLE_KEY.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(listener -> listener.accept(UndergroundJungle.TEMPLE_SHOVEL.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(listener -> listener.accept(UndergroundJungle.TEMPLE_PICKAXE.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(listener -> listener.accept(UndergroundJungle.TEMPLE_AXE.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(listener -> listener.accept(UndergroundJungle.TEMPLE_HOE.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(listener -> listener.accept(UndergroundJungle.AXE_OF_REGROWTH.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(listener -> listener.accept(UndergroundJungle.TEMPLE_SWORD.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(listener -> listener.accept(UndergroundJungle.TEMPLE_AXE.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(listener -> listener.accept(UndergroundJungle.BLADE_OF_THE_JUNGLE.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS).register(listener -> listener.accept(UndergroundJungle.JUNGLE_SPORES.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS).register(listener -> listener.accept(UndergroundJungle.MOSSY_SKELETON_SPAWN_EGG.get()));
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS).register(listener -> listener.accept(UndergroundJungle.JUNGLE_ZOMBIE_SPAWN_EGG.get()));
        BlockEntityRenderers.register(UndergroundJungle.TEMPLE_CHEST_ENTITY.get(), ChestRenderer::new);
        BuiltinItemRendererRegistry.INSTANCE.register(UndergroundJungle.TEMPLE_CHEST.get(), new BlockEntityItemRenderer(UndergroundJungle.TEMPLE_CHEST.get()));
        EntityRendererRegistry.register(UndergroundJungle.JUNGLE_ZOMBIE.get(), JungleZombieRenderer::new);
        EntityRendererRegistry.register(UndergroundJungle.MOSSY_SKELETON.get(), MossySkeletonRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(UndergroundJungle.JUNGLE_VINES.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(UndergroundJungle.JUNGLE_VINES_PLANT.get(), RenderType.cutout());
    }
}
