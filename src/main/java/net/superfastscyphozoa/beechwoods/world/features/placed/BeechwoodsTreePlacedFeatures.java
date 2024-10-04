package net.superfastscyphozoa.beechwoods.world.features.placed;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.superfastscyphozoa.beechwoods.registry.RegisterBlocks;
import net.superfastscyphozoa.beechwoods.world.features.configured.BeechwoodsTreeConfiguredFeatures;

import static net.superfastscyphozoa.beechwoods.world.features.placed.BeechwoodsPlacedFeatures.registerKey;

public class BeechwoodsTreePlacedFeatures {
    public static final RegistryKey<PlacedFeature> RED_BEECH_PLACED_KEY = registerKey("red_beech_placed");
    public static final RegistryKey<PlacedFeature> YELLOW_BEECH_PLACED_KEY = registerKey("yellow_beech_placed");

    public static final RegistryKey<PlacedFeature> VINY_RED_BEECH_PLACED_KEY = registerKey("viny_red_beech_placed");
    public static final RegistryKey<PlacedFeature> VINY_YELLOW_BEECH_PLACED_KEY = registerKey("viny_yellow_beech_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntry<ConfiguredFeature<?, ?>> red_beech = configuredFeatureRegistryEntryLookup.getOrThrow(BeechwoodsTreeConfiguredFeatures.RED_BEECH_KEY);
        RegistryEntry<ConfiguredFeature<?, ?>> yellow_beech = configuredFeatureRegistryEntryLookup.getOrThrow(BeechwoodsTreeConfiguredFeatures.YELLOW_BEECH_KEY);

        RegistryEntry<ConfiguredFeature<?, ?>> viny_red_beech = configuredFeatureRegistryEntryLookup.getOrThrow(BeechwoodsTreeConfiguredFeatures.VINY_RED_BEECH_KEY);
        RegistryEntry<ConfiguredFeature<?, ?>> viny_yellow_beech = configuredFeatureRegistryEntryLookup.getOrThrow(BeechwoodsTreeConfiguredFeatures.VINY_YELLOW_BEECH_KEY);

        BeechwoodsPlacedFeatures.register(context, RED_BEECH_PLACED_KEY, red_beech, PlacedFeatures.wouldSurvive(RegisterBlocks.BEECH_SAPLING));
        BeechwoodsPlacedFeatures.register(context, YELLOW_BEECH_PLACED_KEY, yellow_beech, PlacedFeatures.wouldSurvive(RegisterBlocks.BEECH_SAPLING));

        BeechwoodsPlacedFeatures.register(context, VINY_RED_BEECH_PLACED_KEY, viny_red_beech, PlacedFeatures.wouldSurvive(RegisterBlocks.BEECH_SAPLING));
        BeechwoodsPlacedFeatures.register(context, VINY_YELLOW_BEECH_PLACED_KEY, viny_yellow_beech, PlacedFeatures.wouldSurvive(RegisterBlocks.BEECH_SAPLING));

    }
}
