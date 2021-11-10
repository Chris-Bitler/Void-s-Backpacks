package io.cbitler.voidsbackpacks.items;

import dev.emi.trinkets.api.Trinket;
import dev.emi.trinkets.api.TrinketsApi;
import io.cbitler.voidsbackpacks.client.screens.BackpackScreenHandlerFactory;
import io.cbitler.voidsbackpacks.inventory.BackpackInventory;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.DyeableItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class BackpackItem extends Item implements Trinket, DyeableItem {
    public BackpackItem(Settings settings) {
        super(settings);
    }

    /**
     * Register it post-creation. For some reason registering it in the constructor causes the
     * trinkets api to see it as air
     */
    public void registerTrinket() {
        TrinketsApi.registerTrinket(this, this);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(new TranslatableText("info.how-to-use"));
    }

    /**
     * Handle the player using a backpack
     * @param world The world the player used the backpack item in
     * @param player The player using the backpack item
     * @param hand The hand the backpack was in
     * @return Pass (don't block event)
     */
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        ItemStack used;
        if (hand == Hand.MAIN_HAND) {
            used = player.getMainHandStack();
        } else {
            used = player.getOffHandStack();
        }

        if (used != null && used.getItem() instanceof BackpackItem) {
            // Read in inventory contents and open a screen to show it to the user
            DefaultedList<ItemStack> items = DefaultedList.ofSize(BackpackInventory.INVENTORY_SIZE, ItemStack.EMPTY);
            NbtCompound inventoryNbt = used.getOrCreateNbt();
            Inventories.readNbt(inventoryNbt, items);
            Inventory inventory = new BackpackInventory(used, items.toArray(new ItemStack[0]));
            BackpackScreenHandlerFactory factory = new BackpackScreenHandlerFactory(inventory);
            player.openHandledScreen(factory);
        }

        return TypedActionResult.pass(used);
    }
}
