package sif3.hits.domain.converter;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sif.dd.au30.model.ScoreDescriptionListType;
import sif.dd.au30.model.ScoreDescriptionType;
import sif.dd.au30.model.ScoreType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.Score;
import sif3.hits.domain.model.ScoreDescription;

@Component
public class ScoreConverter extends HitsConverter<ScoreType, Score>{

  @Autowired
  private ScoreDescriptionConverter scoreDescriptionConverter;
  
  public ScoreConverter() {
    super(ScoreType.class, Score.class);
  }

  @Override
  public void toSifModel(Score source, ScoreType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      
      target.setMaxScoreValue(getBigDecimalValue(source.getMaxScoreValue()));
      List<ScoreDescriptionType> scoreDescriptionList = scoreDescriptionConverter.toSifModelList(source.getScoreDescriptionList());
      if (scoreDescriptionList != null && !scoreDescriptionList.isEmpty()) {
        ScoreDescriptionListType scoreDescriptionListType = objectFactory.createScoreDescriptionListType();
        scoreDescriptionListType.getScoreDescription().addAll(scoreDescriptionList);
        target.setScoreDescriptionList(scoreDescriptionListType);
      }      
    }
  }

  @Override
  public void toHitsModel(ScoreType source, Score target) {
    if (source != null && target != null) {
      target.setMaxScoreValue(getBigDecimalValue(source.getMaxScoreValue()));
      if (target.getScoreDescriptionList() == null) {
        target.setScoreDescriptionList(new HashSet<ScoreDescription>());
      }
      target.getScoreDescriptionList().clear();
      ScoreDescriptionListType scoreDescriptionListType = source.getScoreDescriptionList();
      if (scoreDescriptionListType != null) {
        target.getScoreDescriptionList().addAll(scoreDescriptionConverter.toHitsModelList(scoreDescriptionListType.getScoreDescription()));
        for (ScoreDescription scoreDescription : target.getScoreDescriptionList()) {
          scoreDescription.setScore(target);
        }
      }
    }
  }
  
}
