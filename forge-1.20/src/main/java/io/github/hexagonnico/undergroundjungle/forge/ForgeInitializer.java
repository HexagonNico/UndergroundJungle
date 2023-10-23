package io.github.hexagonnico.undergroundjungle.forge;

import io.github.hexagonnico.undergroundjungle.RegistryManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

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
    }
}
