package webApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import webApp.CoursesQuery;

@Controller
public class WebController implements WebMvcConfigurer {

	// home
	@GetMapping("/")
	public String root() {
		return "redirect:/home";
	}

	@GetMapping("/home")
	public String loginForm(Model model) {
		model.addAttribute("loginForm", new LoginForm());
		return "home";
	}


	@RequestMapping(value="/catalogue", method = {RequestMethod.GET, RequestMethod.POST})
	public String createCourses(Model model, @ModelAttribute("searchForm") SearchForm searchForm){
		model.addAttribute("searchForm", new SearchForm());


		//model.addAttribute("s", s);

		return "catalogue";
	}



	// faq
	@GetMapping("/faq")
	public String faq(Model model){
		model.addAttribute("bugReportForm", new BugReportForm());
		return "faq";
	}

	@PostMapping("/faq")
	public String sendBug(@ModelAttribute("bugReportForm") BugReportForm bugReportForm){
		System.out.println(bugReportForm.getDescription());
		return "faq";
	}

	// schedule
	@GetMapping("/schedule")
	public String schedule(){return "schedule";}

	//My Degrees
	@GetMapping("/degree")
	public String degree(){ return "degree";}

	//My Courses
	@GetMapping("/course")
	public String course(){ return "course";}


	//sign In
	@GetMapping("/signIn")
	public String signIn(){ return "signIn";}

	//sign up

}
