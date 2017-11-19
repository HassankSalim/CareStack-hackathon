package hassan.docappoint;

/**
 * Created by hassan on 19/11/17.
 */

public class AppoinmentDetails {

    private String docName, timeAndDate;

    public AppoinmentDetails(String docName, String timeAndDate) {
        this.docName = docName;
        this.timeAndDate = timeAndDate;
    }

    public String getDocName() {
        return docName;
    }

    public String getTimeAndDate() {
        return timeAndDate;
    }

}
