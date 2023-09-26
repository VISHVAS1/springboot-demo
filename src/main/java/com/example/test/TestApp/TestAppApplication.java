package com.example.test.TestApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class TestAppApplication {
	@Autowired
	@Qualifier("stu2")
	public Student  stu;
	public static void main(String[] args) {
		SpringApplication.run(TestAppApplication.class, args);
	}

	@GetMapping("/demo")
	public String index() {
		return "Greetings from Spring Boot change!";
	}
	@GetMapping("/{str}")
	public String hello(@PathVariable  String str){
		if(str.equals("vish")){
		throw  new ProductNotFoundException();}
		return "hello"+str+stu.getName();

	}
/*
	echo "# springboot-demo" >> README.md
	git init
	git add README.md
	git commit -m "first commit"
	git branch -M main
	git remote add origin https://github.com/VISHVAS1/springboot-demo.git
	git push -u origin main
*/

/*
	@GetMapping("/{himsg}")
	public String hi(@PathVariable String str){
		return "hi"+str;
	}
*/

	@GetMapping({"/myfoos/optional", "/myfoos/optional/{id}"})

	public String getFooByOptionalId(@PathVariable(required = false) String id){
		return "ID: " + id;
	}


}
@Configuration
class ContainBean{

	@Bean

	public Student stu1(){
		return new Student(11,"Ram");
	}

	@Bean
	public Student stu2(){
		return new Student(12,"Shyam");
	}

	@Bean
	public Student stu3(){
		return new Student(13,"Hari");
	}
}