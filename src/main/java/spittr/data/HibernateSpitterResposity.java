package spittr.data;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import net.sf.ehcache.search.aggregator.Count;
import spittr.Spitter;

@Repository
public class HibernateSpitterResposity {
	
	private SessionFactory sessionFactory;
	
	@Inject
	public HibernateSpitterResposity(SessionFactory sessionFactory) {
		this.sessionFactory =sessionFactory;
	}
	
	private Session currentSession() {
		return sessionFactory.getCurrentSession();
	}

	public long count() {
		return findAll().size();
		
	}
	
	public Spitter save(Spitter spitter) {
		Serializable id = currentSession().save(spitter);
		
		return new Spitter((Long) id,spitter.getFirstName(),spitter.getLastName(),spitter.getUserName(),spitter.getPassword());
		
	}
	
	public Spitter findOne(long id) {
		return (Spitter) currentSession().get(Spitter.class, id);
	}
	
	public Spitter findByUsername(String username) {
		return (Spitter) currentSession().createCriteria(Spitter.class).add(Restrictions.eq("userName", username));
		
	}

	private List<Spitter> findAll() {
		// TODO Auto-generated method stub
		return (List<Spitter>) currentSession().createCriteria(Spitter.class).list();
	}
}
