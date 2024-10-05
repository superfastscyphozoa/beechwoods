package net.superfastscyphozoa.beechwoods.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.source.util.MultiNoiseUtil;
import net.minecraft.world.biome.source.util.VanillaBiomeParameters;
import net.superfastscyphozoa.beechwoods.world.biome.BeechwoodsBiomeKeys;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(VanillaBiomeParameters.class)
public class BiomeParametersMixin {

    @WrapMethod(
            method = "getRegularBiome"
    )
    private RegistryKey<Biome> getAutumnBiomes(int temperature, int humidity, MultiNoiseUtil.ParameterRange weirdness, Operation<RegistryKey<Biome>> original) {

        if (temperature == 1 && weirdness.max() >= 0L){

            if (humidity == 1) {
                return BeechwoodsBiomeKeys.BEECH_PLAINS;
            }
            else if (humidity == 2) {
                return BeechwoodsBiomeKeys.BEECH_FOREST;
            }

            else {
                return original.call(temperature, humidity, weirdness);
            }

        } else {
            return original.call(temperature, humidity, weirdness);
        }
    }
}
