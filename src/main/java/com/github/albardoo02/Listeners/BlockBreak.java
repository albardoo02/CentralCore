package com.github.albardoo02.Listeners;

import com.github.albardoo02.CentralCore;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreak implements Listener {

    CentralCore plugin;

    public BlockBreak(CentralCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerInteract(BlockBreakEvent event) {
        Economy economy = CentralCore.getEconomy();
        Player player = event.getPlayer();
        Block block = event.getBlock();
        EconomyResponse response = economy.depositPlayer(player, Double.parseDouble(plugin.getConfig().getString("BlockBreakMoney.Amount")));
        if (!plugin.getConfig().getBoolean("BlockBreakMoney.Enabled")) {
            return;
        }
        if(block.getType() == event.getBlock().getType()){
            if (response.transactionSuccess()) {
                player.spigot().sendMessage(
                        ChatMessageType.ACTION_BAR,
                        new TextComponent(economy.format(response.amount) + " added")
                );
            }
        }
    }
}
