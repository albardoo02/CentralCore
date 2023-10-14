package com.github.albardoo02.Listeners;

import com.github.albardoo02.CentralCore;
import com.github.albardoo02.ItemManager;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Economy economy = CentralCore.getEconomy();

        if(event.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "自販機")) {
            if (event.getCurrentItem() == null) {
                return;
            }
            else if (event.getCurrentItem().getType().equals(Material.POTION)) {
                if (player.getInventory().firstEmpty() == -1) {
                    player.sendMessage(ChatColor.RED + "インベントリに空きがありません！");
                }
                else{
                    if (Double.valueOf(economy.getBalance(player)) < 100) {
                        player.sendMessage(ChatColor.RED + "残高が足りません！");
                        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO,1,1);
                    }
                    else {
                        double withdraw_amount = Double.valueOf(100);
                        EconomyResponse response = economy.withdrawPlayer(player, withdraw_amount);
                        player.sendMessage(economy.format(response.amount) + " でポーションを購入しました");
                        player.getInventory().addItem(ItemManager.potion);
                        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,1,1);
                    }
                }
            }
            else if (event.getCurrentItem().getType().equals(Material.HONEY_BOTTLE)) {
                if (player.getInventory().firstEmpty() == -1) {
                    player.sendMessage(ChatColor.RED + "インベントリに空きがありません！");
                }
                else{
                    if (Double.valueOf(economy.getBalance(player)) < 200) {
                        player.sendMessage(ChatColor.RED + "残高が足りません！");
                        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO,1,1);
                    }
                    else {
                        double withdraw_amount = Double.valueOf(200);
                        EconomyResponse response = economy.withdrawPlayer(player, withdraw_amount);
                        player.sendMessage(economy.format(response.amount) + " で甘いはちみつを購入しました");
                        player.getInventory().addItem(ItemManager.honey);
                        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,1,1);
                    }
                }
            }
            else if (event.getCurrentItem().getType().equals(Material.MUSHROOM_STEW)) {
                if (player.getInventory().firstEmpty() == -1) {
                    player.sendMessage(ChatColor.RED + "インベントリに空きがありません！");
                }
                else{
                    if (Double.valueOf(economy.getBalance(player)) < 150) {
                        player.sendMessage(ChatColor.RED + "残高が足りません！");
                        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO,1,1);
                    }
                    else {
                        double withdraw_amount = Double.valueOf(150);
                        EconomyResponse response = economy.withdrawPlayer(player, withdraw_amount);
                        player.sendMessage(economy.format(response.amount) + " で温かいキノコシチューを購入しました");
                        player.getInventory().addItem(ItemManager.mushroom);
                        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,1,1);
                    }
                }
            }
            else if (event.getCurrentItem().getType().equals(Material.STICK)) {
                if (player.getInventory().firstEmpty() == -1) {
                    player.sendMessage(ChatColor.RED + "インベントリに空きがありません！");
                }
                else{
                    if (Double.valueOf(economy.getBalance(player)) < 100) {
                        player.sendMessage(ChatColor.RED + "残高が足りません！");
                        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO,1,1);
                    }
                    else {
                        double withdraw_amount = Double.valueOf(100);
                        EconomyResponse response = economy.withdrawPlayer(player, withdraw_amount);
                        player.sendMessage(economy.format(response.amount) + " でBlockCheckerを購入しました");
                        player.getInventory().addItem(ItemManager.stick);
                        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,1,1);
                    }
                }
            }
            else if (event.getCurrentItem().getType().equals(Material.BLAZE_ROD)) {
                if (player.getInventory().firstEmpty() == -1) {
                    player.sendMessage(ChatColor.RED + "インベントリに空きがありません！");
                }
                else{
                    if (Double.valueOf(economy.getBalance(player)) < 100) {
                        player.sendMessage(ChatColor.RED + "残高が足りません！");
                        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_VILLAGER_NO,1,1);
                    }
                    else {
                        double withdraw_amount = Double.valueOf(100);
                        EconomyResponse response = economy.withdrawPlayer(player, withdraw_amount);
                        player.sendMessage(economy.format(response.amount) + " でガラス粉砕ツールを購入しました");
                        player.getInventory().addItem(ItemManager.stick2);
                        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP,1,1);
                    }
                }
            }
            else if (event.getCurrentItem().getType().equals(Material.BARRIER)) {
                player.closeInventory();
            }
            event.setCancelled(true);
        }
    }
}