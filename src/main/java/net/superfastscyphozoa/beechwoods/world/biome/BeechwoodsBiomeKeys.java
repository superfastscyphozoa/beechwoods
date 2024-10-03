package net.superfastscyphozoa.beechwoods.world.biome;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.biome.Biome;
import net.superfastscyphozoa.beechwoods.Beechwoods;

public abstract class BeechwoodsBiomeKeys {

    public static final RegistryKey<Biome> BEECH_FOREST = registerBeechwoodsBiomeKeys("beech_forest");

    private static RegistryKey<Biome> registerBeechwoodsBiomeKeys(String name) {
        return RegistryKey.of(RegistryKeys.BIOME, Identifier.of(Beechwoods.MOD_ID, name));
    }

}
