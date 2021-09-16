package de.sabberkopp;

import de.sabberkopp.cmd.FClaimCmd;
import de.sabberkopp.cmd.FCreateCmd;
import de.sabberkopp.helper.ChunkHelper;
import de.sabberkopp.sql.SqlHelper;
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
        SqlHelper.creatTable("`factions` ( `id` INT NOT NULL AUTO_INCREMENT , `name` VARCHAR(300) NOT NULL , `desc` TEXT NULL , `leader` VARCHAR(100) NOT NULL , `power` INT NULL , `players` TEXT NOT NULL , `chunkids` TEXT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;");
        SqlHelper.creatTable("`claimedchunks` ( `id` INT NOT NULL , `chunkid` VARCHAR(100) NOT NULL , `ownedby` VARCHAR(300) NOT NULL ) ENGINE = InnoDB;");
        getCommand("fcreate").setExecutor(new FCreateCmd());
        getCommand("fclaim").setExecutor(new FClaimCmd());
        Bukkit.getPluginManager().registerEvents(new ChunkHelper(),this);
        ChunkHelper.playerChunk();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
