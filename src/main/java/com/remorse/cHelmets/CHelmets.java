package com.remorse.cHelmets;

import com.remorse.cHelmets.config.ConfigManager;
import com.remorse.cHelmets.cosmetic.CosmeticManager;
import com.remorse.cHelmets.economy.EconomyHook;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.plugin.java.JavaPlugin;

@SuppressWarnings("unused")
public final class CHelmets extends JavaPlugin {

    private EconomyHook economyHook;
    private ConfigManager configManager;
    private CosmeticManager cosmeticManager;
    private MiniMessage miniMessage;

    @Override
    public void onEnable() {
        this.getLogger().info("Plugin enabled");

        // Init Configs
        this.configManager = new ConfigManager(this);

        // Init Economy
        this.economyHook = new EconomyHook(this);

        // Init Managers
        this.cosmeticManager = new CosmeticManager(this);

        // Register commands & Listeners
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        this.getLogger().info("Plugin disabled");
    }

    private void registerCommands() {
        this.getLifecycleManager().registerEventHandler(LifecycleEvents.COMMANDS, commands -> {

        });
    }

    private void registerConfigs() {
        configManager.getDefaultConfig();
        configManager.get("helmets.yml");
    }

    // Getters

    public EconomyHook getEconomyHook() {
        return economyHook;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public CosmeticManager getCosmeticManager() {
        return cosmeticManager;
    }

    public MiniMessage getMM(){
        return miniMessage;
    }

}
