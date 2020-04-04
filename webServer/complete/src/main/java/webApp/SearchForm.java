package webApp;

public class SearchForm {

    private String subjectCode;
    private String yearLvl;
    private int numResults;

    @Override
    public String toString() {
        return "SearchForm{" +
                "subjectCode='" + subjectCode + '\'' +
                ", yearLvl=" + yearLvl +
                ", numResults=" + numResults +
                '}';
    }

    public int getNumResults() {
        return numResults;
    }

    public void setNumResults(int numResults) {
        this.numResults = numResults;
    }

    public String getYearLvl() {
        return yearLvl;
    }

    public void setYearLvl(String yearLvl) {
        this.yearLvl = yearLvl;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

}
