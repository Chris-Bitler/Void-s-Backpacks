package io.cbitler.voidsbackpacks.util;

import dev.emi.trinkets.api.TrinketComponent;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;

public class TrinketsUtil {
    /**
     * Get if a user has a specific trinket item equipped
     * @param player The player to check for the item
     * @param item The item type to check
     * @return True if the user has the trinket item equipped, false otherwise
     */
    public static boolean hasItemEquipped(PlayerEntity player, Item item) {
        Optional<TrinketComponent> component = TrinketsApi.getTrinketComponent(player);
        AtomicBoolean found = new AtomicBoolean(false);
        component.ifPresent(trinketComponent -> trinketComponent.forEach(((slotReference, itemStack) -> {
            if (itemStack.getItem().equals(item)) found.set(true);
        })));

        return found.get();
    }
}
