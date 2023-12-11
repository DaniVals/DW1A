package com.videosboy.hardmode;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

/*
 * hardmode java plugin
 */
public class Plugin extends JavaPlugin
{
  private static final Logger LOGGER=Logger.getLogger("videosboy's hardmode");
  private static Plugin plugin;
  public static Plugin getPlugin() {
    return plugin;}

  //avisar de que se ha cargado el plugin y registrar los comandos y los eventos
  public void onEnable(){
    LOGGER.info("plugin activado oleeee");
    plugin = this;

    //añadir comandos
    this.getCommand("vida").setExecutor(new Comando());
    this.getCommand("vida").setTabCompleter(new TabComplete());
    this.getCommand("hard").setExecutor(new Comando());
    this.getCommand("hard").setTabCompleter(new TabComplete());

    //añadir eventos
    registerEvents(this, 
      new EventoClickDerecho(),
      new EventoCrafteo(),
      new EventoDano(), 
      new EventoMobSpawn(),
      new EventoMovimientoJugador(), 
      new EventoMuerte(),  
      new EventoPlayerJoin()
    );
      
    //crafteos
    ShapedRecipe crafteo;
    crafteo = new ShapedRecipe(NamespacedKey.minecraft("vida_botas_de_velocidad"), CustomItem.createItem("botas_de_velocidad"));
    crafteo.shape("CCC","CBC","CCC");
    crafteo.setIngredient('C', CustomItem.createItem("cuero_de_velocidad").getData());
    crafteo.setIngredient('B', Material.LEATHER_BOOTS);
    Bukkit.getServer().addRecipe(crafteo);

    //config
    CustomConfig.setup();
    //Player
    CustomConfig.getter().addDefault("DamageVidaMaxLost", false);
    CustomConfig.getter().addDefault("DeathVidaMaxReset", false);
    //Zombie
    CustomConfig.getter().addDefault("SpecialZombieSpawnPercent", 0.0);

    CustomConfig.getter().addDefault("SpeedZombieSpawnWheight", 0);
    CustomConfig.getter().addDefault("SpeedZombieSpawnLevel", 0);
    CustomConfig.getter().addDefault("SpeedZombieDropPercent", 0.0);
    CustomConfig.getter().addDefault("SpeedZombieUpPercent", 0.0);
    CustomConfig.getter().addDefault("SpeedZombieDownPercent", 0.0);
    //guardar todo
    CustomConfig.getter().options().copyDefaults(true);
    CustomConfig.save();
  }

  //avisar de que se ha descargado el plugin
  public void onDisable(){
    LOGGER.info("plugin desactivado");
    plugin = null;
  }
  
  //registrar las clases que son eventos
  public static void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... listeners) {
    for (Listener listener : listeners) {
      Bukkit.getServer().getPluginManager().registerEvents(listener, plugin);
    }
  }
}
