package com.github.ukraine1449.godvanishplugin;

import com.github.ukraine1449.godvanishplugin.commands.Vanish;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Godvanishplugin extends JavaPlugin {
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
