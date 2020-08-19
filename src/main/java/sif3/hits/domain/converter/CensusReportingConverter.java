package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.CensusReportingType;
import sif.dd.au30.model.CensusStaffListType;
import sif.dd.au30.model.CensusStaffType;
import sif.dd.au30.model.CensusStudentListType;
import sif.dd.au30.model.CensusStudentType;
import sif.dd.au30.model.EntityContactInfoType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.CensusReporting;
import sif3.hits.domain.model.CensusReportingEntityContact;
import sif3.hits.domain.model.CensusReportingStaff;
import sif3.hits.domain.model.CensusReportingStudent;
import sif3.hits.utils.UsesConstants;

@Component
public class CensusReportingConverter extends HitsConverter<CensusReportingType, CensusReporting>
		implements UsesConstants {

	@Autowired
	HitsConverter<EntityContactInfoType, CensusReportingEntityContact> censusReportingEntityContactConverter;
	
	@Autowired
	HitsConverter<CensusStaffType, CensusReportingStaff> censusReportingStaffConverter;
	
	@Autowired
	HitsConverter<CensusStudentType, CensusReportingStudent> censusReportingStudentConverter;

	public CensusReportingConverter() {
		super(CensusReportingType.class, CensusReporting.class);
	}

	@Override
	public void toSifModel(CensusReporting source, CensusReportingType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();
			
			target.setEntityLevel(objectFactory.createCensusReportingTypeEntityLevel(source.getEntityLevel()));
			target.setCommonwealthId(source.getCommonwealthId());
			target.setEntityName(objectFactory.createCensusReportingTypeEntityName(source.getEntityName()));
			target.setEntityContact(censusReportingEntityContactConverter.toSifModel(source.getEntityContact()));
			
			List<CensusStaffType> censusStaffTypeList = censusReportingStaffConverter.toSifModelList(source.getCensusStaffList());
			if (!censusStaffTypeList.isEmpty()) {
				CensusStaffListType censusStaffListType = objectFactory.createCensusStaffListType();
				censusStaffListType.getCensusStaff().addAll(censusStaffTypeList);
				target.setCensusStaffList(objectFactory.createCensusReportingTypeCensusStaffList(censusStaffListType));
			}
			
			List<CensusStudentType> censusStudentTypeList = censusReportingStudentConverter.toSifModelList(source.getCensusStudentList());
			if (!censusStudentTypeList.isEmpty()) {
				CensusStudentListType censusStudentListType = objectFactory.createCensusStudentListType();
				censusStudentListType.getCensusStudent().addAll(censusStudentTypeList);
				target.setCensusStudentList(objectFactory.createCensusReportingTypeCensusStudentList(censusStudentListType));
			}
		}
	}

	@Override
	public void toHitsModel(CensusReportingType source, CensusReporting target) {
		if (source != null && target != null) {
			target.setEntityLevel(getJAXBValue(source.getEntityLevel()));
			target.setCommonwealthId(source.getCommonwealthId());
			target.setEntityName(getJAXBValue(source.getEntityName()));
			target.setEntityContact(censusReportingEntityContactConverter.toHitsModel(source.getEntityContact()));
			
			if (target.getCensusStaffList() == null) {
				target.setCensusStaffList(new ArrayList<>());
			}
			target.getCensusStaffList().clear();
			CensusStaffListType censusStaffListType = getJAXBValue(source.getCensusStaffList());
			if (censusStaffListType != null) {
				List<CensusReportingStaff> censusReportingStaffList = censusReportingStaffConverter.toHitsModelList(censusStaffListType.getCensusStaff());
				for (CensusReportingStaff censusReportingStaff : censusReportingStaffList ) {
					target.getCensusStaffList().add(censusReportingStaff);
					censusReportingStaff.setCensusReporting(target);
				}
			}
			
			if (target.getCensusStudentList() == null) {
				target.setCensusStudentList(new ArrayList<>());
			}
			target.getCensusStudentList().clear();
			CensusStudentListType censusStudentListType = getJAXBValue(source.getCensusStudentList());
			if (censusStudentListType != null) {
				List<CensusReportingStudent> censusReportingStudentList = censusReportingStudentConverter.toHitsModelList(censusStudentListType.getCensusStudent());
				for (CensusReportingStudent censusReportingStudent : censusReportingStudentList ) {
					target.getCensusStudentList().add(censusReportingStudent);
					censusReportingStudent.setCensusReporting(target);
				}
			}
		}
	}

}