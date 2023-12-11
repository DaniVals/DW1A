package com.videosboy.hardmode;

import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Vida {
  //constructor (usar metodos estaticos no funciona)
  public Vida() {}

  //metodos de vida maxima
  public double getVM(Player atacado){
    return atacado.getMaxHealth();
  }
  public void setVM(Player atacado, double cantidad){
    atacado.setMaxHealth(cantidad);
    this.nameColor(atacado);
  }
  public void changeVM(Player atacado, double cantidad){
    atacado.setMaxHealth(atacado.getMaxHealth()+cantidad);
    this.nameColor(atacado);
  }
  
  public void nameColor(Player atacado){
    //barra completa o mas
    if (atacado.getMaxHealth()>=20) { 
      atacado.setPlayerListName(ChatColor.GREEN+atacado.getName()+ChatColor.WHITE);
      atacado.setDisplayName(ChatColor.GREEN+atacado.getName()+ChatColor.WHITE);
      
      //peligro
    }else if (20>atacado.getMaxHealth()&&atacado.getMaxHealth()>=10) {
      atacado.setPlayerListName(ChatColor.YELLOW+atacado.getName()+ChatColor.WHITE);
      atacado.setDisplayName(ChatColor.YELLOW+atacado.getName()+ChatColor.WHITE);
      
      //media barra
    }else if (10>atacado.getMaxHealth()) {
      atacado.setPlayerListName(ChatColor.RED+atacado.getName()+ChatColor.WHITE);
      atacado.setDisplayName(ChatColor.RED+atacado.getName()+ChatColor.WHITE);
      
      //default gris
    }else{
      atacado.setPlayerListName(ChatColor.GRAY+atacado.getName()+ChatColor.WHITE);
      atacado.setDisplayName(ChatColor.GRAY+atacado.getName()+ChatColor.WHITE);
    }
  }
}
