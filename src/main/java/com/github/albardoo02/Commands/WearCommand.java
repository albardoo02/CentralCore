package com.github.albardoo02.Commands;

import com.github.albardoo02.CentralCore;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WearCommand implements CommandExecutor, TabCompleter {

    CentralCore plugin;
    public WearCommand(CentralCore plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (command.getName().equalsIgnoreCase("wear")) {
                if (sender.hasPermission("centralcore.command.wear")) {
                    if (args.length <= 0) {
                        for (String line : plugin.getConfig().getStringList("WearCommandHelp")) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                        }
                        return true;
                    }
                    if (args.length == 1) {
                        if (args[0].equalsIgnoreCase("help")) {
                            for (String line : plugin.getConfig().getStringList("WearCommandHelp")) {
                                player.sendMessage(ChatColor.translateAlternateColorCodes('&', line));
                            }
                            return true;
                        }
                        if (args[0].equalsIgnoreCase("helmet")) {
                            PlayerInventory inv = player.getInventory();
                            ItemStack hand = inv.getItemInMainHand();
                            ItemStack helmet = inv.getHelmet();
                            inv.setItemInMainHand(helmet);
                            inv.setHelmet(hand);
                        }
                        if (args[0].equalsIgnoreCase("chestplate")) {
                            PlayerInventory inv = player.getInventory();
                            ItemStack hand = inv.getItemInMainHand();
                            ItemStack chestplate = inv.getChestplate();
                            inv.setItemInMainHand(chestplate);
                            inv.setChestplate(hand);
                        }
                        if (args[0].equalsIgnoreCase("leggings")) {
                            PlayerInventory inv = player.getInventory();
                            ItemStack hand = inv.getItemInMainHand();
                            ItemStack leggings = inv.getLeggings();
                            inv.setItemInMainHand(leggings);
                            inv.setLeggings(hand);
                        }
                        if (args[0].equalsIgnoreCase("boots")) {
                            PlayerInventory inv = player.getInventory();
                            ItemStack hand = inv.getItemInMainHand();
                            ItemStack boots = inv.getBoots();
                            inv.setItemInMainHand(boots);
                            inv.setBoots(hand);
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(command.getName().equalsIgnoreCase("wear")) {
            if (args.length == 1) {
                if (args[0].length() == 0) {
                    return Arrays.asList("helmet", "chestplate", "leggings", "boots");
                } else {
                    if ("helmet".startsWith(args[0]) && "chestplate".startsWith(args[0]) && "leggings".startsWith(args[0]) && "leggings".startsWith(args[0]) && "boots".startsWith(args[0])) {
                        return Arrays.asList("helmet", "chestplate", "leggings", "boots");
                    } else if ("helmet".startsWith(args[0])) {
                        return Collections.singletonList("helmet");
                    } else if ("chestplate".startsWith(args[0])) {
                        return Collections.singletonList("chestplate");
                    } else if ("leggings".startsWith(args[0])) {
                        return Collections.singletonList("leggings");
                    } else if ("boots".startsWith(args[0])) {
                        return Collections.singletonList("boots");
                    }
                }
            }
        }
        return null;
    }
}
