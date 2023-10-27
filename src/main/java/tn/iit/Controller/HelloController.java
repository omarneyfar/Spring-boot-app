package tn.iit.Controller;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/hello")
public class HelloController {
@GetMapping("/index")
public String sayHello(Model model) {
	model.addAttribute("ServerTime",LocalDate.now());
	return "hello";
}
@GetMapping("/index2")
public ModelAndView sayHello2() {
	ModelAndView modelAndView=new ModelAndView();
	modelAndView.addObject("ServerTime",LocalTime.now());
	modelAndView.setViewName("hello");

	return modelAndView;
}
}
