package io.github.hexagonnico.undergroundjungle.forge.events;

import io.github.hexagonnico.undergroundjungle.UndergroundJungle;
import io.github.hexagonnico.undergroundjungle.renderers.JungleZombieRenderer;
import io.github.hexagonnico.undergroundjungle.renderers.MossySkeletonRenderer;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = UndergroundJungle.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModClientEventHandler {

    @SubscribeEvent
    public static void onBuildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey().equals(CreativeModeTabs.BUILDING_BLOCKS)) {
            event.accept(UndergroundJungle.TEMPLE_BRICKS);
            event.accept(UndergroundJungle.CRACKED_TEMPLE_BRICKS);
            event.accept(UndergroundJungle.MOSSY_TEMPLE_BRICKS);
            event.accept(UndergroundJungle.CHISELED_TEMPLE_BRICKS);
            event.accept(UndergroundJungle.TEMPLE_BRICK_TILES);
            event.accept(UndergroundJungle.TEMPLE_BRICK_STAIRS);
            event.accept(UndergroundJungle.TEMPLE_BRICK_SLAB);
            event.accept(UndergroundJungle.TEMPLE_BRICK_WALL);
            event.accept(UndergroundJungle.TEMPLE_BRICK_TILE_STAIRS);
            event.accept(UndergroundJungle.TEMPLE_BRICK_TILE_SLAB);
            event.accept(UndergroundJungle.TEMPLE_BRICK_TILE_WALL);
        } else if(event.getTabKey().equals(CreativeModeTabs.NATURAL_BLOCKS)) {
            event.accept(UndergroundJungle.JUNGLE_GRASS);
            event.accept(UndergroundJungle.JUNGLE_VINES);
        } else if(event.getTabKey().equals(CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
            event.accept(UndergroundJungle.TEMPLE_CHEST);
        } else if(event.getTabKey().equals(CreativeModeTabs.TOOLS_AND_UTILITIES)) {
            event.accept(UndergroundJungle.TEMPLE_KEY);
            event.accept(UndergroundJungle.TEMPLE_SHOVEL);
            event.accept(UndergroundJungle.TEMPLE_PICKAXE);
            event.accept(UndergroundJungle.TEMPLE_AXE);
            event.accept(UndergroundJungle.TEMPLE_HOE);
            event.accept(UndergroundJungle.AXE_OF_REGROWTH);
        } else if(event.getTabKey().equals(CreativeModeTabs.COMBAT)) {
            event.accept(UndergroundJungle.TEMPLE_SWORD);
            event.accept(UndergroundJungle.TEMPLE_AXE);
            event.accept(UndergroundJungle.BLADE_OF_THE_JUNGLE);
        } else if(event.getTabKey().equals(CreativeModeTabs.INGREDIENTS)) {
            event.accept(UndergroundJungle.JUNGLE_SPORES);
        } else if(event.getTabKey().equals(CreativeModeTabs.SPAWN_EGGS)) {
            event.accept(UndergroundJungle.MOSSY_SKELETON_SPAWN_EGG);
            event.accept(UndergroundJungle.JUNGLE_ZOMBIE_SPAWN_EGG);
        }
    }

    @SubscribeEvent
    public static void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(UndergroundJungle.TEMPLE_CHEST_ENTITY.get(), ChestRenderer::new);
        event.registerEntityRenderer(UndergroundJungle.JUNGLE_ZOMBIE.get(), JungleZombieRenderer::new);
        event.registerEntityRenderer(UndergroundJungle.MOSSY_SKELETON.get(), MossySkeletonRenderer::new);
    }
}
