package io.github.hexagonnico.undergroundjungle.forge;

import io.github.hexagonnico.undergroundjungle.CommonRegistry;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(ForgeInitializer.MOD_ID)
public class ForgeInitializer {

    public static final String MOD_ID = "underground_jungle";

    public ForgeInitializer() {
        CommonRegistry.init(new ForgeRegistry());
        MinecraftForge.EVENT_BUS.register(this);
    }
}
