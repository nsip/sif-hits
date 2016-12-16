package sif3.hits.domain.dao.filter.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sif3.hits.domain.dao.filter.NAPCodeFrameFilterDAO;
import sif3.hits.domain.model.NAPCodeFrame;

@Repository
public class NAPCodeFrameFilterDAOImpl extends BaseFilterableRepository<NAPCodeFrame> implements NAPCodeFrameFilterDAO {
  public NAPCodeFrameFilterDAOImpl() {
    super(NAPCodeFrame.class);
  }
  
  protected void addExampleCriteria(Criteria criteria, NAPCodeFrame example) {
    if (example.getNapTest() != null && StringUtils.isNotBlank(example.getNapTest().getRefId())) {
      criteria.add(Restrictions.eq("napTest.refId", example.getNapTest().getRefId()));
    }
  }
}
