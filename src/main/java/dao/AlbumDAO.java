package dao;

import model.Album;
import model.Performer;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class AlbumDAO {
    private Session session;

    public AlbumDAO(Session session) {
        this.session = session;
    }

    public void delete(Album album){
        session.beginTransaction();
        session.delete(album);
        session.getTransaction().commit();
    }

    public void insert(Album album){
        session.beginTransaction();
        session.save(album);
        session.getTransaction().commit();
    }

    public void update(Album album){
        session.beginTransaction();
        session.update(album);
        session.getTransaction().commit();
    }

    public Album select(Long id){
        session.beginTransaction();
        return session.get(Album.class,id);
    }

    public List<Album> selectAll(){
        return session.createQuery("from Album").list();
    }
}
