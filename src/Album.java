import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

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

    public Cancion findSong(String titulo){
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
            System.out.println("Se ha añadido la canción " + cancion.getTitulo() + " a la PlayList");
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
                System.out.println("Se ha añadido la canción " + cancionExistente.getTitulo() + " a la PlayList");
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
}
