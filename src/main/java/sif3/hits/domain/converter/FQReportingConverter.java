package sif3.hits.domain.converter;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsYesOrNoCategoryType;
import sif.dd.au30.model.FQContextualQuestionListType;
import sif.dd.au30.model.FQContextualQuestionType;
import sif.dd.au30.model.FQItemListType;
import sif.dd.au30.model.FQItemType;
import sif.dd.au30.model.FQReportingType;
import sif.dd.au30.model.FQRuleListType;
import sif.dd.au30.model.FQRuleType;
import sif.dd.au30.model.SoftwareVendorInfoContainerType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.FQContextualQuestion;
import sif3.hits.domain.model.FQItem;
import sif3.hits.domain.model.FQReporting;
import sif3.hits.domain.model.FQRule;

@Component
public class FQReportingConverter extends HitsConverter<FQReportingType, FQReporting> {

    @Autowired
    FQEntityContactConverter entityContactConverter;

    public FQReportingConverter() {
        super(FQReportingType.class, FQReporting.class);
    }

    @Override
    public void toSifModel(FQReporting source, FQReportingType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();

            target.setRefId(source.getRefId());
            target.setFQYear(getYearValue(source.getFqYear()));
            target.setReportingAuthority(objectFactory.createFQReportingTypeReportingAuthority(source.getReportingAuthority()));
            target.setReportingAuthoritySystem(objectFactory.createFQReportingTypeReportingAuthoritySystem(source.getReportingAuthoritySystem()));
            target.setReportingAuthorityCommonwealthId(objectFactory.createFQReportingTypeReportingAuthorityCommonwealthId(source.getReportingAuthorityCommonwealthId()));
            target.setSystemSubmission(objectFactory.createFQReportingTypeSystemSubmission(getEnumValue(source.getSystemSubmission(), AUCodeSetsYesOrNoCategoryType.class)));
            target.setEntityLevel(objectFactory.createFQReportingTypeEntityLevel(source.getEntityLevel()));
            target.setSchoolInfoRefId(objectFactory.createFQReportingTypeSchoolInfoRefId(source.getSchoolInfoRefId()));
            target.setLocalId(objectFactory.createFQReportingTypeLocalId(source.getLocalId()));
            target.setStateProvinceId(objectFactory.createFQReportingTypeStateProvinceId(source.getStateProvinceId()));
            target.setCommonwealthId(objectFactory.createFQReportingTypeCommonwealthId(source.getCommonwealthId()));
            target.setACARAId(objectFactory.createFQReportingTypeACARAId(source.getAcaraId()));
            target.setEntityName(objectFactory.createFQReportingTypeEntityName(source.getEntityName()));
            target.setEntityContact(objectFactory.createFQReportingTypeEntityContact(entityContactConverter.toSifModel(source.getEntityContact())));
            
            if (StringUtils.isNotBlank(source.getSoftwareProduct()) || StringUtils.isNotBlank(source.getSoftwareVersion())) {
                SoftwareVendorInfoContainerType softwareVendor = objectFactory.createSoftwareVendorInfoContainerType();
                softwareVendor.setSoftwareProduct(objectFactory.createSoftwareVendorInfoContainerTypeSoftwareProduct(source.getSoftwareProduct()));
                softwareVendor.setSoftwareVersion(objectFactory.createSoftwareVendorInfoContainerTypeSoftwareVersion(source.getSoftwareVersion()));
                target.setSoftwareVendorInfo(objectFactory.createFQReportingTypeSoftwareVendorInfo(softwareVendor));
            }

            if (source.getFqContextualQuestionList() != null && !source.getFqContextualQuestionList().isEmpty()) {
                FQContextualQuestionListType fqContextualQuestionListType = objectFactory.createFQContextualQuestionListType();
                for (FQContextualQuestion question : source.getFqContextualQuestionList()) {
                    FQContextualQuestionType fqContextualQuestionType = objectFactory.createFQContextualQuestionType();
                    fqContextualQuestionType.setFQContext(question.getContext());
                    fqContextualQuestionType.setFQAnswer(question.getAnswer());
                    fqContextualQuestionListType.getFQContextualQuestion().add(fqContextualQuestionType);
                }
                target.setFQContextualQuestionList(objectFactory.createFQReportingTypeFQContextualQuestionList(fqContextualQuestionListType));
            }

            if (source.getFqItemList() != null && !source.getFqItemList().isEmpty()) {
                FQItemListType fqItemListType = objectFactory.createFQItemListType();
                for (FQItem item : source.getFqItemList()) {
                    FQItemType fqItemType = objectFactory.createFQItemType();
                    fqItemType.setBoardingAmount(objectFactory.createFQItemTypeBoardingAmount(getBigDecimalValue(item.getBoardingAmount())));
                    fqItemType.setDioceseAmount(objectFactory.createFQItemTypeDioceseAmount(getBigDecimalValue(item.getDioceseAmount())));
                    fqItemType.setSystemAmount(objectFactory.createFQItemTypeSystemAmount(getBigDecimalValue(item.getSystemAmount())));
                    fqItemType.setTuitionAmount(objectFactory.createFQItemTypeTuitionAmount(getBigDecimalValue(item.getTuitionAmount())));
                    fqItemType.setFQComments(item.getFqComment());
                    fqItemType.setFQItemCode(item.getFqItemCode());
                    fqItemListType.getFQItem().add(fqItemType);
                }
                target.setFQItemList(objectFactory.createFQReportingTypeFQItemList(fqItemListType));
            }

            if (source.getFqRuleList() != null && !source.getFqRuleList().isEmpty()) {
                FQRuleListType fqRuleListType = objectFactory.createFQRuleListType();
                for (FQRule rule : source.getFqRuleList()) {
                    FQRuleType fqRuleType = objectFactory.createFQRuleType();
                    fqRuleType.setFQRuleCode(objectFactory.createFQRuleTypeFQRuleCode(rule.getFqRuleCode()));
                    fqRuleType.setFQRuleComment(objectFactory.createFQRuleTypeFQRuleComment(rule.getFqRuleComment()));
                    fqRuleListType.getFQRule().add(fqRuleType);
                }
                target.setFQRuleList(objectFactory.createFQReportingTypeFQRuleList(fqRuleListType));
            }
        }
    }

    @Override
    public void toHitsModel(FQReportingType source, FQReporting target) {
        if (source != null && target != null) {
            target.setRefId(source.getRefId());
            target.setFqYear(getYearValue(source.getFQYear()));
            target.setReportingAuthority(getJAXBValue(source.getReportingAuthority()));
            target.setReportingAuthoritySystem(getJAXBValue(source.getReportingAuthoritySystem()));
            target.setReportingAuthorityCommonwealthId(getJAXBValue(source.getReportingAuthorityCommonwealthId()));
            target.setSystemSubmission(getJAXBEnumValue(source.getSystemSubmission()));
            target.setEntityLevel(getJAXBValue(source.getEntityLevel()));
            target.setSchoolInfoRefId(getJAXBValue(source.getSchoolInfoRefId()));
            target.setLocalId(getJAXBValue(source.getLocalId()));
            target.setStateProvinceId(getJAXBValue(source.getStateProvinceId()));
            target.setCommonwealthId(getJAXBValue(source.getCommonwealthId()));
            target.setAcaraId(getJAXBValue(source.getACARAId()));
            target.setEntityName(getJAXBValue(source.getEntityName()));
            
            SoftwareVendorInfoContainerType softwareVendor = getJAXBValue(source.getSoftwareVendorInfo());
            if (softwareVendor != null) {
                target.setSoftwareProduct(getJAXBValue(softwareVendor.getSoftwareProduct()));
                target.setSoftwareVersion(getJAXBValue(softwareVendor.getSoftwareVersion()));
            }
            
            
            target.setEntityContact(entityContactConverter.toHitsModel(getJAXBValue(source.getEntityContact())));
            if (!entityContactConverter.isPopulated(target.getEntityContact())) {
                target.setEntityContact(null);
            } else {
                target.getEntityContact().setFqReporting(target);
            }

            if (target.getFqContextualQuestionList() == null) {
                target.setFqContextualQuestionList(new ArrayList<FQContextualQuestion>());
            }
            target.getFqContextualQuestionList().clear();
            FQContextualQuestionListType fqContextualQuestionListType = getJAXBValue(source.getFQContextualQuestionList());
            if (fqContextualQuestionListType != null) {
                for (FQContextualQuestionType fqContextualQuestionType : fqContextualQuestionListType.getFQContextualQuestion()) {
                    FQContextualQuestion question = new FQContextualQuestion();
                    question.setAnswer(fqContextualQuestionType.getFQAnswer());
                    question.setContext(fqContextualQuestionType.getFQContext());
                    question.setFqReporting(target);
                    target.getFqContextualQuestionList().add(question);
                }
            }

            if (target.getFqItemList() == null) {
                target.setFqItemList(new ArrayList<FQItem>());
            }
            target.getFqItemList().clear();
            FQItemListType fqItemListType = getJAXBValue(source.getFQItemList());
            if (fqItemListType != null) {
                for (FQItemType fqItemType : fqItemListType.getFQItem()) {
                    FQItem item = new FQItem();
                    item.setBoardingAmount(getBigDecimalValue(getJAXBValue(fqItemType.getBoardingAmount())));
                    item.setDioceseAmount(getBigDecimalValue(getJAXBValue(fqItemType.getDioceseAmount())));
                    item.setSystemAmount(getBigDecimalValue(getJAXBValue(fqItemType.getSystemAmount())));
                    item.setTuitionAmount(getBigDecimalValue(getJAXBValue(fqItemType.getTuitionAmount())));
                    item.setFqComment(fqItemType.getFQComments());
                    item.setFqItemCode(fqItemType.getFQItemCode());
                    item.setFqReporting(target);
                    target.getFqItemList().add(item);
                }
            }

            if (target.getFqRuleList() == null) {
                target.setFqRuleList(new ArrayList<FQRule>());
            }
            target.getFqRuleList().clear();
            FQRuleListType fqRuleListType = getJAXBValue(source.getFQRuleList());
            if (fqRuleListType != null) {
                for (FQRuleType fqRuleType : fqRuleListType.getFQRule()) {
                    FQRule rule = new FQRule();
                    rule.setFqRuleCode(getJAXBValue(fqRuleType.getFQRuleCode()));
                    rule.setFqRuleComment(getJAXBValue(fqRuleType.getFQRuleComment()));
                    rule.setFqReporting(target);
                    target.getFqRuleList().add(rule);
                }
            }
        }
    }
}
