package com.videosboy.hardmode;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import net.md_5.bungee.api.ChatColor;

//cuando spawnea un mob
public class EventoMobSpawn implements Listener
{
    //private static final Logger LOGGER=Logger.getLogger("videosboy's hardmode");

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event){
        Entity mob = (Entity) event.getEntity();
        //LOGGER.info("ha spawneado la entidad "+event.getEntity());

        //en caso de que sea un zombie
        if (mob instanceof Zombie) {
            //zombie especial?
            if (Math.random()<Double.parseDouble(CustomConfig.getter().get("SpecialZombieSpawnPercent").toString())) {
                Zombie zombie = (Zombie) mob;
            
                int pesoTotal = 0, //suma todos los pesos para crear un aleatorio del que se saca que tipo de zombie sera
                pesoActual=0; //va sumando los tipos de zombie de 1 en 1 segun los va comparando, y elige el tipo de zombie cuando este valor es alcanzado

                //sumar todo a peso total y crear el aleatorio
                pesoTotal+= Integer.parseInt(CustomConfig.getter().get("SpeedZombieSpawnWheight").toString());
                double aleatorio = pesoTotal*Math.random();


                //zombie de velocidad
                pesoActual+= Integer.parseInt(CustomConfig.getter().get("SpeedZombieSpawnWheight").toString());
                if (aleatorio<pesoActual) {
                    zombie.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, Integer.MAX_VALUE, 
                    Integer.parseInt(CustomConfig.getter().get("SpeedZombieSpawnLevel").toString()), false, false));
    
                    zombie.getEquipment().setBoots(CustomItem.createItem("botas_de_velocidad"));
                    zombie.getEquipment().setBootsDropChance(0);
                    mob.setCustomName(ChatColor.RED+"zombie veloz");
                    mob.setCustomNameVisible(true);
                    return;
                }
            }
        }
    }
}