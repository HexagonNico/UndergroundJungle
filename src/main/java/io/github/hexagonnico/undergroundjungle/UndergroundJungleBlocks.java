package io.github.hexagonnico.undergroundjungle;

import io.github.hexagonnico.undergroundjungle.blocks.MudGrassBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class UndergroundJungleBlocks {

    private static final DeferredRegister<Block> REGISTER = DeferredRegister.create(Registries.BLOCK, UndergroundJungleMod.ID);

    public static final RegistryObject<Block> JUNGLE_GRASS = REGISTER.register("jungle_grass", () -> new MudGrassBlock(BlockBehaviour.Properties.copy(Blocks.MUD).color(MaterialColor.GRASS).sound(SoundType.GRASS).randomTicks()));

    public static void register(IEventBus eventBus) {
        REGISTER.register(eventBus);
    }
}
