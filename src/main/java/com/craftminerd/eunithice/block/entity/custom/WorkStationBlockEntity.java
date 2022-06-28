package com.craftminerd.eunithice.block.entity.custom;

import com.craftminerd.eunithice.block.entity.EunithiceBlockEntities;
import com.craftminerd.eunithice.recipe.WorkStationShapelessRecipe;
import com.craftminerd.eunithice.screen.WorkStationMenu;
import com.craftminerd.eunithice.util.EunithiceTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Optional;
import java.util.Random;

public class WorkStationBlockEntity extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemHandler = new ItemStackHandler(7) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
        }
    };

    private LazyOptional<IItemHandler> lazyItemHandler = LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 72;

    public WorkStationBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(EunithiceBlockEntities.WORK_STATION_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
        this.data = new ContainerData() {
            @Override
            public int get(int index) {
                switch (index){
                    case 0: return WorkStationBlockEntity.this.progress;
                    case 1: return WorkStationBlockEntity.this.maxProgress;
                    default: return 0;
                }
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: WorkStationBlockEntity.this.progress = value; break;
                    case 1: WorkStationBlockEntity.this.maxProgress = value; break;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return new TranslatableComponent("block_entity.eunithice.display_name.work_station");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory, Player pPlayer) {
        return new WorkStationMenu(pContainerId,pInventory,this, this.data);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @javax.annotation.Nullable Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return lazyItemHandler.cast();
        }

        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        pTag.put("inventory", itemHandler.serializeNBT());
        pTag.putInt("work_station.progress", progress);
        super.saveAdditional(pTag);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        itemHandler.deserializeNBT(pTag.getCompound("inventory"));
        progress = pTag.getInt("work_station.progress");
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i=0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i,itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level pLevel, BlockPos pPos, BlockState pState, WorkStationBlockEntity pBlockEntity) {
        if (hasRecipe(pBlockEntity)) {
            pBlockEntity.progress += 4;
            setChanged(pLevel,pPos,pState);
            if (pBlockEntity.progress > pBlockEntity.maxProgress) {
                craftItem(pBlockEntity);
            }
        } else {
            pBlockEntity.resetProgress();
            setChanged(pLevel,pPos,pState);
        }
    }

    private static void craftItem(WorkStationBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i = 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<WorkStationShapelessRecipe> match = level.getRecipeManager()
                .getRecipeFor(WorkStationShapelessRecipe.Type.INSTANCE, inventory, level);

        if (match.isPresent()) {
            if (entity.itemHandler.getStackInSlot(0) != ItemStack.EMPTY) {
                if (entity.itemHandler.getStackInSlot(0).is(EunithiceTags.Items.CORES)) {
                    entity.itemHandler.getStackInSlot(0).hurt(1, new Random(), null);
                } else {
                    entity.itemHandler.extractItem(0,1,false);
                }
            }
            if (entity.itemHandler.getStackInSlot(1) != ItemStack.EMPTY) {
                if (entity.itemHandler.getStackInSlot(1).is(EunithiceTags.Items.HAMMERS)) {
                    entity.itemHandler.getStackInSlot(1).hurt(1, new Random(), null);
                } else {
                    entity.itemHandler.extractItem(1,1,false);
                }
            }
            if (entity.itemHandler.getStackInSlot(2) != ItemStack.EMPTY) {
                entity.itemHandler.extractItem(2,1,false);
            }
            if (entity.itemHandler.getStackInSlot(3) != ItemStack.EMPTY) {
                entity.itemHandler.extractItem(3,1,false);
            }
            if (entity.itemHandler.getStackInSlot(4) != ItemStack.EMPTY) {
                entity.itemHandler.extractItem(4,1,false);
            }
            if (entity.itemHandler.getStackInSlot(5) != ItemStack.EMPTY) {
                entity.itemHandler.extractItem(5,1,false);
            }
            entity.itemHandler.setStackInSlot(6, new ItemStack(match.get().getResultItem().getItem(), entity.itemHandler.getStackInSlot(6).getCount() + match.get().getResultItem().getCount()));
            entity.resetProgress();
        }

    }


    private static boolean hasRecipe(WorkStationBlockEntity entity) {
        Level level = entity.level;
        SimpleContainer inventory = new SimpleContainer(entity.itemHandler.getSlots());
        for (int i= 0; i < entity.itemHandler.getSlots(); i++) {
            inventory.setItem(i, entity.itemHandler.getStackInSlot(i));
        }

        Optional<WorkStationShapelessRecipe> match = level.getRecipeManager()
                .getRecipeFor(WorkStationShapelessRecipe.Type.INSTANCE,inventory,level);
        return match.isPresent() && canInsertAmountIntoResultSlot(inventory, match.get().getResultItem()) && canInsertItemIntoResultSlot(inventory, match.get().getResultItem());
    }

    private void resetProgress() { this.progress = 0; }

    private static boolean canInsertItemIntoResultSlot(SimpleContainer inventory, ItemStack result) {
        return inventory.getItem(6).getItem() == result.getItem() || inventory.getItem(6).isEmpty();
    }

    private static boolean canInsertAmountIntoResultSlot(SimpleContainer inventory, ItemStack result) {
        return result.getMaxStackSize() >= inventory.getItem(6).getCount() + result.getCount();
    }


}
