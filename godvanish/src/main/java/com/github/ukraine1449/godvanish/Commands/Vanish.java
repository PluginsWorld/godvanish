package com.github.ukraine1449.godvanish.Commands;

import com.github.ukraine1449.godvanish.Godvanish;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Vanish implements CommandExecutor {
    Godvanish plugin;

    public Vanish(Godvanish plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if(commandSender instanceof Player){
            Player player = (Player) commandSender;
            if(player.hasPermission("godvanishplugin.vanish")){
                if(args.length > 0 ){
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(plugin.vanished.contains(target)){
                        plugin.vanished.remove(player);
                        for(Player people : Bukkit.getOnlinePlayers()){
                            people.showPlayer(plugin, target);
                        }
                        target.showPlayer(target);
                        target.sendMessage(ChatColor.GOLD + "You are now visible");
                    }else if(!plugin.vanished.contains(target)){
                        plugin.vanished.add(target);
                        for(Player people : Bukkit.getOnlinePlayers()){
                            people.hidePlayer(plugin, target);
                        }
                        target.hidePlayer(target);
                        target.sendMessage(ChatColor.GOLD + "You are now vanished");

                    }
                }else{
                    if(plugin.vanished.contains(player)){
                        plugin.vanished.remove(player);
                        for(Player people : Bukkit.getOnlinePlayers()){
                            people.showPlayer(plugin, player);
                        }
                        player.showPlayer(player);
                        player.sendMessage(ChatColor.GOLD + "You are now visible");
                    }else if(!plugin.vanished.contains(player)){
                        plugin.vanished.add(player);
                        for(Player people : Bukkit.getOnlinePlayers()){
                            people.hidePlayer(plugin, player);
                        }
                        player.hidePlayer(player);
                        player.sendMessage(ChatColor.GOLD + "You are now vanished");

                    }
                }






            }
        }

        return true;
    }
}
