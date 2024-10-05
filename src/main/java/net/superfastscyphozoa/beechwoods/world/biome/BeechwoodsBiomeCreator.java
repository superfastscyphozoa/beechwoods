package net.superfastscyphozoa.beechwoods.world.biome;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.RegistryEntryLookup;
import net.minecraft.sound.BiomeMoodSound;
import net.minecraft.sound.MusicSound;
import net.minecraft.sound.MusicType;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.biome.*;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.superfastscyphozoa.beechwoods.world.features.placed.BeechwoodsVegetationPlacedFeatures;
import org.jetbrains.annotations.Nullable;

public class BeechwoodsBiomeCreator {
    private static Biome createBiome(
            boolean precipitation, float temperature, float downfall,
            SpawnSettings.Builder spawnSettings,
            GenerationSettings.LookupBackedBuilder generationSettings,
            @Nullable MusicSound music
    )
    {
        return createBiome(precipitation, temperature, downfall, 4159204, 329011, null, null, spawnSettings, generationSettings, music);
    }

    private static Biome createBiome(
            boolean precipitation, float temperature, float downfall,
            int waterColor, int waterFogColor,
            @Nullable Integer grassColor, @Nullable Integer foliageColor,
            SpawnSettings.Builder spawnSettings,
            GenerationSettings.LookupBackedBuilder generationSettings,
            @Nullable MusicSound music)
    {
        BiomeEffects.Builder builder = new BiomeEffects.Builder()
                .waterColor(waterColor).waterFogColor(waterFogColor)
                .fogColor(12638463).skyColor(OverworldBiomeCreator.getSkyColor(temperature))
                .moodSound(BiomeMoodSound.CAVE).music(music);

        if (grassColor != null) {
            builder.grassColor(grassColor);
        }
        if (foliageColor != null) {
            builder.foliageColor(foliageColor);
        }

        return new Biome.Builder()
                .precipitation(precipitation).temperature(temperature).downfall(downfall)
                .effects(builder.build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();
    }

    private static void addBasicFeatures(GenerationSettings.LookupBackedBuilder generationSettings) {
        DefaultBiomeFeatures.addLandCarvers(generationSettings);
        DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addSprings(generationSettings);
        DefaultBiomeFeatures.addFrozenTopLayer(generationSettings);
    }

    private static void addBeechPlainsFeatures(GenerationSettings.LookupBackedBuilder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, BeechwoodsVegetationPlacedFeatures.BEECH_PLAINS_GRASS_PATCH);
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, BeechwoodsVegetationPlacedFeatures.SUNFLOWER_PATCH);
    }

    private static void addBeechBiomeFeatures(GenerationSettings.LookupBackedBuilder builder) {
        builder.feature(GenerationStep.Feature.VEGETAL_DECORATION, BeechwoodsVegetationPlacedFeatures.PUMPKIN_PATCH);
    }

    //biomes

    public static Biome createBeechForest(RegistryEntryLookup<PlacedFeature> featureLookup, RegistryEntryLookup<ConfiguredCarver<?>> carverLookup) {

        //generation and features
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(featureLookup, carverLookup);

        addBasicFeatures(generationSettings);
        addBeechBiomeFeatures(generationSettings);

        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, BeechwoodsVegetationPlacedFeatures.TREES_BEECH_FOREST);

        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addDefaultDisks(generationSettings);

        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, BeechwoodsVegetationPlacedFeatures.FERN_PATCH);

        DefaultBiomeFeatures.addDefaultGrass(generationSettings);
        DefaultBiomeFeatures.addForestGrass(generationSettings);
        DefaultBiomeFeatures.addPlainsTallGrass(generationSettings);

        DefaultBiomeFeatures.addDefaultMushrooms(generationSettings);
        DefaultBiomeFeatures.addDefaultVegetation(generationSettings);

        //spawns
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnSettings);

        spawnSettings
                .spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 4, 2, 3))
                .spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 8, 2, 4));

        //music
        MusicSound musicSound = MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_FOREST);

        //-2125507
        //-3982326

        return createBiome(
                true, 0.7F, 0.8F,
                4159204, 329011, -8152271, -8743902,
                spawnSettings, generationSettings, musicSound);
    }

    public static Biome createBeechPlains(RegistryEntryLookup<PlacedFeature> featureLookup, RegistryEntryLookup<ConfiguredCarver<?>> carverLookup) {

        //generation and features
        GenerationSettings.LookupBackedBuilder generationSettings = new GenerationSettings.LookupBackedBuilder(featureLookup, carverLookup);

        addBasicFeatures(generationSettings);
        addBeechBiomeFeatures(generationSettings);
        addBeechPlainsFeatures(generationSettings);

        generationSettings.feature(GenerationStep.Feature.VEGETAL_DECORATION, BeechwoodsVegetationPlacedFeatures.TREES_BEECH_PLAINS);

        DefaultBiomeFeatures.addDefaultOres(generationSettings);
        DefaultBiomeFeatures.addDefaultDisks(generationSettings);

        DefaultBiomeFeatures.addDefaultGrass(generationSettings);
        DefaultBiomeFeatures.addPlainsTallGrass(generationSettings);

        DefaultBiomeFeatures.addDefaultMushrooms(generationSettings);
        DefaultBiomeFeatures.addDefaultVegetation(generationSettings);

        //spawns
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        DefaultBiomeFeatures.addBatsAndMonsters(spawnSettings);

        spawnSettings
                .spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.RABBIT, 4, 2, 3))
                .spawn(SpawnGroup.CREATURE, new SpawnSettings.SpawnEntry(EntityType.FOX, 8, 2, 4));

        //music
        MusicSound musicSound = MusicType.createIngameMusic(SoundEvents.MUSIC_OVERWORLD_FOREST);

        return createBiome(
                true, 0.7F, 0.8F,
                4159204, 329011, -6707397, -8743902,
                spawnSettings, generationSettings, musicSound);
    }
}
