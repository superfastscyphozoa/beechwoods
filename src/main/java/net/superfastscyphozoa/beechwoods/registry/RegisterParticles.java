package net.superfastscyphozoa.beechwoods.registry;

import net.fabricmc.fabric.api.particle.v1.FabricParticleTypes;
import net.minecraft.particle.SimpleParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.superfastscyphozoa.beechwoods.Beechwoods;

public class RegisterParticles {
    public static final SimpleParticleType BEECH_LEAVES = FabricParticleTypes.simple();

    public static void registerBeechwoodsParticles(){
        Beechwoods.LOGGER.info("Registering Particles for " + Beechwoods.MOD_ID);

        Registry.register(Registries.PARTICLE_TYPE, Identifier.of(Beechwoods.MOD_ID, "beech_leaves"),
                BEECH_LEAVES);
    }
}
