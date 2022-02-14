package io.github.varatros.serversecore;

import io.github.varatros.serversecore.commands.MapCommand;
import io.github.varatros.serversecore.commands.TwitchCommand;
import io.github.varatros.serversecore.events.player.PlayerConnectionEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class ServerseCore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("map").setExecutor(new MapCommand());
        this.getCommand("twitch").setExecutor(new TwitchCommand());
        Bukkit.getPluginManager().registerEvents(new PlayerConnectionEvents(), this);



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
