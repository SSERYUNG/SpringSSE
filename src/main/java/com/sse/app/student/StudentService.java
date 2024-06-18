package com.sse.app.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	private StudentDAO studentDAO;

	public List<StudentDTO> getList() {

		List<StudentDTO> ar = null;
		try {
			ar = studentDAO.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ar;
	}

	public void addStudentPost(StudentDTO studentDTO) {

		try {
			studentDAO.addStudentPost(studentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public StudentDTO detail(StudentDTO studentDTO) {
		try {
			studentDTO = studentDAO.detail(studentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			studentDTO = null;
		}
		return studentDTO;
	}

	public void remove(StudentDTO studentDTO) {

		try {
			studentDAO.remove(studentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(StudentDTO studentDTO) {
		try {
			studentDAO.update(studentDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
