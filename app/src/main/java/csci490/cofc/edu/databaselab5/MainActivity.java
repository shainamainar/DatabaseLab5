package csci490.cofc.edu.databaselab5;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button submitBut, dataBut;
    private LabDatabase labDatabase;
    public String DATABASE_NAME;
    public EditText name;
    public Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        labDatabase = Room.databaseBuilder(this,LabDatabase.class, DATABASE_NAME).build();
        submitBut = findViewById(R.id.submitButton);
        dataBut = findViewById(R.id.dataButton);
        name = findViewById(R.id.input);

        submitBut.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                submitToDatabase();
            }
        });
        dataBut.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                retrieveName();

            }
        });

    }
    public void submitToDatabase(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                Person person =new Person();
                person.setName(name.getText().toString());
                labDatabase.personDao().insertPerson(person);
            }
        }) .start();
    }
    public void retrieveName(){
        MyAsyncTask myAsyncTask = new MyAsyncTask(labDatabase, context);
        myAsyncTask.execute();
    }

}
