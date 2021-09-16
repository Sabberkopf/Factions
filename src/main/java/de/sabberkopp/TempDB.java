package de.sabberkopp;

import de.sabberkopp.classe.Chunk;
import de.sabberkopp.classe.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TempDB {
    public static HashMap<String, List<String>> claimedchunks = new HashMap<>();
    public static HashMap<String, Player> allplayers = new HashMap<>();



    public static void addChunk(String key,String ownedby){
        System.out.println(key+"/"+ownedby);
        if(claimedchunks.containsKey(key)){
           List<String> chunks = claimedchunks.get(key);
           chunks.add(ownedby);
           claimedchunks.put(key,chunks);
        }else {
            List<String> chunks = new ArrayList<>();
            chunks.add(ownedby);
            claimedchunks.put(key,chunks);
        }

    }
}

