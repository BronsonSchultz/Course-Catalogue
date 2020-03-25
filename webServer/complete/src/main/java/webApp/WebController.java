package webApp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import webApp.CoursesQuery;

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

	@PostMapping("/home")
	public String checkUserInfo(@ModelAttribute("loginForm") LoginForm loginForm) {
		return "home";
	}



	@RequestMapping(value="/catalogue", method = {RequestMethod.GET, RequestMethod.POST})
	public String createCourses(Model model, @ModelAttribute("searchForm") SearchForm searchForm){
		model.addAttribute("searchForm", new SearchForm());

//		SearchResults s = new SearchResults("SELECT SubjectCode, CourseCode, CourseName, Description FROM Courses");
		SearchResults s = new SearchResults();
		
		ArrayList<Course> rsCourses = CoursesQuery.query(searchForm.getSearchStr());
		for (Course c : rsCourses) {
			s.addCourse(c);
		}

//		Course c = new Course("CMPT",100,"Introduction to Computing","A survey of" +
//				" major computer science areas, combining a breadth of topics with depth via specific examples within " +
//				"each topic. Topics include: history of computing, computer applications, analysis and design, high " +
//				"level programming, computer software, computer hardware, artificial intelligence, and the social" +
//				" impact of computers.");
//
//		Course d = new Course("MATH", 110, "Calculus I", "Introduction to " +
//				"derivatives, limits, techniques of differentiation, maximum and minimum problems and other" +
//				" applications, implicit differentiation, anti-derivatives.");
//
//
//		s.addCourse(c);
//		s.addCourse(d);
		model.addAttribute("s", s);

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
