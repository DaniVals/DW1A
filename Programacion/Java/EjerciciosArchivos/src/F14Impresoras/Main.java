package src.F14Impresoras;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import src.F14Impresoras.Impresora.Tipo;

/* 
3.
Pedir  datos  sobre  impresoras  por  teclado:  número  de  serie  (sólo  dígitos),  marca,  
modelo  y  tipo.  Las  impresoras  pueden  ser  de  dos  tipos:  tinta  y  láser.    Almacenar  la 
información  en  un  ArrayList.  Después  preguntar  al  usuario  si  quiere  almacenar  esos 
objetos  en  un  fichero.  Si  la  respuesta  es  afirmativa,  crear  un  fichero  con  esos  datos 
llamado impresoras. 

*/

public class Main {
    public static void main(String[] args) throws IOException{
        
        ArrayList<Impresora> impresoras = new ArrayList<Impresora>();

        impresoras.add(new Impresora(10, "MX-210", "HP", Tipo.TINTA));
        impresoras.add(new Impresora(43, "SS-10", "HP", Tipo.TINTA));
        impresoras.add(new Impresora(58, "ML-3060", "HP", Tipo.LASER));


        for (Impresora i : impresoras) {
            System.out.println(i);
        }

        System.out.println("Quieres guardar esta lista");
        boolean respuesta = true;

        if (respuesta) {
            ObjectOutputStream out = null;
            try {
                out = new ObjectOutputStream(new BufferedOutputStream(
                    new FileOutputStream("Programacion/Java/EjerciciosArchivos/src/F14Impresoras/baseDeDatos.impresoras")));
                    
                for (int i = 0; i < impresoras.size(); i++) {
                    out.writeObject(impresoras.get(i));
                }
            }
            catch(IOException e)
            {e.printStackTrace();}
            finally 
            {out.close();}
        }
    }
}