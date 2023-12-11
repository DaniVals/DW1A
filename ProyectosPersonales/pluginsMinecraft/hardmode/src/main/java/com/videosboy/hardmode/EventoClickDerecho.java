package com.videosboy.hardmode;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import net.md_5.bungee.api.ChatColor;

//cuando un jugador da click 
public class EventoClickDerecho implements Listener
{
    Vida vida=new Vida();
    //private static final Logger LOGGER=Logger.getLogger("videosboy's hardmode");

    @EventHandler
    public void onPlayerInteraction(PlayerInteractEvent event) {
        //evitar errores falsos
        try{
            Player jugador = (Player) event.getPlayer();
            ItemStack item = (ItemStack) event.getItem();
            
            if (event.getAction()==Action.RIGHT_CLICK_AIR) {
            }
            if (event.getAction()==Action.RIGHT_CLICK_BLOCK) {
            }
            if (event.getAction()==Action.LEFT_CLICK_AIR) {
            }
            if (event.getAction()==Action.LEFT_CLICK_BLOCK) {
            }

            //buscar que item es a traves de la descripcion (ehl lore)
            if (item.getItemMeta().getLore().toString().compareTo(
                "[Pocion que recupera un contenedor de corazon, Click derecho para usar]")==0){
                vida.changeVM(jugador, 2);
                jugador.setHealth(jugador.getHealth()+2);
                jugador.sendMessage(ChatColor.GREEN + "Tu vida maxima a cambiado a "+vida.getVM(jugador));
                event.getItem().setAmount(item.getAmount()-1);

            }else if (item.getItemMeta().getLore().toString().compareTo(
                "[Si estas viendo esto es que has creado un objeto con un nombre inexistente, Click derecho para usar]")==0){
                jugador.sendMessage(ChatColor.YELLOW + "Tu no has visto nada...");
                event.getItem().setAmount(item.getAmount()-1);
                event.setCancelled(true);
            }
        } catch (NullPointerException error) {
            return;
        }
    }
}
