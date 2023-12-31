package com.github.albardoo02.Commands;

import com.github.albardoo02.CentralCore;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BalanceCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            Economy economy = CentralCore.getEconomy();

            if (args.length == 0) {
                player.sendMessage(ChatColor.GREEN + "Current Balance: " + economy.format(economy.getBalance(player)));
            } else if (args.length == 2 && args[0].equalsIgnoreCase("withdraw")) {
                double withdraw_amount = Double.valueOf(args[1]);

                EconomyResponse response = economy.withdrawPlayer(player, withdraw_amount);
                if (response.transactionSuccess()) {
                    player.sendMessage("You have successfully removed: " + economy.format(response.amount));
                    player.sendMessage("Your new balance: " + economy.format(response.balance) + "");
                } else {
                    player.sendMessage(ChatColor.RED + "Failed to withdraw money from your balance");
                    player.sendMessage(response.errorMessage);
                }
            }
        }
        return true;
    }

}
