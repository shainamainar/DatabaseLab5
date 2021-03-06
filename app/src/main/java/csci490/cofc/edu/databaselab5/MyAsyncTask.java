package csci490.cofc.edu.databaselab5;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.util.ArrayList;

/**
 * Created by smainar on 3/15/2018.
 */

public class MyAsyncTask extends AsyncTask<Void, Void, ArrayList<Person>>{
    LabDatabase labDatabase;
    private Context context;

    public MyAsyncTask(LabDatabase labDatabase, Context context){
        this.labDatabase = labDatabase;
        this.context = context;
    }

    @Override
    protected void onPostExecute(ArrayList<Person> persons) {
        super.onPostExecute(persons);
        ArrayList<String> personNames = new ArrayList<>();
        for(Person p: persons) {
            personNames.add(p.getName());
        }

        Intent i = new Intent(context, PersonsActivity.class);
        i.putExtra("Persons", personNames);
        context.startActivity(i);
    }

    protected ArrayList<Person> doInBackground(Void... voids) {
        ArrayList<Person> persons =(ArrayList) labDatabase.personDao().getAllPersons();
        return persons;
    }
}
