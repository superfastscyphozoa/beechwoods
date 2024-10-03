package net.superfastscyphozoa.beechwoods.block.util;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.superfastscyphozoa.beechwoods.registry.RegisterBlocks;

public class BeechwoodsFlammableBlocks {
    public static void RegisterFlammableBlocks(){

        FlammableBlockRegistry.getDefaultInstance().add(RegisterBlocks.BEECH_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(RegisterBlocks.BEECH_WOOD, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(RegisterBlocks.STRIPPED_BEECH_LOG, 5, 5);
        FlammableBlockRegistry.getDefaultInstance().add(RegisterBlocks.STRIPPED_BEECH_WOOD, 5, 5);

        //FlammableBlockRegistry.getDefaultInstance().add(RegisterBlocks.BEECH_PLANKS, 5, 20);

        FlammableBlockRegistry.getDefaultInstance().add(RegisterBlocks.RED_BEECH_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(RegisterBlocks.ORANGE_BEECH_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(RegisterBlocks.YELLOW_BEECH_LEAVES, 30, 60);
    }
}
