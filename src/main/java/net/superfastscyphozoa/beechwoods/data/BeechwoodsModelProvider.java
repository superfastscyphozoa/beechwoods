package net.superfastscyphozoa.beechwoods.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.superfastscyphozoa.beechwoods.registry.RegisterBlocks;

public class BeechwoodsModelProvider extends FabricModelProvider {
    public BeechwoodsModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerTintableCross(RegisterBlocks.BEECH_SAPLING, BlockStateModelGenerator.TintType.NOT_TINTED);

        blockStateModelGenerator.registerSimpleCubeAll(RegisterBlocks.RED_BEECH_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(RegisterBlocks.ORANGE_BEECH_LEAVES);
        blockStateModelGenerator.registerSimpleCubeAll(RegisterBlocks.YELLOW_BEECH_LEAVES);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
