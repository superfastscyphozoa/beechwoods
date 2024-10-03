package net.superfastscyphozoa.beechwoods;

import net.fabricmc.api.ModInitializer;

import net.superfastscyphozoa.beechwoods.block.util.BeechwoodsFlammableBlocks;
import net.superfastscyphozoa.beechwoods.block.util.BeechwoodsStrippableBlocks;
import net.superfastscyphozoa.beechwoods.registry.RegisterBlocks;
import net.superfastscyphozoa.beechwoods.registry.RegisterItems;
import net.superfastscyphozoa.beechwoods.registry.RegisterParticles;
import net.superfastscyphozoa.beechwoods.world.gen.BeechwoodsWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Beechwoods implements ModInitializer {
	public static final String MOD_ID = "beechwoods";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		RegisterItems.registerBeechwoodsItems();
		RegisterBlocks.registerBeechwoodsBlocks();

		BeechwoodsFlammableBlocks.RegisterFlammableBlocks();
		BeechwoodsStrippableBlocks.RegisterStrippableBlocks();

		RegisterParticles.registerBeechwoodsParticles();

		BeechwoodsWorldGeneration.generateBeechwoodsWorldgen();

		LOGGER.info("Boo! muahahahahaha i spooked you lmao");
	}
}