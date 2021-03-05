package model;


import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;

// represents a university with domestic and international students arrival list
public class University implements Writable {
    private String name;
    private final ArrayList<Student> domestic;
    private final ArrayList<Student> international;

    //constructs university with empty domestic and international student Arraylist.
    public University(String name) {
        this.name = name;
        domestic = new ArrayList<>();
        international = new ArrayList<>();

    }

    /*
    REQUIRES: Student input
    MODIFIES: this
    EFFECTS : adds the student name to the list
     */
    public void addToDomestic(Student student) {
        domestic.add(student);
    }

    /*
    REQUIRES: Student input
    MODIFIES: this
    EFFECTS : adds the student name to the list
     */
    public void addToInternational(Student student) {
        international.add(student);
    }

    public void addStudent(Student student) {
        if (!student.getCountry().equals("Canada")) {
            addToInternational(student);
        } else {
            addToDomestic(student);
        }
    }

    //EFFECTS returns domestic student list
    public ArrayList<Student> getDomestic() {
        return domestic;
    }

    //EFFECTS returns international student list
    public ArrayList<Student> getInternational() {
        return international;
    }

    /*
    REQUIRES: Name of Student
    EFFECTS: if student name is there, adds student to list
             checks for multiple similar student names
             returns list
     */
    public ArrayList<Student> searchStudent(String name) {
        ArrayList<Student> result = new ArrayList<>();

        for (Student value : domestic) {
            if (value.getName().equals(name)) {
                result.add(value);
            }
        }
        for (Student value : international) {
            if (value.getName().equals(name)) {
                result.add(value);
            }
        }
        return result;
    }

    // EFFECTS: returns total number of students

    public int totalStudents() {
        int canadians = domestic.size();
        int foreigners = international.size();
        return canadians + foreigners;
    }

    // EFFECTS: returns total number of domestic arrivals

    public int getDomesticSize() {
        return domestic.size();
    }

    // EFFECTS: returns total number of international arrivals

    public int getInternationalSize() {
        return international.size();
    }

    //EFFECTS: returns name of University
    public String getName() {
        return name;
    }

    //EFFECTS: returns json object with University details in it
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("domestic", domesticToJson());
        json.put("international", internationalToJson());
        return json;
    }

    // EFFECTS: returns domestic students in this university as a JSON array
    private JSONArray domesticToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Student s : domestic) {
            jsonArray.put(s.toJson());
        }

        return jsonArray;
    }

    // EFFECTS: returns international students in this university as a JSON array
    private JSONArray internationalToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Student s : international) {
            jsonArray.put(s.toJson());
        }

        return jsonArray;
    }
}

