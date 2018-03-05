package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif.dd.au30.model.NAPTestType;
import sif3.hits.domain.dao.filter.NAPTestFilterDAO;
import sif3.hits.domain.model.NAPTest;

@Repository
public class NAPTestFilterDAOImpl extends BaseFilterableRepository<NAPTest, NAPTestType> implements NAPTestFilterDAO {
    public NAPTestFilterDAOImpl() {
        super(NAPTest.class, NAPTestType.class);
    }
}
