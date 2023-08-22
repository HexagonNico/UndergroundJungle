package io.github.hexagonnico.undergroundjungle.renderers;

import io.github.hexagonnico.undergroundjungle.UndergroundJungleMod;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;
import org.jetbrains.annotations.NotNull;

public class JungleZombieRenderer extends ZombieRenderer {

    private static final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(UndergroundJungleMod.ID, "textures/entity/jungle_zombie.png");

    public JungleZombieRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Zombie zombie) {
        return TEXTURE_LOCATION;
    }
}
