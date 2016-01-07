package com.xjtu.sglab.shems.dao;

import java.sql.Timestamp;
import java.util.List;

import com.xjtu.sglab.shems.entity.LampStatus;

/**
 * Interface for LampStatusDAO.
 * 
 * @author MyEclipse Persistence Tools
 */

public interface ILampStatusDAO {
	/**
	 * Perform an initial save of a previously unsaved LampStatus entity. All
	 * subsequent persist actions of this entity should use the #update()
	 * method. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#persist(Object)
	 * EntityManager#persist} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ILampStatusDAO.save(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            LampStatus entity to persist
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void save(LampStatus entity);

	/**
	 * Delete a persistent LampStatus entity. This operation must be performed
	 * within the a database transaction context for the entity's data to be
	 * permanently deleted from the persistence store, i.e., database. This
	 * method uses the {@link javax.persistence.EntityManager#remove(Object)
	 * EntityManager#delete} operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * ILampStatusDAO.delete(entity);
	 * EntityManagerHelper.commit();
	 * entity = null;
	 * </pre>
	 * 
	 * @param entity
	 *            LampStatus entity to delete
	 * @throws RuntimeException
	 *             when the operation fails
	 */
	public void delete(LampStatus entity);

	/**
	 * Persist a previously saved LampStatus entity and return it or a copy of
	 * it to the sender. A copy of the LampStatus entity parameter is returned
	 * when the JPA persistence mechanism has not previously been tracking the
	 * updated entity. This operation must be performed within the a database
	 * transaction context for the entity's data to be permanently saved to the
	 * persistence store, i.e., database. This method uses the
	 * {@link javax.persistence.EntityManager#merge(Object) EntityManager#merge}
	 * operation.
	 * 
	 * <pre>
	 * EntityManagerHelper.beginTransaction();
	 * entity = ILampStatusDAO.update(entity);
	 * EntityManagerHelper.commit();
	 * </pre>
	 * 
	 * @param entity
	 *            LampStatus entity to update
	 * @return LampStatus the persisted LampStatus entity instance, may not be
	 *         the same
	 * @throws RuntimeException
	 *             if the operation fails
	 */
	public LampStatus update(LampStatus entity);

	public LampStatus findById(Integer id);

	/**
	 * Find all LampStatus entities with a specific property value.
	 * 
	 * @param propertyName
	 *            the name of the LampStatus property to query
	 * @param value
	 *            the property value to match
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<LampStatus> found by query
	 */
	public List<LampStatus> findByProperty(String propertyName, Object value,
			int... rowStartIdxAndCount);

	public List<LampStatus> findByLampStatus(Object lampStatus,
			int... rowStartIdxAndCount);

	public List<LampStatus> findByIsControlledByUser(Object isControlledByUser,
			int... rowStartIdxAndCount);

	public List<LampStatus> findByIsAlreadyControlled(
			Object isAlreadyControlled, int... rowStartIdxAndCount);

	/**
	 * Find all LampStatus entities.
	 * 
	 * @param rowStartIdxAndCount
	 *            Optional int varargs. rowStartIdxAndCount[0] specifies the the
	 *            row index in the query result-set to begin collecting the
	 *            results. rowStartIdxAndCount[1] specifies the the maximum
	 *            count of results to return.
	 * @return List<LampStatus> all LampStatus entities
	 */
	public List<LampStatus> findAll(int... rowStartIdxAndCount);
}