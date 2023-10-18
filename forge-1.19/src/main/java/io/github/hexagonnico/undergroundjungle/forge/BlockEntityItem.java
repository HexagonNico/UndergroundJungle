package io.github.hexagonnico.undergroundjungle.forge;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

/**
 * Extension of {@link BlockItem} that implements forge's method {@link net.minecraft.world.item.Item#initializeClient(Consumer)} needed to render block entity items.
 *
 * @author Nico
 */
public class BlockEntityItem extends BlockItem {

    /** Needed to create the block entity to be rendered */
    private final BlockEntityType.BlockEntitySupplier<?> blockEntitySupplier;

    /**
     * Constructs a {@code BlockEntityItem}.
     *
     * @param block The block corresponding to this item
     * @param blockEntitySupplier Needed to create the block entity to be rendered
     * @param properties Item properties
     */
    public BlockEntityItem(Block block, BlockEntityType.BlockEntitySupplier<?> blockEntitySupplier, Properties properties) {
        super(block, properties);
        this.blockEntitySupplier = blockEntitySupplier;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new IClientItemExtensions() {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer() {
                Minecraft minecraft = Minecraft.getInstance();
                return new BlockEntityWithoutLevelRenderer(minecraft.getBlockEntityRenderDispatcher(), minecraft.getEntityModels()) {

                    /** The block entity to be rendered as the item */
                    private final BlockEntity blockEntity = blockEntitySupplier.create(BlockPos.ZERO, getBlock().defaultBlockState());

                    @Override
                    public void renderByItem(@NotNull ItemStack itemStack, @NotNull ItemDisplayContext itemDisplayContext, @NotNull PoseStack poseStack, @NotNull MultiBufferSource multiBufferSource, int x, int y) {
                        minecraft.getBlockEntityRenderDispatcher().renderItem(blockEntity, poseStack, multiBufferSource, x, y);
                    }
                };
            }
        });
    }
}
