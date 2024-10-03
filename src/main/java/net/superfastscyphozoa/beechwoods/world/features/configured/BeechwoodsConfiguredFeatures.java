package net.superfastscyphozoa.beechwoods.world.features.configured;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.superfastscyphozoa.beechwoods.Beechwoods;

public class BeechwoodsConfiguredFeatures {

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        BeechwoodsVegetationConfiguredFeatures.bootstrap(context);
        BeechwoodsTreeConfiguredFeatures.bootstrap(context);
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(Beechwoods.MOD_ID, name));
    }

    protected static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                     RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
