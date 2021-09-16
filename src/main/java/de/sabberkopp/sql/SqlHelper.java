package de.sabberkopp.sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SqlHelper {
    private static String host = "localhost";
    private static int port = 3306;
    private static String database = "factions";
    private static String username = "root";
    private static String password = "";
    private static Connection connection;

    public static HashMap<String,String> getallChunk(){
        try {
            if(connection==null){
                connect();
            }
            PreparedStatement statement = connection.prepareStatement("SELECT name,chunkids FROM factions");
            ResultSet result = statement.executeQuery();

            HashMap<String,String> hashmap = new HashMap<>();
            while(result.next()){
                System.out.println(result.getString("name"));
                System.out.println(result.getString("chunkids"));

                hashmap.put(result.getString("name"),result.getString("chunkids"));
            }
            return hashmap;

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("getchunk");
        }
        return null;
    }
    public static void addChunk(String fname, String chunkid){
      HashMap<String,String> allchunks = getallChunk();
      String chunks = allchunks.get(fname);
      if(chunks==null){
         chunks = chunkid;
      }else {
          chunks=chunks+","+chunkid;
      }
      sendSpl("UPDATE `factions` SET `chunkids` = '"+chunks+"' WHERE `factions`.`name` = '"+fname+"'");
    }
    public static void insertInToTable(String table,String name, String desc, String leader, int power, String players, String chunkids){
      sendSpl("INSERT INTO "+table +" (`id`, `name`, `desc`, `leader`, `power`, `players`, `chunkids`) VALUES ("+null+", '"+name+"', '"+desc+"', '"+leader+"', '"+power+"', '"+players+"', '"+chunkids+"');");
    }
    public static void creatTable(String table){
      sendSpl("CREATE TABLE IF NOT EXISTS `factions`."+table);
    }
    public static void sendSpl(String cmd){
        try {
            if(connection==null){
                connect();
            }
            PreparedStatement create = connection.prepareStatement(cmd);
            create.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("complete");
        }
    }
    public static void connect() throws ClassNotFoundException {
        if(!isConnected()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/"+ database + "?autoReconnect=true", username, password);
                System.out.println("MySQL connected");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private static boolean isConnected() {
        return connection != null;
    }
    public Connection getConnection() {
        return connection;
    }
}
