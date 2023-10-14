package com.github.albardoo02.Listeners;

import com.github.albardoo02.CentralCore;
import com.github.albardoo02.ItemManager;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class BlockBreak implements Listener {

    CentralCore plugin;

    public BlockBreak(CentralCore plugin) {
        this.plugin = plugin;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onBlockBreak(PlayerInteractEvent event) {
        Economy economy = CentralCore.getEconomy();
        Player player = event.getPlayer();
        Action action = event.getAction();
        EconomyResponse response = economy.depositPlayer(player, Double.parseDouble(plugin.getConfig().getString("BlockBreakMoney.Amount")));
        if (!plugin.getConfig().getBoolean("BlockBreakMoney.Enabled")) {
            return;
        }
        if (event.getItem() != null) {
            if (event.getItem().getItemMeta().equals((ItemManager.stick.getItemMeta()))) {
                return;
            }
        }
        if(action.equals(Action.LEFT_CLICK_BLOCK)){
            if (response.transactionSuccess()) {
                player.spigot().sendMessage(
                        ChatMessageType.ACTION_BAR,
                        new TextComponent(economy.format(response.amount) + " added")
                );
            }
        }
    }
}
