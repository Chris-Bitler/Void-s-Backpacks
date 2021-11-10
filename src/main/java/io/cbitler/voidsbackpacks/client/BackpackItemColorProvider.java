package io.cbitler.voidsbackpacks.client;

import io.cbitler.voidsbackpacks.init.ItemInit;
import io.cbitler.voidsbackpacks.items.BackpackItem;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.item.ItemStack;

public class BackpackItemColorProvider implements ItemColorProvider {
    @Override
    public int getColor(ItemStack itemStack, int i) {
        if (itemStack.isOf(ItemInit.backpack)) {
            return ((BackpackItem)itemStack.getItem()).getColor(itemStack);
        }

        return -1;
    }
}
