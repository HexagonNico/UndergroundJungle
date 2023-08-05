package io.github.hexagonnico.undergroundjungle.renderers;

import io.github.hexagonnico.undergroundjungle.UndergroundJungleMod;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.blockentity.ChestRenderer;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.jetbrains.annotations.NotNull;

public class TempleChestRenderer<T extends BlockEntity & LidBlockEntity> extends ChestRenderer<T> {

    public TempleChestRenderer(BlockEntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    protected @NotNull Material getMaterial(@NotNull T blockEntity, @NotNull ChestType chestType) {
        return new Material(Sheets.CHEST_SHEET, new ResourceLocation(UndergroundJungleMod.ID, "entity/chest/temple"));
    }
}
