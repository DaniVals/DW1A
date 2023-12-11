package com.videosboy.hardmode;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.inventory.ItemStack;

//cuando se detecta un craftep
public class EventoCrafteo implements Listener
{
    //private static final Logger LOGGER=Logger.getLogger("videosboy's hardmode");

    @EventHandler
    public void onCrafteoDetected(PrepareItemCraftEvent event){
        try{
            if (event.getRecipe().getResult().getItemMeta().getLore().toString().compareTo(
                "[Botas que dan velocidad 1 a quien las use, Solo se aplica mientras andas]")==0) {
                int fallos=-1; 
                for(int i=0;i<10;i++){
                    try{
                        event.getInventory().getItem(i).getItemMeta().getLore().toString();
                    } catch (NullPointerException error) {
                        fallos++;
                    }
                }
                if (0<fallos) {
                    event.getViewers().get(0).sendMessage("la receta debera ser hecha con cuero de velocidad");
                    event.getInventory().setItem(0, new ItemStack(Material.AIR));
                }

            }
        } catch (NullPointerException error) {
            return;
        }
        
    }
}
