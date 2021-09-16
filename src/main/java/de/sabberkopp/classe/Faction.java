package de.sabberkopp.classe;

import java.util.HashMap;
import java.util.List;

public class Faction {
    private String name;
    private String desc;
    private String leader;
    private List<Player> players;
    private List<Chunk> claimedChunks;
    private int power;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Chunk> getClaimedChunks() {
        return claimedChunks;
    }

    public void setClaimedChunks(List<Chunk> claimedChunks) {
        this.claimedChunks = claimedChunks;
    }

    public void addClaimedChunk(Chunk chunk){
        this.claimedChunks.add(chunk);
    }


    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }
}
