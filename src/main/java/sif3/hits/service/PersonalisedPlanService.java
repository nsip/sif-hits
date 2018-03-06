package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.PersonalisedPlanCollectionType;
import sif.dd.au30.model.PersonalisedPlanType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.PersonalisedPlanConverter;
import sif3.hits.domain.dao.PersonalisedPlanDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.PersonalisedPlanFilterDAO;
import sif3.hits.domain.model.PersonalisedPlan;

@Service
public class PersonalisedPlanService extends BaseService<PersonalisedPlanType, PersonalisedPlanCollectionType, PersonalisedPlan> {

  @Autowired
  private PersonalisedPlanConverter personalisedPlanConverter;

  @Autowired
  private PersonalisedPlanDAO personalisedPlanDAO;

  @Autowired
  private PersonalisedPlanFilterDAO personalisedPlanFilterDAO;

  @Override
  protected PersonalisedPlanCollectionType getCollection(List<PersonalisedPlanType> items) {
    PersonalisedPlanCollectionType result = new PersonalisedPlanCollectionType();
    if (items != null) {
      result.getPersonalisedPlan().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<PersonalisedPlanType, PersonalisedPlan> getConverter() {
    return personalisedPlanConverter;
  }

  @Override
  protected JpaRepository<PersonalisedPlan, String> getDAO() {
    return personalisedPlanDAO;
  }

  @Override
  protected FilterableRepository<PersonalisedPlan,PersonalisedPlanType> getFilterableDAO() {
    return personalisedPlanFilterDAO;
  }
}
