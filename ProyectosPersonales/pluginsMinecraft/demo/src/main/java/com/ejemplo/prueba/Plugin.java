package com.ejemplo.prueba;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameRule;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Event;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Entity.Spigot;
import org.bukkit.attribute.Attribute;

/*
 * demo java plugin
 */
public class Plugin extends JavaPlugin
{
  private static final Logger LOGGER=Logger.getLogger("prueba");

  public void onEnable()
  {
    LOGGER.info("plugin activado SIUUUU");
  }

  public void onDisable()
  {
    LOGGER.info("plugin desactivado por pollo");
  }

  //mostrar opciones de comandos
  @Override
  public List<String> onTabComplete(CommandSender sender, Command command, String nombreComando, String[] args){
    ArrayList<String> list = new ArrayList<>(); 
    
    //comprobar que estamos en el comando de "vida"
    if (nombreComando.compareTo("vida")==0) {
  
      if(args.length == 1){ 
        if (sender.isOp()) {
          list.add("check");
          list.add("refresh");
        }
        list.add("change");
        list.add("reset");
      }
      if(args.length == 2){
        for (Player p : Bukkit.getOnlinePlayers()) {
          list.add(p.getName());
        }
      }
    }
    return list;
  }
  //ejecutar comandos
  @Override 
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    //comprobar si es el comando "vida" para empezar
    if (label.equalsIgnoreCase("vida")) {

      //help 
      if (args[0].compareTo("help")==0) {
        sender.sendMessage(ChatColor.GREEN + "Los comandos disponibles para ti son:");
        if (sender.isOp()) { 
          //mostrar todos los comandos
          sender.sendMessage(ChatColor.GREEN + "-change: cambia la vida maxima de un jugador");
          sender.sendMessage(ChatColor.GREEN + "-reset: devuelve tu vida a la default (20)");
        }
        //mostrar los comandos que no hace falta ser OP
        sender.sendMessage(ChatColor.GREEN + "-check: muestra la vida maxima de alguien");
        sender.sendMessage(ChatColor.GREEN + "-refresh: actualiza tu hotbar");
        return true;
      }
      
      //variable jugador
      Player victima;
      if (Bukkit.getPlayerExact(args[1])!=null) {
        victima=Bukkit.getPlayerExact(args[1]);
      }else{
        victima=(Player) sender;
      }

      //change 
      if (args[0].compareTo("change")==0) {
        if (sender.isOp()) {
          if (args[1]!=null&&Bukkit.getPlayerExact(args[1])!=null) {
            if (args[2]!=null&&100>=Integer.parseInt(args[2])&&Integer.parseInt(args[2])>=-100) {
              int numero = Integer.parseInt(args[2]);
              
              victima.setMaxHealth(victima.getMaxHealth()+numero);
              sender.sendMessage(ChatColor.GREEN + "La vida maxima de "+victima.getName()+" a cambiado a "+victima.getMaxHealth());
              return true;
            }
            sender.sendMessage(ChatColor.RED + "numero fuera de rango <-100 a 100>");
            return false;
          }
          sender.sendMessage(ChatColor.RED + "jugador no encontrado");
          return false;
        }
        sender.sendMessage(ChatColor.RED + "no tienes permiso para este comando");
        return false;
      }

      //reset 
      if (args[0].compareTo("reset")==0) {
        if (sender.isOp()) {
          if (args[1]!=null&&Bukkit.getPlayerExact(args[1])!=null) {
            victima.setMaxHealth(20);
            sender.sendMessage(ChatColor.GREEN + "La vida maxima de "+victima.getName()+" ahora es "+victima.getMaxHealth());
            return true;
          }
          sender.sendMessage(ChatColor.RED + "jugador no encontrado");
          return false;
        }
        sender.sendMessage(ChatColor.RED + "no tienes permiso para este comando");
        return false;
      }
      
      //check 
      if (args[0].compareTo("check")==0) {
        if (args[1]!=null&&Bukkit.getPlayerExact(args[1])!=null) {
          sender.sendMessage(ChatColor.GREEN + "La vida maxima de "+victima.getName()+" a aumentado a "+victima.getMaxHealth());
          return true;
        }
        sender.sendMessage(ChatColor.RED + "jugador no encontrado");
        return false;
      }
      
      //refresh 
      if (args[0].compareTo("refresh")==0) {
        if (args[1]!=null&&Bukkit.getPlayerExact(args[1])!=null) {
          victima.setMaxHealth(victima.getMaxHealth());
          sender.sendMessage(ChatColor.GREEN + "Puto minecraft buggeado");
          return true;
        }
        sender.sendMessage(ChatColor.RED + "jugador no encontrado");
        return false;
      }

    //mensage default en caso de que no exista el comando introducido
    sender.sendMessage(ChatColor.RED + "no has seleccionado ningun comando");
    sender.sendMessage(ChatColor.YELLOW + "puedes ver la funcionalidad de estos con /vida help");
  }
    return false;
  }
}