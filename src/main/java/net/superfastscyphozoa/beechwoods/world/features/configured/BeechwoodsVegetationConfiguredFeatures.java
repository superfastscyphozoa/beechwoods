package net.superfastscyphozoa.beechwoods.world.features.configured;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.collection.DataPool;
import net.minecraft.util.math.Direction;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.WeightedBlockStateProvider;
import net.superfastscyphozoa.beechwoods.registry.RegisterBlocks;
import net.superfastscyphozoa.beechwoods.world.features.placed.BeechwoodsTreePlacedFeatures;

import java.util.List;

import static net.superfastscyphozoa.beechwoods.world.features.configured.BeechwoodsConfiguredFeatures.registerKey;

public class BeechwoodsVegetationConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?,?>> TREES_BEECH_FOREST = registerKey("trees_beech_forest");
    public static final RegistryKey<ConfiguredFeature<?,?>> TREES_BEECH_PLAINS = registerKey("trees_beech_plains");
    public static final RegistryKey<ConfiguredFeature<?,?>> SUNFLOWER_PATCH = registerKey("sunflower_patch");
    public static final RegistryKey<ConfiguredFeature<?,?>> PUMPKIN_PATCH = registerKey("pumpkin_patch");
    public static final RegistryKey<ConfiguredFeature<?,?>> FERN_PATCH = registerKey("fern_patch");

    private static RandomPatchFeatureConfig createRandomPatchFeatureConfig(BlockStateProvider block, int tries) {
        return ConfiguredFeatures.createRandomPatchFeatureConfig(tries, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(block)));
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        var configuredFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);
        RegistryEntry<ConfiguredFeature<?, ?>> brown_mushy = configuredFeatureRegistryEntryLookup.getOrThrow(TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM);

        var placedFeatureRegistryEntryLookup = context.getRegistryLookup(RegistryKeys.PLACED_FEATURE);
        RegistryEntry<PlacedFeature> red_beech = placedFeatureRegistryEntryLookup.getOrThrow(BeechwoodsTreePlacedFeatures.RED_BEECH_PLACED_KEY);
        RegistryEntry<PlacedFeature> yellow_beech = placedFeatureRegistryEntryLookup.getOrThrow(BeechwoodsTreePlacedFeatures.YELLOW_BEECH_PLACED_KEY);
        RegistryEntry<PlacedFeature> fancyOak = placedFeatureRegistryEntryLookup.getOrThrow(TreePlacedFeatures.FANCY_OAK_BEES_002);
        RegistryEntry<PlacedFeature> oak = placedFeatureRegistryEntryLookup.getOrThrow(TreePlacedFeatures.OAK_BEES_0002);

        //tree

        BeechwoodsConfiguredFeatures.register(context, TREES_BEECH_FOREST, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(
                        new RandomFeatureEntry(PlacedFeatures.createEntry(brown_mushy), 0.075F),

                        new RandomFeatureEntry(fancyOak, 0.2F),
                        new RandomFeatureEntry(oak, 0.1F),

                        new RandomFeatureEntry(yellow_beech, 0.5F)
                ), red_beech)
        );

        BeechwoodsConfiguredFeatures.register(context, TREES_BEECH_PLAINS, Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(List.of(
                        new RandomFeatureEntry(PlacedFeatures.createEntry(brown_mushy), 0.075F),

                        new RandomFeatureEntry(yellow_beech, 0.5F)
                ), red_beech)
        );

        //flowers and other plants

        BeechwoodsConfiguredFeatures.register(
                context,
                SUNFLOWER_PATCH,
                Feature.RANDOM_PATCH,
                ConfiguredFeatures.createRandomPatchFeatureConfig(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(Blocks.SUNFLOWER)))
        );

        DataPool.Builder<BlockState> pumpkinBuilder = DataPool.builder();
        pumpkinBuilder.add(Blocks.PUMPKIN.getDefaultState(), 3).add(RegisterBlocks.PUMPKIN_FLOWER.getDefaultState(), 2);

        BeechwoodsConfiguredFeatures.register(
                context,
                PUMPKIN_PATCH,
                Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(
                        96, 7, 2,
                        PlacedFeatures.createEntry(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(new WeightedBlockStateProvider(pumpkinBuilder)),
                                BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.noFluid(), BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), Blocks.GRASS_BLOCK))
                        )
                )
        );

        //grass and ferns

        BeechwoodsConfiguredFeatures.register(
                context,
                FERN_PATCH,
                Feature.RANDOM_PATCH,
                createRandomPatchFeatureConfig(
                        new WeightedBlockStateProvider(DataPool.<BlockState>builder()
                                .add(Blocks.FERN.getDefaultState(), 3)
                                .add(Blocks.LARGE_FERN.getDefaultState(), 2)),
                        64
                )
        );
    }
}
