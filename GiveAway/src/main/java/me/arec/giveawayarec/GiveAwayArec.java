package me.arec.giveawayarec;

import Commands.CommandCekilis;
import org.bukkit.plugin.java.JavaPlugin;

public final class GiveAwayArec extends JavaPlugin {

    @Override
    public void onEnable() {
getLogger().info("GiveAway is Active!");
new CommandCekilis(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
