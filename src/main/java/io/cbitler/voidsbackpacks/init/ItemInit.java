package io.cbitler.voidsbackpacks.init;

import io.cbitler.voidsbackpacks.items.BackpackItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemInit {
    public static final Item backpack = new BackpackItem(new FabricItemSettings().group(ItemGroup.INVENTORY));
}
