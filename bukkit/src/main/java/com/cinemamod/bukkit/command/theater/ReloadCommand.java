package com.cinemamod.bukkit.command.theater;

import com.cinemamod.bukkit.CinemaModPlugin;

import net.md_5.bungee.api.ChatColor;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadCommand implements CommandExecutor {

    private CinemaModPlugin cinemaModPlugin;

    public ReloadCommand(CinemaModPlugin cinemaModPlugin) {
        this.cinemaModPlugin = cinemaModPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("cinemamod.admin")) {
            sender.sendMessage(ChatColor.RED + "You don't have enough permissions");
            return false;
        }

        cinemaModPlugin.reloadConfig();
        cinemaModPlugin.getTheaterManager().clear();
        cinemaModPlugin
                .getTheaterManager()
                .loadFromConfig(cinemaModPlugin.getConfig().getConfigurationSection("theaters"));

        sender.sendMessage(ChatColor.GREEN + "Reloaded CinemaMod");
        return true;
    }
}
