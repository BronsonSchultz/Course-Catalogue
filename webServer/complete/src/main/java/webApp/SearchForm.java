package webApp;

import javax.validation.constraints.Size;

public class SearchForm {


    private String subjectCode;

    private String yearLvl;

    @Override
    public String toString() {
        return "SearchForm{" +
                "subjectCode='" + subjectCode + '\'' +
                ", yearLvl='" + yearLvl + '\'' +
                '}';
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
