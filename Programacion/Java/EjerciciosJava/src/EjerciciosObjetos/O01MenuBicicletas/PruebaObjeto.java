package EjerciciosObjetos.O01MenuBicicletas;

import java.util.Scanner;

public class PruebaObjeto {

    public static void main(String[] args) {
        
            //definir
            Scanner teclado=new Scanner(System.in);
            int opcion=1, biciSeleccionada=1, valorTeclado=0;
            Bicycle bici1=null, bici2=null;
            bici1=new Bicycle(0,0,0);
            bici2=new Bicycle(0,0,0);

            //bucle principal
            while (opcion!=0){
                System.out.println("Elije una opcion para la bici "+biciSeleccionada+": 1.acelerar 2.frenar 3.cambiar marcha 4.mostrar estadisticas 5. cambiar bici 0.salir");
                opcion= teclado.nextInt();
                switch (opcion){
                    case 1://acelerar
                        valorTeclado=0;
                        while (valorTeclado<1) {
                            System.out.println("Cuanto quieres acelerar?");
                            valorTeclado= teclado.nextInt();
                        }
                        if (biciSeleccionada==1) {
                            bici1.speedUp(valorTeclado);
                        }else{
                            bici2.speedUp(valorTeclado);
                        }
                    break;
                    case 2://frenar
                        valorTeclado=0;
                        while (valorTeclado<1) {
                            System.out.println("Cuanto quieres frenar?");
                            valorTeclado= teclado.nextInt();
                        }
                        if (biciSeleccionada==1) {
                            bici1.applyBrake(valorTeclado);
                        }else{
                            bici2.applyBrake(valorTeclado);
                        }
                    break;
                    case 3://marcha
                        valorTeclado=0;
                        while (valorTeclado<1 || 6<valorTeclado) {
                            System.out.println("Que marcha quieres?");
                            valorTeclado= teclado.nextInt();
                        }
                        if (biciSeleccionada==1) {
                            bici1.setGear(valorTeclado);
                        }else{
                            bici2.setGear(valorTeclado);
                        }
                    break;
                    case 4://mostrar stats
                        System.out.println("Bici 1");
                        System.out.println("    Velocidad: "+bici1.showSpeed());
                        System.out.println("    Marcha: "+bici1.showGear());
                        System.out.println("Bici 2");
                        System.out.println("    Velocidad: "+bici2.showSpeed());
                        System.out.println("    Marcha: "+bici2.showGear());
                    break;
                    case 5://cambio de bici
                        if (biciSeleccionada==1) {
                            biciSeleccionada = 2;
                        }else{
                            biciSeleccionada = 1;
                        }
                            System.out.println("Bici cambiada a bici "+biciSeleccionada);
                    break;
                }
            }
        teclado.close();
    }
}
//menu para 2 bicis cambiar marcha, acelerar, frenar, mostrar datos, salir
//validar estos datos, la marcha entre 1 y 7, acelerar y frenar positivo