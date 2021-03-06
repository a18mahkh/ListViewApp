package org.brohede.marcus.listviewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String[] mountainNames = {"Matterhorn","Mont Blanc","Denali"};
    private String[] mountainLocations = {"Alps","Alps","Alaska"};
    private int[] mountainHeights ={4478,4808,6190};
    // Create ArrayLists from the raw data above and use these lists when populating your ListView.
    List<String> listData=new ArrayList<String>(Arrays.asList(mountainNames));




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayAdapter adapter=new ArrayAdapter(getApplicationContext(), R.layout.list_item_textview,
                R.id.my_item_textview, listData);

        ListView myListView = (ListView) findViewById(R.id.my_Listview);
        myListView.setAdapter(adapter);
        //adapter.add("hilding");
        myListView.setDivider(null);


        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                int bergHojd = mountainHeights[position];
                String bergNamn = mountainNames[position];

                Toast.makeText(getApplicationContext(), String.valueOf(bergNamn) + ": " + bergHojd + " Meter", Toast.LENGTH_SHORT).show();
                //Toast.makeText(getApplicationContext(), String.valueOf(bergHojd) + " Meter", Toast.LENGTH_SHORT).show();


            }
        });



        /* String[] kjell = {"Allamus", "David", "Anna"};



        Toast.makeText(getApplicationContext(), Arrays.toString(kjell), Toast.LENGTH_SHORT).show();

        Log.d("brom-debug", Arrays.toString(kjell));

        Button b = (Button) findViewById(R.id.toasterButton);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText my_EdtBox = (EditText) findViewById(R.id.toasterText);
                Toast.makeText(getApplicationContext(), my_EdtBox.getText(), Toast.LENGTH_SHORT).show();

            }
        });/

        // The onCreate method is run when the app is created.
        // Before you can implement this you need to create the layout xml files that
        // will hold/show your data created here. You need three create things:
        // * my_listview - the ID to the actual layout element that is our ListView.
        //                 This my_listview element is created in the activity_main.xml file
        // * list_item_textview - This is a new layout xml file that holds the layout for an
        //                        individual item in the ListView we are creating
        // * my_item_textview - This is the ID to the actual TextView that will contain the text for
        //                      an individual item in the ListView we are creating.
        // Here you should enter your code that fills the ListView
        // 1. Create an array
        // 2. Create a List object with your array from step 1 as in-data


        /*adapter=new ArrayAdapter<String>(this, R.layout.list_item_textview, R.id.list_item_textview, listData);
        ListView my_listview=(ListView) findViewById(R.id.my_listview);
        my_listview.setAdapter(adapter); */


        // 3. Create an ArrayAdapter object that connects
        //    * list_item_textview
        //    * my_item_textview
        //    * List object created in step 2
        // 4. Find the ListView layout element "my_listview" and create an object instance
        // 5. Connect the ArrayAdapter from step 3 with ListView object created in step 4
        // 6. Style the ListView items according to Material Design
        //    See: https://material.io/guidelines/components/lists.html#lists-specs
        //    Look for "singel line specs" for "text only" lists and modify the list_item_textview
        //    accordingly
    }
}
