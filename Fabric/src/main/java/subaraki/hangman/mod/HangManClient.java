package subaraki.hangman.mod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import subaraki.hangman.entity.EmptyEntityRenderer;
import subaraki.hangman.registry.HangManBlock;
import subaraki.hangman.registry.HangManEntity;

public class HangManClient extends HangManCommon implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(HangManBlock.NOOSE, RenderType.cutout());
        EntityRendererRegistry.register(HangManEntity.NOOSE, EmptyEntityRenderer::new);
        EntityRendererRegistry.register(HangManEntity.CAMERA, EmptyEntityRenderer::new);

        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES).register(entries -> {
            entries.accept(BuiltInRegistries.ITEM.get(new ResourceLocation(HangManCommon.MODID, "noose")));
        });
    }
}
