package sif3.hits.domain.dao.filter;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import sif3.hits.rest.dto.KeyValuePair;

public interface FilterableRepository<T,SE> {

  public Page<T> findAllWithZone(String zoneId, Pageable pageable);

  public T findOneWithZone(String refId, String zoneId);
  
  public Page<T> findAllWithExample(T example, SE input, String zoneId, Pageable pageable);
  
  public Page<T> findAllWithServicePaths(List<KeyValuePair> servicePaths, String zoneId, Pageable pageable);

}
