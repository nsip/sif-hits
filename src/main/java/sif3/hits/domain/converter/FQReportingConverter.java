package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

@Component
public class FQReportingConverter {
//	extends HitsConverter<FQReportingType, FQReporting> {
//}
//
//    @Autowired
//    FQEntityContactConverter entityContactConverter;
//
//    @Autowired
//    FQContextualQuestionConverter fqContextualQuestionConverter;
//
//    @Autowired
//    FQItemConverter fqItemConverter;
//
//    @Autowired
//    FQRuleConverter fqRuleConverter;
//
//
//    public FQReportingConverter() {
//        super(FQReportingType.class, FQReporting.class);
//    }
//
//    @Override
//    public void toSifModel(FQReporting source, FQReportingType target) {
//        if (source != null && target != null) {
//            IObjectFactory objectFactory = getObjectFactory();
//            target.setFQRefId(objectFactory.createFQReportingTypeFQRefId(source.getFqRefId()));
//            target.setEntityLevel(source.getEntityLevel());
//            target.setSchoolInfoRefId(objectFactory.createFQReportingTypeSchoolInfoRefId(source.getSchoolInfoRefId()));
//            target.setLocalId(objectFactory.createFQReportingTypeLocalId(source.getLocalId()));
//            target.setStateProvinceId(objectFactory.createFQReportingTypeStateProvinceId(source.getStateProvinceId()));
//            target.setCommonwealthId(source.getCommonwealthId());
//            target.setACARAId(objectFactory.createFQReportingTypeACARAId(source.getAcaraId()));
//            target.setEntityName(objectFactory.createFQReportingTypeEntityName(source.getEntityName()));
//            target.setEntityContact(entityContactConverter.toSifModel(source.getEntityContact()));
//
//            List<FQContextualQuestionType> fqContextualQuestionTypeList = fqContextualQuestionConverter.toSifModelList(source.getFqContextualQuestionList());
//            if (fqContextualQuestionTypeList != null && !fqContextualQuestionTypeList.isEmpty()) {
//                FQContextualQuestionListType fqContextualQuestionListType = objectFactory.createFQContextualQuestionListType();
//                fqContextualQuestionListType.getFQContextualQuestion().addAll(fqContextualQuestionTypeList);
//                target.setFQContextualQuestionList(objectFactory.createFQReportingTypeFQContextualQuestionList(fqContextualQuestionListType));
//            }
//
//            List<FQItemType> fqItemTypeList = fqItemConverter.toSifModelList(source.getFqItemList());
//            if (fqItemTypeList != null && !fqItemTypeList.isEmpty()) {
//                FQItemListType fqItemListType = objectFactory.createFQItemListType();
//                fqItemListType.getFQItem().addAll(fqItemTypeList);
//                target.setFQItemList(fqItemListType);
//            }
//
//            List<AGRuleType> fqRuleList = fqRuleConverter.toSifModelList(source.getFqRuleList());
//            if (fqRuleList != null && !fqRuleList.isEmpty()) {
//                AGRuleListType agRuleListType = objectFactory.createAGRuleListType();
//                agRuleListType.getAGRule().addAll(fqRuleList);
//                target.setAGRuleList(objectFactory.createFQReportingTypeAGRuleList(agRuleListType));
//            }
//        }
//    }
//
//    @Override
//    public void toHitsModel(FQReportingType source, FQReporting target) {
//        if (source != null && target != null) {
//            target.setFqRefId(getJAXBValue(source.getFQRefId()));
//            target.setEntityLevel(source.getEntityLevel());
//            target.setSchoolInfoRefId(getJAXBValue(source.getSchoolInfoRefId()));
//            target.setLocalId(getJAXBValue(source.getLocalId()));
//            target.setStateProvinceId(getJAXBValue(source.getStateProvinceId()));
//            target.setCommonwealthId(source.getCommonwealthId());
//            target.setAcaraId(getJAXBValue(source.getACARAId()));
//            target.setEntityName(getJAXBValue(source.getEntityName()));
//            target.setEntityContact(entityContactConverter.toHitsModel(source.getEntityContact()));
//            if (target.getEntityContact() != null) {
//                target.getEntityContact().setFqReporting(target);
//            }
//
//            if (target.getFqContextualQuestionList() == null) {
//                target.setFqContextualQuestionList(new ArrayList<>());
//            }
//            target.getFqContextualQuestionList().clear();
//            FQContextualQuestionListType fqContextualQuestionListType = getJAXBValue(source.getFQContextualQuestionList());
//            if (fqContextualQuestionListType != null) {
//                for (FQContextualQuestionType fqContextualQuestionType : fqContextualQuestionListType.getFQContextualQuestion()) {
//                    FQContextualQuestion fqContextualQuestion = fqContextualQuestionConverter.toHitsModel(fqContextualQuestionType);
//                    if (fqContextualQuestion != null) {
//                        fqContextualQuestion.setFqReporting(target);
//                        target.getFqContextualQuestionList().add(fqContextualQuestion);
//                    }
//                }
//            }
//
//            if (target.getFqItemList() == null) {
//                target.setFqItemList(new ArrayList<>());
//            }
//            target.getFqItemList().clear();
//            FQItemListType fqItemListType = source.getFQItemList();
//            if (fqItemListType != null) {
//                for (FQItemType fqItemType : fqItemListType.getFQItem()) {
//                    FQItem fqItem = fqItemConverter.toHitsModel(fqItemType);
//                    if (fqItem != null) {
//                        fqItem.setFqReporting(target);
//                        target.getFqItemList().add(fqItem);
//                    }
//                }
//            }
//
//            if (target.getFqRuleList() == null) {
//                target.setFqRuleList(new ArrayList<>());
//            }
//            target.getFqRuleList().clear();
//            AGRuleListType fqRuleListType = getJAXBValue(source.getAGRuleList());
//            if (fqRuleListType != null) {
//                for (AGRuleType fqRuleType : fqRuleListType.getAGRule()) {
//                    FQRule fqRule = fqRuleConverter.toHitsModel(fqRuleType);
//                    if (fqRule != null) {
//                        fqRule.setFqReporting(target);
//                        target.getFqRuleList().add(fqRule);
//                    }
//                }
//            }
//        }
//    }
}
