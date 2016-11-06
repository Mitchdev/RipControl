package me.ripbandit.ripcp;

import me.ripbandit.ripcp.events.DeathEvent;
import me.ripbandit.ripcp.events.PlayerChat;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

/**
 * Created by rip on 11/5/16.
 */
public class RipCP extends JavaPlugin {

    public static RipCP instance;

    @Override
    public void onEnable() {
        instance = this;

        loadConfig();

        registerListeners();
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    private void loadConfig() {
        try {
            if (!getDataFolder().exists()) {
                getDataFolder().mkdirs();
            }
            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
                getLogger().info("Config found, loading.");
                saveDefaultConfig();
            } else {
                getLogger().info("Config not found, creating!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new DeathEvent(), this);
        pm.registerEvents(new PlayerChat(), this);
    }
}
