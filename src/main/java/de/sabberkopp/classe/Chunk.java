package de.sabberkopp.classe;

import java.util.HashMap;
import java.util.logging.Handler;

public class Chunk {
    public String id;
    public double x;
    public double z;
    public String owedby;
    public Chunk(String id, int x, int z) {
        this.id = id;
        this.x = x;
        this.z = z;
    }

    public String getOwedby() {
        return owedby;
    }

    public void setOwedby(String owedby) {
        this.owedby = owedby;
    }
}
