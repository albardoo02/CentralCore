package com.github.albardoo02.Commands;

import com.github.albardoo02.CentralCore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class SetWikiCommand implements CommandExecutor {

    CentralCore plugin;
    public SetWikiCommand(CentralCore plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
        }
        if (command.getName().equalsIgnoreCase("setwiki")) {
            if (sender.hasPermission("centralcore.command.setwiki")) {
                if (args.length <= 0) {
                    for (String line : plugin.getConfig().getStringList("SetCommandHelp")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                    }
                    return true;
                }
                if (args[0].equalsIgnoreCase("help")) {
                    for (String line : plugin.getConfig().getStringList("SetCommandHelp")) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                    }
                    return true;
                }
                if (args[0].equalsIgnoreCase("set")) {
                    if (args.length == 1) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "/wiki set <URL>"));
                    }
                    if (args[1].equalsIgnoreCase(args[1])) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&eURLを &d" + args[1] + " &eに設定しました"));
                        plugin.getConfig().set("URL", args[1]);
                        plugin.saveConfig();
                    }
                }
                if (args[0].equalsIgnoreCase("add")) {
                    if (args.length == 1) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "/wiki add <設定名> <URL>"));
                    }
                    if (args.length == 2) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "/wiki add " + args[1] + " <URL>"));
                    }
                    if (args[2].equalsIgnoreCase(args[2])) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d" + args[1] + " のリンクを &d" + args[2] + " で登録しました"));
                        plugin.getConfig().set("Links." + args[1] + ".URL", args[2]);
                        List<String> TAB = plugin.getConfig().getStringList("TAB");
                        TAB.add(args[1]);
                        plugin.getConfig().set("TAB", TAB);
                        plugin.saveConfig();
                    }
                }
            } else {
                for (String line : plugin.getConfig().getStringList("NoPerm")) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                }
            }
        }
        return true;
    }

}
