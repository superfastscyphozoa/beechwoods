package net.superfastscyphozoa.beechwoods.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.render.RenderLayer;
import net.superfastscyphozoa.beechwoods.registry.RegisterBlocks;

@Environment(EnvType.CLIENT)
public class BeechwoodsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(RegisterBlocks.BEECH_SAPLING, RenderLayer.getCutout());
    }
}
