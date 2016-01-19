package sif3.hits.domain.criteria;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
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
  
  public String getOrderAttribute() {
    return "refId";
  }

  public List<T> getPage(Pageable pageable) {
    List<T> typedResult = new ArrayList<T>();
    this.criteria.setMaxResults(pageable.getPageSize());
    this.criteria.setFirstResult(pageable.getOffset());
    this.criteria.addOrder(Order.asc(getOrderAttribute()));
    List<?> result = this.criteria.list();
        
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
