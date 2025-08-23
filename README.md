<div align="center">
  <a href="https://modrinth.com/mod/wapi">
    <img alt="modrinth" height="56" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/modrinth_vector.svg">
  </a>
  <a href="https://github.com/Hezaerd/wapi">
    <img alt="github" height="56" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/cozy/available/github_vector.svg">
  </a>
<br>
  <img alt="fabric" height="40" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact/supported/fabric_vector.svg">
  <img alt="forge" height="40" src="https://cdn.jsdelivr.net/npm/@intergrav/devins-badges@3/assets/compact/unsupported/forge_vector.svg">
</div>

<br/>

# WAPI

A Fabric library mod that provides a simple and easy-to-use wrapper for the Wynncraft API v3. This mod allows other mods to easily interact with Wynncraft's game data including players, guilds, items, leaderboards, and more.

## Features

- **Player Data**: Get player statistics, character information, and more
- **Guild Information**: Access guild data and member lists  
- **Item Database**: Retrieve item information and metadata
- **Leaderboards**: Access various game leaderboards
- **Map Data**: Get territory and map information
- **Search**: Search for players, guilds, and other game entities
- **News**: Get the latest Wynncraft news
- **Classes & Abilities**: Access class and ability information

## How to Add to Your Mod

### For Mod Developers

Add the following to your `build.gradle`:

```gradle
dependencies {
    // Add WAPI as a dependency
    modImplementation "com.hezaerd:wapi:${wapi_version}"
}
```
> *As of today, the latest version is `1.0.0`*

And include it as a dependency in your `fabric.mod.json`:

```json
{
    "depends": {
        "wapi": ">=1.0.0"
    }
}
```

### For Players

This is a library mod that other mods depend on. Simply download and place the JAR file in your `mods` folder alongside Fabric API.

**Requirements:**
- Minecraft 1.21.4
- Fabric Loader 0.17.2+
- Fabric API

## How to Use

### Basic Setup

```java
import com.hezaerd.wapi.WapiClient;

// Create a client instance
WapiClient client = new WapiClient();
```

### Getting Player Data

```java
// Get player information
client.player().getPlayer("playerName").thenAccept(playerData -> {
    if (playerData != null) {
        System.out.println("Player: " + playerData.getUsername());
        System.out.println("Guild: " + playerData.getGuild().getName());
    }
});

// Get player characters
client.player().getCharacters("playerName").thenAccept(characters -> {
    characters.forEach(character -> {
        System.out.println("Character: " + character.getNickname());
        System.out.println("Level: " + character.getLevel());
    });
});
```

### Guild Information

```java
// Get guild data
client.guild().getGuild("guildName").thenAccept(guildData -> {
    if (guildData != null) {
        System.out.println("Guild: " + guildData.getName());
        System.out.println("Level: " + guildData.getLevel());
        System.out.println("Members: " + guildData.getMembers().size());
    }
});
```

### Item Database

```java
// Get all items
client.item().getAllItems().thenAccept(items -> {
    items.forEach((name, item) -> {
        System.out.println("Item: " + name + " (Tier: " + item.getTier() + ")");
    });
});
```

### Search

```java
// Search for players
client.search().searchPlayers("playerName").thenAccept(results -> {
    results.forEach(player -> {
        System.out.println("Found player: " + player);
    });
});
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Links

- **Author**: [Hezaerd](https://hezaerd.com/)
- **Source Code**: [GitHub](https://github.com/hezaerd/wapi)
- **Modrinth**: [Download](https://modrinth.com/mod/wapi)

<br>

<p align="center">
	<img src="https://raw.githubusercontent.com/catppuccin/catppuccin/main/assets/footers/gray0_ctp_on_line.svg?sanitize=true" />
</p>

<p align="center">
        <i><code>&copy 2025-present <a href="https://hezaerd.com">Hezaerd</a></code></i>
</p>

<div align="center">
<a href="https://github.com/hezaerd/wapi/blob/master/LICENSE"><img src="https://img.shields.io/github/license/hezaerd/wapi?logoColor=cdd6f4&labelColor=302D41&color=CBA6F7
" alt="LICENSE"></a>&nbsp;&nbsp;
</div>