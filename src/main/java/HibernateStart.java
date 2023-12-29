import model.Album;
import model.Composition;
import model.Performer;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class HibernateStart {
    public static void main(String[] args) {
        Session session =
                HibernateUtil.getSession();
        // Начало транзакции
        session.beginTransaction();
        Performer performer1 = new Performer();
        performer1.setName("per1");
        List<Album> albums = new ArrayList<>();
        Album album1 = new Album();
        album1.setName("alb1");
        album1.setStyle("Style1");
        album1.setId_performer(performer1.getId());
        Album album2 = new Album();
        album1.setName("alb2");
        album1.setStyle("Style1");
        album1.setId_performer(performer1.getId());
        List<Composition> compositions1 = new ArrayList<>();
        List<Composition> compositions2 = new ArrayList<>();
        Composition composition1 = new Composition();
        Composition composition2 = new Composition();
        Composition composition3 = new Composition();
        composition1.setName("com1");
        composition2.setName("com2");
        composition3.setName("com3");
        composition1.setLength(5);
        composition2.setLength(4);
        composition3.setLength(2);
        composition1.setIdAlbum(album1.getId());
        composition2.setIdAlbum(album2.getId());
        composition3.setIdAlbum(album2.getId());
        compositions1.add(composition1);
        album1.setCompositions(compositions1);
        compositions2.add(composition2);
        compositions2.add(composition3);
        album2.setCompositions(compositions2);
        albums.add(album1);
        albums.add(album2);
        performer1.setAlbums(albums);
        session.save(composition1);
        session.save(composition2);
        session.save(composition3);
        session.save(album1);
        session.save(album2);
        session.save(performer1);
        session.getTransaction().commit();
    }
}
