package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.JournalCollectionType;
import sif.dd.au30.model.JournalType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.JournalConverter;
import sif3.hits.domain.dao.JournalDAO;
import sif3.hits.domain.dao.ZoneFilterableRepository;
import sif3.hits.domain.model.Journal;

@Service
public class JournalService
    extends BaseService<JournalType, JournalCollectionType, Journal> {

  @Autowired
  private JournalDAO journalDAO;

  @Override
  public JpaRepository<Journal, String> getDAO() {
    return journalDAO;
  }

  @Override
  public ZoneFilterableRepository<Journal> getZoneFilterableDAO() {
    return journalDAO;
  }

  @Autowired
  private JournalConverter locationInfoConverter;

  @Override
  public HitsConverter<JournalType, Journal> getConverter() {
    return locationInfoConverter;
  }

  @Override
  protected JournalCollectionType getCollection(List<JournalType> items) {
    JournalCollectionType result = new JournalCollectionType();
    if (items != null) {
      result.getJournal().addAll(items);
    }
    return result;
  }

  @Override
  protected Journal getFiltered(String refId, java.util.List<String> schoolRefIds) {
    Journal result = null;
    if (schoolRefIds != null && !schoolRefIds.isEmpty()) {
      result = journalDAO.findOneWithFilter(refId, schoolRefIds);
    }
    return result;
  }
}
