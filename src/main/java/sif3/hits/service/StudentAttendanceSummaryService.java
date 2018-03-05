package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.StudentAttendanceSummaryCollectionType;
import sif.dd.au30.model.StudentAttendanceSummaryType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.StudentAttendanceSummaryConverter;
import sif3.hits.domain.dao.StudentAttendanceSummaryDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.StudentAttendanceSummaryFilterDAO;
import sif3.hits.domain.model.StudentAttendanceSummary;

@Service
public class StudentAttendanceSummaryService extends BaseService<StudentAttendanceSummaryType, StudentAttendanceSummaryCollectionType, StudentAttendanceSummary> {

  @Autowired
  private StudentAttendanceSummaryConverter studentAttendanceSummaryConverter;

  @Autowired
  private StudentAttendanceSummaryDAO studentAttendanceSummaryDAO;

  @Autowired
  private StudentAttendanceSummaryFilterDAO studentAttendanceSummaryFilterDAO;

  @Override
  protected StudentAttendanceSummaryCollectionType getCollection(List<StudentAttendanceSummaryType> items) {
    StudentAttendanceSummaryCollectionType result = new StudentAttendanceSummaryCollectionType();
    if (items != null) {
      result.getStudentAttendanceSummary().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<StudentAttendanceSummaryType, StudentAttendanceSummary> getConverter() {
    return studentAttendanceSummaryConverter;
  }

  @Override
  protected JpaRepository<StudentAttendanceSummary, String> getDAO() {
    return studentAttendanceSummaryDAO;
  }

  @Override
  protected FilterableRepository<StudentAttendanceSummary,StudentAttendanceSummaryType> getFilterableDAO() {
    return studentAttendanceSummaryFilterDAO;
  }
}
