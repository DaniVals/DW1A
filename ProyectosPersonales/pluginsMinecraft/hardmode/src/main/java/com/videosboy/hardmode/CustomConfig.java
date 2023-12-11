package com.videosboy.hardmode;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class CustomConfig
{
    private static File file;
    private static FileConfiguration customConfig;

    //busca si existe el archivo, y si no lo crea
    public static void setup(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("hardmode").getDataFolder(), "hardmodeConfig.yml");
        if (!file.exists()) {
            try{
                file.createNewFile();
            }catch(IOException e){
            }
        }
        load();
    }

    //getter custom file
    public static FileConfiguration getter() {
        return customConfig;
    }

    //save el archivo
    public static void save(){
        try{
            customConfig.save(file);
        }catch(IOException e){
        }
    }

    //cargar el archivo
    public static void load(){
        customConfig = YamlConfiguration.loadConfiguration(file);
    }
    
    //guardar el archivo y volverlo a cargar
    public static void refresh(){
        save();
        load();
    }
}
