package net.superfastscyphozoa.beechwoods.world.features.placed;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationConfiguredFeatures;
import net.minecraft.world.gen.placementmodifier.*;
import net.superfastscyphozoa.beechwoods.registry.RegisterBlocks;
import net.superfastscyphozoa.beechwoods.world.features.configured.BeechwoodsVegetationConfiguredFeatures;

import static net.minecraft.world.gen.feature.VegetationPlacedFeatures.treeModifiers;
import static net.superfastscyphozoa.beechwoods.world.features.placed.BeechwoodsPlacedFeatures.registerKey;

public class BeechwoodsVegetationPlacedFeatures {

    public static final RegistryKey<PlacedFeature> TREES_BEECH_FOREST = registerKey("trees_beech_forest");
    public static final RegistryKey<PlacedFeature> TREES_BEECH_PLAINS = registerKey("trees_beech_plains");
    public static final RegistryKey<PlacedFeature> SUNFLOWER_PATCH = registerKey("sunflower_patch");
    public static final RegistryKey<PlacedFeature> BEECH_PLAINS_GRASS_PATCH = registerKey("beech_plains_grass_patch");
    public static final RegistryKey<PlacedFeature> PUMPKIN_PATCH = registerKey("pumpkin_patch");
    public static final RegistryKey<PlacedFeature> FERN_PATCH = registerKey("fern_patch");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntry<ConfiguredFeature<?, ?>> beechForestTrees = configuredFeatureRegistryEntryLookup.getOrThrow(BeechwoodsVegetationConfiguredFeatures.TREES_BEECH_FOREST);
        RegistryEntry<ConfiguredFeature<?, ?>> beechPlainsTrees = configuredFeatureRegistryEntryLookup.getOrThrow(BeechwoodsVegetationConfiguredFeatures.TREES_BEECH_PLAINS);
        RegistryEntry<ConfiguredFeature<?, ?>> sunflowerPatch = configuredFeatureRegistryEntryLookup.getOrThrow(BeechwoodsVegetationConfiguredFeatures.SUNFLOWER_PATCH);
        RegistryEntry<ConfiguredFeature<?, ?>> grass_patch = configuredFeatureRegistryEntryLookup.getOrThrow(VegetationConfiguredFeatures.PATCH_GRASS);
        RegistryEntry<ConfiguredFeature<?, ?>> pumpkin_patch = configuredFeatureRegistryEntryLookup.getOrThrow(BeechwoodsVegetationConfiguredFeatures.PUMPKIN_PATCH);
        RegistryEntry<ConfiguredFeature<?, ?>> fern_patch = configuredFeatureRegistryEntryLookup.getOrThrow(BeechwoodsVegetationConfiguredFeatures.FERN_PATCH);

        //tree

        BeechwoodsPlacedFeatures.register(context, TREES_BEECH_FOREST, beechForestTrees, treeModifiers(PlacedFeatures.createCountExtraModifier(10, 0.1F, 1)));

        PlacementModifier plainsPlacementModifier = SurfaceWaterDepthFilterPlacementModifier.of(0);
        BeechwoodsPlacedFeatures.register(
                context,
                TREES_BEECH_PLAINS,
                beechPlainsTrees,
                PlacedFeatures.createCountExtraModifier(0, 0.2F, 1),
                SquarePlacementModifier.of(),
                plainsPlacementModifier,
                PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP,
                BlockFilterPlacementModifier.of(BlockPredicate.wouldSurvive(RegisterBlocks.BEECH_SAPLING.getDefaultState(), BlockPos.ORIGIN)),
                BiomePlacementModifier.of()
        );

        //flowers and other plants

        BeechwoodsPlacedFeatures.register(
                context,
                SUNFLOWER_PATCH,
                sunflowerPatch,
                RarityFilterPlacementModifier.of(3),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );

        BeechwoodsPlacedFeatures.register(
                context,
                PUMPKIN_PATCH,
                pumpkin_patch,
                RarityFilterPlacementModifier.of(40),
                SquarePlacementModifier.of(),
                PlacedFeatures.MOTION_BLOCKING_HEIGHTMAP,
                BiomePlacementModifier.of()
        );

        //grass

        BeechwoodsPlacedFeatures.register(
                context,
                BEECH_PLAINS_GRASS_PATCH,
                grass_patch,
                NoiseThresholdCountPlacementModifier.of(-0.8, 5, 10),
                SquarePlacementModifier.of(),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                BiomePlacementModifier.of()
        );

        BeechwoodsPlacedFeatures.register(
                context,
                FERN_PATCH,
                fern_patch,
                RarityFilterPlacementModifier.of(9),
                SquarePlacementModifier.of(),
                PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
                BiomePlacementModifier.of()
        );
    }
}
