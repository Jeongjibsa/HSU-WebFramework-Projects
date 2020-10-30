package kr.ac.hansung.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import kr.ac.hansung.model.Course;
import kr.ac.hansung.model.Offer;
import kr.ac.hansung.service.CourseService;

@Controller
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/showCredit") // 학기별 이수 학점 조회
	public String showCredit(Model model) {
		List<Course> credits = courseService.getCredits();
		model.addAttribute("credits", credits);

		return "showCredit";
	}

//	@RequestMapping("/showCreditDetail") // 학기별 이수 학점 조회 - 상세보기
//	public String showCreditDetail(Model model, @RequestParam("year") String year,
//			@RequestParam("semester") int semester) {
//		List<Course> courses = courseService.getCurrent(year, semester);
//		model.addAttribute("courses", courses);
//
//		return "showCreditDetail";
//	}
	
	@RequestMapping(value="/showCreditDetail", method = RequestMethod.GET) // 학기별 이수 학점 조회 - 상세보기
	public String showCreditDetail(Model model, Course course) {
		List<Course> courses = courseService.getCurrent(course.getYear(), course.getSemester());
		model.addAttribute("courses", courses);

		return "showCreditDetail";
	}

	@RequestMapping("/showCurrent") // 수강 신청 조회
	public String showCourses(Model model) {
		List<Course> courses = courseService.getCurrent("2020", 1);
		model.addAttribute("courses", courses);

		return "showCurrent";
	}

	@RequestMapping("/createCourse") // 수강 신청
	public String createOffer(Model model) {

		model.addAttribute("course", new Course());

		return "createCourse";
	}

	@RequestMapping("/doCreateCourse")
	public String doCreate(Model model, @Valid Course course, BindingResult result) {

		if (result.hasErrors()) {
			System.out.println("==== Web Form data does not validated ===");
			List<ObjectError> errors = result.getAllErrors();

			for (ObjectError error : errors) {
				System.out.println(error.getDefaultMessage());
			}

			return "createCourse";
		}

//		System.out.println(offer);
		courseService.insert(course); // controller -> service -> dao

		return "courseCreated";
	}
}
