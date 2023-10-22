package io.github.hexagonnico.undergroundjungle.fabric;

import io.github.hexagonnico.undergroundjungle.RegistryManager;
import io.github.hexagonnico.undergroundjungle.fabric.renderers.TempleChestItemRenderer;
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

/**
 * Fabric client initializer.
 *
 * @author Nico
 */
public class FabricClientInitializer implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockEntityRenderers.register(RegistryManager.TEMPLE_CHEST_ENTITY.get(), ChestRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(RegistryManager.JUNGLE_VINES.get(), RenderType.cutout());
        BlockRenderLayerMap.INSTANCE.putBlock(RegistryManager.JUNGLE_VINES_PLANT.get(), RenderType.cutout());
        EntityRendererRegistry.register(RegistryManager.JUNGLE_ZOMBIE.get(), JungleZombieRenderer::new);
        EntityRendererRegistry.register(RegistryManager.MOSSY_SKELETON.get(), MossySkeletonRenderer::new);
        BuiltinItemRendererRegistry.INSTANCE.register(RegistryManager.TEMPLE_CHEST.get(), new TempleChestItemRenderer());
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.BUILDING_BLOCKS).register(listener -> {
            listener.accept(RegistryManager.TEMPLE_BRICKS.get());
            listener.accept(RegistryManager.CRACKED_TEMPLE_BRICKS.get());
            listener.accept(RegistryManager.MOSSY_TEMPLE_BRICKS.get());
            listener.accept(RegistryManager.CHISELED_TEMPLE_BRICKS.get());
            listener.accept(RegistryManager.TEMPLE_BRICK_TILES.get());
            listener.accept(RegistryManager.TEMPLE_BRICK_STAIRS.get());
            listener.accept(RegistryManager.TEMPLE_BRICK_SLAB.get());
            listener.accept(RegistryManager.TEMPLE_BRICK_WALL.get());
            listener.accept(RegistryManager.TEMPLE_BRICK_TILE_STAIRS.get());
            listener.accept(RegistryManager.TEMPLE_BRICK_TILE_SLAB.get());
            listener.accept(RegistryManager.TEMPLE_BRICK_TILE_WALL.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.NATURAL_BLOCKS).register(listener -> {
            listener.accept(RegistryManager.JUNGLE_GRASS.get());
            listener.accept(RegistryManager.JUNGLE_VINES.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.FUNCTIONAL_BLOCKS).register(listener -> {
            listener.accept(RegistryManager.TEMPLE_CHEST.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(listener -> {
            listener.accept(RegistryManager.TEMPLE_KEY.get());
            listener.accept(RegistryManager.TEMPLE_SHOVEL.get());
            listener.accept(RegistryManager.TEMPLE_PICKAXE.get());
            listener.accept(RegistryManager.TEMPLE_AXE.get());
            listener.accept(RegistryManager.TEMPLE_HOE.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.COMBAT).register(listener -> {
            listener.accept(RegistryManager.TEMPLE_SWORD.get());
            listener.accept(RegistryManager.TEMPLE_AXE.get());
        });
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.SPAWN_EGGS).register(listener -> {
            listener.accept(RegistryManager.MOSSY_SKELETON_SPAWN_EGG.get());
            listener.accept(RegistryManager.JUNGLE_ZOMBIE_SPAWN_EGG.get());
        });
    }
}
