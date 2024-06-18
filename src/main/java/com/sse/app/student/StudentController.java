package com.sse.app.student;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

	@RequestMapping("/student/list")
	public String getList() {

		System.out.println("list page");
		return "student/list";

	}
}