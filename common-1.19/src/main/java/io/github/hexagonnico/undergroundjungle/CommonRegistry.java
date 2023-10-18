package io.github.hexagonnico.undergroundjungle;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

public class CommonRegistry {

    public static void init(AbstractRegistry registry) {
        registry.addItem("test_item", () -> new Item(new Item.Properties()));
        registry.addBlock("test_block", () -> new Block(BlockBehaviour.Properties.of(Material.BAMBOO)));
        registry.addBlockAndItem("test_test", () -> new Block(BlockBehaviour.Properties.of(Material.BAMBOO)));
        registry.registerAll();
    }
}
