package webApp;

public class SearchForm {

    private String searchStr;
    private int yearLvl;

    @Override
    public String toString() {
        return "SearchForm{" +
                "searchStr='" + searchStr + '\'' +
                ", yearLvl=" + yearLvl +
                '}';
    }

    public String getYearLvl() {
    	if (yearLvl != 0) {
    		return "SELECT Subject, CourseCode, CourseName FROM Courses WHERE CourseCode LIKE '" +  yearLvl + "%'";
    	}
    	else {
    		return "SELECT Subject, CourseCode, CourseName FROM Courses;
    	}
    }

    public void setYearLvl(int yearLvl) {
        this.yearLvl = yearLvl;
    }

    public String getSearchStr() {
    	return "SELECT Subject, CourseCode, CourseName FROM Courses WHERE CourseName LIKE '%" +  searchStr + "%'";
    }

    public void setSearchStr(String searchStr) {
        this.searchStr = searchStr;
    }

}
