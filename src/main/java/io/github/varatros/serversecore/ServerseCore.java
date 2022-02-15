package io.github.varatros.serversecore;

import io.github.varatros.serversecore.commands.CommandSpyCommand;
import io.github.varatros.serversecore.commands.MapCommand;
import io.github.varatros.serversecore.commands.ShrugCommand;
import io.github.varatros.serversecore.commands.TwitchCommand;
import io.github.varatros.serversecore.events.player.PlayerConnectionEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class ServerseCore extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        //Commands
        Objects.requireNonNull(this.getCommand("map")).setExecutor(new MapCommand());
        Objects.requireNonNull(this.getCommand("twitch")).setExecutor(new TwitchCommand());
        Objects.requireNonNull(this.getCommand("shrug")).setExecutor(new ShrugCommand());
        Objects.requireNonNull(this.getCommand("commandspy")).setExecutor((new CommandSpyCommand()));

        //Listeners
        Bukkit.getPluginManager().registerEvents(new PlayerConnectionEvents(), this);



    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
