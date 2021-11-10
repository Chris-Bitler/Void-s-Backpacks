package io.cbitler.voidsbackpacks.inventory;

import io.cbitler.voidsbackpacks.init.ItemInit;
import io.cbitler.voidsbackpacks.items.BackpackItem;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.collection.DefaultedList;

/**
 * The inventory that will attach to a backpack
 * Mainly extended to save the inventory to the backpack ItemStack on close
 */
public class BackpackInventory extends SimpleInventory {
    public static final int INVENTORY_SIZE = 27;
    private final ItemStack backpack;
    public BackpackInventory(ItemStack backpack, ItemStack... items) {
        super(items);
        this.backpack = backpack;
    }

    /**
     * Store the inventory contents in the Backpack ItemStack's NBT
     * @param player The player closing the inventory. Only used in superclass
     */
    @Override
    public void onClose(PlayerEntity player) {
        super.onClose(player);
        DefaultedList<ItemStack> stacks = DefaultedList.ofSize(INVENTORY_SIZE, ItemStack.EMPTY);
        for(int i = 0; i < INVENTORY_SIZE; i++) {
            stacks.set(i, this.getStack(i));
        }

        if(backpack.isOf(ItemInit.backpack)) {
            BackpackItem bpItem = (BackpackItem) backpack.getItem();
            NbtCompound compound = new NbtCompound();
            NbtCompound result = Inventories.writeNbt(compound, stacks);
            NbtCompound subCompound = new NbtCompound();
            subCompound.putInt("color", bpItem.getColor(backpack));
            result.put("display", subCompound);
            backpack.setNbt(result);
        }
    }
}