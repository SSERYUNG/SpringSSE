package com.sse.app.student;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/student/list")
	public String getList(HttpServletRequest request) {

		List<StudentDTO> stlist = studentService.getList();
		request.setAttribute("list", stlist);
		return "student/list";

	}

	@RequestMapping(value = "/student/add", method = RequestMethod.POST)
	public String addStudentPost(HttpServletRequest request) {

		StudentDTO student = new StudentDTO();

		String name = request.getParameter("name");
		int a = Integer.parseInt(request.getParameter("kor"));
		int b = Integer.parseInt(request.getParameter("eng"));
		int c = Integer.parseInt(request.getParameter("math"));
		int d = a + b + c;
		double e = d / 3;

		student.setName(name);
		student.setKor(a);
		student.setEng(b);
		student.setMath(c);
		student.setTotal(d);
		student.setAvg(e);

		studentService.addStudentPost(student);
		return "redirect:./list";

	}

	@RequestMapping(value = "/student/add", method = RequestMethod.GET)
	public String addStudentGet(HttpServletRequest request) {
		return "student/add";
	}

	@RequestMapping("/student/detail")
	public String detail(HttpServletRequest request) {
		String number = request.getParameter("num");
		StudentDTO st = new StudentDTO();
		st.setNum(Integer.parseInt(number));
		st = studentService.detail(st);

		if (st != null) {

			request.setAttribute("one", st);
			return "student/detail";
		} else {

			request.setAttribute("message", "정보가 없습니다");
			return "commons/message";
		}
	}

	@RequestMapping(value = "/student/delete", method = RequestMethod.POST)
	public String delete(HttpServletRequest request) {

		int num = Integer.parseInt(request.getParameter("number"));
		StudentDTO one = new StudentDTO();
		one.setNum(num);
		studentService.remove(one);

		return "redirect:./list";
	}

	@RequestMapping(value = "/student/update", method = RequestMethod.POST)
	public String updatePost(HttpServletRequest request) {

		int num = Integer.parseInt(request.getParameter("num"));
		String name = request.getParameter("name");
		int kor = Integer.parseInt(request.getParameter("kor"));
		int eng = Integer.parseInt(request.getParameter("eng"));
		int math = Integer.parseInt(request.getParameter("math"));
		int total = kor + eng + math;
		double avg = total / 3;

		StudentDTO studentDTO = new StudentDTO();

		studentDTO.setNum(num);
		studentDTO.setName(name);
		studentDTO.setKor(kor);
		studentDTO.setEng(eng);
		studentDTO.setMath(math);
		studentDTO.setTotal(total);
		studentDTO.setAvg(avg);

		studentService.update(studentDTO);

		return "redirect:./list";

	}

	@RequestMapping(value = "/student/update", method = RequestMethod.GET)
	public String updateGet(HttpServletRequest request) {

		int i = Integer.parseInt(request.getParameter("number"));
		StudentDTO one = new StudentDTO();
		one.setNum(i);
		StudentDTO student = studentService.detail(one);

		request.setAttribute("st", student);

		return "student/update";

	}

}