package minocha.rishabh.htv2;

/**
 * Created by rishabh on 24/02/18.
 */

public class ReviewApplication {

    private String description;
    private String location;
    private String time;
    private String rating;
    private String appId;
    public ReviewApplication(String description, String location, String time, String rating, String appId){
        this.description=description;
        this.time=time;
        this.location=location;
        this.rating=rating;
        this.appId = appId;

    }
    public ReviewApplication(){

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getRating() {
        return rating;
    }

    public void getRating(String rating) {
        this.rating = rating;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

}
