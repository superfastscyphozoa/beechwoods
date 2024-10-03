package net.superfastscyphozoa.beechwoods.data.tags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.superfastscyphozoa.beechwoods.registry.RegisterBlocks;
import net.superfastscyphozoa.beechwoods.util.BeechwoodsTags;

import java.util.concurrent.CompletableFuture;

public class BeechwoodsBlockTagProvider extends FabricTagProvider.BlockTagProvider{
    public BeechwoodsBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        getOrCreateTagBuilder(BlockTags.OVERWORLD_NATURAL_LOGS)
                .add(
                        RegisterBlocks.BEECH_LOG
                );

        getOrCreateTagBuilder(BeechwoodsTags.Blocks.BEECH_LOGS)
                .add(
                        RegisterBlocks.BEECH_LOG,
                        RegisterBlocks.BEECH_WOOD,
                        RegisterBlocks.STRIPPED_BEECH_LOG,
                        RegisterBlocks.STRIPPED_BEECH_WOOD
                );

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .addTag(BeechwoodsTags.Blocks.BEECH_LOGS);
    }
}
