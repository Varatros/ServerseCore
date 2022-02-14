package io.github.varatros.serversecore;

import io.github.varatros.serversecore.commands.MapCommand;
import io.github.varatros.serversecore.commands.TwitchCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerseCore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("map").setExecutor(new MapCommand());
        this.getCommand("twitch").setExecutor(new TwitchCommand());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
