package net.superfastscyphozoa.beechwoods.block;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.superfastscyphozoa.beechwoods.registry.RegisterBlocks;

public class BeechwoodsFlammableBlocks {
    public static void RegisterFlammableBlocks(){
        FlammableBlockRegistry instance = FlammableBlockRegistry.getDefaultInstance();

        instance.add(RegisterBlocks.BEECH_LOG, 5, 5);
        instance.add(RegisterBlocks.BEECH_WOOD, 5, 5);
        instance.add(RegisterBlocks.STRIPPED_BEECH_LOG, 5, 5);
        instance.add(RegisterBlocks.STRIPPED_BEECH_WOOD, 5, 5);

        //instance.add(RegisterBlocks.BEECH_PLANKS, 5, 20);

        //instance.add(RegisterBlocks.RED_BEECH_LEAVES, 30, 60);
        //instance.add(RegisterBlocks.ORANGE_BEECH_LEAVES, 30, 60);
        //instance.add(RegisterBlocks.YELLOW_BEECH_LEAVES, 30, 60);
    }
}
