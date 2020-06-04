<<<<<<< HEAD
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
=======
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.util.Date;

/**
 *
 * @author Adair Hernández
 */
public class ProjectPojo {
    private String name;
    private Date date;
    private String activities;
    private String description;
    private String schedule;
    private String methodology;
    private String generalObjectives;
    private String immediateObjectives;
    private String mediateObjectives;
    private int requiredStudents;
    private int assignedStudents;
    private String status;
    
    private LinkedOrganizationPojo linkedOrganization;
>>>>>>> aaf92c49bb418bcb24acc07ee8e15bb265a01395

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

<<<<<<< HEAD
=======
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

>>>>>>> aaf92c49bb418bcb24acc07ee8e15bb265a01395
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

<<<<<<< HEAD
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
=======
    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public String getMethodology() {
        return methodology;
    }

    public void setMethodology(String methodology) {
        this.methodology = methodology;
    }

    public String getGeneralObjectives() {
        return generalObjectives;
    }

    public void setGeneralObjectives(String generalObjectives) {
        this.generalObjectives = generalObjectives;
    }

    public String getImmediateObjectives() {
        return immediateObjectives;
    }

    public void setImmediateObjectives(String immediateObjectives) {
        this.immediateObjectives = immediateObjectives;
    }

    public String getMediateObjectives() {
        return mediateObjectives;
    }

    public void setMediateObjectives(String mediateObjectives) {
        this.mediateObjectives = mediateObjectives;
    }

    public int getRequiredStudents() {
        return requiredStudents;
    }

    public void setRequiredStudents(int requiredStudents) {
        this.requiredStudents = requiredStudents;
    }
    
        public int getAssignedStudents() {
        return assignedStudents;
    }

    public void setAssignStudents(int assignedStudents) {
        this.assignedStudents = assignedStudents;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LinkedOrganizationPojo getLinkedOrganization() {
        return linkedOrganization;
    }

    public void setLinkedOrganization(LinkedOrganizationPojo linkedOrganization) {
        this.linkedOrganization = linkedOrganization;
    }
    
    
    
}
>>>>>>> aaf92c49bb418bcb24acc07ee8e15bb265a01395
