import java.util.*;

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

    public static void play(LinkedList<Cancion> playList){
        Scanner sc = new Scanner(System.in);
        int opcion = -1;
        menu();

        Cancion cancionActual = null;
        ListIterator<Cancion> iterator = playList.listIterator();

        while(opcion != 0) {

            System.out.print("\n[+] Introduce una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("[*] Saliendo...");
                    break;
                case 1:
                    if (iterator.hasNext()){
                        cancionActual = iterator.next();
                        System.out.println("\n[*] Esta sonando " + cancionActual.getTitulo());
                    }else {
                        System.out.println("\n[*] Estás en la última canción de la PlayList");
                        cancionActual = iterator.previous();
                    }
                    break;
                case 2:
                    if(cancionActual == null){
                        System.out.println("\n[*] Estás en la primera canción de la PlayList");
                    } else{
                        if (iterator.hasPrevious()){
                            cancionActual = iterator.previous();
                            System.out.println("\n[*] Esta sonando " + cancionActual.getTitulo());
                        }else {
                            System.out.println("\n[*] Estás en la primera canción de la PlayList");
                            cancionActual = iterator.next();
                        }
                    }
                    break;
                case 3:
                    if(cancionActual != null){
                        System.out.println("\n[*] Esta sonando " + cancionActual.getTitulo());
                    }else {
                        System.out.println("\n[*] No hay ninguna canción seleccionada");
                    }
                    break;
                case 4:
                    imprimirPlayList(playList);
                    break;
                case 5:
                    menu();
                    break;
                default:
                    System.out.println("[!] Opción no válida");
                    break;
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

        System.out.println("\n[+] Añadimos algunas canciones a la Playlist");
        albumes.get(0).addToPlayList(2,playList);
        albumes.get(1).addToPlayList(8,playList);
        albumes.get(0).addToPlayList("Aleteos Nocturnos",playList);
        albumes.get(1).addToPlayList("Ritmo del Sur",playList);

        play(playList);
    }
}