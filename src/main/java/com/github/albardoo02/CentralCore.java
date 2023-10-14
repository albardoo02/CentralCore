package com.github.albardoo02;

import com.github.albardoo02.Commands.*;
import com.github.albardoo02.Listeners.BlockBreak;
import com.github.albardoo02.Listeners.InventoryClick;
import com.github.albardoo02.Listeners.PlayerInteract;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class CentralCore extends JavaPlugin {

    public String version = getDescription().getVersion();

    private static Economy econ = null;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',"[CentralCore] &aPlugin has been Enabled"));
        this.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',"[CentralCore] &fVersion：&e" + version));

        if (!setupEconomy() ) {
            getLogger().info("Not found Economy Plugin");
            getLogger().info("Vault has been disabled");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        this.getCommand("wiki").setExecutor(new WikiCommand(this));
        this.getCommand("wiki").setTabCompleter(new WikiCommandTabComplete(this));
        this.getCommand("setwiki").setExecutor(new SetWikiCommand(this));
        this.getCommand("setwiki").setTabCompleter(new SetWikiCommandTabComplete(this));
        this.getCommand("cc").setExecutor(new CentralCoreCommand(this));
        this.getCommand("wear").setExecutor(new WearCommand(this));
        this.getCommand("money").setExecutor(new BalanceCommand());
        this.getCommand("gui").setExecutor(new GUICommand());

        this.getServer().getPluginManager().registerEvents(new PlayerInteract(), this);
        this.getServer().getPluginManager().registerEvents(new InventoryClick(),this);
        this.getServer().getPluginManager().registerEvents(new BlockBreak(this),this);

        this.saveDefaultConfig();

        ItemManager.init();
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getServer().getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&',"[CentralCore] &cPlugin has been disabled"));
        saveConfig();
    }
}
