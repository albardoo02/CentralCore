package com.github.albardoo02.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GUICommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            Inventory gui = Bukkit.createInventory(player, 9, ChatColor.RED + "自販機");

            ItemStack potion = new ItemStack(Material.POTION,1);
            ItemStack honey = new ItemStack(Material.HONEY_BOTTLE,1);
            ItemStack mushroom = new ItemStack(Material.MUSHROOM_STEW,1);
            ItemStack stick = new ItemStack(Material.STICK,1);
            ItemStack rod = new ItemStack(Material.STICK,1);
            ItemStack end = new ItemStack(Material.BARRIER,1);

            ItemMeta potion_meta = potion.getItemMeta();
            potion_meta.setDisplayName(ChatColor.AQUA + "聖水");
            ArrayList<String> potion_lore = new ArrayList<>();
            potion_lore.add("とりたての聖水");
            potion_lore.add("");
            potion_lore.add(ChatColor.LIGHT_PURPLE+ "価格: " + ChatColor.YELLOW + "$100");
            potion_lore.add(ChatColor.GREEN + "クリックで購入する");
            potion_meta.setLore(potion_lore);
            potion.setItemMeta(potion_meta);

            ItemMeta honey_meta = honey.getItemMeta();
            honey_meta.setDisplayName(ChatColor.GOLD + "甘いはちみつ");
            ArrayList<String> honey_lore = new ArrayList<>();
            honey_lore.add("糖分摂取");
            honey_lore.add("");
            honey_lore.add(ChatColor.LIGHT_PURPLE+ "価格: " + ChatColor.YELLOW + "$200");
            honey_lore.add(ChatColor.GREEN + "クリックで購入する");
            honey_meta.setLore(honey_lore);
            honey.setItemMeta(honey_meta);

            ItemMeta mushroom_meta = mushroom.getItemMeta();
            mushroom_meta.setDisplayName(ChatColor.WHITE + "温かいキノコシチュー");
            ArrayList<String> mushroom_lore = new ArrayList<>();
            mushroom_lore.add("できたてほやほや");
            mushroom_lore.add("");
            mushroom_lore.add(ChatColor.LIGHT_PURPLE+ "価格: " + ChatColor.YELLOW + "$150");
            mushroom_lore.add(ChatColor.GREEN + "クリックで購入する");
            mushroom_meta.setLore(mushroom_lore);
            mushroom.setItemMeta(mushroom_meta);

            ItemMeta stick_meta = stick.getItemMeta();
            stick_meta.setDisplayName(ChatColor.YELLOW + "BlockChecker");
            ArrayList<String> stick_lore = new ArrayList<>();
            stick_lore.add("click and check the block ID");
            stick_lore.add("use left click");
            stick_lore.add("");
            stick_lore.add(ChatColor.LIGHT_PURPLE+ "価格: " + ChatColor.YELLOW + "$100");
            stick_lore.add(ChatColor.GREEN + "クリックで購入する");
            stick_meta.setLore(stick_lore);
            stick.setItemMeta(stick_meta);

            ItemMeta rod_meta = stick.getItemMeta();
            rod_meta.setDisplayName(ChatColor.AQUA + "ガラス粉砕ツール");
            ArrayList<String> rod_lore = new ArrayList<>();
            rod_lore.add("click and check the block ID");
            rod_lore.add("use left click");
            rod_lore.add("");
            rod_lore.add(ChatColor.LIGHT_PURPLE+ "価格: " + ChatColor.YELLOW + "$100");
            rod_lore.add(ChatColor.GREEN + "クリックで購入する");
            rod_meta.setLore(rod_lore);
            rod.setItemMeta(rod_meta);

            ItemMeta end_meta = end.getItemMeta();
            end_meta.setDisplayName(ChatColor.RED + "メニューを閉じる");
            end.setItemMeta(end_meta);
            gui.setItem(8,end);

            gui.addItem(potion, honey, mushroom, stick, rod);
            player.openInventory(gui);
        }
        return true;
    }
}