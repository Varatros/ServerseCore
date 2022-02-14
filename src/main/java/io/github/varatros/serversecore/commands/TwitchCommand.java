package io.github.varatros.serversecore.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class TwitchCommand implements CommandExecutor {
    final TextComponent prefix = Component.text().content("[").color(NamedTextColor.GOLD)
            .append(net.kyori.adventure.text.Component.text(">").color(NamedTextColor.AQUA))
            .append(Component.text("] ").color(NamedTextColor.GOLD)).build();
    final TextComponent suffix = Component.text().content("[").color(NamedTextColor.GOLD)
            .append(net.kyori.adventure.text.Component.text("<").color(NamedTextColor.AQUA))
            .append(Component.text("] ").color(NamedTextColor.GOLD)).build();
    final TextComponent twitchMessage = Component.text().append(prefix)
            .append(Component.text("Below you can find links to all of our twitch friends!")
                    .color(NamedTextColor.GOLD))
            .append(Component.text().append(suffix))
            .append(Component.text("\n• PsycheSiren - ").color(NamedTextColor.GOLD)
                    .append(Component.text("https://twitch.tv/psychesiren").color(NamedTextColor.AQUA)
                            .clickEvent(ClickEvent.openUrl("https://twitch.tv/psychesiren"))))
            .append(Component.text("\n• FunkFrog - ").color(NamedTextColor.GOLD)
                    .append(Component.text("https://twitch.tv/funkfrog_").color(NamedTextColor.AQUA)
                            .clickEvent(ClickEvent.openUrl("https://twitch.tv/funkfrog_"))))
            .append(Component.text("\n").append(prefix))
            .append(Component.text(" ------------------------------------ ").color(NamedTextColor.GOLD))
            .append(Component.text().append(suffix))
            .build();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        sender.sendMessage(twitchMessage);
        return false;
    }
}
