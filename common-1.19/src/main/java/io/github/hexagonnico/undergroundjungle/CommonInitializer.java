package io.github.hexagonnico.undergroundjungle;

/**
 * All the mod's initialization happens here.
 * Specific loaders may extend this class and call {@link CommonInitializer#init(AbstractRegistry)} to register things.
 *
 * @author Nico
 */
public class CommonInitializer {

    /** The mod id */
    public static final String MOD_ID = "underground_jungle";

    /**
     * Initialization process.
     * Registers everything.
     *
     * @param registry The platform's specific registry
     */
    protected final void init(AbstractRegistry registry) {
        registry.registerAll();
    }
}
