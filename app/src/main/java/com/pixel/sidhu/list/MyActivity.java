
package com.pixel.sidhu.list;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.CharSequence;
import java.lang.Object;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

public class MyActivity extends Activity {


    EditText nametxt,dobtxt, classtxt,markstxt;
    List<Details> Details = new ArrayList<Details>();
    ListView detailsListView;


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(R.layout.activity_my);

        nametxt = (EditText)(findViewById(R.id.textstud_name));
        dobtxt = (EditText)(findViewById(R.id.textdob));
        classtxt = (EditText)(findViewById(R.id.textClass));
        markstxt = (EditText)(findViewById(R.id.textmarks));
        detailsListView = (ListView)findViewById(R.id.listView);
        TabHost tabHost = (TabHost)(findViewById(R.id.tabHost));

        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("Creator");
        tabSpec.setContent(R.id.tabcreator);
        tabSpec.setIndicator("Creator");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("List");
        tabSpec.setContent(R.id.tablist);
        tabSpec.setIndicator("List");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("About us");
        tabSpec.setContent(R.id.tababtus);
        tabSpec.setIndicator("About us");
        tabHost.addTab(tabSpec);

        final Button button = (Button)(findViewById(R.id.btnadd));

        button.setOnClickListener(new View.OnClickListener(); {             //error.
            addDetail(nametxt.getText().toString(), dobtxt.getText().toString(), classtxt.getText().toString(), markstxt.getText().toString());
            populatelist();
            Toast.makeText(getApplicationContext(), nametxt.getText().toString() + "Your details has been added to list!", Toast.LENGTH_SHORT).show();

            };
        
        nametxt.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                boolean bl = !(MyActivity.this.nametxt.getText().toString().trim().isEmpty());
                button.setEnabled(bl);
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        });
    }


    public void populatelist() {
        ArrayAdapter<Details> adapter = new detailslistAdapter();
        detailsListView.setAdapter(adapter);
    }

    private  void addDetail (String name, String dob, String clas , String marks){
        Details.add(new Details(name,dob,clas,marks));
    }

   private class detailslistAdapter extends  ArrayAdapter<Details> {
       public detailslistAdapter() {
           super(MyActivity.this, R.layout.listview_item, Details);
       }

       @Override
       public View getView(int position, View view, ViewGroup viewGroup) {
           if (view == null)
               view = getLayoutInflater().inflate(R.layout.listview_item, viewGroup, false);

           Details currentdetails = (MyActivity.this.Details.get(position));

           TextView name = (TextView) (view.findViewById(R.id.textstud_name));
           name.setText(currentdetails.getName());
           TextView dob = (TextView) (view.findViewById(R.id.textdob));
           dob.setText(currentdetails.getDob());
           TextView clas = (TextView) (view.findViewById(R.id.textClass));
           clas.setText(currentdetails.getClas());
           TextView marks = (TextView) (view.findViewById(R.id.textmarks));
           marks.setText(currentdetails.getMarks());

           return view;

       }

   }

}

