package de.sabberkopp.helper;


import org.bukkit.entity.Player;

public class MessageHelper {

    public static void setTitle(Player p, String title,String subtitle){
        p.sendTitle(title,subtitle);
    }
}
