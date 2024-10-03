package net.superfastscyphozoa.beechwoods.world.biome;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.PlacedFeature;

public class BeechwoodsBiomes {
    public static void bootstrap(Registerable<Biome> context) {
        RegistryEntryLookup<PlacedFeature> placedFeatureLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RegistryEntryLookup<ConfiguredCarver<?>> configuredCarverLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_CARVER);

        context.register(BeechwoodsBiomeKeys.BEECH_FOREST, BeechwoodsOverworldBiomeCreators.createBeechForest(placedFeatureLookup, configuredCarverLookup));
    }
}
