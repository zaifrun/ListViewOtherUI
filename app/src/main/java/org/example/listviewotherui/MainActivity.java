package org.example.listviewotherui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {



    private String[] countries = { "Albania", "Algeria", "Armenia", "Andorra",
            "Angola", "Argentina", "Australia", "Bahrain", "Bangladesh",
            "Barbados", "Brazil", "China", "Denmark", "Egypt", "France",
            "Ghana", "Hong Kong", "India", "Italy", "United Kingdom",
            "United States", "United Arab Emirates" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //convert into an arraylist
        final ArrayList<String> list =new ArrayList<>(Arrays.asList(countries));

        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_checked, list);

        final ListView listView = findViewById(R.id.mylist);

        //only allow one element to be selected at the same time
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        //Selection Button clicked
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected = listView.getCheckedItemPosition();
                Log.d("selection","selected: "+selected);

                //check if something is clicked
                if (selected!=ListView.INVALID_POSITION)
                    Toast.makeText(getApplicationContext(),
                        "My selection: "+list.get(selected),Toast.LENGTH_SHORT).show();
            }
        });

        //add button clicked
       findViewById(R.id.add).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
                EditText editText = findViewById(R.id.editCountry);
                String newCountry = editText.getText().toString();
                if (newCountry.length()>0)
                {
                    adapter.add(newCountry);
                    Log.d("AddCountry","Adding : "+newCountry);
                    //you can also do the code below - same effect.
                    //list.add(newCountry);
                   // adapter.notifyDataSetChanged();
                }
           }
       });

       findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int selected = listView.getCheckedItemPosition();

               //check if something is selected
               if (selected!=ListView.INVALID_POSITION)
               {
                   String removeString = adapter.getItem(selected);

                   adapter.remove(removeString);
               }
           }
       });

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("listview","itemclicked");
                String country = list.get(position);
                Toast.makeText(getApplicationContext(),"you clicked : "+
                        country,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
