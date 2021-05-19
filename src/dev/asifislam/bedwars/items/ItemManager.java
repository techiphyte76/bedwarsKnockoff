package dev.asifislam.bedwars.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    public static ItemStack wand;

    public static void init() {
        createWand();
    }

    private static void createWand() {
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("Elder Wand");
        List<String> lore = new ArrayList<String>();
        lore.add("The most powerful wand in existence");
        lore.add("Use it wisely...");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.KNOCKBACK, 100, false);
        item.setItemMeta(meta);
        wand = item;
    }

    public static void createFireball() {

    }
}
