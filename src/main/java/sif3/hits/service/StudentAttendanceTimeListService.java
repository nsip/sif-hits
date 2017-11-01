package sif3.hits.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import sif.dd.au30.model.StudentAttendanceTimeListCollectionType;
import sif.dd.au30.model.StudentAttendanceTimeListType;
import sif3.hits.domain.converter.HitsConverter;
import sif3.hits.domain.converter.StudentAttendanceTimeListConverter;
import sif3.hits.domain.dao.StudentAttendanceTimeListDAO;
import sif3.hits.domain.dao.filter.FilterableRepository;
import sif3.hits.domain.dao.filter.StudentAttendanceTimeListFilterDAO;
import sif3.hits.domain.model.StudentAttendanceTimeList;

@Service
public class StudentAttendanceTimeListService extends BaseService<StudentAttendanceTimeListType, StudentAttendanceTimeListCollectionType, StudentAttendanceTimeList> {

  @Autowired
  private StudentAttendanceTimeListConverter studentAttendanceTimeListConverter;

  @Autowired
  private StudentAttendanceTimeListDAO studentAttendanceTimeListDAO;

  @Autowired
  private StudentAttendanceTimeListFilterDAO studentAttendanceTimeListFilterDAO;

  @Override
  protected StudentAttendanceTimeListCollectionType getCollection(List<StudentAttendanceTimeListType> items) {
    StudentAttendanceTimeListCollectionType result = new StudentAttendanceTimeListCollectionType();
    if (items != null) {
      result.getStudentAttendanceTimeList().addAll(items);
    }
    return result;
  }

  @Override
  protected HitsConverter<StudentAttendanceTimeListType, StudentAttendanceTimeList> getConverter() {
    return studentAttendanceTimeListConverter;
  }

  @Override
  protected JpaRepository<StudentAttendanceTimeList, String> getDAO() {
    return studentAttendanceTimeListDAO;
  }

  @Override
  protected FilterableRepository<StudentAttendanceTimeList> getFilterableDAO() {
    return studentAttendanceTimeListFilterDAO;
  }

}
