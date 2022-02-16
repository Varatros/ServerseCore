package io.github.varatros.serversecore.events.player;

import io.github.varatros.serversecore.ServerseCore;
import io.github.varatros.serversecore.util.CommandSpyHandler;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.UUID;

public class PlayerChatEvents implements Listener {

    private final CommandSpyHandler commandSpyHandler = new CommandSpyHandler();
    final TextComponent prefix = Component.text().content("[").color(NamedTextColor.DARK_GRAY)
            .append(Component.text(">").color(NamedTextColor.DARK_RED))
            .append(Component.text("] ").color(NamedTextColor.DARK_GRAY)).build();


    @EventHandler
    private void playerCommandEvent(PlayerCommandPreprocessEvent event) {
        for (UUID playerUUID : commandSpyHandler.getSpying()) {
            Player player = Bukkit.getPlayer(playerUUID);
                if (player != null && !event.getPlayer().hasPermission("serverse.staff")) {
                    TextComponent commandSpyMessage = Component.text().append(prefix)
                            .append(Component.text(event.getPlayer().getName()).color(NamedTextColor.GRAY))
                            .append(Component.text(": ").color(NamedTextColor.DARK_GRAY))
                            .append(Component.text(event.getMessage()).color(NamedTextColor.RED))
                            .build();
                    player.sendMessage(commandSpyMessage);
                    //Will probably have to make custom message depending on how color codes work.
                    //Also need to figure out how to get Bungee Server.
                    ServerseCore.CMD_LOG_CHANNEL.ifPresent(textChannel -> textChannel.sendMessage(commandSpyMessage.content()));
            }
        }
    }

}
