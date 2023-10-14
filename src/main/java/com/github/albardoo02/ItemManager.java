package com.github.albardoo02;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemManager {

    public static ItemStack ROD;
    public static ItemStack potion;
    public static ItemStack honey;
    public static ItemStack mushroom;
    public static ItemStack stick;

    public static ItemStack stick2;

    public static void init() {
        createROD();
        createPotion();
        createHoney();
        createMushroom();
        createStick();
        createStick2();
    }

    private static void createROD() {
        ItemStack item = new ItemStack(Material.BLAZE_ROD, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "ガラス粉砕ツール");
        List<String> lore = new ArrayList<>();
        lore.add("ガラスを一瞬で破壊するツール");
        lore.add("左クリックで使用");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        ROD = item;
    }

    private static void createPotion() {
        ItemStack item = new ItemStack(Material.POTION,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "聖水");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("とりたての聖水");
        meta.setLore(lore);
        item.setItemMeta(meta);
        potion = item;
    }

    private static void createHoney() {
        ItemStack item = new ItemStack(Material.HONEY_BOTTLE,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.GOLD + "甘いはちみつ");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("糖分摂取");
        meta.setLore(lore);
        item.setItemMeta(meta);
        honey = item;
    }

    private static void createMushroom() {
        ItemStack item = new ItemStack(Material.MUSHROOM_STEW,1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.WHITE + "温かいキノコシチュー");
        ArrayList<String> lore = new ArrayList<>();
        lore.add("できたてほやほや");
        meta.setLore(lore);
        item.setItemMeta(meta);
        mushroom = item;
    }

    private static void createStick(){
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "BlockChecker");
        List<String> lore = new ArrayList<>();
        lore.add("click and check the block ID");
        lore.add("use left click");
        lore.add("");
        lore.add("Shift + RightClick to Change Mode");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        stick = item;
    }

    private static void createStick2(){
        ItemStack item = new ItemStack(Material.STICK, 1);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.YELLOW + "ガラス粉砕ツール");
        List<String> lore = new ArrayList<>();
        lore.add("ガラスを一瞬で破壊するツール");
        lore.add("左クリックで使用");
        lore.add("");
        lore.add("Shift + 右クリックでモードを切り替えます");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 1, true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        meta.setUnbreakable(true);
        item.setItemMeta(meta);
        stick2 = item;
    }
}
