package csci490.cofc.edu.databaselab5;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by smainar on 3/15/2018.
 */
@Entity
public class Person {
    private String name;
    @PrimaryKey(autoGenerate = true)
    private int id;
    public Person(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
