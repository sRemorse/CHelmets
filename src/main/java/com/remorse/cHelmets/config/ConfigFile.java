package com.remorse.cHelmets.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@SuppressWarnings("unused")
public class ConfigFile {

    private final JavaPlugin plugin;
    private final String fileName;
    private final File file;
    private FileConfiguration config;

    public ConfigFile(JavaPlugin plugin, String fileName) {
        this.plugin = plugin;
        this.fileName = fileName;
        this.file = new File(plugin.getDataFolder(), fileName);

        saveDefault();
        reload();
    }

    private void saveDefault() {
        if (!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdirs();
        }

        if (!file.exists()) {
            plugin.saveResource(fileName, false);
        }
    }

    public void reload() {
        this.config = YamlConfiguration.loadConfiguration(file);
    }

    public void save() {
        try {
            config.save(file);
        } catch (IOException error) {
            plugin.getLogger().severe("Could not save " + fileName);
            error.printStackTrace();
        }
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public String getFileName() {
        return fileName;
    }

    // Pass-through helpers

    public Set<String> getKeys(boolean deep) {
        return config.getKeys(deep);
    }

    public String getString(String path) {
        return config.getString(path);
    }

    public double getDouble(String path) {
        return config.getDouble(path);
    }

    public boolean getBoolean(String path) {
        return config.getBoolean(path);
    }

    public List<String> getStringList(String path) {
        return config.getStringList(path);
    }

}
