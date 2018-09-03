package org.example.listviewotherui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_checked, countries);

        final ListView listView = findViewById(R.id.mylist);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        //Button clicked
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selected = listView.getCheckedItemPosition();
                Log.d("selection","selected: "+selected);
                if (selected!=ListView.INVALID_POSITION)
                Toast.makeText(getApplicationContext(),
                        "My selection: "+countries[selected],Toast.LENGTH_SHORT).show();
            }
        });

        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.d("listview","itemclicked");
                String country = countries[position];
                Toast.makeText(getApplicationContext(),"you clicked : "+
                        country,Toast.LENGTH_SHORT).show();
            }
        });

    }
}
