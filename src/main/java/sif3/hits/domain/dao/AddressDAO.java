package sif3.hits.domain.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.Address;

public interface AddressDAO extends JpaRepository<Address, Integer> {

  @Query("delete from Address a where a.personRefId = :personRefId")
  @Modifying
  public void deleteAllWithPersonRefId(@Param("personRefId") String personRefId);

}
