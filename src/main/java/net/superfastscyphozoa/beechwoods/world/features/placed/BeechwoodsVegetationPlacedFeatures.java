package net.superfastscyphozoa.beechwoods.world.features.placed;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.superfastscyphozoa.beechwoods.world.features.configured.BeechwoodsVegetationConfiguredFeatures;

import static net.minecraft.world.gen.feature.VegetationPlacedFeatures.treeModifiers;
import static net.superfastscyphozoa.beechwoods.world.features.placed.BeechwoodsPlacedFeatures.registerKey;

public class BeechwoodsVegetationPlacedFeatures {

    public static final RegistryKey<PlacedFeature> TREES_BEECH_FOREST = registerKey("trees_beech_forest");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntry<ConfiguredFeature<?, ?>> beechForestTrees = configuredFeatureRegistryEntryLookup.getOrThrow(BeechwoodsVegetationConfiguredFeatures.TREES_BEECH_FOREST);

        BeechwoodsPlacedFeatures.register(context, TREES_BEECH_FOREST, beechForestTrees, treeModifiers(PlacedFeatures.createCountExtraModifier(10, 0.1F, 1)));
    }
}
