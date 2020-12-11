package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AGRuleListType;
import sif.dd.au30.model.AGRuleType;
import sif.dd.au30.model.EntityContactInfoType;
import sif.dd.au30.model.FQContextualQuestionListType;
import sif.dd.au30.model.FQContextualQuestionType;
import sif.dd.au30.model.FQItemListType;
import sif.dd.au30.model.FQItemType;
import sif.dd.au30.model.FQReportingType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.FQItem;
import sif3.hits.domain.model.FQReporting;
import sif3.hits.domain.model.FQReportingAGRule;
import sif3.hits.domain.model.FQReportingEntityContact;
import sif3.hits.domain.model.FQReportingFQContextualQuestion;
import sif3.hits.utils.UsesConstants;

@Component
public class FQReportingConverter extends HitsConverter<FQReportingType, FQReporting> implements UsesConstants {

	@Autowired
	HitsConverter<EntityContactInfoType, FQReportingEntityContact> entityContactConverter;

	@Autowired
	HitsConverter<FQContextualQuestionType, FQReportingFQContextualQuestion> fqContextualQuestionConverter;

	@Autowired
	HitsConverter<FQItemType, FQItem> fqItemConverter;

	@Autowired
	HitsConverter<AGRuleType, FQReportingAGRule> agRuleConverter;

	public FQReportingConverter() {
		super(FQReportingType.class, FQReporting.class);
	}

	@Override
	public void toSifModel(FQReporting source, FQReportingType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setEntityLevel(source.getEntityLevel());
			target.setSchoolInfoRefId(objectFactory.createFQReportingTypeSchoolInfoRefId(source.getSchoolInfoRefId()));
			target.setLocalId(objectFactory.createFQReportingTypeLocalId(source.getLocalId()));
			target.setStateProvinceId(objectFactory.createFQReportingTypeStateProvinceId(source.getStateProvinceId()));
			target.setCommonwealthId(source.getCommonwealthId());
			target.setACARAId(objectFactory.createFQReportingTypeACARAId(source.getAcaraId()));
			target.setEntityName(objectFactory.createFQReportingTypeEntityName(source.getEntityName()));

			EntityContactInfoType entityContact = entityContactConverter.toSifModel(source.getEntityContact());
			target.setEntityContact(entityContact);

			List<FQContextualQuestionType> contextualQuestions = fqContextualQuestionConverter
					.toSifModelList(source.getContextualQuestionList());
			FQContextualQuestionListType fqContextualQuestionListType = null;
			if (!contextualQuestions.isEmpty()) {
				fqContextualQuestionListType = objectFactory.createFQContextualQuestionListType();
				fqContextualQuestionListType.getFQContextualQuestion().addAll(contextualQuestions);
			}
			target.setFQContextualQuestionList(
					objectFactory.createFQReportingTypeFQContextualQuestionList(fqContextualQuestionListType));

			List<FQItemType> fqItems = fqItemConverter.toSifModelList(source.getFqItemList());
			FQItemListType fqItemListType = null;
			if (!fqItems.isEmpty()) {
				fqItemListType = objectFactory.createFQItemListType();
				fqItemListType.getFQItem().addAll(fqItems);
			}
			target.setFQItemList(fqItemListType);

			List<AGRuleType> agRules = agRuleConverter.toSifModelList(source.getAgRuleList());
			AGRuleListType agRuleListType = null;
			if (!agRules.isEmpty()) {
				agRuleListType = objectFactory.createAGRuleListType();
				agRuleListType.getAGRule().addAll(agRules);
			}
			target.setAGRuleList(objectFactory.createFQReportingTypeAGRuleList(agRuleListType));
		}
	}

	@Override
	public void toHitsModel(FQReportingType source, FQReporting target) {
		if (source != null && target != null) {
			target.setEntityLevel(source.getEntityLevel());
			target.setSchoolInfoRefId(getJAXBValue(source.getSchoolInfoRefId()));
			target.setLocalId(getJAXBValue(source.getLocalId()));
			target.setStateProvinceId(getJAXBValue(source.getStateProvinceId()));
			target.setCommonwealthId(source.getCommonwealthId());
			target.setAcaraId(getJAXBValue(source.getACARAId()));
			target.setEntityName(getJAXBValue(source.getEntityName()));

			FQReportingEntityContact entityContact = entityContactConverter.toHitsModel(source.getEntityContact());
			target.setEntityContact(entityContact);

			if (target.getContextualQuestionList() == null) {
				target.setContextualQuestionList(new ArrayList<>());
			}
			target.getContextualQuestionList().clear();
			FQContextualQuestionListType fqContextualQuestionListType = getJAXBValue(
					source.getFQContextualQuestionList());
			if (fqContextualQuestionListType != null) {
				List<FQReportingFQContextualQuestion> contextualQuestions = fqContextualQuestionConverter
						.toHitsModelList(fqContextualQuestionListType.getFQContextualQuestion());
				for (FQReportingFQContextualQuestion contextualQuestion : contextualQuestions) {
					target.getContextualQuestionList().add(contextualQuestion);
					contextualQuestion.setFqReporting(target);
				}
			}

			if (target.getFqItemList() == null) {
				target.setFqItemList(new ArrayList<>());
			}
			target.getFqItemList().clear();
			if (source.getFQItemList() != null) {
				List<FQItem> fqItems = fqItemConverter.toHitsModelList(source.getFQItemList().getFQItem());
				for (FQItem fqItem : fqItems) {
					target.getFqItemList().add(fqItem);
					fqItem.setFqReporting(target);
				}
			}

			if (target.getAgRuleList() == null) {
				target.setAgRuleList(new ArrayList<>());
			}
			target.getAgRuleList().clear();
			AGRuleListType agRuleListType = getJAXBValue(source.getAGRuleList());
			if (agRuleListType != null) {
				List<FQReportingAGRule> agRules = agRuleConverter.toHitsModelList(agRuleListType.getAGRule());
				for (FQReportingAGRule agRule : agRules) {
					target.getAgRuleList().add(agRule);
					agRule.setFqReporting(target);
				}
			}
		}
	}
}
