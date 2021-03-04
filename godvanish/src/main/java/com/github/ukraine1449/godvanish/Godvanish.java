package com.github.ukraine1449.godvanish;

import com.github.ukraine1449.godvanish.Commands.God;
import com.github.ukraine1449.godvanish.Commands.Vanish;
import com.github.ukraine1449.godvanish.Events.PlayerJoin;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Godvanish extends JavaPlugin {
    public ArrayList<Player> vanished = new ArrayList<>();

    @Override
    public void onEnable() {
        getCommand("vanish").setExecutor(new Vanish(this));
        getServer().getPluginManager().registerEvents(new PlayerJoin(this), this);
        getCommand("god").setExecutor(new God());


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
