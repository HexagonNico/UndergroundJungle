package io.github.hexagonnico.undergroundjungle.worldgen;

import com.mojang.serialization.Codec;
import io.github.hexagonnico.undergroundjungle.UndergroundJungle;
import io.github.hexagonnico.undergroundjungle.integration.IntegrationHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class IntegrationProcessor extends StructureProcessor {

    private static final IntegrationProcessor INSTANCE = new IntegrationProcessor();

    public static final Codec<IntegrationProcessor> CODEC = Codec.unit(() -> INSTANCE);

    private static StructureProcessorType<IntegrationProcessor> type;

    @Nullable
    @Override
    public StructureTemplate.StructureBlockInfo processBlock(@NotNull LevelReader world, @NotNull BlockPos pos1, @NotNull BlockPos pos2, @NotNull StructureTemplate.StructureBlockInfo structureBlockInfo1, @NotNull StructureTemplate.StructureBlockInfo structureBlockInfo2, @NotNull StructurePlaceSettings structurePlaceSettings) {
        BlockState blockState = structureBlockInfo2.state();
        if(blockState.is(Blocks.CHEST)) {
            BlockState integrationChest = IntegrationHelper.getChestIntegration()
                .setValue(ChestBlock.FACING, blockState.getValue(ChestBlock.FACING))
                .setValue(ChestBlock.TYPE, blockState.getValue(ChestBlock.TYPE));
            return new StructureTemplate.StructureBlockInfo(structureBlockInfo2.pos(), integrationChest, structureBlockInfo2.nbt());
        }
        return super.processBlock(world, pos1, pos2, structureBlockInfo1, structureBlockInfo2, structurePlaceSettings);
    }

    @Override
    protected @NotNull StructureProcessorType<?> getType() {
        return type;
    }

    public static void register() {
        type = Registry.register(BuiltInRegistries.STRUCTURE_PROCESSOR, new ResourceLocation(UndergroundJungle.MOD_ID, "integration"), () -> CODEC);
    }
}
