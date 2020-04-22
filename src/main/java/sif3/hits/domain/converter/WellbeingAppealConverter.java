package sif3.hits.domain.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsWellbeingAppealStatusType;
import sif.dd.au30.model.WellbeingAppealType;
import sif.dd.au30.model.WellbeingDocumentListType;
import sif.dd.au30.model.WellbeingDocumentType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.WellbeingAppeal;
import sif3.hits.domain.model.WellbeingAppealDocument;
import sif3.hits.utils.UsesConstants;

@Component
public class WellbeingAppealConverter extends HitsConverter<WellbeingAppealType, WellbeingAppeal>
		implements UsesConstants {

	@Autowired
	WellbeingAppealDocumentConverter documentConverter;

	public WellbeingAppealConverter() {
		super(WellbeingAppealType.class, WellbeingAppeal.class);
	}

	@Override
	public void toSifModel(WellbeingAppeal source, WellbeingAppealType target) {
		if (source != null && target != null) {
			IObjectFactory objectFactory = getObjectFactory();

			target.setRefId(source.getRefId());
			target.setLocalId(objectFactory.createWellbeingAlertTypeLocalId(source.getLocalId()));
			target.setStudentPersonalRefId(source.getStudentPersonalRefId());
			target.setSchoolInfoRefId(source.getSchoolInfoRefId());
			target.setWellbeingResponseRefId(source.getWellbeingResponseRefId());
			target.setLocalAppealId(objectFactory.createWellbeingAppealTypeLocalAppealId(source.getLocalAppealId()));
			target.setAppealStatusCode(objectFactory.createWellbeingAppealTypeAppealStatusCode(
					getEnumValue(source.getAppealStatusCode(), AUCodeSetsWellbeingAppealStatusType.class)));
			target.setDate(objectFactory.createWellbeingAppealTypeDate(getDateValue(source.getAppealDate())));
			target.setAppealNotes(objectFactory.createWellbeingAppealTypeAppealNotes(source.getAppealNotes()));
			target.setAppealOutcome(objectFactory.createWellbeingAppealTypeAppealOutcome(source.getAppealOutcome()));

			if (source.getDocuments() != null && !source.getDocuments().isEmpty()) {
				List<WellbeingDocumentType> documents = documentConverter.toSifModelList(source.getDocuments());
				if (documents != null && !documents.isEmpty()) {
					WellbeingDocumentListType documentList = objectFactory.createWellbeingDocumentListType();
					documentList.getDocument().addAll(documents);
					target.setDocumentList(objectFactory.createWellbeingAppealTypeDocumentList(documentList));
				}
			}
		}
	}

	@Override
	public void toHitsModel(WellbeingAppealType source, WellbeingAppeal target) {
		if (source != null && target != null) {
			resetModel(target);
			target.setRefId(source.getRefId());
			target.setLocalId(getJAXBValue(source.getLocalId()));
			target.setStudentPersonalRefId(source.getStudentPersonalRefId());
			target.setSchoolInfoRefId(source.getSchoolInfoRefId());
			target.setWellbeingResponseRefId(source.getWellbeingResponseRefId());
			target.setLocalAppealId(getJAXBValue(source.getLocalAppealId()));
			target.setAppealStatusCode(getJAXBEnumValue(source.getAppealStatusCode()));
			target.setAppealDate(getDateValue(getJAXBValue(source.getDate())));
			target.setAppealNotes(getJAXBValue(source.getAppealNotes()));
			target.setAppealOutcome(getJAXBValue(source.getAppealOutcome()));

			WellbeingDocumentListType documentList = getJAXBValue(source.getDocumentList());
			if (documentList != null && !documentList.getDocument().isEmpty()) {
				List<WellbeingAppealDocument> documents = documentConverter.toHitsModelList(documentList.getDocument());
				if (documents != null && !documents.isEmpty()) {
					for (WellbeingAppealDocument document : documents) {
						document.setWellbeingAppeal(target);
					}
					target.getDocuments().addAll(documents);
				}
			}
		}
	}

	private void resetModel(WellbeingAppeal target) {
		if (target.getDocuments() == null) {
			target.setDocuments(new ArrayList<WellbeingAppealDocument>());
		}
		target.getDocuments().clear();
	}

}
