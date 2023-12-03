package com.videosboy.hardmode;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

//cuando un jugador recibe daño
public class EventoDano implements Listener
{
  private static final Logger LOGGER=Logger.getLogger("AAAAAAAAAAAAAAAAAAAAAAAAAAAA");

  @EventHandler
  public void onEntityDamage(EntityDamageEvent event) {
    if (event.getEntity() instanceof Player){
      Player atacado=(Player)event.getEntity();
      LOGGER.info(atacado.getName()+" ha recibido daño");
      atacado.setMaxHealth(atacado.getHealth());
      if (atacado.getMaxHealth()>=20) {
        atacado.setPlayerListName(ChatColor.GREEN+atacado.getPlayerListName());
      LOGGER.info(atacado.getName()+" es verde");
      }else if (atacado.getMaxHealth()<=10) {
        atacado.setPlayerListName(ChatColor.RED+atacado.getPlayerListName());
      LOGGER.info(atacado.getName()+" es rojo");
      }else{
        atacado.setPlayerListName(ChatColor.YELLOW+atacado.getPlayerListName());
      LOGGER.info(atacado.getName()+" es amarillo");
      }
    }
  }
}
