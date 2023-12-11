package com.videosboy.hardmode;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import net.md_5.bungee.api.ChatColor;

public class EventoMuerte implements Listener
{
  Vida vida=new Vida();
  //private static final Logger LOGGER=Logger.getLogger("videosboy's hardmode");
  
  @EventHandler
  public void onEntityDeath(EntityDeathEvent event){
    LivingEntity entidad= (LivingEntity) event.getEntity();

    //cuando muere un jugador
    if (entidad instanceof Player){
      //reiniciar vida maxima al morir
      if (CustomConfig.getter().get("DeathVidaMaxReset").toString().compareTo("true")==0) {
        vida.setVM((Player)event.getEntity(), 20);
        return;
      }
    }
    //cuando muere un zombie
    if (entidad instanceof Zombie) {
      Zombie zombie = (Zombie) entidad;

      //zombie de velocidad
      try {
        if (zombie.getCustomName().compareTo((ChatColor.RED+"zombie veloz"))==0) {
          if (Math.random()<Double.parseDouble(CustomConfig.getter().get("SpeedZombieDropPercent").toString())) {
            zombie.getWorld().dropItemNaturally(zombie.getLocation(), CustomItem.createItem("cuero_de_velocidad"));
          }
          return;
        }      
      } catch (NullPointerException e) {
      }
    }
  }
}
