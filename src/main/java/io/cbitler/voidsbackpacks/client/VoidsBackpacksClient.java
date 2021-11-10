package io.cbitler.voidsbackpacks.client;

import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import io.cbitler.voidsbackpacks.VoidsBackpacks;
import io.cbitler.voidsbackpacks.client.renderers.BackpackRenderer;
import io.cbitler.voidsbackpacks.init.ItemInit;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.util.Identifier;

@net.fabricmc.api.Environment(net.fabricmc.api.EnvType.CLIENT)
public class VoidsBackpacksClient implements ClientModInitializer {
    public static Identifier BACKPACK_MODEL_ID = new Identifier(VoidsBackpacks.MOD_ID, "backpack");
    @Override
    public void onInitializeClient() {
        ColorProviderRegistry.ITEM.register(new BackpackItemColorProvider(), ItemInit.backpack);
        ModelLoadingRegistry.INSTANCE.registerModelProvider((manager, out) -> out.accept(BACKPACK_MODEL_ID));
        TrinketRendererRegistry.registerRenderer(ItemInit.backpack, new BackpackRenderer());
    }
}
