package com.lishid.openinv.internal.v1_21_R1.inventory;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.bukkit.event.inventory.InventoryType;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

/**
 * A fake slot used to fill spaces in the inventory that can't be interacted with.
 */
class ContainerSlotUninteractable implements ContainerSlot {

  @NotNull ServerPlayer holder;

  ContainerSlotUninteractable(@NotNull ServerPlayer holder) {
    this.holder = holder;
  }

  @Override
  public void setHolder(@NotNull ServerPlayer holder) {
    this.holder = holder;
  }

  @Override
  public ItemStack get() {
    return ItemStack.EMPTY;
  }

  @Override
  public ItemStack remove() {
    return ItemStack.EMPTY;
  }

  @Override
  public ItemStack removePartial(int amount) {
    return ItemStack.EMPTY;
  }

  @Override
  public void set(ItemStack itemStack) {
    this.holder.drop(itemStack, false);
  }

  @Override
  public Slot asMenuSlot(Container container, int index, int x, int y) {
    return new SlotUninteractable(container, index, x, y);
  }

  @Override
  public InventoryType.SlotType getSlotType() {
    return InventoryType.SlotType.OUTSIDE;
  }

  static class SlotUninteractable extends MenuSlotPlaceholder {

    SlotUninteractable(Container container, int index, int x, int y) {
      super(container, index, x, y);
    }

    @Override
    ItemStack getOrDefault() {
      return PlaceholderManager.notSlot;
    }

    public void onQuickCraft(ItemStack var0, ItemStack var1) {}

    public void onTake(Player var0, ItemStack var1) {}

    @Override
    public boolean mayPlace(ItemStack var0) {
      return false;
    }

    public ItemStack getItem() {
      return ItemStack.EMPTY;
    }

    @Override
    public boolean hasItem() {
      return false;
    }

    public void setByPlayer(ItemStack newStack) {}

    public void setByPlayer(ItemStack newStack, ItemStack oldStack) {}

    public void set(ItemStack var0) {}

    public void setChanged() {}

    public int getMaxStackSize() {
      return 0;
    }

    public int getMaxStackSize(ItemStack itemStack) {
      return 0;
    }

    public ItemStack remove(int amount) {
      return ItemStack.EMPTY;
    }

    @Override
    public boolean mayPickup(Player var0) {
      return false;
    }

    public boolean isActive() {
      return false;
    }

    public Optional<ItemStack> tryRemove(int var0, int var1, Player var2) {
      return Optional.empty();
    }

    public ItemStack safeTake(int var0, int var1, Player var2) {
      return ItemStack.EMPTY;
    }

    public ItemStack safeInsert(ItemStack itemStack) {
      return itemStack;
    }

    public ItemStack safeInsert(ItemStack itemStack, int amount) {
      return itemStack;
    }

    @Override
    public boolean allowModification(Player var0) {
      return false;
    }

    public int getContainerSlot() {
      return this.slot;
    }

    public boolean isHighlightable() {
      return false;
    }

    @Override
    public boolean isFake() {
      return true;
    }

  }
}
