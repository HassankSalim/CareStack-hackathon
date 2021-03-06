package hassan.docappoint;

import java.util.ArrayList;

/**
 * Created by hassan on 14/11/17.
 */

public class DocDetails {

    private String docName,docSpec, docId;
    private ArrayList<String> days;
    private ArrayList<String> times;

    public DocDetails(String docName, String docSpec, String docId, ArrayList<String> days, ArrayList<String> times) {
        this.docName = docName;
        this.docSpec = docSpec;
        this.docId = docId;
        this.days = days;
        this.times = times;
    }

    public ArrayList<String> getDays() { return days; }

    public void setDays(ArrayList<String> days) { this.days = days; }

    public ArrayList<String> getTimes() { return times; }

    public void setTimes(ArrayList<String> times) { this.times = times; }

    public String getDocId() { return docId; }

    public void setDocId(String docId) { this.docId = docId; }

    public String getDocSpec() { return docSpec; }

    public void setDocSpec(String docSpec) { this.docSpec = docSpec; }

    public String getDocName() { return docName; }

    public void setDocName(String docName) { this.docName = docName; }

}
