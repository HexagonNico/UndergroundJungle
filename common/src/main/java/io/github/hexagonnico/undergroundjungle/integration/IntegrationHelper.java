package io.github.hexagonnico.undergroundjungle.integration;

import com.mojang.logging.LogUtils;
import io.github.hexagonnico.undergroundjungle.PlatformHelper;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import org.slf4j.Logger;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IntegrationHelper {

    private static final Logger LOGGER = LogUtils.getLogger();

    @SuppressWarnings("JavaReflectionInvocation")
    public static void addTerraBlenderRegions() {
        if(PlatformHelper.isModLoaded("terrablender")) try {
            Class<?> regionClass = Class.forName("terrablender.api.Region");
            Method registerMethod = Class.forName("terrablender.api.Regions").getMethod("register", regionClass);
            Object regionInstance = Class.forName("io.github.hexagonnico.undergroundjungle.integration.terrablender.UndergroundJungleRegion").getConstructor().newInstance();
            registerMethod.invoke(null, regionInstance);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | ClassNotFoundException | InvocationTargetException e) {
            LOGGER.error("Error with TerraBlender integration", e);
        }
    }

    public static BlockState getChestIntegration() {
        if(PlatformHelper.isModLoaded("woodworks")) {
            ResourceLocation key = new ResourceLocation("woodworks", "jungle_chest");
            if(BuiltInRegistries.BLOCK.containsKey(key)) {
                return BuiltInRegistries.BLOCK.get(key).defaultBlockState();
            }
        } else if(PlatformHelper.isModLoaded("quark")) {
            ResourceLocation key = new ResourceLocation("quark", "jungle_chest");
            if(BuiltInRegistries.BLOCK.containsKey(key)) {
                return BuiltInRegistries.BLOCK.get(key).defaultBlockState();
            }
        }
        return Blocks.CHEST.defaultBlockState();
    }
}
