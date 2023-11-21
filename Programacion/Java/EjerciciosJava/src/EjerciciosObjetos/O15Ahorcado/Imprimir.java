package EjerciciosObjetos.O15Ahorcado;

public class Imprimir {
    
    public static void muerte(int partes){

        switch (partes) {
            case 0:
                System.out.println(
                " ______     \n"+
                " |    |     \n"+
                " |          \n"+
                " |          \n"+
                " |          \n"+
                "_|_         \n"
                );
            break;
            case 1:
                System.out.println(
                " ______     \n"+
                " |    |     \n"+
                " |    o     \n"+
                " |          \n"+
                " |          \n"+
                "_|_         \n"
                );
            break;
            case 2:
                System.out.println(
                " ______     \n"+
                " |    |     \n"+
                " |    o     \n"+
                " |    |     \n"+
                " |          \n"+
                "_|_         \n"
                );
            break;
            case 3:
                System.out.println(
                " ______     \n"+
                " |    |     \n"+
                " |    o/    \n"+
                " |    |     \n"+
                " |          \n"+
                "_|_         \n"
                );
            break;
            case 4:
                System.out.println(
                " ______     \n"+
                " |    |     \n"+
                " |    o/    \n"+
                " |   /|     \n"+
                " |          \n"+
                "_|_         \n"
                );
            break;
            case 5:
                System.out.println(
                " ______     \n"+
                " |    |     \n"+
                " |    o/    \n"+
                " |   /|     \n"+
                " |     |    \n"+
                "_|_         \n"
                );
            break;
            case 6:
            default:
                System.out.println(
                " ______     \n"+
                " |    |     \n"+
                " |    o/    \n"+
                " |   /|     \n"+
                " |   | |    \n"+
                "_|_         \n"
                );
            break;
        }

    }
}
