import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void menu() {
        System.out.println("\n0 – Salir de la lista de reproducción");
        System.out.println("1 – Reproducir siguiente canción en la lista");
        System.out.println("2 – Reproducir la canción previa de la lista");
        System.out.println("3 – Repetir la canción actua");
        System.out.println("4 – Imprimir la lista de canciones en la playlist");
        System.out.println("5 – Volver a imprimir el menú");

    }

    public static void imprimirPlayList(LinkedList<Cancion> playList){
        Iterator<Cancion> iterador = playList.iterator(); {
            System.out.println("\n[+] Contenido de la PlayList");
            while(iterador.hasNext()){
                System.out.println("\tCanción: " + iterador.next());
            }
        }
    }
    public static void main(String[] args) {
        ArrayList<Album> albumes = new ArrayList<>() {{
            add(new Album("Los polluelos", "Álvaro") {{
                addSong("Picoteo Mañanero", 3.5);
                addSong("El Baile del Nido", 4.2);
                addSong("Vuelo sin Rumbo", 5.1);
                addSong("Aleteos Nocturnos", 2.8);
                addSong("Plumas al Viento", 4.0);
                addSong("¡Polluelos, Despegamos!", 3.3);
            }});

            add(new Album("Sevillanas Remix", "Guada"){{
                addSong("Fiesta Flamenca", 3.0);
                addSong("Bailando Bajo la Luna", 2.5);
                addSong("Ritmo del Sur", 4.1);
                addSong("Flor de Azahar", 3.8);
                addSong("Olé y Ole", 4.5);
                addSong("Sevillanas Sabrosas", 3.2);
                addSong("Alegría en la Feria", 2.7);
                addSong("Encanto Andaluz", 4.0);
                addSong("Girasol del Guadalquivir", 3.5);
                addSong("Rumbo a Triana", 3.9);
            }});
        }};

        LinkedList<Cancion> playList = new LinkedList<>();

        albumes.get(0).addToPlayList(2,playList);
        albumes.get(1).addToPlayList(8,playList);
        albumes.get(0).addToPlayList("Aleteos Nocturnos",playList);
        albumes.get(1).addToPlayList("Ritmo del Sur",playList);

        imprimirPlayList(playList);

        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        menu();

        while(opcion != 0) {
            System.out.println("\n[*] Introduce una opción: ");
            switch (opcion) {
                case 0:
                    System.out.println("[!] Saliendo...");
                    break;
                case 1:
                    System.out.println("[!] Saliendo...");
                    break;
                case 2:
                    System.out.println("[!] Saliendo...");
                    break;
                case 3:
                    System.out.println("[*] Esta sonando ")//Añadir cación actual;
                    break;
                case 4:
                    System.out.println("[!] Saliendo...");
                    break;
                case 5:
                    System.out.println("[!] Saliendo...");
                    break;
                default:
                    System.out.println("[!] Opción no válida");
                    break;
            }
        }
    }
}