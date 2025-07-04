package task.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
public class Person {
    @Id
    @GeneratedValue
    private int id;

    @NonNull private String name;
    @NonNull private String locationName;

    public Person() {
    }

    public Person(String name, String locationName) {
        this.name = name;
        this.locationName = locationName;
    }

    public Person(int id, String name, String locationName) {
        this.id = id;
        this.name = name;
        this.locationName = locationName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
