package io.cbitler.voidsbackpacks.client.screens;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import org.jetbrains.annotations.Nullable;

/**
 * Factory class for creating inventory screens to show users from a backpack inventory
 */
public class BackpackScreenHandlerFactory implements NamedScreenHandlerFactory {
    private final Inventory inventory;
    public BackpackScreenHandlerFactory(Inventory inventory) {
        this.inventory = inventory;
    }
    @Override
    public Text getDisplayName() {
        return new TranslatableText("item.backpack.name");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
        // Create a genedric screen handler for a 9x3 (27 slot) inventory based on the passed in inventory
        return GenericContainerScreenHandler.createGeneric9x3(i, playerInventory, inventory);
    }
}
