package com.videosboy.hardmode;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

public class TabComplete implements TabCompleter {
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
        list.add("item");
      }
      list.add("change");
      list.add("reset");
    }
    if(args.length == 2){
      for (Player p : Bukkit.getOnlinePlayers()) {
        list.add(p.getName());
      }
    }
    if(args.length == 3){ 
      list.add("<numero>");
    }
    if(args.length == 4&&args[0].compareTo("item")==0){ 
      list.add("pocion_de_generacion");
      list.add("botas_de_velocidad");
      list.add("cuero_de_velocidad");
    }
  }

  //comprobar que estamos en el comando de "hardmode"
  if (nombreComando.compareTo("hard")==0) {
    if (sender.isOp()) {
      if(args.length == 1){ 
        list.add("wiki");
        list.add("get");
        list.add("set");
        list.add("help");
        list.add("save");
        list.add("load");
      }
    }

    //getters and setters
    if(args[0].compareTo("set")==0||args[0].compareTo("get")==0){
      if(args.length == 2){
        list.add(".");
        for(Object objeto : CustomConfig.getter().getKeys(true).toArray()){
          list.add(objeto.toString());
        }
      }
      if(args.length == 3){
        list.add("true");
        list.add("false");
        list.add("<numero>");
      }
    }

    //wiki
    if(args[0].compareTo("wiki")==0){
      if(args.length == 2){
        list.add("player");
        list.add("zombie");
      }
      if(args.length == 3){
        list.add("<pagina>");
      }
      }
    }
    return list;
  }
}
