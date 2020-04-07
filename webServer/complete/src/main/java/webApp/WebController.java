package webApp;

import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * a router to deal with most of the website's endpoints
 */
@Controller
public class WebController implements WebMvcConfigurer {


	// home

	/**
	 * if the user goes to the '/' endpoint, redirect them to /home
	 * @return a spring redirect to /home
	 */
	@GetMapping("/")
	public String root() {
		return "redirect:/home";
	}

	/**
	 * display the home page at the /home endpoint
	 * @return the name fo the template that spring should render with a GET request at /home
	 */
	@GetMapping("/home")
	public String displayHome() {
		return "home";
	}


	//catalogue

	/**
	 * on a GET or a POST, display the appropriate template. GET here allows the search results to be shown while
	 * POST allows for the user to submit their search parameters
	 * @param model the model of the spring MVC
	 * @param searchForm the simple class that stores the user's search parameters
	 * @return the name of the template spring should render
	 * @throws SQLException if a connection to the database can't be formed
	 */
	@RequestMapping(value="/catalogue", method = {RequestMethod.GET, RequestMethod.POST})
	public String createCourses(Model model, @ModelAttribute("searchForm") SearchForm searchForm) throws SQLException {
		model.addAttribute("searchForm", new SearchForm());
		model.addAttribute("favAndCompleteForm", new FavAndCompleteForm());



		CourseSelector querier = new CourseSelector();
		if (searchForm.getYearLvl() != null && searchForm.getSubjectCode() != null) {
			ArrayList<HashMap<String, String>> courses = querier.getCoursesFromDB(searchForm.getSubjectCode(), searchForm.getYearLvl());
			JSONObject[] searchResults = querier.jsonifyList(courses);
			model.addAttribute("searchResults", searchResults);
			model.addAttribute("numResults", searchResults.length);
		}

		return "catalogue";
	}

	/**
	 * allow the user to favourite or mark a course as completed from the catalogue page
	 * @param favAndCompleteForm a simple class that save's the user's choices of a class
	 * @param searchForm the searchform attribute so the user can search again after saving a course
	 * @return the name of the template spring should render
	 */
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

	/**
	 * add a bug report form to the FAQ page and tell spring to render the faq template
	 * @param model the model object of the MVC
	 * @return the name of the template that should be rendered if the user goes to /faq with a GET request
	 */
	@GetMapping("/faq")
	public String faq(Model model){
		model.addAttribute("bugReportForm", new BugReportForm());
		return "faq";
	}

	/**
	 * allow the user to submit there bug report to the server, save that report to a text file along with a time stamp
	 * @param bugReportForm the model attribute we added in the get request, containing the user's input
	 * @return the name of the template that should be rendered if the user goes to /faq with a POST request
	 */
	@PostMapping("/faq")
	public String sendBug(@ModelAttribute("bugReportForm") BugReportForm bugReportForm){

		try {
			FileWriter writer = new FileWriter("bugReports.txt");
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date date = new Date();
			writer.write("//////// new bug report on " + dateFormat.format(date) + " //////// \n" + bugReportForm.getDescription() + "\n");
			writer.close();
			System.out.println("Successfully wrote to the bug log file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

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

/**
 * a smaller controller to deal with URL issues
 */
@Controller
@RequestMapping(path="/course")
class CourseController implements WebMvcConfigurer {

	/**
	 * on the catalogue page, show the user their saved courses
	 * @param model the model object of the MVC
	 * @return the name of the template spring should render
	 * @throws SQLException if a connection to the database can't be formed
	 */
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

	/**
	 * allow the user to delete all of their favourited courses
	 * @return a redirect to the course page
	 */
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