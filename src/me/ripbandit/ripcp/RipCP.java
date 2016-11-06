package me.ripbandit.ripcp;

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
}
