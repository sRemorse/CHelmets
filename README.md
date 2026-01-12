# CHelmets

**CHelmets** is a small Minecraft plugin for Paper servers that adds **cosmetic helmets** for players. Players can purchase and equip fun heads, without affecting their regular armor.

It’s designed as a **learning project** to explore **clean plugin architecture** and best practices, including configuration management, GUIs, and integration with economy plugins.

---

## Features

- Cosmetic helmets / heads that float or replace the helmet slot visually.
- Fully compatible with **Vault** and any supported economy plugin.
- GUI for browsing, equipping, and purchasing cosmetic helmets.
- Configurable **`helmets.yml`** to add or remove heads easily.
- Permissions support for locking certain helmets.
- Built with Paper 1.21.11 in min. Adventure Components, and modern Java practices.

---

## Requirements

- **Paper 1.21.11**
- **Vault** (for economy integration)

---

## Configuration

**`helmets.yml`** example:

```yaml
# Helmets Configuration
# Each key is a unique helmet ID (used internally and for permissions)
# The base64 value is from minecraft-heads.com

# name: "Example" - Display name (Supports mini-message)
# price: 100.0 - Price in-game
# permission-only: true/false - If only unlocked via permissions such as chelmets.helmet.<ID>
# texture: texture value from minecraft-heads.com

samurai_snow:
  name: "<aqua><!i>Sorrowful Snow Samurai"
  price: 500.0
  permission-only: false
  texture: "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTU5YTZhNWFiZTA3NDRhOTBkZDhhZGFkNWU4YTQyZmMwY2QxYTJkNzIyNDM2YzkyZGQzMzY1ODYzYTM0NWZkOCJ9fX0="
  lore:
    - "<blue>A majestic Samurai helmet"
    - "<blue>Fit for a god!"

samurai_red:
  name: "<red><!i>Sorrowful Red Samurai"
  price: 500.0
  permission-only: false
  texture: "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvNTU5YTZhNWFiZTA3NDRhOTBkZDhhZGFkNWU4YTQyZmMwY2QxYTJkNzIyNDM2YzkyZGQzMzY1ODYzYTM0NWZkOCJ9fX0="
  lore:
    - "<blue>A majestic Samurai helmet"
    - "<blue>Filled with anger!"
```

---

## Contributing
- This project is primarily a learning project, but pull requests and suggestions are welcome!