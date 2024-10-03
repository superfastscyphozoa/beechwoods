package net.superfastscyphozoa.beechwoods.client.particle;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.superfastscyphozoa.beechwoods.particle.BeechLeavesParticle;
import net.superfastscyphozoa.beechwoods.registry.RegisterParticles;

public class BeechwoodsParticleFactories {
    public static void registerParticleFactories(){

        ParticleFactoryRegistry.getInstance().register(
                RegisterParticles.BEECH_LEAVES,
                spriteProvider -> (parameters, world, x, y, z, velocityX, velocityY, velocityZ) -> new BeechLeavesParticle(world, x, y, z, spriteProvider)
        );
    }
}
