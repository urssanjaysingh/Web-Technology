package mypack;

import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name;

    public Employee() {
        // Default constructor
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
