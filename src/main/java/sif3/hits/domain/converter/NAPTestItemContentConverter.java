package sif3.hits.domain.converter;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsNAPTestItemMarkingTypeType;
import sif.dd.au30.model.AUCodeSetsNAPTestItemTypeType;
import sif.dd.au30.model.AUCodeSetsNAPWritingGenreType;
import sif.dd.au30.model.ContentDescriptionListType;
import sif.dd.au30.model.NAPTestItemContentType;
import sif.dd.au30.model.NAPWritingRubricListType;
import sif.dd.au30.model.NAPWritingRubricType;
import sif.dd.au30.model.StimulusListType;
import sif.dd.au30.model.StimulusType;
import sif.dd.au30.model.SubstituteItemListType;
import sif.dd.au30.model.SubstituteItemType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.NAPTestItem;
import sif3.hits.domain.model.NAPWritingRubric;
import sif3.hits.domain.model.Stimulus;
import sif3.hits.domain.model.SubstituteItem;

@Component
public class NAPTestItemContentConverter extends HitsConverter<NAPTestItemContentType, NAPTestItem> {

    @Autowired
    private StimulusConverter stimulusConverter;

    @Autowired
    private NAPWritingRubricConverter napWritingRubricConverter;

    @Autowired
    private NAPItemSubstitutedForConverter napItemSubstitutedForConverter;

    public NAPTestItemContentConverter() {
        super(NAPTestItemContentType.class, NAPTestItem.class);
    }

    @Override
    public void toSifModel(NAPTestItem source, NAPTestItemContentType target) {
        if (source != null && target != null) {
            IObjectFactory objectFactory = getObjectFactory();

            target.setNAPTestItemLocalId(source.getLocalId());
            target.setCorrectAnswer(objectFactory.createNAPTestItemContentTypeCorrectAnswer(source.getCorrectAnswer()));
            target.setExemplarURL(objectFactory.createNAPTestItemContentTypeExemplarURL(source.getExemplarURL()));
            target.setItemDescriptor(source.getItemDescriptor());
            target.setItemType(getEnumValue(source.getItemType(), AUCodeSetsNAPTestItemTypeType.class));
            target.setItemDifficulty(getBigDecimalValue(source.getItemDifficulty()));
            target.setItemDifficultyLogit5(getBigDecimalValue(source.getItemDifficultyLogit5()));
            target.setItemDifficultyLogit5SE(getBigDecimalValue(source.getItemDifficultyLogit5SE()));
            target.setItemDifficultyLogit62(getBigDecimalValue(source.getItemDifficultyLogit62()));
            target.setItemDifficultyLogit62SE(getBigDecimalValue(source.getItemDifficultyLogit62SE()));
            target.setItemProficiencyBand(getBigIntegerValue(source.getItemProficiencyBand()));
            target.setItemProficiencyLevel(objectFactory.createNAPTestItemContentTypeItemProficiencyLevel(source.getItemProficiencyLevel()));
            target.setMarkingType(getEnumValue(source.getMarkingType(), AUCodeSetsNAPTestItemMarkingTypeType.class));
            target.setMaximumScore(getBigDecimalValue(source.getMaximumScore()));
            target.setMultipleChoiceOptionCount(objectFactory.createNAPTestItemContentTypeMultipleChoiceOptionCount(getIntegerValue(source.getMultipleChoiceOptionCount())));
            target.setReleasedStatus(getBoolValue(source.getReleasedStatus()));
            target.setSubdomain(source.getSubdomain());
            target.setWritingGenre(objectFactory.createNAPTestItemContentTypeWritingGenre(getEnumValue(source.getWritingGenre(), AUCodeSetsNAPWritingGenreType.class)));

            List<StimulusType> stimulusList = stimulusConverter.toSifModelList(source.getStimulusList());
            if (stimulusList != null && !stimulusList.isEmpty()) {
                StimulusListType stimulusListType = objectFactory.createStimulusListType();
                stimulusListType.getStimulus().addAll(stimulusList);
                target.setStimulusList(objectFactory.createNAPTestItemContentTypeStimulusList(stimulusListType));
            }

            if (source.getContentDescriptionList() != null && !source.getContentDescriptionList().isEmpty()) {
                ContentDescriptionListType contentDescriptionList = objectFactory.createContentDescriptionListType();
                for (String contentDescription : source.getContentDescriptionList()) {
                    contentDescriptionList.getContentDescription().add(contentDescription);
                }
                target.setContentDescriptionList(objectFactory.createNAPTestItemContentTypeContentDescriptionList(contentDescriptionList));
            }

            List<NAPWritingRubricType> writingRubricList = napWritingRubricConverter.toSifModelList(source.getWritingRubricList());
            if (writingRubricList != null && !writingRubricList.isEmpty()) {
                NAPWritingRubricListType napWritingRubricListType = objectFactory.createNAPWritingRubricListType();
                napWritingRubricListType.getNAPWritingRubric().addAll(writingRubricList);
                target.setNAPWritingRubricList(objectFactory.createNAPTestItemContentTypeNAPWritingRubricList(napWritingRubricListType));
            }

            List<SubstituteItemType> napItemSubstitutedForList = napItemSubstitutedForConverter.toSifModelList(source.getItemSubstitutedForList());
            if (napItemSubstitutedForList != null && !napItemSubstitutedForList.isEmpty()) {
                SubstituteItemListType substituteItemListType = objectFactory.createSubstituteItemListType();
                substituteItemListType.getSubstituteItem().addAll(napItemSubstitutedForList);
                target.setItemSubstitutedForList(objectFactory.createNAPTestItemContentTypeItemSubstitutedForList(substituteItemListType));
            }
        }
    }

