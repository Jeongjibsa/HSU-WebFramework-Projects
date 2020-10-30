package kr.ac.hansung.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.hansung.dao.CourseDao;
import kr.ac.hansung.model.Course;
import kr.ac.hansung.model.Offer;

@Service
public class CourseService {

	@Autowired
	private CourseDao courseDao;

	public List<Course> getCurrent() {
		return courseDao.getCourses();
	}

	public List<Course> getCredits() { // 학기별 학점 조회
		return courseDao.getCredits();
	}

	public List<Course> getCurrent(String year, int semester) { // 학기별 학점 조회 - 상세보기
		return courseDao.getCourses(year, semester);
	}

	public void insert(Course course) {
		courseDao.insert(course);
	}

	public void delete(String code) {
		courseDao.delete(code);
	}

	public void update(Course course) {
		courseDao.update(course);
	}
}
