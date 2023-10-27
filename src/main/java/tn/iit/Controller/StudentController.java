package tn.iit.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.AllArgsConstructor;
import tn.iit.dto.StudentDto;
import tn.iit.service.StudentService;

@Controller
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
	private final StudentService studentService;

	@GetMapping("/")
	public String sayHello(Model model) {
		model.addAttribute("students", studentService.findAll());
		return "students";
	}

	@PostMapping("/save")
	public String save(@RequestParam(name = "id") int id, @RequestParam(name = "name") String name,
			@RequestParam(name = "gender") Character gender) {
		StudentDto studentDto = new StudentDto(id, name, gender);
		studentService.save(studentDto);
		return "redirect:/students/";
	}

	@PostMapping("/save2")
	public String save(@ModelAttribute StudentDto studentDto) {
		studentService.save(studentDto);
		return "redirect:/students/";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable(name = "id") int id) {
		studentService.delete(id);
		return "redirect:/students/";
	}

	@ResponseBody
	@PostMapping("/delete-ajax")
	public void deleteAjax(@RequestParam(name = "id") int id) {
		studentService.delete(id);
	}

	@GetMapping("/edit")

	public String edit(@RequestParam(name = "id") int id, Model model) {

		model.addAttribute("student", studentService.getById(id));

		return "studentsupdate";

	}

	@PostMapping("/update")

	public String update(@ModelAttribute StudentDto studentDto) {

		studentService.update(studentDto.getId(), studentDto);

		return "redirect:/students/";

	}

}
