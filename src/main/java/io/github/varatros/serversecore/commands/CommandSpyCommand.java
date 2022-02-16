package io.github.varatros.serversecore.commands;

import io.github.varatros.serversecore.ServerseCore;
import io.github.varatros.serversecore.util.CommandSpyHandler;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CommandSpyCommand implements CommandExecutor {

    private final CommandSpyHandler commandSpyHandler = new CommandSpyHandler();

    final TextComponent prefix = Component.text().content("[").color(NamedTextColor.DARK_GRAY)
            .append(Component.text(">").color(NamedTextColor.DARK_RED))
            .append(Component.text("] ").color(NamedTextColor.DARK_GRAY)).build();
    final TextComponent message = Component.text()
            .append(prefix)
            .append(Component.text("CommandSPY has been turned ").color(NamedTextColor.GRAY))
            .build();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) return false;
        boolean toggleIsSpying = commandSpyHandler.toggleIsSpying(player.getUniqueId());
        TextComponent mode;
        if (toggleIsSpying) {
            mode = Component.text("on").color(NamedTextColor.GREEN);
        } else {
            mode = Component.text("off").color(NamedTextColor.RED);
        }

        TextComponent finalMessage = Component.text().append(message)
                .append(Component.text().append(mode))
                .append(Component.text(".").color(NamedTextColor.GRAY))
                .build();

        player.sendMessage(finalMessage);

        ServerseCore.CMD_LOG_CHANNEL.ifPresent(textChannel -> textChannel.sendMessage(finalMessage.content()));

        return false;
    }
}
