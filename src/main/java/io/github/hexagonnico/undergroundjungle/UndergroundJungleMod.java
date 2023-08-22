package io.github.hexagonnico.undergroundjungle;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(UndergroundJungleMod.ID)
public class UndergroundJungleMod {

    public static final String ID = "underground_jungle";

    public UndergroundJungleMod() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        UndergroundJungleBlocks.register(eventBus);
        UndergroundJungleBlockEntities.register(eventBus);
        UndergroundJungleItems.register(eventBus);
        UndergroundJungleEntities.register(eventBus);
        eventBus.register(new UndergroundJungleEvents());
        MinecraftForge.EVENT_BUS.register(this);
    }
}
