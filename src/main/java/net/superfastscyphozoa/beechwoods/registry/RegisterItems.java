package net.superfastscyphozoa.beechwoods.registry;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.superfastscyphozoa.beechwoods.Beechwoods;

public class RegisterItems {

    //registry

    public static final Item PUMPKIN_SOUP = registerItem("pumpkin_soup", new Item(new Item.Settings()));

    //registry end

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Beechwoods.MOD_ID, name), item);
    }

    public static void registerBeechwoodsItems() {
        Beechwoods.LOGGER.info("Registering Items for " + Beechwoods.MOD_ID);

        //tells the game where to put the items in the inventory

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {

            entries.addAfter(Items.BEETROOT_SOUP, PUMPKIN_SOUP);
        });
    }
}
