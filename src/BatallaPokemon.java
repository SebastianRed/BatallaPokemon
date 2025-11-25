class Pokemon {
    
    String nombre;
    Integer saludMax;
    Integer saludActual;

    public Pokemon(String nombre, Integer salud) {
        this.nombre = nombre;
        this.saludMax = salud;
        this.saludActual = salud;
    }

}

public class BatallaPokemon {

    public static void main(String[] args) {
        Pokemon pikachu = new Pokemon("Pikachu", 100);
        Pokemon charmander = new Pokemon("Charmander", 80);

        System.out.println("Pokemon 1: " + pikachu.nombre + " | Salud: " + pikachu.saludActual + "/" + pikachu.saludMax);
        System.out.println("Pokemon 2: " + charmander.nombre + " | Salud: " + charmander.saludActual + "/" + charmander.saludMax);
    }
}