import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Album {
    private String nombre;
    private String artista;
    private ArrayList<Cancion> canciones;

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        canciones = new ArrayList<Cancion>();
    }

    public boolean addSong(String titulo, double duracion){
        // Buscar la canción en el álbum utilizando el título
        Cancion cancionExistente = findSong(titulo);
        // Si se encuentra una canción con el mismo título
        if (cancionExistente != null) {
            System.out.println("[!] La canción '" + titulo + "' ya existe en el álbum.");
            return false;
        }
        try{
            Cancion cancion = new Cancion(titulo, duracion);
            //Aqui puedo añadir un mensaje diciendo qu ehe añadido la canción
            canciones.add(cancion);
            return true;

        }catch (IllegalArgumentException e){
            System.out.println("Error: El título o la duración de la canción no son válidos.");
            return false;
        }
    }

    private Cancion findSong(String titulo){
        for(Cancion cancion : canciones){
            if(titulo.equals(cancion.getTitulo())){
                return cancion;
            }
        }
        return null;
    }

    public boolean addToPlayList(int numeroPista, LinkedList<Cancion> playList){
        //Comprobamos si la canción está dentro del album por número (si existe una canción 10 por ejemplo)
        if (numeroPista < 1 || numeroPista > canciones.size()){
            return false;
        }
        // Obtenemos la canción y la añadimos
        try {
            Cancion cancion = canciones.get(numeroPista - 1);
            playList.add(cancion);
            System.out.println("\tSe ha añadido la canción " + cancion.getTitulo() + " a la PlayList");
            return true;
        } catch (Exception e){
            System.out.println("[!] La canción no exite en el álbum");
            return false;
        }
    }

    public boolean addToPlayList(String titulo, LinkedList<Cancion> playList){
        Cancion cancionExistente = findSong(titulo);
        if(cancionExistente != null){
            try{
                playList.add(cancionExistente);
                System.out.println("\tSe ha añadido la canción " + cancionExistente.getTitulo() + " a la PlayList");
                return true;
            } catch (Exception e){
                System.out.println("[!] Error la canción no se puede añadir a la PlayList");
                return false;
            }
        } else {
            System.out.println("[!] La canción no exite en el álbum");
            return false;
        }
    }
    public boolean addToPlayListInOrder(LinkedList<Cancion> playList, String titulo, ArrayList<Album> albumes){
        Cancion nuevaCancion = null;
        for(Album album : albumes){
            Cancion cancion = album.findSong(titulo);
            if(cancion != null){
                nuevaCancion = cancion;
                break;
            }
        }

        if(nuevaCancion == null){
            System.out.println("\n[!] La canción no existe en los álbumes.");
            return false;
        }

        ListIterator<Cancion> iterator = playList.listIterator();
        while (iterator.hasNext()){
            int comparacion = iterator.next().getTitulo().compareTo(nuevaCancion.getTitulo());
            if (comparacion == 0){
                System.out.println("\n[!] La canción ya está en la playlist");
                return false;
            } else if (comparacion > 0) {
                iterator.previous();
                break;
            }

        }
        iterator.add(nuevaCancion);
        System.out.println("\n[*] Canción añadida en orden: " + nuevaCancion.getTitulo());
        return true;
    }

    public boolean addToPlayListInOrder(int numeroPista, LinkedList<Cancion> playList) {
        if (numeroPista < 1 || numeroPista > canciones.size()) {
            System.out.println("[!] Número de pista no válido.");
            return false;
        }
        Cancion cancion = canciones.get(numeroPista - 1);
        return addInOrder(cancion, playList);
    }

    public boolean addToPlayListInOrder(String titulo, LinkedList<Cancion> playList) {
        Cancion cancionExistente = findSong(titulo);
        if (cancionExistente == null) {
            System.out.println("[!] La canción no existe en el álbum.");
            return false;
        }
        return addInOrder(cancionExistente, playList);
    }

    private boolean addInOrder(Cancion cancion, LinkedList<Cancion> playList) {
        ListIterator<Cancion> iterator = playList.listIterator();
        while (iterator.hasNext()) {
            Cancion actual = iterator.next();
            if (actual.getTitulo().equalsIgnoreCase(cancion.getTitulo())) {
                System.out.println("\n[!] La canción ya está en la playlist.");
                return false;
            } else if (actual.getTitulo().compareToIgnoreCase(cancion.getTitulo()) > 0) {
                iterator.previous();
                break;
            }
        }
        iterator.add(cancion);
        System.out.println("\n[*] Canción añadida en orden: " + cancion.getTitulo());
        return true;
    }
}
