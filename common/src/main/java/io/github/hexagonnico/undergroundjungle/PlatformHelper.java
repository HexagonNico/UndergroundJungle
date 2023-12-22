package io.github.hexagonnico.undergroundjungle;

import java.util.ServiceLoader;

public class PlatformHelper {

    private static final Platform PLATFORM = ServiceLoader.load(Platform.class).findFirst().orElse(new ErrorPlatform());

    public static boolean isModLoaded(String mod) {
        return PLATFORM.isModLoaded(mod);
    }

    private static class ErrorPlatform implements Platform {

        @Override
        public boolean isModLoaded(String mod) {
            return false;
        }
    }
}
