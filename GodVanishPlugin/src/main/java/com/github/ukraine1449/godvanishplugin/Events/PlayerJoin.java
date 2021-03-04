package com.github.ukraine1449.godvanishplugin.Events;

import com.github.ukraine1449.godvanishplugin.Godvanishplugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
Godvanishplugin plugin;

    public PlayerJoin(Godvanishplugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        for(int i = 0; i < plugin.vanished.size(); i++){
            player.hidePlayer(plugin, plugin.vanished.get(i));
            player.hidePlayer(player);
        }
    }

}
