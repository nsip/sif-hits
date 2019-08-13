package sif3.hits.domain.converter;

import org.springframework.stereotype.Component;

import sif.dd.au30.model.StimulusType;
import sif3.hits.domain.converter.factory.IObjectFactory;
import sif3.hits.domain.model.Stimulus;

@Component
public class StimulusConverter extends HitsConverter<StimulusType, Stimulus>{
  
  public StimulusConverter() {
    super(StimulusType.class, Stimulus.class);
  }

  @Override
  public void toSifModel(Stimulus source, StimulusType target) {
    if (source != null && target != null) {
      IObjectFactory objectFactory = getObjectFactory();
      
      target.setContent(source.getContent());
      target.setTextDescriptor(objectFactory.createStimulusTypeTextDescriptor(source.getDescriptor()));
      target.setStimulusLocalId(source.getLocalId());
      target.setTextGenre(objectFactory.createStimulusTypeTextGenre(source.getTextGenre()));
      target.setTextType(objectFactory.createStimulusTypeTextType(source.getTextType()));
      target.setWordCount(objectFactory.createStimulusTypeWordCount(getBigIntegerValue(source.getWordCount())));
    }
  }

  @Override
  public void toHitsModel(StimulusType source, Stimulus target) {
    if (source != null && target != null) {
      target.setContent(source.getContent());
      target.setDescriptor(getJAXBValue(source.getTextDescriptor()));
      target.setLocalId(source.getStimulusLocalId());
      target.setTextGenre(getJAXBValue(source.getTextGenre()));
      target.setTextType(getJAXBValue(source.getTextType()));
      target.setWordCount(getBigIntegerValue(getJAXBValue(source.getWordCount())));
    }
  }
  
  

}
