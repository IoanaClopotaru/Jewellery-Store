package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import model.Jewellery;

public class JewelleryDao extends GenericDao<Jewellery> {
	private EntityManagerFactory factory;

public JewelleryDao(EntityManagerFactory factory) {
super(Jewellery.class);
this.factory = factory;
}

	@Override
	public EntityManager getEntityManager() {
		try {
			return factory.createEntityManager();
		} catch (Exception ex) {
			System.out.println("The entity manager cannot be created!");
			return null;
		}
	}

// for login
	public List<Jewellery> find(String name) {
		EntityManager em = getEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Jewellery> q = cb.createQuery(Jewellery.class);
		Root<Jewellery> c = q.from(Jewellery.class);
		ParameterExpression<String> paramName = cb.parameter(String.class);
		q.select(c).where(cb.equal(c.get("Jewelleryname"), paramName));
		TypedQuery<Jewellery> query = em.createQuery(q);
		query.setParameter(paramName, name);
		List<Jewellery> results = query.getResultList();
		return results;
	}
}