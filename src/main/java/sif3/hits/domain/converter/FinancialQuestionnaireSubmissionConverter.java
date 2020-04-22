package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

@Component
public class FinancialQuestionnaireSubmissionConverter {
//	extends HitsConverter<FinancialQuestionnaireSubmissionType, FinancialQuestionnaireSubmission> {
//}
//
//    @Autowired
//    FQSubmissionEntityContactConverter fqSubmissionEntityContactConverter;
//
//    @Autowired
//    FQReportingConverter fqReportingConverter;
//
//    public FinancialQuestionnaireSubmissionConverter() {
//        super(FinancialQuestionnaireSubmissionType.class, FinancialQuestionnaireSubmission.class);
//    }
//
//    @Override
//    public void toSifModel(FinancialQuestionnaireSubmission source, FinancialQuestionnaireSubmissionType target) {
//        if (source != null && target != null) {
//            IObjectFactory objectFactory = getObjectFactory();
//
//            target.setRefId(source.getRefId());
//            target.setFQYear(getYearValue(source.getFqYear()));
//            target.setReportingAuthority(objectFactory.createFinancialQuestionnaireSubmissionTypeReportingAuthority(source.getReportingAuthority()));
//            target.setReportingAuthoritySystem(objectFactory.createFinancialQuestionnaireSubmissionTypeReportingAuthoritySystem(source.getReportingAuthoritySystem()));
//            target.setReportingAuthorityCommonwealthId(source.getReportingAuthorityCommonwealthId());
//            target.setSystemSubmission(objectFactory.createFinancialQuestionnaireSubmissionTypeSystemSubmission(getEnumValue(source.getSystemSubmission(), AUCodeSetsYesOrNoCategoryType.class)));
//            target.setFQReportComments(objectFactory.createFinancialQuestionnaireSubmissionTypeFQReportComments(source.getFqReportComments()));
//
//            if (StringUtils.isNotBlank(source.getSoftwareProduct()) || StringUtils.isNotBlank(source.getSoftwareVersion())) {
//                SoftwareVendorInfoContainerType softwareVendorInfoContainerType = objectFactory.createSoftwareVendorInfoContainerType();
//                softwareVendorInfoContainerType.setSoftwareProduct(source.getSoftwareProduct());
//                softwareVendorInfoContainerType.setSoftwareVersion(source.getSoftwareVersion());
//                target.setSoftwareVendorInfo(softwareVendorInfoContainerType);
//            }
//
//            target.setSubmissionContact(fqSubmissionEntityContactConverter.toSifModel(source.getSubmissionContact()));
//            if (source.getFqReportingList() != null) {
//                List<FQReportingType> fqReportingList = fqReportingConverter.toSifModelList(source.getFqReportingList());
//                if (fqReportingList != null && !fqReportingList.isEmpty()) {
//                    FQReportingListType fqReportingListType = objectFactory.createFQReportingListType();
//                    fqReportingListType.getFQReporting().addAll(fqReportingList);
//                    target.setFQReportingList(objectFactory.createFinancialQuestionnaireSubmissionTypeFQReportingList(fqReportingListType));
//                }
//            }
//        }
//    }
//
//    @Override
//    public void toHitsModel(FinancialQuestionnaireSubmissionType source, FinancialQuestionnaireSubmission target) {
//        if (source != null && target != null) {
//            target.setRefId(source.getRefId());
//            target.setFqYear(getYearValue(source.getFQYear()));
//            target.setReportingAuthority(getJAXBValue(source.getReportingAuthority()));
//            target.setReportingAuthoritySystem(getJAXBValue(source.getReportingAuthoritySystem()));
//            target.setReportingAuthorityCommonwealthId(source.getReportingAuthorityCommonwealthId());
//            target.setSystemSubmission(getJAXBEnumValue(source.getSystemSubmission()));
//            target.setFqReportComments(getJAXBValue(source.getFQReportComments()));
//
//            SoftwareVendorInfoContainerType softwareVendorInfoContainerType = source.getSoftwareVendorInfo();
//            if (softwareVendorInfoContainerType != null) {
//                target.setSoftwareProduct(softwareVendorInfoContainerType.getSoftwareProduct());
//                target.setSoftwareVersion(softwareVendorInfoContainerType.getSoftwareVersion());
//            } else {
//                target.setSoftwareProduct(null);
//                target.setSoftwareVersion(null);
//            }
//
//            target.setSubmissionContact(fqSubmissionEntityContactConverter.toHitsModel(source.getSubmissionContact()));
//            if (target.getSubmissionContact() != null) {
//                target.getSubmissionContact().setFqSubmission(target);
//            }
//
//            if (target.getFqReportingList() == null) {
//                target.setFqReportingList(new ArrayList<>());
//            }
//            target.getFqReportingList().clear();
//
//            FQReportingListType fqReportingListType = getJAXBValue(source.getFQReportingList());
//            if (fqReportingListType != null) {
//                for (FQReportingType fqReportingType : fqReportingListType.getFQReporting()) {
//                    FQReporting fqReporting = fqReportingConverter.toHitsModel(fqReportingType);
//                    if (fqReporting != null) {
//                        fqReporting.setFqSubmission(target);
//                        target.getFqReportingList().add(fqReporting);
//                    }
//                }
//            }
//        }
//    }

}
