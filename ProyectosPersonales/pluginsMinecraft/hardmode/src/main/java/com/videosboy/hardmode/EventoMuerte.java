package com.videosboy.hardmode;

import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

//cuando un jugador muere
public class EventoMuerte implements Listener
{
  private static final Logger LOGGER=Logger.getLogger("prueba");

  @EventHandler
  public void onEntityDeath(EntityDeathEvent event){
    if (event.getEntity() instanceof Player){
      Player atacado=(Player)event.getEntity();
      LOGGER.info("ha muerto el jugador:"+atacado);
      atacado.setMaxHealth(20);
    }
  }
}
