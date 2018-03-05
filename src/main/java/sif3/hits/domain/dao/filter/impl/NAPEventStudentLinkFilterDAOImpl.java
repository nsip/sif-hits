package sif3.hits.domain.dao.filter.impl;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import sif.dd.au30.model.NAPEventStudentLinkType;
import sif3.hits.domain.dao.filter.NAPEventStudentLinkFilterDAO;
import sif3.hits.domain.model.NAPEventStudentLink;

@Repository
public class NAPEventStudentLinkFilterDAOImpl extends BaseFilterableRepository<NAPEventStudentLink, NAPEventStudentLinkType> implements NAPEventStudentLinkFilterDAO {
    public NAPEventStudentLinkFilterDAOImpl() {
        super(NAPEventStudentLink.class, NAPEventStudentLinkType.class);
    }

    @Override
    protected void addExtraExampleCriteria(Criteria criteria, NAPEventStudentLink example, NAPEventStudentLinkType input) {
        if (input != null) {
            if (needsFilter(input.getStudentPersonalRefId())) {
                criteria.createAlias("studentPersonal", "student");
                criteria.add(Restrictions.eq("student.refId", input.getStudentPersonalRefId().getValue()));
            }
            if (StringUtils.isNotBlank(input.getSchoolACARAId())) {
                criteria.createAlias("schoolInfo", "school");
                criteria.add(Restrictions.eq("school.acaraId", input.getSchoolACARAId()));
            }
            if (needsFilter(input.getNAPTestRefId())) {
                criteria.createAlias("napTest", "test");
                criteria.add(Restrictions.eq("test.refId", input.getNAPTestRefId().getValue()));
            }
        }
    }
    
    @Override
    protected void addServicePathCriteria(Criteria criteria, String key, String value) {
        if ("StudentPersonals".equals(key)) {
            criteria.createAlias("studentPersonal", "student");
            criteria.add(Restrictions.eq("student.refId", value));
        } else if ("SchoolInfos".equals(key)) {
            criteria.createAlias("schoolInfo", "school");
            criteria.add(Restrictions.eq("school.refId", value));
        } else {
            super.addServicePathCriteria(criteria, key, value);
        }
    }
}
