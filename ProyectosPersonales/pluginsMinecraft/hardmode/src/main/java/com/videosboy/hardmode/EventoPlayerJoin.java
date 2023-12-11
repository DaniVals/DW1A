package com.videosboy.hardmode;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventoPlayerJoin implements Listener
{
    Vida vida=new Vida();

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        vida.changeVM(event.getPlayer(), 0);
    }
}
