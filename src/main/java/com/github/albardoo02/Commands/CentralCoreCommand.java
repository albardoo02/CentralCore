package com.github.albardoo02.Commands;

import com.github.albardoo02.CentralCore;
import com.github.albardoo02.ItemManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class CentralCoreCommand implements CommandExecutor, TabCompleter {

    CentralCore plugin;
    public CentralCoreCommand(CentralCore plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cコンソールからは実行できません!"));
            return true;
        }
        Player player = (Player) sender;
        if (command.getName().equalsIgnoreCase("cc")) {
            if (player.hasPermission("centralcore.command.admin")) {
                if (args.length <= 0) {
                    for (String line : plugin.getConfig().getStringList("CentralCoreCommandHelp")) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',line));
                    }
                    return true;
                }
                if (args[0].equalsIgnoreCase("help")) {
                    for (String line : plugin.getConfig().getStringList("CentralCoreCommandHelp")) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',line));
                    }
                    return true;
                }
                if (args[0].equalsIgnoreCase("version")) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&fCurrent Version：&d" + plugin.version));
                    return true;
                }
                if (args[0].equalsIgnoreCase("reload")) {
                    plugin.reloadConfig();
                    player.sendMessage("Configを再読み込みしました");
                    return true;
                }
                if (args[0].equalsIgnoreCase("get")) {
                    if (args.length == 1) {
                        player.sendMessage("/cc get <アイテム名>");
                        return true;
                    }
                    if (args.length == 2) {
                        if (args[1].equalsIgnoreCase("tool1")) {
                            player.getInventory().addItem(ItemManager.ROD);
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&dガラス粉砕ツール&fを付与しました"));
                            return true;
                        }
                        if (args[1].equalsIgnoreCase("tool2")) {
                            player.getInventory().addItem(ItemManager.stick);
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&dBlockChecker&fを付与しました"));
                            return true;
                        }
                        if (args[1].equalsIgnoreCase("tool3")) {
                            player.getInventory().addItem(ItemManager.stick2);
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&dガラス粉砕ツール&fを付与しました"));
                            return true;
                        }
                        if (args[1].equalsIgnoreCase("item1")) {
                            player.getInventory().addItem(ItemManager.potion);
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d聖水&fを付与しました"));
                            return true;
                        }
                        if (args[1].equalsIgnoreCase("item2")) {
                            player.getInventory().addItem(ItemManager.honey);
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d甘いはちみつ&fを付与しました"));
                            return true;
                        }
                        if (args[1].equalsIgnoreCase("item3")) {
                            player.getInventory().addItem(ItemManager.mushroom);
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&d温かいキノコシチュー&fを付与しました"));
                            return true;
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String commandLable, String[] args) {
        List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            completions.add("help");
            completions.add("get");
            completions.add("version");
            completions.add("reload");
            return StringUtil.copyPartialMatches(args[0], completions, new ArrayList<>());
        }
        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("get")) {
                completions.add("tool1");
                completions.add("tool2");
                completions.add("tool3");
                completions.add("item1");
                completions.add("item2");
                completions.add("item3");
            }
            return StringUtil.copyPartialMatches(args[1], completions, new ArrayList<>());
        }
        return null;
    }
}
