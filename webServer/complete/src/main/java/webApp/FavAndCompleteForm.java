package webApp;

public class FavAndCompleteForm {

    private boolean isFavourited;
    private boolean isCompleted;

    public boolean isFavourited() {
        return isFavourited;
    }

    public void setFavourited(boolean favourited) {
        isFavourited = favourited;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return "FavAndCompleteForm{" +
                "isFavourited=" + isFavourited +
                ", isCompleted=" + isCompleted +
                '}';
    }

}
