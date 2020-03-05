package webApp;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
public class WebController implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/results").setViewName("results");
	}


	@GetMapping("/")
	public String root() {
		return "redirect:/home";
	}


	@PostMapping("/")
	public String checkUserInfo(@Valid LoginForm loginForm, BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "home";
		}

		return "redirect:/home";
	}

	@GetMapping("/home")
	public String showForm(LoginForm loginForm){ return "home"; }

	@GetMapping("/catalogue")
	public String cat(){return "catalogue";}

	@GetMapping("/faq")
	public String faq(){return "faq";}

	@GetMapping("/schedule")
	public String schedule(){return "schedule";}

}
