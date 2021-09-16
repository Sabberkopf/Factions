package de.sabberkopp;

import de.sabberkopp.classe.Chunk;
import de.sabberkopp.classe.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TempDB {
    public static HashMap<String, List<Chunk>> claimedchunks = new HashMap<>();
    public static HashMap<String, Player> allplayers = new HashMap<>();

    public static void addChunk(String key,Chunk c){
        System.out.println(key+"/"+c.owedby);
        if(claimedchunks.containsKey(key)){
           List<Chunk> chunks = claimedchunks.get(key);
           chunks.add(c);
           claimedchunks.put(key,chunks);
        }else {
            List<Chunk> chunks = new ArrayList<>();
            chunks.add(c);
            claimedchunks.put(key,chunks);
        }

    }
}

