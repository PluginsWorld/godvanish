package com.github.ukraine1449.godvanish;

import com.github.ukraine1449.godvanish.Commands.Vanish;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Godvanish extends JavaPlugin {
    public ArrayList<Player> vanished = new ArrayList<>();

    @Override
    public void onEnable() {
        getCommand("vanish").setExecutor(new Vanish(this));


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
