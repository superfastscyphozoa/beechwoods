package net.superfastscyphozoa.beechwoods.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.superfastscyphozoa.beechwoods.registry.RegisterBlocks;
import net.superfastscyphozoa.beechwoods.util.BeechwoodsTags;

import java.util.concurrent.CompletableFuture;

public class BeechwoodsItemTagProvider extends FabricTagProvider.ItemTagProvider{
    public BeechwoodsItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BeechwoodsTags.Items.BEECH_LOGS)
                .add(
                        RegisterBlocks.BEECH_LOG.asItem(),
                        RegisterBlocks.BEECH_WOOD.asItem(),
                        RegisterBlocks.STRIPPED_BEECH_LOG.asItem(),
                        RegisterBlocks.STRIPPED_BEECH_WOOD.asItem()
                );

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .addTag(BeechwoodsTags.Items.BEECH_LOGS);
    }
}
