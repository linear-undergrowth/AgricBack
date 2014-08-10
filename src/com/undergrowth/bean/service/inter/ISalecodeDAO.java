package com.undergrowth.bean.service.inter;

import java.util.List;

import com.undergrowth.bean.Salecode;

/**
 * Interface for SalecodeDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ISalecodeDAO {
	/**
	 * Perform an initial save of a previously unsaved Salecode entity. All
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
	 * ISalecodeDAO.save(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Salecode entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(Salecode entity);

	/**
	 * Delete a persistent Salecode entity. This operation must be performed
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
	 * ISalecodeDAO.delete(entity);
	 * txManager.commit(txn);
	 * entity = null;
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Salecode entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(Salecode entity);

	/**
	 * Persist a previously saved Salecode entity and return it or a copy of it
	 * to the sender. A copy of the Salecode entity parameter is returned when
	 * the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
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
	 * entity = ISalecodeDAO.update(entity);
	 * txManager.commit(txn);
	 * </pre>
	 * 
	 * @see <a href =
	 *      "http://www.myeclipseide.com/documentation/quickstarts/jpaspring#containermanaged">Spring
	 *      container-managed transaction examples</a>
	 * @param entity
	 *            Salecode entity to update
	 * @return Salecode the persisted Salecode entity instance, may not be the
	 *         same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public Salecode update(Salecode entity);

	public Salecode findById(String id);

	/**
	 * Find all Salecode entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the Salecode property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Salecode> found by query
	 */
	public List<Salecode> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<Salecode> findByTdLocati(Object tdLocati,
			int... rowStartIdxAndCount);

	public List<Salecode> findByTdSlaugsit(Object tdSlaugsit,
			int... rowStartIdxAndCount);

	/**
	 * Find all Salecode entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<Salecode> all Salecode entities
	 */
	public List<Salecode> findAll(int... rowStartIdxAndCount);
}