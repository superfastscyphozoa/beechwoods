package net.superfastscyphozoa.beechwoods.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;
import net.superfastscyphozoa.beechwoods.registry.RegisterBlocks;

import java.util.concurrent.CompletableFuture;

public class BeechwoodsLootTableProvider extends FabricBlockLootTableProvider {
    protected BeechwoodsLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(RegisterBlocks.BEECH_LOG);
        addDrop(RegisterBlocks.BEECH_WOOD);
        addDrop(RegisterBlocks.STRIPPED_BEECH_LOG);
        addDrop(RegisterBlocks.STRIPPED_BEECH_WOOD);
    }
}
