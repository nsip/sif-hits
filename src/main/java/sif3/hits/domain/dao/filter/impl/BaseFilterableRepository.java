package sif3.hits.domain.dao.filter.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import sif3.hits.domain.criteria.TypedCriteria;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.rest.dto.KeyValuePair;

public abstract class BaseFilterableRepository<T> implements FilterableRepository<T>{
  
  @PersistenceContext(unitName = "sif3.hits.dynamic")
  protected EntityManager entityManager;

  protected final Class<T> returnType;
  
  public BaseFilterableRepository(Class<T> returnType, EntityManager entityManager) {
    this.returnType = returnType;
    this.entityManager = entityManager;
  }
  
  public BaseFilterableRepository(Class<T> returnType) {
    this.returnType = returnType;
  }

  /**
   * Override for custom query by example
   * 
   * @param criteria
   * @param example
   */
  protected void addExampleCriteria(Criteria criteria, T example) {
    criteria.add(Example.create(example));
  }

  /**
   * Override for custom zone filtering
   * 
   * @param criteria
   * @param zoneId
   */
  protected void addZoneCriteria(Criteria criteria, String zoneId) {

  }

  /**
   * Override for custom primary key filtering
   * 
   * @param criteria
   * @param refId
   */
  protected void andPrimaryKeyCriteria(Criteria criteria, String refId) {
    criteria.add(Restrictions.eq("refId", refId));
  }
  
  /**
   * Must override for service path queries
   * 
   * @param criteria
   * @param key
   * @param value
   */
  protected void addServicePathCriteria(Criteria criteria, String key, String value) {
    criteria.add(Restrictions.sqlRestriction("1 = 0"));
  }

  @Override
  public final Page<T> findAllWithZone(String zoneId, Pageable pageable) {
    TypedCriteria<T> typedCriteria = new TypedCriteria<T>(entityManager, returnType);
    addZoneCriteria(typedCriteria.getCriteria(), zoneId);
    return applyPage(typedCriteria.getPage(pageable), pageable);
  }

  @Override
  public final T findOneWithZone(String refId, String zoneId) {
    TypedCriteria<T> typedCriteria = new TypedCriteria<T>(entityManager, returnType);
    addZoneCriteria(typedCriteria.getCriteria(), zoneId);
    andPrimaryKeyCriteria(typedCriteria.getCriteria(), refId);
    return typedCriteria.uniqueResult();
  }

  @Override
  public final Page<T> findAllWithExample(T example, String zoneId, Pageable pageable) {
    TypedCriteria<T> typedCriteria = new TypedCriteria<T>(entityManager, returnType);
    addExampleCriteria(typedCriteria.getCriteria(), example);
    addZoneCriteria(typedCriteria.getCriteria(), zoneId);
    return applyPage(typedCriteria.getPage(pageable), pageable);
  }
  
  @Override
  public final Page<T> findAllWithServicePaths(List<KeyValuePair> servicePaths, String zoneId, Pageable pageable) {
    TypedCriteria<T> typedCriteria = new TypedCriteria<T>(entityManager, returnType);
    for (KeyValuePair keyValuePair : servicePaths) {
      addServicePathCriteria(typedCriteria.getCriteria(), keyValuePair.getKey(), keyValuePair.getValue());
    }
    addZoneCriteria(typedCriteria.getCriteria(), zoneId);
    return applyPage(typedCriteria.getPage(pageable), pageable);
  }

  private Page<T> applyPage(List<T> list, Pageable pageable) {
    return new PageImpl<T>(list, pageable, list.size());
  }
}
