package com.remorse.cHelmets.cosmetic;

import com.remorse.cHelmets.CHelmets;
import com.remorse.cHelmets.config.ConfigFile;
import com.remorse.cHelmets.config.ConfigManager;
import net.kyori.adventure.text.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("unused")
public class CosmeticManager {

    private final CHelmets plugin;
    private final ConfigFile helmetsConfig;

    private final Map<String, Helmet> helmets = new HashMap<>();

    public CosmeticManager(CHelmets plugin) {
        this.plugin = plugin;
        ConfigManager configManager = plugin.getConfigManager();
        helmetsConfig = configManager.get("helmets.yml");
    }

    private void loadHelmets(){
        for (String key : helmetsConfig.getKeys(false)) {
            String name = helmetsConfig.getString(key + ".name");
            double price = helmetsConfig.getDouble(key + ".price");
            boolean permissionOnly = helmetsConfig.getBoolean(key + ".permission-only");
            List<String> loreStrings = helmetsConfig.getStringList(key + ".lore");

            List<Component> lore = loreStrings.stream()
                    .map(plugin.getMM()::deserialize).toList();

            String texture = helmetsConfig.getString(key + ".texture");

            // TODO: Finish loading of helmets into a skull item/icon
        }
    }

}
