package pojo;
import java.util.Date;


public class ProjectPojo {
    private String name;
    private String activities;
    private String description;
    private Date date;
    private String timetable;
    private String metodology;
    private int numStudents;
    private String generalObjetive;
    private String immediateObjetive;
    private String mediateObjetive;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActivities() {
        return activities;
    }

    public void setActivities(String activities) {
        this.activities = activities;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTimetable() {
        return timetable;
    }

    public void setTimetable(String timetable) {
        this.timetable = timetable;
    }

    public String getMetodology() {
        return metodology;
    }

    public void setMetodology(String metodology) {
        this.metodology = metodology;
    }

    public int getNumStudents() {
        return numStudents;
    }

    public void setNumStudents(int numStudents) {
        this.numStudents = numStudents;
    }

    public String getGeneralObjetive() {
        return generalObjetive;
    }

    public void setGeneralObjetive(String generalObjetive) {
        this.generalObjetive = generalObjetive;
    }

    public String getImmediateObjetive() {
        return immediateObjetive;
    }

    public void setImmediateObjetive(String immediateObjetive) {
        this.immediateObjetive = immediateObjetive;
    }

    public String getMediateObjetive() {
        return mediateObjetive;
    }

    public void setMediateObjetive(String mediateObjetive) {
        this.mediateObjetive = mediateObjetive;
    }

  }
