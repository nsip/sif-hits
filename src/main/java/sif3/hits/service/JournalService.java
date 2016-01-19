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
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.JournalFilterDAO;
import sif3.hits.domain.model.Journal;

@Service
public class JournalService extends BaseService<JournalType, JournalCollectionType, Journal> {

  @Autowired
  private JournalConverter journalConverter;

  @Autowired
  private JournalDAO journalDAO;

  @Autowired
  private JournalFilterDAO journalFilterDAO;

  @Override
  protected JournalCollectionType getCollection(List<JournalType> items) {
    JournalCollectionType result = new JournalCollectionType();
    if (items != null) {
      result.getJournal().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<JournalType, Journal> getConverter() {
    return journalConverter;
  }

  @Override
  protected JpaRepository<Journal, String> getDAO() {
    return journalDAO;
  }

  @Override
  protected FilterableRepository<Journal> getFilterableDAO() {
    return journalFilterDAO;
  }

}
