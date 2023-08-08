package io.github.hexagonnico.undergroundjungle.renderers;

import io.github.hexagonnico.undergroundjungle.UndergroundJungleMod;
import io.github.hexagonnico.undergroundjungle.blocks.TempleChestBlockEntity;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.jetbrains.annotations.NotNull;

public class TempleChestRenderer extends ChestRenderer<TempleChestBlockEntity> {

    public TempleChestRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected @NotNull Material getMaterial(@NotNull TempleChestBlockEntity blockEntity, @NotNull ChestType chestType) {
        return new Material(Sheets.CHEST_SHEET, new ResourceLocation(UndergroundJungleMod.ID, "entity/chest/temple"));
    }
}
