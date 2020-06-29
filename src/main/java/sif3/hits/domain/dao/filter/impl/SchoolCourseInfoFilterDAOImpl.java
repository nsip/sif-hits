package sif3.hits.domain.dao.filter.impl;

import org.springframework.stereotype.Repository;

import sif.dd.au30.model.SchoolCourseInfoType;
import sif3.hits.domain.dao.filter.SchoolCourseInfoFilterDAO;
import sif3.hits.domain.model.SchoolCourseInfo;

@Repository
public class SchoolCourseInfoFilterDAOImpl extends BaseFilterableRepository<SchoolCourseInfo, SchoolCourseInfoType>
		implements SchoolCourseInfoFilterDAO {
	public SchoolCourseInfoFilterDAOImpl() {
		super(SchoolCourseInfo.class, SchoolCourseInfoType.class);
	}
}
