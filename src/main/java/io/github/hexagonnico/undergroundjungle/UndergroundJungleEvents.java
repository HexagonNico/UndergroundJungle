package io.github.hexagonnico.undergroundjungle;

import io.github.hexagonnico.undergroundjungle.entities.JungleSkeleton;
import io.github.hexagonnico.undergroundjungle.entities.JungleZombie;
import io.github.hexagonnico.undergroundjungle.renderers.*;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
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
            event.accept(UndergroundJungleItems.JUNGLE_VINES::get);
        } else if(event.getTab().equals(CreativeModeTabs.FUNCTIONAL_BLOCKS)) {
            event.accept(UndergroundJungleItems.TEMPLE_CHEST::get);
        } else if(event.getTab().equals(CreativeModeTabs.TOOLS_AND_UTILITIES)) {
            event.accept(UndergroundJungleItems.TEMPLE_KEY::get);
            event.accept(UndergroundJungleItems.TEMPLE_SHOVEL::get);
            event.accept(UndergroundJungleItems.TEMPLE_PICKAXE::get);
            event.accept(UndergroundJungleItems.TEMPLE_AXE::get);
            event.accept(UndergroundJungleItems.TEMPLE_HOE::get);
        } else if(event.getTab().equals(CreativeModeTabs.COMBAT)) {
            event.accept(UndergroundJungleItems.TEMPLE_SWORD::get);
            event.accept(UndergroundJungleItems.TEMPLE_AXE::get);
        }
    }

    @SubscribeEvent
    @SuppressWarnings("unused")
    public void registerRenders(EntityRenderersEvent.RegisterRenderers event) {
        event.registerBlockEntityRenderer(UndergroundJungleBlockEntities.TEMPLE_CHEST.get(), TempleChestRenderer::new);
        event.registerEntityRenderer(UndergroundJungleEntities.JUNGLE_SKELETON.get(), JungleSkeletonRenderer::new);
        event.registerEntityRenderer(UndergroundJungleEntities.JUNGLE_ZOMBIE.get(), JungleZombieRenderer::new);
    }

    @SubscribeEvent
    @SuppressWarnings("unused")
    public void createAttributes(EntityAttributeCreationEvent event) {
        event.put(UndergroundJungleEntities.JUNGLE_SKELETON.get(), JungleSkeleton.attributes().build());
        event.put(UndergroundJungleEntities.JUNGLE_ZOMBIE.get(), JungleZombie.attributes().build());
    }
}
