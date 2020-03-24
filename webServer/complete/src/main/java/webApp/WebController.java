package webApp;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
public class WebController implements WebMvcConfigurer {

//	@Override
//	public void addViewControllers(ViewControllerRegistry registry) {
//		registry.addViewController("/results").setViewName("results");
//	}

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

	@PostMapping("/home")
	public String checkUserInfo(@ModelAttribute("loginForm") LoginForm loginForm) {
		return "home";
	}




	// catalogue
	@GetMapping("/catalogue")
	public String searchForm(Model model) {
		model.addAttribute("searchForm", new SearchForm());
		return "catalogue";
	}

	@PostMapping("/catalogue")
	public String searchSubmit(@ModelAttribute("searchForm") SearchForm searchForm) {
		return "catalogue";
	}


	// faq
	@GetMapping("/faq")
	public String faq(){return "faq";}

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
