package model;


import org.json.JSONObject;
import persistence.Writable;

import java.time.LocalDate;


//represents a Student with their name, result of covidTest, quarantineLocation
public class Student implements Writable {

    private final String name; // name of the student
    private final Boolean covidTest; // result of student's covid test
    private final String quarantineLocation; // where student is quarantining themselves in
    private final String arrivalDate; //date of arrival
    private final String country;
    private University university;

    /*
     * REQUIRES: studentName should be string, Date in YYYY-MM-DD format
     * EFFECTS: name of student is set to studentName;
     *          arrival is set to arrivalDate
     * Covid test is in boolean True = positive, False = negative
     * location is set to quarantine location of student
     */
    public Student(String studentName, Boolean report, String location, LocalDate arrival, String departureCountry) {
        name = studentName;
        arrivalDate = arrival.toString();
        quarantineLocation = location;
        covidTest = report;
        country = departureCountry.substring(0, 1).toUpperCase() + departureCountry.substring(1).toLowerCase();
    }

    // EFFECTS: returns name of student

    public String getName() {
        return name;
    }

    // EFFECTS: returns location of student

    public String getLocation() {
        return quarantineLocation;
    }

    // EFFECTS: returns arrival date of student
    public String getArrivalDate() {
        return arrivalDate;
    }

    // EFFECTS: returns result of void test of student
    public Boolean getTestReport() {
        return covidTest;
    }

    // EFFECTS: returns country of student
    public String getCountry() {
        return country;
    }

    //MODIFIES: this,uni
    //EFFECTS: assigns university to student
    public void assignToUni(University uni) {
        this.university = uni;
        uni.addStudent(this);
    }

    //EFFECTS: returns student's university
    public University getAssignedUni() {
        return university;
    }

    // MODIFIES: this, University uni = getAssignedBus()
    // EFFECTS: if student is assigned to a uni, removes student from assigned university;
    // otherwise has no effect
    public void removeFromUni() {
        University uni = getAssignedUni();
        if (this.university != null) {
            this.university = null;
            uni.removeStudent(this);
        }
    }


    // EFFECTS: returns json object with student details
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("covidTest", covidTest);
        json.put("quarantineLocation", quarantineLocation);
        json.put("country", country);
        json.put("date", arrivalDate);
        return json;
    }


}
