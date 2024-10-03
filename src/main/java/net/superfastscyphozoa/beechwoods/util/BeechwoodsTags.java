package net.superfastscyphozoa.beechwoods.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.superfastscyphozoa.beechwoods.Beechwoods;

public class BeechwoodsTags {
    public static class Blocks {

        public static final TagKey<Block> BEECH_LOGS = createTag("beech_logs");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Beechwoods.MOD_ID, name));
        }

    }

    public static class Items {

        public static final TagKey<Item> BEECH_LOGS = createTag("beech_logs");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Beechwoods.MOD_ID, name));
        }

    }
}
