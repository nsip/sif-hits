package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.ScoreDescriptionType;
import sif3.hits.domain.model.ScoreDescription;

@Component
public class ScoreDescriptionConverter extends HitsConverter<ScoreDescriptionType, ScoreDescription> {

  public ScoreDescriptionConverter() {
    super(ScoreDescriptionType.class, ScoreDescription.class);
  }

  @Override
  public void toSifModel(ScoreDescription source, ScoreDescriptionType target) {
    if (source != null && target != null) {
      target.setDescriptor(source.getDescriptor());
      target.setScoreValue(getBigDecimalValue(source.getScoreValue()));
    }
  }

  @Override
  public void toHitsModel(ScoreDescriptionType source, ScoreDescription target) {
    if (source != null && target != null) {
      target.setDescriptor(source.getDescriptor());
      target.setScoreValue(getBigDecimalValue(source.getScoreValue()));
    }
  }

}
