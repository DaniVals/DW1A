package com.videosboy.hardmode;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.*;

public class CustomItem {
    public static ItemStack createItem(String opcion){
        //crear variables genericas
        ItemStack item;
        Color color;
        List<String> lore = new ArrayList<>();
        PotionMeta pocionMeta;
        LeatherArmorMeta armaduraMeta;
        Damageable danableMeta;
        ItemMeta itemMeta;

        switch (opcion) {
            case "pocion_de_generacion":
            
                //establecer las variables especificas
                item = new ItemStack(Material.POTION);
                pocionMeta = (PotionMeta) item.getItemMeta();
                color=Color.fromBGR(185, 0, 255);
            
                //crear los metadatos
                pocionMeta.setDisplayName("pocion de generacion");
                pocionMeta.setColor(color);
                lore.add("Pocion que recupera un contenedor de corazon");
                lore.add("Click derecho para usar");
                pocionMeta.setLore(lore);
                pocionMeta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                
                //aplicar y devolver el objeto
                item.setItemMeta(pocionMeta);
            return item;
            case "botas_de_velocidad":
            
                //establecer las variables especificas
                item = new ItemStack(Material.LEATHER_BOOTS);
                armaduraMeta = (LeatherArmorMeta) item.getItemMeta();
                danableMeta = (Damageable) item.getItemMeta();
                color=Color.fromBGR(0, 0, 255);
            
                //crear los metadatos
                armaduraMeta.setDisplayName("botas de velocidad");
                armaduraMeta.setColor(color);
                lore.add("Botas que dan velocidad 1 a quien las use");
                lore.add("Solo se aplica mientras andas");
                armaduraMeta.setLore(lore);
                armaduraMeta.setUnbreakable(false);
                danableMeta.setDamage(100);


                //aplicar y devolver el objeto
                item.setItemMeta(armaduraMeta);
            return item;
            case "cuero_de_velocidad":
            
                //establecer las variables especificas
                item = new ItemStack(Material.LEATHER);
                itemMeta = (ItemMeta) item.getItemMeta();
            
                //crear los metadatos
                itemMeta.setDisplayName("cuero de velocidad");
                lore.add("Cuero que aporta velocidad al usuario");
                lore.add("Juntalo con unas botas para usarlo");
                itemMeta.setLore(lore);
                
                //aplicar y devolver el objeto
                item.setItemMeta(itemMeta);
            return item;
            default:

                //crear las variables
                item = new ItemStack(Material.BARRIER);
                itemMeta = (ItemMeta) item.getItemMeta();
                
                //crear los metadatos
                itemMeta.setDisplayName("ERROR");
                lore.add("Si estas viendo esto es que has creado un objeto con un nombre inexistente");
                lore.add("Click derecho para usar");
                itemMeta.setLore(lore);
                    
                //aplicar y devolver el objeto
                item.setItemMeta(itemMeta);
            return item;
        }
    }
    public static void giveItem(Player p, String opcion) {
        p.getInventory().addItem(createItem(opcion));
    }
}
