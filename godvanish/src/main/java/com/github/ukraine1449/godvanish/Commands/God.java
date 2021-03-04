package com.github.ukraine1449.godvanish.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class God implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            if(player.hasPermission("godvanishplugin.god")) {
                if(args.length > 0 ){
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target.isInvulnerable()){
                        target.setInvulnerable(false);
                        String td = target.getDisplayName();
                        player.sendMessage(ChatColor.GOLD + "You have now made " + ChatColor.AQUA + td + ChatColor.GOLD + " vulnerable");
                        target.sendMessage(ChatColor.GOLD + "You are now vulnerable");
                    }else{
                        target.setInvulnerable(true);
                        String td = target.getDisplayName();
                        player.sendMessage(ChatColor.GOLD + "You have now made " + ChatColor.AQUA + td + ChatColor.GOLD + " invulnerable");
                        target.sendMessage(ChatColor.GOLD + "You are now invulnerable");
                    }
                }else {
                    if(player.isInvulnerable()){
                        player.setInvulnerable(false);
                        player.sendMessage(ChatColor.GOLD + "You are now vulnerable");
                    }else{
                        player.setInvulnerable(true);
                        player.sendMessage(ChatColor.GOLD + "You are now invulnerable");
                    }
                }

            }else {
                player.sendMessage(ChatColor.GOLD + "You do not have the required permission (godvanishplugin.god)");
            }
        }else{
            System.out.println("Please be a player to do this command");
        }

        return true;
    }
}
