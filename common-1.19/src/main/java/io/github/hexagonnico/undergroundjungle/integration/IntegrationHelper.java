package io.github.hexagonnico.undergroundjungle.integration;

import io.github.hexagonnico.undergroundjungle.PlatformHelper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class IntegrationHelper {

    @SuppressWarnings("JavaReflectionInvocation")
    public static void addTerraBlenderRegions() {
        if(PlatformHelper.isModLoaded("terrablender")) try {
            Class<?> regionClass = Class.forName("terrablender.api.Region");
            Method registerMethod = Class.forName("terrablender.api.Regions").getMethod("register", regionClass);
            Object regionInstance = Class.forName("io.github.hexagonnico.undergroundjungle.integration.terrablender.UndergroundJungleRegion").getConstructor().newInstance();
            registerMethod.invoke(null, regionInstance);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | ClassNotFoundException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
