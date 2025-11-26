import java.util.Random;
import java.util.Scanner;

class Pokemon {
	String nombre;
	int vidaMax;
	int vidaActual;
	boolean defendiendo;

	// Contructor
	// pedir -> Nombre y Vida maxima
	public Pokemon(String pokemonName, int vida) {
		this.nombre = pokemonName;
		this.vidaMax = vida;
		this.vidaActual = vida;
	}

	boolean estaVivo() {
		return vidaActual > 0;
	}

	// ---------------------------------------------------------
	// ---------------- ACCIONES DE BATALLA --------------------
	// ---------------------------------------------------------

	void mostrarEstado() {
		// Pikachu ♥ 90/95
		System.out.println(nombre + " ♥ " + vidaActual + "/" + vidaMax);
	}

	void recibirDano(int dano) {
		vidaActual -= dano;

		if(vidaActual < 0) {
			vidaActual = 0;
		}

		// .𖥔 Pikachu recibe 100 de daño.
		System.out.println(".𖥔 " + nombre + " recibe " + dano + " de daño.");
	}

	void curar(int cantidad) {
		vidaActual += cantidad;

		if(vidaActual > vidaMax) {
			vidaActual = vidaMax;
		}

		// +♥ Pikachu se cura 100 puntos de vida.
		System.out.println("+♥ " + nombre + " se cura " + cantidad + " puntos de vida");
	}

	void defender() {
		defendiendo = true;
		// ⛊ Pikachu se pone en posicion defensiva.
		System.out.println("⛊ " + nombre + " se pone en posicion defensiva.");
	}
}

public class BatallaPokemon { 
	public static void main(String[] args) { 

		Scanner sc = new Scanner(System.in);
		Random random = new Random();

		// crear nuestra lista de pokemon
		// que van a luchar
		// String[] lista = ["A", "B", "C"];
		// Pokemon poke1 = new Pokemon("Charmander", 100);
		Pokemon[] lista = {
			new Pokemon("Charmander", 100),
			new Pokemon("Squirtle", 110),
			new Pokemon("Bulbasaur", 105),
			new Pokemon("Pikachu", 95)
		};

		System.out.println("");
		System.out.println("𓃻  BATALLA POKEMON 𓅂");
		System.out.println("Elige tu Pokemon:");
		System.out.println("");

		for(int i = 0; i < lista.length; i++){
			// 1) Charmander [100] - HP
			// 2) Squirtle [110] - HP
			
			/*
			(i+1)    -> 0+1, para que muestre 1
			lista[i] -> hace referencia al elemento de mi lista
			lista[i].nombre -> atributo nombre
			*/

			System.out.println((i + 1) + ") " + lista[i].nombre + " [" + lista[i].vidaMax + "] - HP");
		}

		System.out.println("Opcion: ");
		int opcionJugador = sc.nextInt() - 1;

		if(opcionJugador < 0 || opcionJugador >= lista.length ) {
			System.out.println("Opcion no valida, se asignara el primero de la lista");
			opcionJugador = 0;
		}

		//                  lista[2];
		Pokemon tuPokemon = lista[opcionJugador];

		int opcionMaquina = random.nextInt(lista.length);

		if(opcionMaquina == opcionJugador && lista.length > 1) {
			//       0    =      3 + 1  = 4 / 4 = 1   (% == 0)
			//       2    =      1 + 1  = 2 / 4 = 0.5 (% == 2)
			opcionMaquina = (opcionMaquina + 1) % lista.length;
		}

		//Pokemon pokemonCPU = lista[opcionMaquina];

		// new Pokemon(nombre, vida);
		Pokemon pokemonCPU = new Pokemon(lista[opcionMaquina].nombre, lista[opcionMaquina].vidaMax);

		System.out.println("\nTu eliges a: " + tuPokemon.nombre);
		System.out.println("La CPU elige a: " + pokemonCPU.nombre);
		System.out.println("\n¡Que comience la batalla!\n");
	}
}