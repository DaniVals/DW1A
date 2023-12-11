package com.videosboy.hardmode;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class EventoDano implements Listener
{
  //private static final Logger LOGGER=Logger.getLogger("videosboy's hardmode");
  
  @EventHandler
  public void onEntityDamage(EntityDamageEvent evento) {
    //eventos del jugador en cualquier tipo de daño
    if (evento.getEntity() instanceof Player){
      
      //perder vida maxima al recibir daño
      if (CustomConfig.getter().get("DamageVidaMaxLost").toString().compareTo("true")==0) {
        Vida vida=new Vida();
        Player victima=(Player)evento.getEntity();
        vida.changeVM(victima, -evento.getDamage());
        evento.setDamage(0);
      }
    }
  }
}
