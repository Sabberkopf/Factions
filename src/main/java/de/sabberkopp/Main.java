package de.sabberkopp;

import de.sabberkopp.cmd.FClaimCmd;
import de.sabberkopp.helper.ChunkHelper;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
    public static Main main;

    public static Main getMain() {
        return main;
    }

    @Override
    public void onEnable() {
        main = this;
        getCommand("fclaim").setExecutor(new FClaimCmd());
        Bukkit.getPluginManager().registerEvents(new ChunkHelper(),this);
        ChunkHelper.playerChunk();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
