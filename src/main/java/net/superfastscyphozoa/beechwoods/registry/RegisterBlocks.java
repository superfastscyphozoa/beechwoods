package net.superfastscyphozoa.beechwoods.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.superfastscyphozoa.beechwoods.Beechwoods;

public class RegisterBlocks {

    //registry

    public static final Block BEECH_LOG = registerBlock("beech_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));

    public static final Block BEECH_WOOD = registerBlock("beech_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));

    public static final Block STRIPPED_BEECH_LOG = registerBlock("stripped_beech_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final Block STRIPPED_BEECH_WOOD = registerBlock("stripped_beech_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));

    //registry end

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Beechwoods.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Beechwoods.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerBeechwoodsBlocks() {
        Beechwoods.LOGGER.info("Registering Blocks for " + Beechwoods.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> {
            entries.addAfter(Blocks.CHERRY_LOG, BEECH_LOG);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(Blocks.CHERRY_BUTTON, BEECH_LOG);
            entries.addAfter(BEECH_LOG, BEECH_WOOD);
            entries.addAfter(BEECH_WOOD, STRIPPED_BEECH_LOG);
            entries.addAfter(STRIPPED_BEECH_LOG, STRIPPED_BEECH_WOOD);
        });

    }
}
