package net.superfastscyphozoa.beechwoods.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.superfastscyphozoa.beechwoods.Beechwoods;
import net.superfastscyphozoa.beechwoods.block.BeechLeavesBlock;
import net.superfastscyphozoa.beechwoods.world.tree.BeechwoodsSaplingGenerators;

public class RegisterBlocks {

    //registry

    public static final Block BEECH_LOG = registerBlock("beech_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));

    public static final Block GAZING_BEECH_LOG = registerBlock("gazing_beech_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)));

    public static final Block BEECH_WOOD = registerBlock("beech_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)));

    public static final Block STRIPPED_BEECH_LOG = registerBlock("stripped_beech_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)));

    public static final Block STRIPPED_BEECH_WOOD = registerBlock("stripped_beech_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)));

    public static final Block RED_BEECH_LEAVES = registerBlock("red_beech_leaves", createBeechLeaves(MapColor.RED));
    public static final Block ORANGE_BEECH_LEAVES = registerBlock("orange_beech_leaves", createBeechLeaves(MapColor.ORANGE));
    public static final Block YELLOW_BEECH_LEAVES = registerBlock("yellow_beech_leaves", createBeechLeaves(MapColor.YELLOW));

    public static final Block BEECH_SAPLING = registerBlock("beech_sapling",
            new SaplingBlock(BeechwoodsSaplingGenerators.BEECH, AbstractBlock.Settings.create()
                    .mapColor(MapColor.ORANGE)
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.GRASS)
                    .pistonBehavior(PistonBehavior.DESTROY)));

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
            entries.addAfter(BEECH_LOG, GAZING_BEECH_LOG);
            entries.addAfter(Blocks.CHERRY_SAPLING, BEECH_SAPLING);
            entries.addAfter(Blocks.CHERRY_LEAVES, RED_BEECH_LEAVES);
            entries.addAfter(RED_BEECH_LEAVES, ORANGE_BEECH_LEAVES);
            entries.addAfter(ORANGE_BEECH_LEAVES, YELLOW_BEECH_LEAVES);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.addAfter(Blocks.CHERRY_BUTTON, BEECH_LOG);
            entries.addAfter(BEECH_LOG, BEECH_WOOD);
            entries.addAfter(BEECH_WOOD, STRIPPED_BEECH_LOG);
            entries.addAfter(STRIPPED_BEECH_LOG, STRIPPED_BEECH_WOOD);
        });

    }

    // blocks

    public static Block createBeechLeaves(MapColor colour){
        return new BeechLeavesBlock(AbstractBlock.Settings.create()
                .mapColor(colour)
                .strength(0.2F)
                .ticksRandomly()
                .sounds(BlockSoundGroup.GRASS)
                .nonOpaque()
                .allowsSpawning(Blocks::canSpawnOnLeaves)
                .suffocates(Blocks::never)
                .blockVision(Blocks::never)
                .burnable()
                .pistonBehavior(PistonBehavior.DESTROY)
                .solidBlock(Blocks::never));
    }
}
