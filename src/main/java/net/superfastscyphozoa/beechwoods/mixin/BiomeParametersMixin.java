package net.superfastscyphozoa.beechwoods.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.random.Random;
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
    private RegistryKey<Biome> e(int temperature, int humidity, MultiNoiseUtil.ParameterRange weirdness, Operation<RegistryKey<Biome>> original) {
        if (Random.create().nextBoolean()){
            return BeechwoodsBiomeKeys.BEECH_FOREST;
        } else {
            return original.call(temperature, humidity, weirdness);
        }
    }
}
