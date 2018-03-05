package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.DomainScoreType;
import sif.dd.au30.model.NAPStudentResponseSetType;
import sif.dd.au30.model.NAPStudentResponseTestletListType;
import sif.dd.au30.model.NAPTestletResponseType;
import sif.dd.au30.model.StudentPersonalType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.dao.NAPTestDAO;
import sif3.hits.domain.dao.StudentPersonalDAO;
import sif3.hits.domain.model.DomainScore;
import sif3.hits.domain.model.NAPStudentResponseSet;
import sif3.hits.domain.model.NAPTest;
import sif3.hits.domain.model.StudentPersonal;
import sif3.hits.domain.model.TestletResponse;
import sif3.hits.service.PersonalStudentIdService;

@Component
public class NAPStudentResponseSetConverter extends HitsConverter<NAPStudentResponseSetType, NAPStudentResponseSet> {

    @Autowired
    private DomainScoreConverter domainScoreConverter;

    @Autowired
    private StudentPersonalConverter studentPersonalConverter;

    @Autowired
    private NAPStudentResponseTestletConverter studentResponseTestletConverter;

    @Autowired
    private NAPTestDAO napTestDAO;

    @Autowired
    private StudentPersonalDAO studentPersonalDAO;

    public NAPStudentResponseSetConverter() {
        super(NAPStudentResponseSetType.class, NAPStudentResponseSet.class);
    }

    @Override
    public void toSifModel(NAPStudentResponseSet source, NAPStudentResponseSetType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();

            target.setRefId(source.getRefId());

            target.setCalibrationSampleFlag(objectFactory.createNAPStudentResponseSetTypeCalibrationSampleFlag(source.getCalibrationSampleFlag()));
            target.setEquatingSampleFlag(objectFactory.createNAPStudentResponseSetTypeEquatingSampleFlag(source.getEquatingSampleFlag()));
            target.setPathTakenForDomain(objectFactory.createNAPStudentResponseSetTypePathTakenForDomain(source.getPathTakenForDomain()));
            target.setReportExclusionFlag(getBoolValue(source.getReportExclusionFlag()));
            target.setParallelTest(objectFactory.createNAPStudentResponseSetTypeParallelTest(source.getParallelTest()));

            if (source.getDomainScores() != null && !source.getDomainScores().isEmpty()) {
                target.setDomainScore(objectFactory.createNAPStudentResponseSetTypeDomainScore(domainScoreConverter.toSifModel(source.getDomainScores().get(0))));
            }

            // NAP Test
            NAPTest napTest = source.getNapTest();
            if (napTest != null) {
                target.setNAPTestLocalId(napTest.getLocalId());
                target.setNAPTestRefId(objectFactory.createNAPStudentResponseSetTypeNAPTestRefId(napTest.getRefId()));
            }

            // Student Personal
            StudentPersonal studentPersonal = source.getStudentPersonal();
            if (studentPersonal != null) {
                StudentPersonalType studentPersonalType = studentPersonalConverter.toSifModel(studentPersonal);
                target.setPlatformStudentIdentifier(PersonalStudentIdService.getIdentifier(studentPersonalType));
                target.setStudentPersonalRefId(objectFactory.createNAPStudentResponseSetTypeStudentPersonalRefId(studentPersonal.getRefId()));
            }

            // NAP Testlet List
            List<NAPTestletResponseType> testletList = studentResponseTestletConverter.toSifModelList(source.getTestletList());
            if (testletList != null && !testletList.isEmpty()) {
                NAPStudentResponseTestletListType napTestletListType = objectFactory.createNAPStudentResponseTestletListType();
                napTestletListType.getTestlet().addAll(testletList);
                target.setTestletList(objectFactory.createNAPStudentResponseSetTypeTestletList(napTestletListType));
            }
        }
    }

    @Override
    public void toHitsModel(NAPStudentResponseSetType source, NAPStudentResponseSet target) {
        if (source != null && target != null) {
            target.setRefId(source.getRefId());

            target.setCalibrationSampleFlag(getJAXBValue(source.getCalibrationSampleFlag()));
            target.setEquatingSampleFlag(getJAXBValue(source.getEquatingSampleFlag()));
            target.setPathTakenForDomain(getJAXBValue(source.getPathTakenForDomain()));
            target.setReportExclusionFlag(getBooleanValue(source.isReportExclusionFlag()));
            target.setParallelTest(getJAXBValue(source.getParallelTest()));

            // NAPTest
            String testRefId = getJAXBValue(source.getNAPTestRefId());
            String testLocalId = source.getNAPTestLocalId();
            NAPTest napTest = napTestDAO.findOne(testRefId);
            if (napTest == null) {
                List<NAPTest> napTests = napTestDAO.findWithLocalId(testLocalId);
                if (!napTests.isEmpty()) {
                    napTest = napTests.get(0);
                }
            }
            target.setNapTest(napTest);

            // StudentPersonal
            String studentRefId = getJAXBValue(source.getStudentPersonalRefId());
            String studentLocalId = source.getPlatformStudentIdentifier();
            StudentPersonal studentPersonal = studentPersonalDAO.findOne(studentRefId);
            if (studentPersonal == null) {
                List<StudentPersonal> studentPersonals = studentPersonalDAO.findWithOtherId(PersonalStudentIdService.PERSONAL_STUDENT_IDENTIFIER_TYPE, studentLocalId);
                if (!studentPersonals.isEmpty()) {
                    studentPersonal = studentPersonals.get(0);
                }
            }
            target.setStudentPersonal(studentPersonal);

            // NAP Testlet List
            if (target.getTestletList() == null) {
                target.setTestletList(new ArrayList<TestletResponse>());
            }
            target.getTestletList().clear();
            NAPStudentResponseTestletListType napTestletListType = getJAXBValue(source.getTestletList());
            if (napTestletListType != null) {
                target.getTestletList().addAll(studentResponseTestletConverter.toHitsModelList(napTestletListType.getTestlet()));
                for (TestletResponse testletResponse : target.getTestletList()) {
                    testletResponse.setNapStudentResponseSet(target);
                }
            }

            // Domain Score
            if (target.getDomainScores() == null) {
                target.setDomainScores(new ArrayList<DomainScore>());
            }
            target.getDomainScores().clear();
            DomainScoreType domainScoreType = getJAXBValue(source.getDomainScore());
            if (domainScoreType != null) {
                target.getDomainScores().add(domainScoreConverter.toHitsModel(domainScoreType));
                for (DomainScore domainScore : target.getDomainScores()) {
                    domainScore.setNapStudentResponseSet(target);
                }
            }
        }
    }
}
