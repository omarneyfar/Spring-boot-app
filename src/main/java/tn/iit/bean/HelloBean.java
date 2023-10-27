package tn.iit.bean;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {
	public String sayHello() {
		return "Hello first Spring Bean";
	}
}