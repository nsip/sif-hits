package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif.dd.au30.model.JournalType;
import sif3.hits.domain.dao.filter.JournalFilterDAO;
import sif3.hits.domain.model.Journal;

@Repository
public class JournalFilterDAOImpl extends BaseFilterableRepository<Journal, JournalType> implements JournalFilterDAO {
    public JournalFilterDAOImpl() {
        super(Journal.class, JournalType.class);
    }
}
