package com.remorse.cHelmets.config;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class ConfigManager {

    private final JavaPlugin plugin;
    private final Map<String, ConfigFile> configs = new HashMap<>();

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    /**
     * Create or get a new {@link ConfigFile}
     */
    public ConfigFile get(String fileName) {
        return configs.computeIfAbsent(
                fileName,
                name -> new ConfigFile(plugin, name)
        );
    }

    public void reloadAll() {
        configs.values().forEach(ConfigFile::reload);
    }

    public Map<String, ConfigFile> getAll() {
        return Collections.unmodifiableMap(configs);
    }

    /**
     * Get the default config.yml from the plugin resources folder and save it to the data folder.
     */
    public void getDefaultConfig() {
        plugin.getConfig().options().copyDefaults();
        plugin.saveDefaultConfig();
    }

}
