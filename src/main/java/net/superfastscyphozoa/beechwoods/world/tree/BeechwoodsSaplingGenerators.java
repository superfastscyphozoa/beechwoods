package net.superfastscyphozoa.beechwoods.world.tree;

import net.minecraft.block.SaplingGenerator;
import net.superfastscyphozoa.beechwoods.world.features.configured.BeechwoodsTreeConfiguredFeatures;

import java.util.Optional;

public class BeechwoodsSaplingGenerators {
    public static final SaplingGenerator BEECH =
            new SaplingGenerator("beech", 0.5f, Optional.empty(),
                    Optional.empty(),
                    Optional.of(BeechwoodsTreeConfiguredFeatures.RED_BEECH_KEY),
                    Optional.of(BeechwoodsTreeConfiguredFeatures.YELLOW_BEECH_KEY),
                    Optional.empty(),
                    Optional.empty());
}