    @Override
    public void toHitsModel(NAPTestItemContentType source, NAPTestItem target) {
        if (source != null && target != null) {
            target.setLocalId(source.getNAPTestItemLocalId());
            target.setCorrectAnswer(getJAXBValue(source.getCorrectAnswer()));
            target.setExemplarURL(getJAXBValue(source.getExemplarURL()));
            target.setItemDescriptor(source.getItemDescriptor());
            target.setItemType(getEnumValue(source.getItemType()));
            target.setItemDifficulty(getBigDecimalValue(source.getItemDifficulty()));
            target.setItemDifficultyLogit5(getBigDecimalValue(source.getItemDifficultyLogit5()));
            target.setItemDifficultyLogit5SE(getBigDecimalValue(source.getItemDifficultyLogit5SE()));
            target.setItemDifficultyLogit62(getBigDecimalValue(source.getItemDifficultyLogit62()));
            target.setItemDifficultyLogit62SE(getBigDecimalValue(source.getItemDifficultyLogit62SE()));
            target.setItemProficiencyBand(getBigIntegerValue(source.getItemProficiencyBand()));
            target.setItemProficiencyLevel(getJAXBValue(source.getItemProficiencyLevel()));
            target.setMarkingType(getEnumValue(source.getMarkingType()));
            target.setMaximumScore(getBigDecimalValue(source.getMaximumScore()));
            target.setMultipleChoiceOptionCount(getIntegerValue(getJAXBValue(source.getMultipleChoiceOptionCount())));
            target.setReleasedStatus(getBooleanValue(source.isReleasedStatus()));
            target.setSubdomain(source.getSubdomain());
            target.setWritingGenre(getJAXBEnumValue(source.getWritingGenre()));

            if (target.getStimulusList() == null) {
                target.setStimulusList(new HashSet<Stimulus>());
            }
            target.getStimulusList().clear();
            StimulusListType stimulusListType = getJAXBValue(source.getStimulusList());
            if (stimulusListType != null) {
                target.getStimulusList().addAll(stimulusConverter.toHitsModelList(stimulusListType.getStimulus()));
                for (Stimulus stimulus : target.getStimulusList()) {
                    stimulus.setTestItem(target);
                }
            }

            if (target.getContentDescriptionList() == null) {
                target.setContentDescriptionList(new HashSet<String>());
            }
            target.getContentDescriptionList().clear();
            ContentDescriptionListType contentDescriptionListType = getJAXBValue(source.getContentDescriptionList());
            if (contentDescriptionListType != null) {
                target.getContentDescriptionList().addAll(contentDescriptionListType.getContentDescription());
            }

            if (target.getWritingRubricList() == null) {
                target.setWritingRubricList(new HashSet<NAPWritingRubric>());
            }
            target.getWritingRubricList().clear();
            NAPWritingRubricListType napWritingRubricListType = getJAXBValue(source.getNAPWritingRubricList());
            if (napWritingRubricListType != null) {
                target.getWritingRubricList().addAll(napWritingRubricConverter.toHitsModelList(napWritingRubricListType.getNAPWritingRubric()));
                for (NAPWritingRubric napWritingRubric : target.getWritingRubricList()) {
                    napWritingRubric.setNapTestItem(target);
                }
            }

            if (target.getItemSubstitutedForList() == null) {
                target.setItemSubstitutedForList(new HashSet<SubstituteItem>());
            }
            target.getItemSubstitutedForList().clear();
            SubstituteItemListType substituteItemListType = getJAXBValue(source.getItemSubstitutedForList());
            if (substituteItemListType != null) {
                target.getItemSubstitutedForList().addAll(napItemSubstitutedForConverter.toHitsModelList(substituteItemListType.getSubstituteItem()));
            }
            for (SubstituteItem substituteItem : target.getItemSubstitutedForList()) {
                substituteItem.setNapTestItem(target);
            }
        }
    }
}
