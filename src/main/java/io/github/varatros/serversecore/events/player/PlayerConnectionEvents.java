package io.github.varatros.serversecore.events.player;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import javax.naming.Name;

public class PlayerConnectionEvents implements Listener {

    final TextComponent joinPrefix = Component.text().content("[").color(NamedTextColor.GOLD)
            .append(Component.text("→").color(NamedTextColor.GREEN))
            .append(Component.text("] ").color(NamedTextColor.GOLD)).build();
    final TextComponent quitPrefix = Component.text().content("[").color(NamedTextColor.GOLD)
            .append(Component.text("←").color(NamedTextColor.RED))
            .append(Component.text("] ").color(NamedTextColor.GOLD)).build();
    @EventHandler
    private void playerJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPlayedBefore()) {
            TextComponent welcomeMessage = Component.text().append(joinPrefix)
                    .append(Component.text("Welcome ").color(NamedTextColor.GOLD))
                    .append(Component.text(player.getName()).color(NamedTextColor.AQUA))
                    .append(Component.text(" to the server for the very first time!")
                            .color(NamedTextColor.GOLD))
                    .build();
            Bukkit.broadcast(welcomeMessage);
            //Setup warp to spawn if needed.
            return;
        }
        TextComponent joinMessage = Component.text().append(joinPrefix)
                .append(Component.text(player.getName()).color(NamedTextColor.GOLD))
                .append(Component.text(" joined this world.").color(NamedTextColor.GOLD))
                .build();
        Bukkit.broadcast(joinMessage);
    }

    @EventHandler
    private void playerQuitEvent(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        TextComponent quitMessage = Component.text().append(quitPrefix)
                .append(Component.text(player.getName()).color(NamedTextColor.GOLD))
                .append(Component.text(" joined this world.").color(NamedTextColor.GOLD))
                .build();
        Bukkit.broadcast(quitMessage);
    }

}
