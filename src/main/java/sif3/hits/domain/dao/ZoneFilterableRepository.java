package sif3.hits.domain.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ZoneFilterableRepository<T> {

  public Page<T> findAllWithFilter(List<String> schoolRefIds, Pageable pageable);

  public T findOneWithFilter(String refId, List<String> schoolRefIds);

}
