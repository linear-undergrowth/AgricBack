package com.undergrowth.bean.service.interimple;

import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.undergrowth.bean.Eartag;
import com.undergrowth.bean.EartagId;
import com.undergrowth.bean.service.inter.IEartagDAO;

/**
 * A data access object (DAO) providing persistence and search support for
 * Eartag entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.undergrowth.bean.Eartag
 * @author MyEclipse Persistence Tools
 */
@Transactional
@Repository
public class EartagDAO implements IEartagDAO {
	private static final Log logger = LogFactory.getLog(EartagDAO.class);
	// property constants
	public static final String ET_SITE = "etSite";
	public static final String ET_ANTIEPI = "etAntiepi";
	public static final String ET_FEEDING = "etFeeding";

	private EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	private EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Perform an initial save of a previously unsaved Eartag entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * <p>
	 * User-managed Spring transaction example:
	 * 
	 * <pre>
	 * TransactionStatus txn = txManager
	 * 		.getTransaction(new DefaultTransactionDefinition());
	 * EartagDAO.save(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Eartag entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Eartag entity) {
		logger.info("saving Eartag instance");
		try {
			getEntityManager().persist(entity);
			logger.info("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
			throw re;
		}
	}

	/**
	 * Delete a persistent Eartag entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * <p>
	 * User-managed Spring transaction example:
	 * 
	 * <pre>
	 * TransactionStatus txn = txManager
	 * 		.getTransaction(new DefaultTransactionDefinition());
	 * EartagDAO.delete(entity);
	 * txManager.commit(txn);
	 * entity = null;
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Eartag entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Eartag entity) {
		logger.info("deleting Eartag instance");
		try {
			entity = getEntityManager().getReference(Eartag.class,
					entity.getId());
			getEntityManager().remove(entity);
			logger.info("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
			throw re;
		}
	}

	/**
	 * Persist a previously saved Eartag entity and return it or a copy of it to
	 * the sender. A copy of the Eartag entity parameter is returned when the
	 * JPA persistence mechanism has not previously been tracking the updated
	 * entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * <p>
	 * User-managed Spring transaction example:
	 * 
	 * <pre>
	 * TransactionStatus txn = txManager
	 * 		.getTransaction(new DefaultTransactionDefinition());
	 * entity = EartagDAO.update(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Eartag entity to update
	 * @return Eartag the persisted Eartag entity instance, may not be the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Eartag update(Eartag entity) {
		logger.info("updating Eartag instance");
		try {
			Eartag result = getEntityManager().merge(entity);
			logger.info("update successful");
			return result;
		} catch (RuntimeException re) {
			logger.error("update failed", re);
			throw re;
		}
	}

	public Eartag findById(EartagId id) {
		logger.info("finding Eartag instance with id: " + id);
		try {
			Eartag instance = getEntityManager().find(Eartag.class, id);
			return instance;
		} catch (RuntimeException re) {
			logger.error("find failed", re);
			throw re;
		}
	}

	/**
	 * Find all Eartag entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Eartag property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            number of results to return.
	 * @return List<Eartag> found by query
	 */
	@SuppressWarnings("unchecked")
	public List<Eartag> findByProperty(String propertyName, final Object value,
			final int... rowStartIdxAndCount) {
		logger.info("finding Eartag instance with property: " + propertyName
				+ ", value: " + value);
		try {
			final String queryString = "select model from Eartag model where model."
					+ propertyName + "= :propertyValue order by model.id.etWdate desc";
			Query query = getEntityManager().createQuery(queryString);
			query.setParameter("propertyValue", value);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Eartag> findByEtSite(Object etSite, int... rowStartIdxAndCount) {
		return findByProperty(ET_SITE, etSite, rowStartIdxAndCount);
	}

	public List<Eartag> findByEtAntiepi(Object etAntiepi,
			int... rowStartIdxAndCount) {
		return findByProperty(ET_ANTIEPI, etAntiepi, rowStartIdxAndCount);
	}

	public List<Eartag> findByEtFeeding(Object etFeeding,
			int... rowStartIdxAndCount) {
		return findByProperty(ET_FEEDING, etFeeding, rowStartIdxAndCount);
	}

	/**
	 * Find all Eartag entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Eartag> all Eartag entities
	 */
	@SuppressWarnings("unchecked")
	public List<Eartag> findAll(final int... rowStartIdxAndCount) {
		logger.info("finding all Eartag instances");
		try {
			final String queryString = "select model from Eartag model";
			Query query = getEntityManager().createQuery(queryString);
			if (rowStartIdxAndCount != null && rowStartIdxAndCount.length > 0) {
				int rowStartIdx = Math.max(0, rowStartIdxAndCount[0]);
				if (rowStartIdx > 0) {
					query.setFirstResult(rowStartIdx);
				}

				if (rowStartIdxAndCount.length > 1) {
					int rowCount = Math.max(0, rowStartIdxAndCount[1]);
					if (rowCount > 0) {
						query.setMaxResults(rowCount);
					}
				}
			}
			return query.getResultList();
		} catch (RuntimeException re) {
			logger.error("find all failed", re);
			throw re;
		}
	}

	public static IEartagDAO getFromApplicationContext(ApplicationContext ctx) {
		return (IEartagDAO) ctx.getBean("EartagDAO");
	}
}