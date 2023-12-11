package com.videosboy.hardmode;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

//cuando un jugador se mueve
public class EventoMovimientoJugador implements Listener
{

    @EventHandler
    public void onMovingPlayer(PlayerMoveEvent event){
        try{
            if (event.getPlayer().getInventory().getBoots().getItemMeta().getLore().toString().compareTo(
                "[Botas que dan velocidad 1 a quien las use, Solo se aplica mientras andas]")==0) {
                    event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 2, 0, false, false));
            }
        } catch (NullPointerException error) {
            return;
        }
    }
}
