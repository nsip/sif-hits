package sif3.hits.domain.dao.filter.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.NAPCodeFrameType;
import sif3.hits.domain.dao.filter.NAPCodeFrameFilterDAO;
import sif3.hits.domain.model.NAPCodeFrame;

@Repository
public class NAPCodeFrameFilterDAOImpl extends BaseFilterableRepository<NAPCodeFrame, NAPCodeFrameType> implements NAPCodeFrameFilterDAO {
    public NAPCodeFrameFilterDAOImpl() {
        super(NAPCodeFrame.class, NAPCodeFrameType.class);
    }

    @Override
    protected void addExtraExampleCriteria(Criteria criteria, NAPCodeFrame example, NAPCodeFrameType input) {
        if (input != null) {
            if (StringUtils.isNotBlank(input.getNAPTestRefId())) {
                criteria.add(Restrictions.eq("napTest.refId", input.getNAPTestRefId()));
            }
        }
    }
}
