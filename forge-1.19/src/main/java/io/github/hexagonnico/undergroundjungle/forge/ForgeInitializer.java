package io.github.hexagonnico.undergroundjungle.forge;

import io.github.hexagonnico.undergroundjungle.CommonInitializer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

/**
 * Forge mod initializer.
 *
 * @author Nico
 */
@Mod(ForgeInitializer.MOD_ID)
public class ForgeInitializer extends CommonInitializer {

    /**
     * Initialize forge.
     */
    public ForgeInitializer() {
        this.init(new ForgeRegistry());
        MinecraftForge.EVENT_BUS.register(this);
    }
}
