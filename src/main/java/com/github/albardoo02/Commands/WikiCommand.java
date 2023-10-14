package com.github.albardoo02.Commands;

import com.github.albardoo02.CentralCore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WikiCommand implements CommandExecutor {

    CentralCore plugin;
    public WikiCommand(CentralCore plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String url = plugin.getConfig().getString("URL");
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("wiki")) {
                if (args.length <= 0) {
                    sender.sendMessage(url);
                    return true;
                }
                if (args[0].equalsIgnoreCase("url")) {
                    sender.sendMessage(url);
                }
                for (String line : plugin.getConfig().getStringList("TAB")) {
                    if (args[0].equalsIgnoreCase(line)) {
                        for (String link : plugin.getConfig().getStringList("Link")) {
                            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', link).replace("%name", args[0]).replace("%url", plugin.getConfig().getString("Links." + args[0] + ".URL")));
                        }
                    }
                }

            }
        }
        return true;
    }
}
