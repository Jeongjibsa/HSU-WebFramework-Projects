package kr.ac.hansung.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.model.Offer;

@Repository
public class CourseDao {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int getRowCount() {
		String sqlStatement = "select count(*) from courses";
		return jdbcTemplate.queryForObject(sqlStatement, Integer.class);
	}

	// query and return a single object
	public Course getCourse(String name) {
		String sqlStatement = "select * from courses where name=?"; // placeholder
		return jdbcTemplate.queryForObject(sqlStatement, new Object[] { name }, new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();

				course.setYear(rs.getString("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCode(rs.getString("code"));
				course.setName(rs.getString("name"));
				course.setDivision(rs.getString("division"));
				course.setCredit(rs.getInt("credit"));

				return course;
			}

		});

	}

	// query and return a multiple object
	public List<Course> getCourses() {
		String sqlStatement = "select * from courses"; // placeholder
		return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();

				course.setYear(rs.getString("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCode(rs.getString("code"));
				course.setName(rs.getString("name"));
				course.setDivision(rs.getString("division"));
				course.setCredit(rs.getInt("credit"));

				return course;
			}

		});

	}

	public List<Course> getCourses(String year, int semester) {
		String sqlStatement = "select * from courses where year=? and semester=?"; // placeholder
		return jdbcTemplate.query(sqlStatement, new Object[] { year, semester }, new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();

				course.setYear(rs.getString("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCode(rs.getString("code"));
				course.setName(rs.getString("name"));
				course.setDivision(rs.getString("division"));
				course.setCredit(rs.getInt("credit"));

				return course;
			}

		});

	}

	public List<Course> getCredits() { // 학기별 이수 학점 조회
		String sqlStatement = "select year, semester, sum(credit) from courses group by year, semester order by year, semester"; // placeholder
		return jdbcTemplate.query(sqlStatement, new RowMapper<Course>() {

			@Override
			public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
				Course course = new Course();
				course.setYear(rs.getString("year"));
				course.setSemester(rs.getInt("semester"));
				course.setCredit(rs.getInt("sum(credit)"));

				return course;
			}

		});

	}

	public boolean insert(Course course) {
		String year = "2020";
		int semester = 1;
		String code = course.getCode();
		String name = course.getName();
		String division = course.getDivision();
		int credit = course.getCredit();

		String sqlStatement = "insert into courses (year, semester, code, name, division, credit) values (?,?,?,?,?,?)";

		return (jdbcTemplate.update(sqlStatement, new Object[] { year, semester, code, name, division, credit }) == 1);
	}

	public boolean update(Course course) {
		String year = course.getYear();
		int semester = course.getSemester();
		String code = course.getCode();
		String name = course.getName();
		String division = course.getDivision();
		int credit = course.getCredit();

		String sqlStatement = "update courses set year=?, semester=?, name=?, division=?, credit=? where code=?";

		return (jdbcTemplate.update(sqlStatement, new Object[] { year, semester, name, division, credit, code }) == 1);
	}

	public boolean delete(String code) {
		String sqlStatement = "delete from courses where code=?";

		return (jdbcTemplate.update(sqlStatement, new Object[] { code }) == 1);
	}
}