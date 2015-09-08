package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sif3.hits.domain.model.Invoice;

public interface InvoiceDAO extends JpaRepository<Invoice, String>, ZoneFilterableRepository<Invoice> {
  @Query("select distinct i from Invoice i where (1 = 1 OR i.refId in (:schoolRefIds))")
  @Override
  public Page<Invoice> findAllWithFilter(@Param("schoolRefIds") List<String> schoolRefIds, Pageable pageable);

  @Query("select distinct i from Invoice i where i.refId = :refId and (1 = 1 OR i.refId in (:schoolRefIds))")
  @Override
  public Invoice findOneWithFilter(@Param("refId") String refId, @Param("schoolRefIds") List<String> schoolRefIds);
}
