package kr.ac.hansung.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Course {
	private String year;

	private int semester;

	@Size(min = 7, max = 7, message = "Course Code must be 7 chars")
	@NotEmpty(message = "The code cannot be empty")
	private String code;

	@Size(min = 2, max = 100, message = "Course Name must be between 2 and 100 chars")
	@NotEmpty(message = "The course name cannot be empty")
	@Pattern(regexp="^[A-Z]{1}[a-z]+$")
	private String name;

	@Size(min = 2, max = 50, message = "Course Division must be between 2 and 50 chars")
	@NotEmpty(message = "The course division cannot be empty")
	private String division;

	@Min(1)
	@Max(3)
	private int credit;
}
