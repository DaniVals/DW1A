package src.F09Demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
descripcion articulo en el que se ha gastado mas dinero 
*/
public class SacarMasCaro {
    public static void main(String[] args) throws IOException {








        DataInputStream in = null;
        double total = 0.0;
        try {
            in = new DataInputStream(new BufferedInputStream(new FileInputStream
                ("Programacion/Java/EjerciciosArchivos/src/F09Demo/invoicedata")));

            double price, TotalMasAlto=0;
            int unit;
            String desc, descMasAlto="nada";

            try {
                while (true) {
                    price = in.readDouble();
                    unit = in.readInt();
                    desc = in.readUTF();
                    total += unit * price;

                    System.out.println("You ordered "+unit+" units of "+desc+" at "+price+" ("+total+")");
                    if (TotalMasAlto<total) {
                        TotalMasAlto = total;
                        descMasAlto = desc;
                    }
                }
            } catch (EOFException e) { }

            System.out.println("Te has gastado mas en "+descMasAlto);
        }
        finally {
            in.close();
        }
    }
}
