package com.github.ukraine1449.godvanish.Events;

import com.github.ukraine1449.godvanish.Godvanish;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {
    Godvanish plugin;

    public PlayerJoin(Godvanish plugin) {
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
