package net.superfastscyphozoa.beechwoods.world.features.placed;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.superfastscyphozoa.beechwoods.registry.RegisterBlocks;
import net.superfastscyphozoa.beechwoods.world.features.configured.BeechwoodsTreeConfiguredFeatures;

import static net.superfastscyphozoa.beechwoods.world.features.placed.BeechwoodsPlacedFeatures.registerKey;

public class BeechwoodsTreePlacedFeatures {
    public static final RegistryKey<PlacedFeature> RED_BEECH_PLACED_KEY = registerKey("red_beech_placed");
    public static final RegistryKey<PlacedFeature> YELLOW_BEECH_PLACED_KEY = registerKey("yellow_beech_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntry<ConfiguredFeature<?, ?>> red_beech = configuredFeatureRegistryEntryLookup.getOrThrow(BeechwoodsTreeConfiguredFeatures.RED_BEECH_KEY);
        RegistryEntry<ConfiguredFeature<?, ?>> yellow_beech = configuredFeatureRegistryEntryLookup.getOrThrow(BeechwoodsTreeConfiguredFeatures.YELLOW_BEECH_KEY);

        BeechwoodsPlacedFeatures.register(context, RED_BEECH_PLACED_KEY, red_beech,
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.1f, 2),
                        RegisterBlocks.BEECH_SAPLING));

        BeechwoodsPlacedFeatures.register(context, YELLOW_BEECH_PLACED_KEY, yellow_beech,
                VegetationPlacedFeatures.treeModifiersWithWouldSurvive(PlacedFeatures.createCountExtraModifier(2, 0.1f, 2),
                        RegisterBlocks.BEECH_SAPLING));
    }
}
