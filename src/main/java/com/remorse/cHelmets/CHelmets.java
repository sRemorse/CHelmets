package com.remorse.cHelmets;

import com.remorse.cHelmets.economy.EconomyHook;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import org.bukkit.plugin.java.JavaPlugin;

public final class CHelmets extends JavaPlugin {

    private EconomyHook economyHook;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getLogger().info("Plugin enabled");

        this.economyHook = new EconomyHook(this);


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

    public EconomyHook getEconomyHook() {
        return economyHook;
    }
}
