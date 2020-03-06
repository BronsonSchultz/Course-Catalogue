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
