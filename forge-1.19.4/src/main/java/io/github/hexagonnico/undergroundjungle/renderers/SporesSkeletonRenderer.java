package io.github.hexagonnico.undergroundjungle.renderers;

import io.github.hexagonnico.undergroundjungle.UndergroundJungleMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SkeletonRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.AbstractSkeleton;
import org.jetbrains.annotations.NotNull;

public class SporesSkeletonRenderer extends SkeletonRenderer {

    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(UndergroundJungleMod.ID, "textures/entity/spores_skeleton.png");

    public SporesSkeletonRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull AbstractSkeleton abstractSkeleton) {
        return TEXTURE_LOCATION;
    }
}
