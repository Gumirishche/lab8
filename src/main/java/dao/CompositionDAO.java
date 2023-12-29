package dao;

import model.Album;
import model.Composition;
import model.Performer;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class CompositionDAO {
    private Session session;

    public CompositionDAO(Session session) {
        this.session = session;
    }

    public void delete(Composition composition){
        session.beginTransaction();
        session.delete(composition);
        session.getTransaction().commit();
    }
    public void insert(Composition composition){
        session.beginTransaction();
        session.save(composition);
        session.getTransaction().commit();
    }
    public void update(Composition composition){
        session.beginTransaction();
        session.update(composition);
        session.getTransaction().commit();
    }
    public Composition select(Long id){
        session.beginTransaction();
        return session.get(Composition.class,id);
    }
    public List<Composition> selectAll(){
        return session.createQuery("from Composition").list();
    }
}
