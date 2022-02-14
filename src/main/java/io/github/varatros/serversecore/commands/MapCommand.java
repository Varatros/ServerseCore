package io.github.varatros.serversecore.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class MapCommand implements CommandExecutor {
    final TextComponent prefix = Component.text().content("[").color(NamedTextColor.GOLD)
            .append(Component.text(">").color(NamedTextColor.AQUA))
            .append(Component.text("] ").color(NamedTextColor.GOLD)).build();
    final TextComponent mapMessage = Component.text().append(prefix)
            .append(Component.text("The dynmap address is ").color(NamedTextColor.GOLD))
            .append(Component.text("https://map.serverse.xyz").color(NamedTextColor.AQUA)
                    .clickEvent(ClickEvent.openUrl("https://map.serverse.xyz")))
            .append(Component.text("\n").append(prefix))
            .append(Component.text("You can also use ").color(NamedTextColor.GOLD))
            .append(Component.text("/dynmap webregister ").color(NamedTextColor.AQUA)
                    .hoverEvent(HoverEvent.showText(Component.text("Click Me!").color(NamedTextColor.AQUA)))
                    .clickEvent(ClickEvent.suggestCommand("/dynmap webregister")))
            .append(Component.text("to unlock additional features on the map!").color(NamedTextColor.GOLD))
            .build();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        sender.sendMessage(mapMessage);
        return false;
    }
}
