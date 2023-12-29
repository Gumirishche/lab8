import dao.AlbumDAO;
import dao.CompositionDAO;
import dao.PerformerDAO;
import model.Album;
import model.Composition;
import model.Performer;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HibernateStart {
    public static void main(String[] args) {
        Session session=HibernateUtil.getSession();
        PerformerDAO performerDAO = new PerformerDAO(session);
        AlbumDAO albumDAO = new AlbumDAO(session);
        CompositionDAO compositionDAO = new CompositionDAO(session);
        Performer performer1 = new Performer("Performer5");
        Performer performer2 = new Performer("Performer4");

        Album album1 = new Album("Rise","Metal");
        Album album2 = new Album("Popcorn","Classic");
        Album album3 = new Album("Borshch","Heavy Metal");

        album1.setIdPerformer(performer1);
        album2.setIdPerformer(performer2);
        album3.setIdPerformer(performer2);

        List<Album> albums1= new ArrayList<>();
        albums1.add(album1);
        performer1.setAlbums(albums1);

        List<Album> albums2= new ArrayList<>();
        albums2.add(album2);
        albums2.add(album3);
        performer2.setAlbums(albums2);

        Composition composition1 = new Composition("First",13);
        Composition composition2 = new Composition("Second",2);
        Composition composition3 = new Composition("Third",6);
        Composition composition4 = new Composition("Fourth",3);

        composition1.setIdAlbum(album1);
        composition2.setIdAlbum(album2);
        composition3.setIdAlbum(album3);
        composition4.setIdAlbum(album3);

        List<Composition> compositions1= new ArrayList<>();
        compositions1.add(composition1);
        album1.setCompositions(compositions1);

        List<Composition> compositions2= new ArrayList<>();
        compositions2.add(composition2);
        album2.setCompositions(compositions2);

        List<Composition> compositions3= new ArrayList<>();
        compositions3.add(composition3);
        compositions3.add(composition4);
        album3.setCompositions(compositions3);

        performerDAO.insert(performer1);
        performerDAO.insert(performer2);

        System.out.println(performerDAO.select(performer1.getId()).getName());
        System.out.println(Arrays.toString(performerDAO.selectAll().toArray()));
    }
}
