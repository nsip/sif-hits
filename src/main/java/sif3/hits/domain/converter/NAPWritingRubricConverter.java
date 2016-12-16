package sif3.hits.domain.converter;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.AUCodeSetsNAPWritingRubricTypeType;
import sif.dd.au30.model.NAPWritingRubricType;
import sif.dd.au30.model.ScoreListType;
import sif.dd.au30.model.ScoreType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.NAPWritingRubric;
import sif3.hits.domain.model.Score;

@Component
public class NAPWritingRubricConverter extends HitsConverter<NAPWritingRubricType, NAPWritingRubric> {

  @Autowired
  private ScoreConverter scoreConverter;

  public NAPWritingRubricConverter() {
    super(NAPWritingRubricType.class, NAPWritingRubric.class);
  }

  @Override
  public void toSifModel(NAPWritingRubric source, NAPWritingRubricType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();

      target.setDescriptor(objectFactory.createNAPWritingRubricTypeDescriptor(source.getDescriptor()));
      target.setRubricType(getEnumValue(source.getRubricType(), AUCodeSetsNAPWritingRubricTypeType.class));

      List<ScoreType> scoreList = scoreConverter.toSifModelList(source.getScoreList());
      if (scoreList != null && !scoreList.isEmpty()) {
        ScoreListType scoreListType = objectFactory.createScoreListType();
        scoreListType.getScore().addAll(scoreList);
        target.setScoreList(scoreListType);
      }
    }
  }

  @Override
  public void toHitsModel(NAPWritingRubricType source, NAPWritingRubric target) {
    if (source != null && target != null) {
      target.setDescriptor(getJAXBValue(source.getDescriptor()));
      target.setRubricType(getEnumValue(source.getRubricType()));

      if (target.getScoreList() == null) {
        target.setScoreList(new HashSet<Score>());
      }
      target.getScoreList().clear();
      ScoreListType scoreListType = source.getScoreList();
      if (scoreListType != null) {
        target.getScoreList().addAll(scoreConverter.toHitsModelList(scoreListType.getScore()));
        for (Score score : target.getScoreList()) {
          score.setNapWritingRubric(target);
        }
      }
    }
  }

}
