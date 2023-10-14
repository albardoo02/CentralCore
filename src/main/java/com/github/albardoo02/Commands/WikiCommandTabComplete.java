package com.github.albardoo02.Commands;

import com.github.albardoo02.CentralCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class WikiCommandTabComplete implements TabCompleter {

    CentralCore plugin;
    public WikiCommandTabComplete(CentralCore plugin){
        this.plugin = plugin;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String commandLable, String[] args) {
        List<String> completions = new ArrayList<>();
        if (args.length == 1) {
            for (String line : plugin.getConfig().getStringList("TAB")) {
                completions.add(line);
            }
            return StringUtil.copyPartialMatches(args[0], completions, new ArrayList<>());
        }
        return null;
    }
}
