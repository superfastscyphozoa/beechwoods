package net.superfastscyphozoa.beechwoods.world.features.configured;

import net.minecraft.block.BlockState;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.minecraft.world.gen.trunk.LargeOakTrunkPlacer;
import net.superfastscyphozoa.beechwoods.registry.RegisterBlocks;

import static net.superfastscyphozoa.beechwoods.world.features.configured.BeechwoodsConfiguredFeatures.registerKey;

public class BeechwoodsTreeConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> RED_BEECH_KEY = registerKey("red_beech");
    public static final RegistryKey<ConfiguredFeature<?, ?>> YELLOW_BEECH_KEY = registerKey("yellow_beech");

    private static TreeFeatureConfig.Builder red_beech() {
        return (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(RegisterBlocks.BEECH_LOG),
                new LargeOakTrunkPlacer(5, 12, 0),

                new WeightedBlockStateProvider(
                        DataPool.<BlockState>builder().add(RegisterBlocks.RED_BEECH_LEAVES.getDefaultState(), 1).add(RegisterBlocks.ORANGE_BEECH_LEAVES.getDefaultState(), 1)),
                new CherryFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), ConstantIntProvider.create(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F),

                new TwoLayersFeatureSize(1, 0, 2))
        ).ignoreVines();
    }

    private static TreeFeatureConfig.Builder yellow_beech() {
        return (new TreeFeatureConfig.Builder(
                BlockStateProvider.of(RegisterBlocks.BEECH_LOG),
                new LargeOakTrunkPlacer(5, 12, 0),

                new WeightedBlockStateProvider(
                        DataPool.<BlockState>builder().add(RegisterBlocks.ORANGE_BEECH_LEAVES.getDefaultState(), 1).add(RegisterBlocks.YELLOW_BEECH_LEAVES.getDefaultState(), 1)),
                new CherryFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), ConstantIntProvider.create(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F),

                new TwoLayersFeatureSize(1, 0, 2))
        ).ignoreVines();
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {

        BeechwoodsConfiguredFeatures.register(context, RED_BEECH_KEY, Feature.TREE, red_beech().build());
        BeechwoodsConfiguredFeatures.register(context, YELLOW_BEECH_KEY, Feature.TREE, yellow_beech().build());

    }
}
