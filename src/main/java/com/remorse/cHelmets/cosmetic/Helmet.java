package com.remorse.cHelmets.cosmetic;

import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;

import java.util.List;
@SuppressWarnings("unused")
public class Helmet {

    private final String id;
    private final Component displayName;
    private final double price;
    private final String texture;
    private final List<Component> lore;
    private final boolean permissionOnly;
    private final ItemStack icon;

    public Helmet(String id, Component displayName, double price, String texture, List<Component> lore, boolean permissionOnly, ItemStack icon) {
        this.id = id;
        this.displayName = displayName;
        this.price = price;
        this.texture = texture;
        this.lore = lore;
        this.permissionOnly = permissionOnly;
        this.icon = icon;
    }

    public String getId() {
        return id;
    }

    public Component getDisplayName() {
        return displayName;
    }

    public double getPrice() {
        return price;
    }

    public String getTexture() {
        return texture;
    }

    public List<Component> getLore() {
        return lore;
    }

    public boolean isPermissionOnly() {
        return permissionOnly;
    }

    public ItemStack getIcon() {
        return icon.clone();
    }
}
