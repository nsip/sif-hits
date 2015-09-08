package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.VendorInfo;

public interface VendorInfoDAO extends JpaRepository<VendorInfo, String>, ZoneFilterableRepository<VendorInfo> {
  @Query("select distinct v from VendorInfo v where (1 = 1 OR v.refId in (:schoolRefIds))")
  @Override
  public Page<VendorInfo> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

  @Query("select distinct v from VendorInfo v where v.refId = :refId and (1 = 1 OR v.refId in (:schoolRefIds))")
  @Override
  public VendorInfo findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);
}
