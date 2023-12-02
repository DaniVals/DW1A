package com.ejemplo.prueba;

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

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    //por defecto pone al sender como victima
    Player victima=(Player)sender;
      
    if (label.equalsIgnoreCase("vida")) {
      //bloquea el acceso si no eres OP
      if (!sender.isOp()) {
        sender.sendMessage(ChatColor.RED + "no tienes permisos para usar este plugin");
        return false;
      }
      if (args.length > 0) {
        //comando check
        if (args[0].equals("check")) {
          if (args.length<=6) {//en caso de que no pongas nada te pone la tuya
            sender.sendMessage(ChatColor.GREEN + "Tu vida maxima es: " + victima.getMaxHealth());
          }else if (Bukkit.getPlayerExact(args[5])!=null) {
            victima=(Player) Bukkit.getPlayerExact(args[5]);
            sender.sendMessage(ChatColor.GREEN + "La vida vida maxima de "+victima.getName()+" es "+victima.getMaxHealth());
          }else{
            sender.sendMessage(ChatColor.RED + "Jugador no encontrado");
          }
        }
        return true;
      }
      sender.sendMessage(ChatColor.RED + "algo has hecho mal xd");
    }
    sender.sendMessage(ChatColor.RED + "algo has hecho mal xddddd");
    return false;
  }
}
  
