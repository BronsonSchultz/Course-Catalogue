package webApp;

public class SearchForm {

    private String searchStr = "CMPT";
    private int yearLvl;
    private int numResults;

    @Override
    public String toString() {
        return "SearchForm{" +
                "searchStr='" + searchStr + '\'' +
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

    public int getYearLvl() {
        return yearLvl;
    }

    public void setYearLvl(int yearLvl) {
        this.yearLvl = yearLvl;
    }

    public String getSearchStr() {
        return searchStr;
    }

    public void setSearchStr(String searchStr) {
        this.searchStr = searchStr;
    }

}
