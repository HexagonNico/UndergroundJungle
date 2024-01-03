package io.github.hexagonnico.undergroundjungle.blocks;

import io.github.hexagonnico.undergroundjungle.UndergroundJungle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.WorldlyContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.ChestLidController;
import net.minecraft.world.level.block.entity.ContainerOpenersCounter;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.entity.RandomizableContainerBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

/**
 * Temple chest block entity.
 *
 * @author Nico
 */
public class TempleChestBlockEntity extends RandomizableContainerBlockEntity implements LidBlockEntity, WorldlyContainer {

    /** Holds the chest's inventory */
    private NonNullList<ItemStack> items = NonNullList.withSize(27, ItemStack.EMPTY);

    /** Keeps track of how many players are opening the chest */
    private final ContainerOpenersCounter openersCounter = new ContainerOpenersCounter() {
        @Override
        protected void onOpen(@NotNull Level world, @NotNull BlockPos pos, @NotNull BlockState state) {
            world.playSound(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.CHEST_OPEN, SoundSource.BLOCKS, 0.5f, world.random.nextFloat() * 0.1f + 0.9f);
        }

        @Override
        protected void onClose(@NotNull Level world, @NotNull BlockPos pos, @NotNull BlockState state) {
            world.playSound(null, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, SoundEvents.CHEST_CLOSE, SoundSource.BLOCKS, 0.5f, world.random.nextFloat() * 0.1f + 0.9f);
        }

        @Override
        protected void openerCountChanged(@NotNull Level world, @NotNull BlockPos pos, @NotNull BlockState state, int i1, int i2) {
            world.blockEvent(pos, state.getBlock(), 1, i2);
        }

        @Override
        protected boolean isOwnContainer(@NotNull Player player) {
            if(player.containerMenu instanceof ChestMenu chestMenu) {
                return chestMenu.getContainer() == TempleChestBlockEntity.this;
            }
            return false;
        }
    };

    /** Controls the chest's animation */
    private final ChestLidController lidController = new ChestLidController();

    /** Set to true when the chest is unlocked with the temple key */
    private boolean unlocked = false;

    /**
     * Constructs a temple chest block entity.
     *
     * @param pos Position
     * @param state Block state
     */
    public TempleChestBlockEntity(BlockPos pos, BlockState state) {
        super(UndergroundJungle.TEMPLE_CHEST_ENTITY.get(), pos, state);
    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    @Override
    protected @NotNull Component getDefaultName() {
        return Component.translatable("container.temple_chest");
    }

    @Override
    public void load(@NotNull CompoundTag compoundTag) {
        super.load(compoundTag);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        if(!this.tryLoadLootTable(compoundTag)) {
            ContainerHelper.loadAllItems(compoundTag, this.items);
        }
        this.unlocked = compoundTag.getBoolean("unlocked");
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        if(!this.trySaveLootTable(compoundTag)) {
            ContainerHelper.saveAllItems(compoundTag, this.items);
        }
        compoundTag.putBoolean("unlocked", this.unlocked);
    }

    /**
     * Advances the lid animation by one tick.
     * Needed to access {@link TempleChestBlockEntity#lidController} from {@link TempleChestBlock}.
     *
     * @param world World
     * @param pos Position
     * @param state Block state
     * @param blockEntity This block entity
     */
    @SuppressWarnings("unused")
    public static void lidAnimateTick(Level world, BlockPos pos, BlockState state, TempleChestBlockEntity blockEntity) {
        blockEntity.lidController.tickLid();
    }

    @Override
    public boolean triggerEvent(int i1, int i2) {
        if(i1 == 1) {
            this.lidController.shouldBeOpen(i2 > 0);
            return true;
        }
        return super.triggerEvent(i1, i2);
    }

    @Override
    public boolean canOpen(@NotNull Player player) {
        return this.unlocked && super.canOpen(player);
    }

    @Override
    public void startOpen(@NotNull Player player) {
        Level world = this.getLevel();
        if(!this.remove && !player.isSpectator() && world != null) {
            this.openersCounter.incrementOpeners(player, world, this.getBlockPos(), this.getBlockState());
        }
    }

    @Override
    public void stopOpen(@NotNull Player player) {
        Level world = this.getLevel();
        if(!this.remove && !player.isSpectator() && world != null) {
            this.openersCounter.decrementOpeners(player, world, this.getBlockPos(), this.getBlockState());
        }
    }

    /**
     * Attempts to unlock the temple chest by checking if the player is holding a temple key.
     *
     * @param player The player entity
     * @param hand The player's interaction hand
     */
    public void tryUnlock(Player player, InteractionHand hand) {
        if(!this.unlocked) {
            ItemStack itemInHand = player.getItemInHand(hand);
            if(itemInHand.is(UndergroundJungle.TEMPLE_KEY.get())) {
                if(!player.isCreative()) {
                    itemInHand.shrink(1);
                }
                this.unlocked = true;
                this.setChanged();
            }
        }
    }

    @Override
    protected @NotNull NonNullList<ItemStack> getItems() {
        return this.items;
    }

    @Override
    protected void setItems(@NotNull NonNullList<ItemStack> items) {
        this.items = items;
    }

    @Override
    public float getOpenNess(float f) {
        return this.lidController.getOpenness(f);
    }

    @Override
    protected @NotNull AbstractContainerMenu createMenu(int i, @NotNull Inventory inventory) {
        return ChestMenu.threeRows(i, inventory, this);
    }

    public void recheckOpen() {
        Level world = this.getLevel();
        if(!this.remove && world != null) {
            this.openersCounter.recheckOpeners(world, this.getBlockPos(), this.getBlockState());
        }
    }

    @Override
    public int @NotNull [] getSlotsForFace(@NotNull Direction face) {
        return new int[0];
    }

    @Override
    public boolean canPlaceItemThroughFace(int i, @NotNull ItemStack itemStack, Direction side) {
        return false;
    }

    @Override
    public boolean canTakeItemThroughFace(int i, @NotNull ItemStack itemStack, @NotNull Direction side) {
        return false;
    }
}
