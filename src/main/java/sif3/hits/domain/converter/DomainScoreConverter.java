package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.DomainScoreType;
import sif3.hits.domain.model.DomainScore;

@Component
public class DomainScoreConverter extends HitsConverter<DomainScoreType, DomainScore>{
  
  public DomainScoreConverter() {
    super(DomainScoreType.class, DomainScore.class);
  }

  @Override
  public void toSifModel(DomainScore source, DomainScoreType target) {
    if (source != null && target != null) {
      target.setRawScore(getBigDecimalValue(source.getRawScore()));
      target.setScaledScoreStandardError(getBigDecimalValue(source.getScaledScoreStandardError()));
      target.setScaledScoreValue(getBigDecimalValue(source.getScaledScoreValue()));
      target.setStudentDomainBand(getBigIntegerValue(source.getStudentDomainBand()));
      target.setStudentProficiency(source.getStudentProficiency());
    }   
  }

  @Override
  public void toHitsModel(DomainScoreType source, DomainScore target) {
    if (source != null && target != null) {
      target.setRawScore(getBigDecimalValue(source.getRawScore()));
      target.setScaledScoreStandardError(getBigDecimalValue(source.getScaledScoreStandardError()));
      target.setScaledScoreValue(getBigDecimalValue(source.getScaledScoreValue()));
      target.setStudentDomainBand(getBigIntegerValue(source.getStudentDomainBand()));
      target.setStudentProficiency(source.getStudentProficiency());
    }
  }
}
