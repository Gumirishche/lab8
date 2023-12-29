package dao;

import model.Album;
import model.Performer;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class PerformerDAO {
    Session session;

    public PerformerDAO(Session session){
        this.session=session;
    }

    public void delete(Performer performer){
        session.beginTransaction();
        session.delete(performer);
        session.getTransaction().commit();
    }

    public void insert(Performer performer){
        session.beginTransaction();
        session.save(performer);
        session.getTransaction().commit();
    }
    public void update(Performer performer){
        session.beginTransaction();
        session.update(performer);
        session.getTransaction().commit();
    }
    public Performer select(Long id){
        return session.get(Performer.class,id);
    }

    public List<Performer> selectAll(){
        return session.createQuery("from Performer").list();
    }
}
