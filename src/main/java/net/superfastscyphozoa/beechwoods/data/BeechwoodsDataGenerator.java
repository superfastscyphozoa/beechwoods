package net.superfastscyphozoa.beechwoods.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.superfastscyphozoa.beechwoods.data.tags.BeechwoodsBlockTagProvider;
import net.superfastscyphozoa.beechwoods.data.tags.BeechwoodsItemTagProvider;
import net.superfastscyphozoa.beechwoods.world.features.configured.BeechwoodsConfiguredFeatures;
import net.superfastscyphozoa.beechwoods.world.features.placed.BeechwoodsPlacedFeatures;

public class BeechwoodsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		pack.addProvider(BeechwoodsLootTableProvider::new);
		pack.addProvider(BeechwoodsModelProvider::new);
		pack.addProvider(BeechwoodsRecipeProvider::new);

		pack.addProvider(BeechwoodsBlockTagProvider::new);
		pack.addProvider(BeechwoodsItemTagProvider::new);

		pack.addProvider(BeechwoodsWorldGenerator::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder registryBuilder){
		registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, BeechwoodsConfiguredFeatures::bootstrap);
		registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, BeechwoodsPlacedFeatures::bootstrap);
		//registryBuilder.addRegistry(RegistryKeys.BIOME, BeechwoodsBiomes::bootstrap);
	}
}
