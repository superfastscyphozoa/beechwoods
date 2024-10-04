package net.superfastscyphozoa.beechwoods.world.features.configured;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.world.gen.feature.*;
import net.superfastscyphozoa.beechwoods.world.features.placed.BeechwoodsTreePlacedFeatures;

import java.util.List;

import static net.superfastscyphozoa.beechwoods.world.features.configured.BeechwoodsConfiguredFeatures.registerKey;

public class BeechwoodsVegetationConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?,?>> TREES_BEECH_FOREST = registerKey("trees_beech_forest");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntry<ConfiguredFeature<?, ?>> brown_mushy = configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM);

        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RegistryEntry<PlacedFeature> red_beech = placedFeatureRegistryEntryLookup.getOrThrow(BeechwoodsTreePlacedFeatures.RED_BEECH_PLACED_KEY);
        RegistryEntry<PlacedFeature> yellow_beech = placedFeatureRegistryEntryLookup.getOrThrow(BeechwoodsTreePlacedFeatures.YELLOW_BEECH_PLACED_KEY);

        RegistryEntry<PlacedFeature> oak = placedFeatureRegistryEntryLookup.getOrThrow(TreePlacedFeatures.FANCY_OAK_CHECKED);

        BeechwoodsConfiguredFeatures.register(context, TREES_BEECH_FOREST, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(
                        new RandomFeatureEntry(PlacedFeatures.createEntry(brown_mushy), 0.06F),

                        new RandomFeatureEntry(oak, 0.2F),

                        new RandomFeatureEntry(yellow_beech, 0.5F)
                ), red_beech)
        );
    }
}
