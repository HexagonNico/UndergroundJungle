package io.github.hexagonnico.undergroundjungle;

import java.util.ServiceLoader;

public class PlatformHelper {

    private static final Platform PLATFORM = ServiceLoader.load(Platform.class).findFirst().orElseThrow();

    public static String platformName() {
        return PLATFORM.platformName();
    }

    public static boolean isModLoaded(String mod) {
        return PLATFORM.isModLoaded(mod);
    }

    private PlatformHelper() {
        throw new AssertionError();
    }

    public interface Platform {

        String platformName();

        boolean isModLoaded(String mod);
    }
}
