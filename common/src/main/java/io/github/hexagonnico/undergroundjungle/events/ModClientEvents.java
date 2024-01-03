package io.github.hexagonnico.undergroundjungle.events;

import io.github.hexagonnico.undergroundjungle.UndergroundJungle;
import io.github.hexagonnico.undergroundjungle.renderers.JungleZombieRenderer;
import io.github.hexagonnico.undergroundjungle.renderers.MossySkeletonRenderer;
import io.github.phantomloader.library.events.ClientEventHandler;
import io.github.phantomloader.library.events.RegisterBlockEntityRenderersEvent;
import io.github.phantomloader.library.events.RegisterEntityRenderersEvent;
import io.github.phantomloader.library.utils.CreativeTabsUtils;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.ItemLike;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ModClientEvents implements ClientEventHandler {

    @Override
    public void addItemsToCreativeTab(ResourceKey<CreativeModeTab> resourceKey, Consumer<Supplier<? extends ItemLike>> event) {
        if(resourceKey.equals(CreativeTabsUtils.BUILDING_BLOCKS)) {
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
        } else if(resourceKey.equals(CreativeTabsUtils.NATURAL_BLOCKS)) {
            event.accept(UndergroundJungle.JUNGLE_GRASS);
            event.accept(UndergroundJungle.JUNGLE_VINES);
        } else if(resourceKey.equals(CreativeTabsUtils.FUNCTIONAL_BLOCKS)) {
            event.accept(UndergroundJungle.TEMPLE_CHEST);
        } else if(resourceKey.equals(CreativeTabsUtils.TOOLS_AND_UTILITIES)) {
            event.accept(UndergroundJungle.TEMPLE_KEY);
            event.accept(UndergroundJungle.TEMPLE_SHOVEL);
            event.accept(UndergroundJungle.TEMPLE_PICKAXE);
            event.accept(UndergroundJungle.TEMPLE_AXE);
            event.accept(UndergroundJungle.TEMPLE_HOE);
        } else if(resourceKey.equals(CreativeTabsUtils.COMBAT)) {
            event.accept(UndergroundJungle.TEMPLE_SWORD);
            event.accept(UndergroundJungle.TEMPLE_AXE);
        } else if(resourceKey.equals(CreativeTabsUtils.SPAWN_EGGS)) {
            event.accept(UndergroundJungle.MOSSY_SKELETON_SPAWN_EGG);
            event.accept(UndergroundJungle.JUNGLE_ZOMBIE_SPAWN_EGG);
        }
    }

    @Override
    public void registerBlockEntityRenderers(RegisterBlockEntityRenderersEvent event) {
        event.register(UndergroundJungle.TEMPLE_CHEST_ENTITY.get(), ChestRenderer::new);
        event.registerItemRenderer(UndergroundJungle.TEMPLE_CHEST);
    }

    @Override
    public void registerEntityRenderers(RegisterEntityRenderersEvent event) {
        event.register(UndergroundJungle.JUNGLE_ZOMBIE.get(), JungleZombieRenderer::new);
        event.register(UndergroundJungle.MOSSY_SKELETON.get(), MossySkeletonRenderer::new);
    }
}
