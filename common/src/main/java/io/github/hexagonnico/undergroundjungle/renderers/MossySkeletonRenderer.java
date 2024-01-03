package io.github.hexagonnico.undergroundjungle.renderers;

import io.github.hexagonnico.undergroundjungle.UndergroundJungle;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import org.jetbrains.annotations.NotNull;

/**
 * Mossy skeleton renderer.
 * Adds the mossy skeleton texture to the default skeleton renderer.
 *
 * @author Nico
 */
public class MossySkeletonRenderer extends SkeletonRenderer {

    /** Location pointing to the mossy skeleton texture */
    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(UndergroundJungle.MOD_ID, "textures/entity/mossy_skeleton.png");

    /**
     * Constructs the renderer.
     *
     * @param context Rendering context
     */
    public MossySkeletonRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull AbstractSkeleton abstractSkeleton) {
        return TEXTURE_LOCATION;
    }
}