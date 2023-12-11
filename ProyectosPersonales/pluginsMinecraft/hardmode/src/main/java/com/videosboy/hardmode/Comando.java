package com.videosboy.hardmode;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import net.md_5.bungee.api.ChatColor;

public class Comando implements CommandExecutor{

    Vida vida=new Vida();
    
    //ejecutar comandos
    @Override 
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    //comprobar si es el comando "vida"
    if (label.equalsIgnoreCase("vida")) {
        
        //help 
        if (args[0].compareTo("help")==0) {
            sender.sendMessage(ChatColor.GREEN + "Los comandos disponibles para ti son:");
            if (sender.isOp()) { 
                //mostrar todos los comandos
                sender.sendMessage(ChatColor.GREEN + "-change: cambia la vida maxima de un jugador");
                sender.sendMessage(ChatColor.GREEN + "-reset: devuelve tu vida a la default (20)");
                sender.sendMessage(ChatColor.GREEN + "-item: da un item");
            }
            //mostrar los comandos que no hace falta ser OP
            sender.sendMessage(ChatColor.GREEN + "-check: muestra la vida maxima de alguien");
            sender.sendMessage(ChatColor.GREEN + "-refresh: actualiza tu hotbar");
            return true;
        }
      
        //variable jugador
        Player victima=(Player) sender;
        if (Bukkit.getPlayerExact(args[1])!=null) {
            victima=Bukkit.getPlayerExact(args[1]);
        }else if (args[1]=="@s") {
            victima=(Player) sender;
        }else{
            sender.sendMessage(ChatColor.RED + "jugador no encontrado");
            return false;
        }
        
        //change 
        if (args[0].compareTo("change")==0) {
            if (sender.isOp()) {
                if (args[2]!=null&&100>=Integer.parseInt(args[2])&&Integer.parseInt(args[2])>=-100) {
                    int numero = Integer.parseInt(args[2]);
                    
                    vida.changeVM(victima, numero);
                    sender.sendMessage(ChatColor.GREEN + "La vida maxima de "+victima.getName()+" a cambiado a "+vida.getVM(victima));
                    return true;
                }
                sender.sendMessage(ChatColor.RED + "numero fuera de rango <-100 a 100>");
                return false;
            }
            sender.sendMessage(ChatColor.RED + "no tienes permiso para este comando");
            return false;
        }
        
        //item 
        if (args[0].compareTo("item")==0) {
            if (sender.isOp()) {
                if (args[2]!=null&&50>=Integer.parseInt(args[2])&&Integer.parseInt(args[2])>=-50) {
                    int numero = Integer.parseInt(args[2]);
                    for(int i=0;i<numero;i++){
                        CustomItem.giveItem(victima, args[3]);
                    }
                    sender.sendMessage(ChatColor.GREEN+"se han dado "+numero+" "+args[3]+" al jugador "+victima.getName());
                    return true;
                }
                sender.sendMessage(ChatColor.RED + "numero fuera de rango <-50 a 50>");
                return false;
            }
            sender.sendMessage(ChatColor.RED + "no tienes permiso para este comando");
            return false;
        }

        //reset 
        if (args[0].compareTo("reset")==0) {
            if (sender.isOp()) {
                vida.setVM(victima, 20);
                sender.sendMessage(ChatColor.GREEN + "La vida maxima de "+victima.getName()+" ahora es "+vida.getVM(victima));
                return true;
            }
            sender.sendMessage(ChatColor.RED + "no tienes permiso para este comando");
            return false;
        }
        
        //check 
        if (args[0].compareTo("check")==0) {
            sender.sendMessage(ChatColor.GREEN + "La vida maxima de "+victima.getName()+" es "+vida.getVM(victima));
            return true;
        }
        
        //refresh 
        if (args[0].compareTo("refresh")==0) {
            vida.changeVM(victima, 0);
            sender.sendMessage(ChatColor.GREEN + "Puto minecraft buggeado");
            return true;
        }
        
        //mensage default en caso de que no exista el comando introducido
        sender.sendMessage(ChatColor.RED + "no has seleccionado ningun comando");
        sender.sendMessage(ChatColor.YELLOW + "puedes ver la funcionalidad de estos con /vida help");
    }
    //comprobar si es el comando "hard"
    if (label.equalsIgnoreCase("hard")||sender.isOp()) {
        
        //help 
        if (args[0].compareTo("help")==0) {
            sender.sendMessage(ChatColor.GREEN + "Los comandos disponibles para ti son:");
            if (sender.isOp()) { 
                sender.sendMessage(ChatColor.GREEN + "-wiki: te muestra todos los ajustes de una categoria y lo que significa");
                sender.sendMessage(ChatColor.GREEN + "-get: te muestra un valor y su dato");
                sender.sendMessage(ChatColor.GREEN + "-set: asigna un valor a una configuracion");
                sender.sendMessage(ChatColor.GREEN + "-save: guarda los ajustes (esto se hace de forma automatica tambien)");
            }
            return true;
        }
        
        //wiki 
        if (args[0].compareTo("wiki")==0) {
            try{
                if (args[1].compareTo("player")==0) {
                    sender.sendMessage(ChatColor.GREEN + "       ============= vida maxima =============");
                    sender.sendMessage(ChatColor.GREEN + "");
                    sender.sendMessage(ChatColor.GREEN + "------booleans------");
                    sender.sendMessage(ChatColor.GREEN + " - DamageVidaMaxLost: al recivir daño perderas el contenedor en vez de la vida (BUG: las armaduras no pierden usos)");
                    sender.sendMessage(ChatColor.GREEN + " - DeathVidaMaxReset: al morir establece tu vida maxima a 20");
                    return true;
                }
                if (args[1].compareTo("zombie")==0) {try{
                    if (args[2].compareTo("1")==0) {
                        sender.sendMessage(ChatColor.GREEN + "       ============= Zombie general =============");
                        sender.sendMessage(ChatColor.GREEN + "");
                        sender.sendMessage(ChatColor.GREEN + "------doubles------");
                        sender.sendMessage(ChatColor.GREEN + "- SpecialZombieSpawnPercent: la probabilidad de que sustituya a un zombie normal por uno especial");
                        sender.sendMessage(ChatColor.GREEN + "");
                        sender.sendMessage(ChatColor.GREEN + "[ probabilidad de 1.0 a 0.0 ]");
                        sender.sendMessage(ChatColor.GREEN + "");
                        sender.sendMessage(ChatColor.GREEN + "<P. 1/3>");
                        return true;
                    }else
                    if (args[2].compareTo("2")==0) {
                        sender.sendMessage(ChatColor.GREEN + "       ============= Zombie de velocidad =============");
                        sender.sendMessage(ChatColor.GREEN + "");
                        sender.sendMessage(ChatColor.GREEN + "--------int--------");
                        sender.sendMessage(ChatColor.GREEN + "- SpeedZombieSpawnWheight: el peso de que un zombie especial sea un zombi veloz");
                        sender.sendMessage(ChatColor.GREEN + "- SpeedZombieSpawnLevel: el nivel base al que aparece el zombie");
                        sender.sendMessage(ChatColor.GREEN + "");
                        sender.sendMessage(ChatColor.GREEN + "------doubles------");
                        sender.sendMessage(ChatColor.GREEN + "- SpeedZombieDropPercent: la probabilidad de que un zombi veloz suelte cuero veloz");
                        sender.sendMessage(ChatColor.GREEN + "- SpeedZombieUpPercent: la probabilidad de que un zombi veloz suba un nivel (coming soon)");
                        sender.sendMessage(ChatColor.GREEN + "- SpeedZombieDownPercent: la probabilidad de que un zombi veloz baje un nivel (coming soon)");
                        sender.sendMessage(ChatColor.GREEN + "");
                        sender.sendMessage(ChatColor.GREEN + "<P. 2/3>");
                        return true;
                    }else
                    if (args[2].compareTo("3")==0) {
                        sender.sendMessage(ChatColor.GREEN + "===== Zombie de salto =====");
                        sender.sendMessage(ChatColor.GREEN + "");
                        sender.sendMessage(ChatColor.GREEN + "<P. 3/3>");
                        return true;
                    }
                    else{
                        sender.sendMessage(ChatColor.RED + "debes introducir una pagina");
                        return false;
                    }
                } catch (NullPointerException e) {
                    sender.sendMessage(ChatColor.RED + "debes introducir una pagina");
                    return false;
                } catch (IndexOutOfBoundsException e){
                    sender.sendMessage(ChatColor.RED + "pagina no existente");
                    return false;

                }}
            }catch (NullPointerException e) {
                sender.sendMessage(ChatColor.RED + "wiki no existente");
                return false;
            }
        }

        //get 
        if (args[0].compareTo("get")==0) {
            try{
                sender.sendMessage(ChatColor.GREEN +args[1].toString()
                +" = "+CustomConfig.getter().get(args[1]).toString()
                );
                return true;
            } catch (NullPointerException e) {
                sender.sendMessage(ChatColor.RED + "dato no existente");
                return false;
            }
        }
        
        //set 
        if (args[0].compareTo("set")==0) {
            try{
                //booleanos
                if ((args[2].compareTo("true")==0||args[2].compareTo("false")==0)&&(
                    args[1].compareTo("DamageVidaMaxLost")==0||
                    args[1].compareTo("DeathVidaMaxReset")==0
                    )){
                    Boolean estado;
                    if (args[2].compareTo("true")==0) {
                        estado=true;
                        sender.sendMessage(ChatColor.GREEN + args[1] + " cambiado a true");
                    }else{
                        estado=false;
                        sender.sendMessage(ChatColor.GREEN + args[1] + " cambiado a false");
                    }

                    CustomConfig.getter().set(args[1].toString(), estado);
                    CustomConfig.refresh();
                    return true;
                }

                //doubles
                try {
                    if (args[1].compareTo("SpecialZombieSpawnPercent")==0||
                        args[1].compareTo("SpeedZombieDropPercent")==0||
                        args[1].compareTo("SpeedZombieUpPercent")==0||
                        args[1].compareTo("SpeedZombieDownPercent")==0
                        ){
                            double nuevo = Double.parseDouble(args[2]);
                            if (nuevo<0||1<nuevo) {
                                sender.sendMessage(ChatColor.RED + "numero fuera de rango (1.0 a 0.0)");
                                return false;
                            }
                            
                        CustomConfig.getter().set(args[1].toString(), nuevo);
                        sender.sendMessage(ChatColor.GREEN + args[1] + " cambiado a "+ nuevo);
                        CustomConfig.refresh();
                        return true;
                    }
                } catch (NumberFormatException e) {
                    sender.sendMessage(ChatColor.RED + "numero no valido");
                    return false;
                }

                //int
                try {
                    if (args[1].compareTo("SpeedZombieSpawnWheight")==0||
                        args[1].compareTo("SpeedZombieSpawnLevel")==0
                        ){
                            int nuevo = Integer.parseInt(args[2]);
                            if (nuevo<0) {
                                sender.sendMessage(ChatColor.RED + "numero fuera de rango (mayor que 0)");
                                return false;
                            }
                            
                        CustomConfig.getter().set(args[1].toString(), nuevo);
                        sender.sendMessage(ChatColor.GREEN + args[1] + " cambiado a "+ nuevo);
                        CustomConfig.refresh();
                        return true;
                    }
                } catch (NumberFormatException e) {
                    sender.sendMessage(ChatColor.RED + "numero no valido");
                    return false;
                }
                //en caso de que no se encuentre ninguna
                sender.sendMessage(ChatColor.RED + "config no existente");
                return false;

            //errores de TOD0 el comando
            } catch (NullPointerException e) {
                sender.sendMessage(ChatColor.RED + "dato no existente");
                return false;
            } catch (IndexOutOfBoundsException e){
                sender.sendMessage(ChatColor.RED + "falta el nuevo valor");
                return false;
            }
        }

        //save 
        if (args[0].compareTo("save")==0) {
            CustomConfig.save();
            return true;
        }
        
        //load 
        if (args[0].compareTo("load")==0) {
            CustomConfig.load();
            return true;
        }

        //mensage default en caso de que no exista el comando introducido
        sender.sendMessage(ChatColor.RED + "no has seleccionado ningun comando");
        sender.sendMessage(ChatColor.YELLOW + "puedes ver la funcionalidad de estos con /harmode help");
    }
    return false;
}
}