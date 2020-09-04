package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AGContextualQuestionListType;
import sif.dd.au30.model.AGContextualQuestionType;
import sif.dd.au30.model.AddressCollectionReportingType;
import sif.dd.au30.model.AddressCollectionStudentListType;
import sif.dd.au30.model.AddressCollectionStudentType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.AddressAGContextualQuestion;
import sif3.hits.domain.model.AddressCollectionReporting;
import sif3.hits.domain.model.AddressCollectionReportingStudent;
import sif3.hits.utils.UsesConstants;

@Component
public class AddressCollectionReportingConverter
		extends HitsConverter<AddressCollectionReportingType, AddressCollectionReporting> implements UsesConstants {

	@Autowired
	AddressCollectionReportingEntityContactConverter entityContactConverter;

	@Autowired
	AddressCollectionReportingAGContextualQuestionConverter agContextualQuestionConverter;

	@Autowired
	AddressCollectionReportingStudentConverter addressCollectionStudentConverter;

	public AddressCollectionReportingConverter() {
		super(AddressCollectionReportingType.class, AddressCollectionReporting.class);
	}

	@Override
	public void toSifModel(AddressCollectionReporting source, AddressCollectionReportingType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setEntityLevel(
					objectFactory.createAddressCollectionReportingTypeEntityLevel(source.getEntityLevel()));
			target.setSchoolInfoRefId(
					objectFactory.createAddressCollectionReportingTypeSchoolInfoRefId(source.getSchoolInfoRefId()));
			target.setLocalId(objectFactory.createAddressCollectionReportingTypeLocalId(source.getLocalId()));
			target.setStateProvinceId(
					objectFactory.createAddressCollectionReportingTypeStateProvinceId(source.getStateProvinceId()));
			target.setCommonwealthId(source.getCommonwealthId());
			target.setACARAId(objectFactory.createAddressCollectionReportingTypeACARAId(source.getAcaraId()));
			target.setEntityName(objectFactory.createAddressCollectionReportingTypeEntityName(source.getEntityName()));

			target.setEntityContact(entityContactConverter.toSifModel(source.getEntityContact()));

			AGContextualQuestionListType agContextualQuestionListType = null;
			List<AGContextualQuestionType> agContextualQuestionTypes = agContextualQuestionConverter
					.toSifModelList(source.getAGContextualQuestions());
			if (!agContextualQuestionTypes.isEmpty()) {
				agContextualQuestionListType = objectFactory.createAGContextualQuestionListType();
				agContextualQuestionListType.getAGContextualQuestion().addAll(agContextualQuestionTypes);
			}
			target.setAGContextualQuestionList(objectFactory
					.createAddressCollectionReportingTypeAGContextualQuestionList(agContextualQuestionListType));

			List<AddressCollectionStudentType> addressCollectionStudentTypes = addressCollectionStudentConverter
					.toSifModelList(source.getAddressCollectionReportingStudents());
			AddressCollectionStudentListType addressCollectionStudentListType = null;
			if (!addressCollectionStudentTypes.isEmpty()) {
				addressCollectionStudentListType = objectFactory.createAddressCollectionStudentListType();
				addressCollectionStudentListType.getAddressCollectionStudent().addAll(addressCollectionStudentTypes);
			}
			target.setAddressCollectionStudentList(
					objectFactory.createAddressCollectionReportingTypeAddressCollectionStudentList(
							addressCollectionStudentListType));
		}
	}

	@Override
	public void toHitsModel(AddressCollectionReportingType source, AddressCollectionReporting target) {
		if (source != null && target != null) {
			target.setEntityLevel(getJAXBValue(source.getEntityLevel()));
			target.setSchoolInfoRefId(getJAXBValue(source.getSchoolInfoRefId()));
			target.setLocalId(getJAXBValue(source.getLocalId()));
			target.setStateProvinceId(getJAXBValue(source.getStateProvinceId()));
			target.setCommonwealthId(source.getCommonwealthId());
			target.setAcaraId(getJAXBValue(source.getACARAId()));
			target.setEntityName(getJAXBValue(source.getEntityName()));
			target.setEntityContact(entityContactConverter.toHitsModel(source.getEntityContact()));

			if (target.getAGContextualQuestions() == null) {
				target.setAGContextualQuestions(new ArrayList<>());
			}
			target.getAGContextualQuestions().clear();
			AGContextualQuestionListType agContextualQuestionListType = getJAXBValue(
					source.getAGContextualQuestionList());
			if (agContextualQuestionListType != null) {
				List<AddressAGContextualQuestion> agContextualQuestions = agContextualQuestionConverter
						.toHitsModelList(agContextualQuestionListType.getAGContextualQuestion());
				for (AddressAGContextualQuestion agContextualQuestion : agContextualQuestions) {
					target.getAGContextualQuestions().add(agContextualQuestion);
					agContextualQuestion.setAddressCollectionReporting(target);
				}
			}

			if (target.getAddressCollectionReportingStudents() == null) {
				target.setAddressCollectionReportingStudents(new ArrayList<>());
			}
			target.getAddressCollectionReportingStudents().clear();
			AddressCollectionStudentListType addressCollectionStudentListType = getJAXBValue(
					source.getAddressCollectionStudentList());
			if (addressCollectionStudentListType != null) {
				List<AddressCollectionReportingStudent> addressCollectionStudents = addressCollectionStudentConverter
						.toHitsModelList(addressCollectionStudentListType.getAddressCollectionStudent());
				for (AddressCollectionReportingStudent addressCollectionStudent : addressCollectionStudents) {
					target.getAddressCollectionReportingStudents().add(addressCollectionStudent);
					addressCollectionStudent.setAddressCollectionReporting(target);
				}
			}
		}
	}
}
