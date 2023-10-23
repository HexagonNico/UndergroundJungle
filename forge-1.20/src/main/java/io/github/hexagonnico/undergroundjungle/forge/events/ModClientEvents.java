package io.github.hexagonnico.undergroundjungle.forge.events;

import io.github.hexagonnico.undergroundjungle.RegistryManager;
import io.github.hexagonnico.undergroundjungle.renderers.JungleZombieRenderer;
import io.github.hexagonnico.undergroundjungle.renderers.MossySkeletonRenderer;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

/**
 * Client events running on the mod event bus.
 *
 * @author Nico
 */
@SuppressWarnings("unused")
@Mod.EventBusSubscriber(modid = "underground_jungle", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModClientEvents {

    /**
     * Adds mod items to creative tabs.
     *
     * @param event Creative tab event
     */
    @SubscribeEvent
    public static void creativeTabEvent(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey().equals(CreativeModeTabs.BUILDING_BLOCKS)) {
            event.accept(RegistryManager.TEMPLE_BRICKS.get());
            event.accept(RegistryManager.CRACKED_TEMPLE_BRICKS.get());
            event.accept(RegistryManager.MOSSY_TEMPLE_BRICKS.get());
            event.accept(RegistryManager.CHISELED_TEMPLE_BRICKS.get());
            event.accept(RegistryManager.TEMPLE_BRICK_TILES.get());
            event.accept(RegistryManager.TEMPLE_BRICK_STAIRS.get());
            event.accept(RegistryManager.TEMPLE_BRICK_SLAB.get());
            event.accept(RegistryManager.TEMPLE_BRICK_WALL.get());
            event.accept(RegistryManager.TEMPLE_BRICK_TILE_STAIRS.get());
            event.accept(RegistryManager.TEMPLE_BRICK_TILE_SLAB.get());
            event.accept(RegistryManager.TEMPLE_BRICK_TILE_WALL.get());
        } else if(event.getTabKey().equals(CreativeModeTabs.NATURAL_BLOCKS)) {
            event.accept(RegistryManager.JUNGLE_GRASS.get());
            event.accept(RegistryManager.JUNGLE_VINES.get());
        } else if(event.getTabKey().equals(CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
            event.accept(RegistryManager.TEMPLE_CHEST.get());
        } else if(event.getTabKey().equals(CreativeModeTabs.TOOLS_AND_UTILITIES)) {
            event.accept(RegistryManager.TEMPLE_KEY.get());
            event.accept(RegistryManager.TEMPLE_SHOVEL.get());
            event.accept(RegistryManager.TEMPLE_PICKAXE.get());
            event.accept(RegistryManager.TEMPLE_AXE.get());
            event.accept(RegistryManager.TEMPLE_HOE.get());
        } else if(event.getTabKey().equals(CreativeModeTabs.COMBAT)) {
            event.accept(RegistryManager.TEMPLE_SWORD.get());
            event.accept(RegistryManager.TEMPLE_AXE.get());
        } else if(event.getTabKey().equals(CreativeModeTabs.SPAWN_EGGS)) {
            event.accept(RegistryManager.MOSSY_SKELETON_SPAWN_EGG.get());
            event.accept(RegistryManager.JUNGLE_ZOMBIE_SPAWN_EGG.get());
        }
    }

    /**
     * Registers entity and block entity renderers.
     *
     * @param event Register renderers event
     */
    @SubscribeEvent
    public static void registerRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(RegistryManager.TEMPLE_CHEST_ENTITY.get(), ChestRenderer::new);
        event.registerEntityRenderer(RegistryManager.JUNGLE_ZOMBIE.get(), JungleZombieRenderer::new);
        event.registerEntityRenderer(RegistryManager.MOSSY_SKELETON.get(), MossySkeletonRenderer::new);
    }
}
