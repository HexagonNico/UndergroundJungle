package io.github.hexagonnico.undergroundjungle.mixin;

import io.github.hexagonnico.undergroundjungle.UndergroundJungle;
import io.github.hexagonnico.undergroundjungle.blocks.TempleChestBlockEntity;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.resources.model.Material;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.properties.ChestType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Mixin class for {@link Sheets}.
 * Used to add the temple chest texture to the chest renderer.
 *
 * @author Nico
 */
@Mixin(Sheets.class)
@SuppressWarnings("unused")
public class SheetsMixin {

    /** Temple chest texture location */
    private static final Material CHEST_MATERIAL = new Material(Sheets.CHEST_SHEET, new ResourceLocation(UndergroundJungle.MOD_ID, "entity/chest/temple"));

    /**
     * Returns {@link SheetsMixin#CHEST_MATERIAL} if the given block entity is a {@link TempleChestBlockEntity}.
     *
     * @param blockEntity Block entity
     * @param type Single, left, or right
     * @param christmas True for Christmas chests
     * @param callbackInfo Mixin callback info
     */
    @Inject(at = @At("HEAD"), method = "chooseMaterial", cancellable = true)
    private static void chooseMaterial(BlockEntity blockEntity, ChestType type, boolean christmas, CallbackInfoReturnable<Material> callbackInfo) {
        if(blockEntity instanceof TempleChestBlockEntity) {
            callbackInfo.setReturnValue(CHEST_MATERIAL);
        }
    }
}
