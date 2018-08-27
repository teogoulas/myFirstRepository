package com.syllogos.repository;

import com.syllogos.model.RodoClass;
import com.syllogos.model.RodoClassView;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository("rodoClassRepository")
public class RodoClassRepositoryImpl implements RodoClassRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	public RodoClass save(RodoClass rodoClass) {

		if (rodoClass.getId() == null){
			em.persist(rodoClass);
			em.flush();
		}else {
			rodoClass = em.merge(rodoClass);
		}

		return rodoClass;
	}

	@Override
	public RodoClass load(String className) {
		TypedQuery<RodoClass> query = em.createNamedQuery(RodoClass.GET_RODOCLASS_BY_NAME, RodoClass.class);
		query.setParameter("className", className);

		return query.getSingleResult();
	}

	@Override
	public RodoClassView loadView(String className) {
		TypedQuery<RodoClassView> query = em.createNamedQuery(RodoClass.GET_RODOCLASS_VIEW_BY_NAME, RodoClassView.class);
		query.setParameter("className", className);

		return query.getSingleResult();
	}

	@Override
	public List<RodoClass> loadAll() {

		TypedQuery<RodoClass> query = em.createNamedQuery(RodoClass.GET_ALL_RODOCLASSES, RodoClass.class);

		List<RodoClass> rodoClasses = query.getResultList();
		return rodoClasses;
	}
}
