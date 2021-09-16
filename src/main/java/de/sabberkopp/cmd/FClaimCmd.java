package de.sabberkopp.cmd;

import de.sabberkopp.TempDB;
import de.sabberkopp.classe.Chunk;

import de.sabberkopp.helper.ChunkHelper;
import de.sabberkopp.sql.SqlHelper;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FClaimCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        System.out.println("hi");
        if(sender instanceof Player){
            Player p = (Player) sender;
            Chunk chunk = ChunkHelper.getChunk(p.getLocation());
            SqlHelper.addChunk(args[0],chunk.id);

            p.sendMessage("Chunk claimed");

        }

        return false;
    }
}
