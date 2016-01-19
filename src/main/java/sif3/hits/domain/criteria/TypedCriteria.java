package sif3.hits.domain.criteria;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.data.domain.Pageable;

public class TypedCriteria<T> {

  private Class<T> returnType;
  private Criteria criteria;

  public TypedCriteria(EntityManager entityManager, Class<T> returnType) {
    Session session = (Session) entityManager.getDelegate();
    this.returnType = returnType;
    this.criteria = session.createCriteria(returnType);
  }

  public Criteria getCriteria() {
    return this.criteria;
  }

  public List<T> getPage(Pageable pageable) {
    List<T> typedResult = new ArrayList<T>();
    List<?> result = this.criteria.setFetchSize(pageable.getPageSize()).setFirstResult(pageable.getOffset()).list();
    for (Object object : result) {
      if (returnType.isAssignableFrom(object.getClass())) {
        typedResult.add(returnType.cast(object));
      }
    }
    return typedResult;
  }

  public T uniqueResult() {
    T result = null;
    Object object = this.criteria.uniqueResult();
    if (object != null && returnType.isAssignableFrom(object.getClass())) {
      result = returnType.cast(object);
    }
    return result;
  }
}
