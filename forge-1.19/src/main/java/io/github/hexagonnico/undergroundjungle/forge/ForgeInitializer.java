package io.github.hexagonnico.undergroundjungle.forge;

import io.github.hexagonnico.undergroundjungle.RegistryManager;
import io.github.hexagonnico.undergroundjungle.integration.IntegrationHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

/**
 * Forge mod initializer.
 *
 * @author Nico
 */
@Mod("underground_jungle")
public class ForgeInitializer {

    /**
     * Initialize forge.
     */
    public ForgeInitializer() {
        RegistryManager.register();
        MinecraftForge.EVENT_BUS.register(this);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(IntegrationHelper::addTerraBlenderRegions);
    }
}
