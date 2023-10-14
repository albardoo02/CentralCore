package com.github.albardoo02.Listeners;

import com.github.albardoo02.ItemManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerInteract implements Listener {

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        Block block = event.getClickedBlock();
        Action action = event.getAction();
        Player player = event.getPlayer();
        if(action.equals(Action.LEFT_CLICK_BLOCK)){
            if (event.getItem() !=null) {
                if (event.getItem().getItemMeta().equals((ItemManager.ROD.getItemMeta()))) {
                    if (block.getType() == Material.GLASS) {
                        event.setCancelled(true);
                        block.setType(Material.AIR);
                        player.getInventory().addItem(new ItemStack(Material.GLASS));
                        player.playSound(player.getLocation(), Sound.BLOCK_GLASS_BREAK, 1.0f, 1.0f);
                    }
                }
                if (event.getItem().getItemMeta().equals((ItemManager.stick2.getItemMeta()))) {
                    if (block.getType() == Material.GLASS) {
                        event.setCancelled(true);
                        block.setType(Material.AIR);
                        player.getInventory().addItem(new ItemStack(Material.GLASS));
                        player.playSound(player.getLocation(), Sound.BLOCK_GLASS_BREAK, 1.0f, 1.0f);
                    }
                }
                if (event.getItem().getItemMeta().equals((ItemManager.stick.getItemMeta()))) {
                    event.setCancelled(true);
                    player.sendMessage("ID: " + block.getType().toString().toUpperCase());
                    player.getWorld().playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BELL,1,1);
                }
            }
        }
        if (!player.isSneaking()) return;
        if(event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK) return;
        if (event.getItem() !=null) {
            if (event.getItem().getItemMeta().equals((ItemManager.stick.getItemMeta()))) {
                ItemStack itemInHand = event.getPlayer().getInventory().getItemInMainHand();
                itemInHand.setAmount(itemInHand.getAmount() - 1);
                player.getInventory().addItem(ItemManager.stick2);
                player.spigot().sendMessage(
                        ChatMessageType.ACTION_BAR,
                        new TextComponent(ChatColor.translateAlternateColorCodes('&',"&aガラス粉砕ツールに切り替えました"))
                );
            }
            if (event.getItem().getItemMeta().equals((ItemManager.stick2.getItemMeta()))) {
                ItemStack itemInHand = event.getPlayer().getInventory().getItemInMainHand();
                itemInHand.setAmount(itemInHand.getAmount() - 1);
                player.getInventory().addItem(ItemManager.stick);
                player.spigot().sendMessage(
                        ChatMessageType.ACTION_BAR,
                        new TextComponent(ChatColor.translateAlternateColorCodes('&',"&aBlockCheckerに切り替えました"))
                );
            }
        }
    }
}