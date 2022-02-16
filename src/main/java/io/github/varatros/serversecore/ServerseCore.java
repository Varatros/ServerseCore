package io.github.varatros.serversecore;

import io.github.varatros.serversecore.commands.CommandSpyCommand;
import io.github.varatros.serversecore.commands.MapCommand;
import io.github.varatros.serversecore.commands.ShrugCommand;
import io.github.varatros.serversecore.commands.TwitchCommand;
import io.github.varatros.serversecore.discord.DiscordInit;
import io.github.varatros.serversecore.events.player.PlayerChatEvents;
import io.github.varatros.serversecore.events.player.PlayerConnectionEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.javacord.api.DiscordApi;
import org.javacord.api.entity.channel.Channel;

import java.util.Objects;
import java.util.Optional;

public final class ServerseCore extends JavaPlugin {
    public static DiscordApi API;
    public static Optional<Channel> CMD_LOG_CHANNEL;

    @Override
    public void onEnable() {
        // Plugin startup logic
        //Commands
        Objects.requireNonNull(this.getCommand("commandspy")).setExecutor((new CommandSpyCommand()));
        Objects.requireNonNull(this.getCommand("map")).setExecutor(new MapCommand());
        Objects.requireNonNull(this.getCommand("shrug")).setExecutor(new ShrugCommand());
        Objects.requireNonNull(this.getCommand("twitch")).setExecutor(new TwitchCommand());

        //Listeners
        Bukkit.getPluginManager().registerEvents(new PlayerChatEvents(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerConnectionEvents(), this);

        API = DiscordInit.init("token goes here");
        CMD_LOG_CHANNEL = API.getChannelById("channel id goes here");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
