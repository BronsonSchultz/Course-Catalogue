package webApp;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.HashMap;
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
	public String createCourses(Model model, @ModelAttribute("searchForm") SearchForm searchForm) throws SQLException {
		model.addAttribute("searchForm", new SearchForm());
		model.addAttribute("favAndCompleteForm", new FavAndCompleteForm());

		CourseSelector querier = new CourseSelector();
		if (searchForm.getYearLvl() != null && searchForm.getSubjectCode() != null) {
			ArrayList<HashMap<String, String>> courses = querier.getCoursesFromDB(searchForm.getSubjectCode(), searchForm.getYearLvl());
			JSONObject[] searchResults = querier.jsonifyList(courses);
			model.addAttribute("searchResults", searchResults);
		}

		return "catalogue";
	}

	@PostMapping("/catalogue/sidebar")
	public String addFavOrComp(@ModelAttribute("favAndCompleteForm") FavAndCompleteForm favAndCompleteForm, @ModelAttribute("searchForm") SearchForm searchForm){

		CourseInserter inserter = new CourseInserter();
		System.out.println(favAndCompleteForm);
		try {
			if (favAndCompleteForm.getFavourited() != null) {
				inserter.insertFavForUser(favAndCompleteForm.getSubjectCode(), favAndCompleteForm.getCourseCode(), "1");
			} else if (favAndCompleteForm.getCompleted() != null){
				inserter.insertCompletedForUser(favAndCompleteForm.getSubjectCode(), favAndCompleteForm.getCourseCode(), "1");
			} else if (favAndCompleteForm.getFavourited() != null && favAndCompleteForm.getCompleted() != null) {
				inserter.insertFavForUser(favAndCompleteForm.getSubjectCode(), favAndCompleteForm.getCourseCode(), "1");
				inserter.insertCompletedForUser(favAndCompleteForm.getSubjectCode(), favAndCompleteForm.getCourseCode(), "1");
			}

		} catch (SQLException e){
			System.out.println(e);
		}
		return "redirect:/catalogue";
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

	//sign In
	@GetMapping("/signIn")
	public String signIn(){ return "signIn";}

	//sign up

}

@Controller
@RequestMapping(path="/course")
class CourseController implements WebMvcConfigurer {
	//My Courses
	@RequestMapping(value="", method = {RequestMethod.GET})
	public String course(Model model) throws SQLException{
		CourseSelector querier = new CourseSelector();

		//if the user is logged in then
		ArrayList<HashMap<String, String>> courses = querier.getUserFavCourses("1");
		JSONObject[] jFavs = querier.jsonifyList(courses);

		courses = querier.getUserCompletedCourses("1");
		JSONObject[] jComplete = querier.jsonifyList(courses);

		model.addAttribute("favourites", jFavs);
		model.addAttribute("completes", jComplete);

		return "course";
	}

	@PostMapping("/favourites")
	public String clearFavs(){
		CourseDeleter deleter = new CourseDeleter();
		try {
			deleter.clearFavForUser("1");
		} catch (SQLException e){
			System.out.println(e);
		}
		return "redirect:/course";
	}
}