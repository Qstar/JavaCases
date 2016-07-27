package collection_map_demo;

import java.util.HashSet;
import java.util.Set;

public class Student {
    public String id;
    public String name;
    private Set courses;

    public Student(String id, String name){
        this.id = id;
        this.name = name;
        this.courses = new HashSet();
    }
}
