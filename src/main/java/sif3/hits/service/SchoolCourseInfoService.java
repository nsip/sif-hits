package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.SchoolCourseInfoCollectionType;
import sif.dd.au30.model.SchoolCourseInfoType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.SchoolCourseInfoConverter;
import sif3.hits.domain.dao.SchoolCourseInfoDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.SchoolCourseInfoFilterDAO;
import sif3.hits.domain.model.SchoolCourseInfo;

@Service
public class SchoolCourseInfoService
		extends BaseService<SchoolCourseInfoType, SchoolCourseInfoCollectionType, SchoolCourseInfo> {

	@Autowired
	private SchoolCourseInfoConverter schoolCourseInfoConverter;

	@Autowired
	private SchoolCourseInfoDAO schoolCourseInfoDAO;

	@Autowired
	private SchoolCourseInfoFilterDAO schoolCourseInfoFilterDAO;

	@Override
	protected SchoolCourseInfoCollectionType getCollection(List<SchoolCourseInfoType> items) {
		SchoolCourseInfoCollectionType result = new SchoolCourseInfoCollectionType();
		if (items != null) {
			result.getSchoolCourseInfo().addAll(items);
		}
		return result;
	}

	@Override
	protected HitsConverter<SchoolCourseInfoType, SchoolCourseInfo> getConverter() {
		return schoolCourseInfoConverter;
	}

	@Override
	protected JpaRepository<SchoolCourseInfo, String> getDAO() {
		return schoolCourseInfoDAO;
	}

	@Override
	protected FilterableRepository<SchoolCourseInfo, SchoolCourseInfoType> getFilterableDAO() {
		return schoolCourseInfoFilterDAO;
	}
}
