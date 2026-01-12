package com.remorse.cHelmets.economy;

import com.remorse.cHelmets.CHelmets;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;


/**
 * Handles hooking into Vault and providing access to an economy plugin.
 * <p>
 * This class checks if Vault is installed and if an economy plugin is registered with Vault.
 * If successful, Allows interaction with the server economy.
 * </p>
 */
@SuppressWarnings("unused")
public class EconomyHook {

    private final CHelmets plugin;
    private Economy economy;

    /**
     * Constructs an EconomyHook for the given plugin and attempts to hook Vault.
     * <p>
     * If no Vault-compatible economy plugin is found, this will disable the plugin.
     * </p>
     *
     * @param plugin The main plugin instance
     */
    public EconomyHook(CHelmets plugin) {
        this.plugin = plugin;

        if (setupEconomy()) {
            plugin.getLogger().info("Economy hooked successfully!");
        } else {
            plugin.getLogger().severe("No economy plugin found! - Disabling CHelmets");
            plugin.getServer().getPluginManager().disablePlugin(plugin);
        }

    }

    /**
     * Attempts to set up the economy by checking if Vault is installed and
     * if an economy plugin is registered with it.
     *
     * @return True - If an economy plugin was successfully hooked, false otherwise.
     */
    private boolean setupEconomy() {
        if (plugin.getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }

        RegisteredServiceProvider<Economy> rsp = plugin.getServer()
                .getServicesManager()
                .getRegistration(Economy.class);

        if (rsp == null) {
            return false;
        }

        this.economy = rsp.getProvider();
        return economy != null;
    }

    /**
     * Returns the economy provider instance.
     *
     * @return The hooked {@link Economy} instance, or null if no economy plugin is found
     */
    public Economy getEconomy() {
        return economy;
    }

    /**
     * Checks whether an economy plugin has been successfully hooked.
     *
     * @return True - If an economy plugin is hooked, false otherwise.
     */
    public boolean hasEconomy() {
        return economy != null;
    }

}
