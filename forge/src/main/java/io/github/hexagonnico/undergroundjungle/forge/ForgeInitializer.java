package io.github.hexagonnico.undergroundjungle.forge;

import io.github.hexagonnico.undergroundjungle.UndergroundJungle;
import io.github.hexagonnico.undergroundjungle.integration.IntegrationHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(UndergroundJungle.MOD_ID)
public class ForgeInitializer {

    public ForgeInitializer() {
        MinecraftForge.EVENT_BUS.register(this);
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(this::commonSetup);
        UndergroundJungle.init();
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(IntegrationHelper::addTerraBlenderRegions);
    }
}
