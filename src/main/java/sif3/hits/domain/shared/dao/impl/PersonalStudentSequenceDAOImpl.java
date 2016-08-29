package sif3.hits.domain.shared.dao.impl;

import java.math.BigInteger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import sif3.hits.domain.shared.dao.PersonalStudentSequenceDAO;

@Repository
public class PersonalStudentSequenceDAOImpl implements PersonalStudentSequenceDAO {
  @PersistenceContext(unitName = "sif3.hits.shared")
  protected EntityManager entityManager;

  @Override
  public Integer getNextId() {
    entityManager.createNativeQuery("update PSISequence set id = last_insert_id(id+1)").executeUpdate();
    Object id = entityManager.createNativeQuery("select last_insert_id()").setMaxResults(1).getSingleResult();
    return ((BigInteger) id).intValue();
  }
}
