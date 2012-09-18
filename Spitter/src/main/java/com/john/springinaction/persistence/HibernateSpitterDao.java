//<start id="java_contextualHibernateDao"/> 
package com.john.springinaction.persistence;

import com.john.springinaction.domain.Spitter;
import com.john.springinaction.domain.Spittle;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Repository("spitterDao")
public class HibernateSpitterDao implements SpitterDao {
  private SessionFactory sessionFactory;

  @Autowired
  public HibernateSpitterDao(SessionFactory sessionFactory) {//<co id="co_injectSessionFactory"/>
    this.sessionFactory = sessionFactory;
  }
  
  private Session currentSession() {
    return sessionFactory.getCurrentSession();//<co id="co_getCurrentSession"/>
  }
  
  public void addSpitter(Spitter spitter) {
    currentSession().save(spitter);//<co id="co_useSession"/>
  }

  public Spitter getSpitterById(long id) {
    return (Spitter) currentSession().get(Spitter.class, id);//<co id="co_useSession"/>
  }

  public void saveSpitter(Spitter spitter) {
    currentSession().update(spitter);//<co id="co_useSession"/>
  }
  //<end id="java_contextualHibernateDao"/> 
  
  public List<Spittle> getRecentSpittle() {
	  Session session = currentSession();
	  Query query = session.createQuery("FROM Spittle");
	  final Collection<Spittle> retrievedSpittles = query.list();
	  List<Spittle> spittlesList = new ArrayList<Spittle>(retrievedSpittles);
	  
  //  return currentSession().f  loadAll(Spittle.class); // this isn't right...just a placeholder for now
	  return spittlesList;
  }
  
  public void saveSpittle(Spittle spittle) {
    currentSession().save(spittle);
  }

  public List<Spittle> getSpittlesForSpitter(
          Spitter spitter) {
    Session session = currentSession();
    Query query = session.createQuery("FROM Spittle WHERE spitter_id = :spitter_id");
    query.setParameter("spitter_id", spitter.getId());
    List<Spittle> spittlesList = query.list();
    return spittlesList;
  }

  public Spitter getSpitterByUsername(String username) {
    Session session = currentSession();
    Query query = session.createQuery("FROM Spitter WHERE username = :username");
    query.setParameter("username", username);
    Spitter spitter = (Spitter) query.uniqueResult();
    return spitter;
  }

  public void deleteSpittle(long id) {
    currentSession().delete(getSpittleById(id));
  }

  public Spittle getSpittleById(long id) {
    return (Spittle) currentSession().get(Spittle.class, id);
  }
  
  public List<Spitter> findAllSpitters() {
    // TODO Auto-generated method stub
    return null;
  }
}