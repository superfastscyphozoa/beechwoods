package net.superfastscyphozoa.beechwoods.block;

import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.superfastscyphozoa.beechwoods.registry.RegisterBlocks;

public class BeechwoodsStrippableBlocks {
    public static void RegisterStrippableBlocks(){
        StrippableBlockRegistry.register(RegisterBlocks.BEECH_LOG, RegisterBlocks.STRIPPED_BEECH_LOG);
        StrippableBlockRegistry.register(RegisterBlocks.BEECH_WOOD, RegisterBlocks.STRIPPED_BEECH_WOOD);
    }
}
