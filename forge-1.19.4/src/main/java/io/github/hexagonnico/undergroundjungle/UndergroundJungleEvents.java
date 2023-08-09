package io.github.hexagonnico.undergroundjungle;

import io.github.hexagonnico.undergroundjungle.renderers.TempleChestRenderer;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class UndergroundJungleEvents {

    @SubscribeEvent
    @SuppressWarnings("unused")
    public void creativeTabEvent(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab().equals(CreativeModeTabs.BUILDING_BLOCKS)) {
            event.accept(UndergroundJungleItems.TEMPLE_BRICKS::get);
            event.accept(UndergroundJungleItems.CRACKED_TEMPLE_BRICKS::get);
            event.accept(UndergroundJungleItems.MOSSY_TEMPLE_BRICKS::get);
            event.accept(UndergroundJungleItems.CHISELED_TEMPLE_BRICKS::get);
            event.accept(UndergroundJungleItems.TEMPLE_BRICK_TILES::get);
            event.accept(UndergroundJungleItems.TEMPLE_BRICK_STAIRS::get);
            event.accept(UndergroundJungleItems.TEMPLE_BRICK_SLAB::get);
            event.accept(UndergroundJungleItems.TEMPLE_BRICK_WALL::get);
            event.accept(UndergroundJungleItems.TEMPLE_BRICK_TILE_STAIRS::get);
            event.accept(UndergroundJungleItems.TEMPLE_BRICK_TILE_SLAB::get);
            event.accept(UndergroundJungleItems.TEMPLE_BRICK_TILE_WALL::get);
        } else if(event.getTab().equals(CreativeModeTabs.NATURAL_BLOCKS)) {
            event.accept(UndergroundJungleItems.JUNGLE_GRASS::get);
            event.accept(UndergroundJungleItems.MUSHROOM_GRASS::get);
            event.accept(UndergroundJungleItems.GLOWING_MUSHROOM::get);
            event.accept(UndergroundJungleItems.GLOWING_MUSHROOM_BLOCK::get);
            event.accept(UndergroundJungleItems.MUSHROOM_TALL_GRASS::get);
        } else if(event.getTab().equals(CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
            event.accept(UndergroundJungleItems.TEMPLE_CHEST::get);
        }
    }

    @SubscribeEvent
    @SuppressWarnings("unused")
    public void registerRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(UndergroundJungleBlockEntities.TEMPLE_CHEST.get(), TempleChestRenderer::new);
    }
}
