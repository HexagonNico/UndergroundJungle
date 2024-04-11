package io.github.hexagonnico.undergroundjungle.integration;

import com.mojang.logging.LogUtils;
import io.github.hexagonnico.undergroundjungle.PlatformHelper;
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
}
