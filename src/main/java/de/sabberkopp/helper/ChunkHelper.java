package de.sabberkopp.helper;


import de.sabberkopp.Main;
import de.sabberkopp.TempDB;
import de.sabberkopp.classe.Chunk;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.List;

public class ChunkHelper implements Listener {
    private static HashMap<String,String> oldmessage = new HashMap<>();
    public static void playerChunk(){
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(Main.getMain(), new Runnable() {
            public void run(){
                for (Player p: Bukkit.getOnlinePlayers()) {
                  String chunkId = getChunkId(p.getLocation());
                    System.out.println(chunkId);
                  if(TempDB.claimedchunks.containsKey(chunkId)) {
                      List<Chunk> c = TempDB.claimedchunks.get(chunkId);
                      for (int i = 0; i < c.size(); i++) {
                          if (oldmessage.containsKey(p.getName())) {
                              if (c.get(i).owedby == oldmessage.get(p.getName())) {
                                  continue;
                              } else {
                                  oldmessage.put(p.getName(), c.get(i).owedby);
                                  MessageHelper.setTitle(p, c.get(i).getOwedby(), null);
                              }

                          } else {
                              oldmessage.put(p.getName(), c.get(i).owedby);
                              MessageHelper.setTitle(p, c.get(i).getOwedby(), null);
                          }
                      }
                  }else if (oldmessage.containsKey(p.getName())){
                      if("Wilderness"==oldmessage.get(p.getName())){
                          continue;
                      }else {
                          oldmessage.put(p.getName(),"Wilderness");
                          MessageHelper.setTitle(p,"Wilderness",null);
                      }

                  }else {
                      oldmessage.put(p.getName(),"Wilderness");
                      MessageHelper.setTitle(p,"Wilderness",null);
                  }


                }
            }

        }, 100, 20);
    }



    public static Chunk getChunk(Location loc){
        double z = getZ(loc);
        double x = getX(loc);
        return new Chunk(String.valueOf((int)z)+":"+String.valueOf((int)x),(int) z,(int) x);


    }
    public static String getChunkId(Location loc){
        double z = getZ(loc);
        double x = getX(loc);
        return String.valueOf((int)z)+":"+String.valueOf((int)x);


    }
    private static double getZ(Location loc){
        double z;
        if(loc.getZ()/16<0){
            z = loc.getZ()/16-1;
        }else
            z = loc.getZ()/16;
        return z;

    }
    private static double getX(Location loc){
        double x;
        if(loc.getX()/16<0){
            x = loc.getX()/16-1;
        }else
            x = loc.getX()/16;
        return x;

    }

}
