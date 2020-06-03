package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.TermInfoCollectionType;
import sif.dd.au30.model.TermInfoType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.TermInfoConverter;
import sif3.hits.domain.dao.TermInfoDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.TermInfoFilterDAO;
import sif3.hits.domain.model.TermInfo;

@Service
public class TermInfoService extends BaseService<TermInfoType, TermInfoCollectionType, TermInfo> {

	@Autowired
	private TermInfoConverter termInfoConverter;

	@Autowired
	private TermInfoDAO termInfoDAO;

	@Autowired
	private TermInfoFilterDAO termInfoFilterDAO;

	@Override
	protected TermInfoCollectionType getCollection(List<TermInfoType> items) {
		TermInfoCollectionType result = new TermInfoCollectionType();
		if (items != null) {
			result.getTermInfo().addAll(items);
		}
		return result;
	}

	@Override
	protected HitsConverter<TermInfoType, TermInfo> getConverter() {
		return termInfoConverter;
	}

	@Override
	protected JpaRepository<TermInfo, String> getDAO() {
		return termInfoDAO;
	}

	@Override
	protected FilterableRepository<TermInfo, TermInfoType> getFilterableDAO() {
		return termInfoFilterDAO;
	}

	@Override
	protected void deleteChildObjects(TermInfo hitsObject) {
	}

	@Override
	protected boolean hasChildObjects(TermInfo hitsObject) {
		return true;
	}
}
