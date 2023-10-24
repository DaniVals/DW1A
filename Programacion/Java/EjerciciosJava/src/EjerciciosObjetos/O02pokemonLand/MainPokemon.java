package EjerciciosObjetos.O02pokemonLand;

public class MainPokemon {
    
    public static void main(String[] args) {
        Pokemon pokemon1, pokemon2;

        pokemon1= new Pokemon('W',7,3,100,3);
        pokemon1.mostrarStats();
        pokemon2= new Pokemon('F',6,4,10,2);
        System.out.println(pokemon2);

        //pokemon2.comerBaya();

        System.out.println("El ganador es el pokemon "+pokemon1.lucha(pokemon2));
    }
}
