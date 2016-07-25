package sif3.hits.domain.shared.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.shared.model.ApplicationKeyUrl;

public interface ApplicationKeyUrlDAO extends JpaRepository<ApplicationKeyUrl, Long> {

  @Query("select a from ApplicationKeyUrl a where a.applicationKey is null")
  public ApplicationKeyUrl findDefault();

  @Query("select a from ApplicationKeyUrl a where a.applicationKey = :applicationKey")
  public ApplicationKeyUrl findOneWithApplicationKey(@Param("applicationKey") String applicationKey);

}
