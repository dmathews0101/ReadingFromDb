package com.readingfromdb;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;
public class MainActivity extends Activity {
    private final static String TAG = "MainActivity";
    DatabaseHelper dbHelper= null;




    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DatabaseHelper(this, getFilesDir().getAbsolutePath());

        try {
        	 dbHelper.prepareDatabase();
		} catch (IOException e) {
			Log.e(TAG, e.getMessage());
		}
        showData();
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//           getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    private void showData() {


        ArrayList<String> al_details = new ArrayList<>();
        al_details = dbHelper.al_details();


        for (int i=0; i<al_details.size();i++){
            Log.e("Value",al_details.get(i));
        }






        List<Employee> list = dbHelper.getEmployees();




//    	StringBuffer data = new StringBuffer();
//    	for (int i =0; i< list.size(); i++) {
//    		Employee emp = list.get(i);
//    		data.append(emp.getId()).append(",").append(emp.getName())
//    		.append(",").append(emp.getAge()).append("<br/>");
//    	}
//    	TextView textView = (TextView)findViewById(R.id.bodytext);
//    	textView.setText(Html.fromHtml(data.toString()));
    }
}