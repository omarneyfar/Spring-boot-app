package tn.iit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.iit.dto.StudentDto;

@Service
public class StudentService {
	private List<StudentDto> students = new ArrayList<>();

	public StudentService() {
		students.add(new StudentDto(1, "alaa",'M'));
		students.add(new StudentDto(2, "Bassma",'F'));
	}

	public void save(StudentDto studentDto) {
		students.add(studentDto);
	}
	public List<StudentDto> findAll() {
		return students;
	}

	public void delete(int id) {
		students.remove(new StudentDto(id,null,null));

	}
	public void update(int id, StudentDto studentsDto) {

		students.set(students.indexOf(studentsDto), studentsDto);

	}



	public StudentDto getById(int id) {

		return students.get(students.indexOf(new StudentDto(id, null, null)));

	}

}
