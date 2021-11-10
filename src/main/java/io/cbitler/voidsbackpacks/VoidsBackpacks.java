package io.cbitler.voidsbackpacks;

import io.cbitler.voidsbackpacks.init.ItemInit;
import io.cbitler.voidsbackpacks.items.BackpackItem;
import net.fabricmc.api.ModInitializer;
import net.minecraft.recipe.RecipeManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class VoidsBackpacks implements ModInitializer {
    public static String MOD_ID = "voids-backpacks";
    @Override
    public void onInitialize() {
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "backpack"), ItemInit.backpack);
        ((BackpackItem)ItemInit.backpack).registerTrinket();
    }
}
