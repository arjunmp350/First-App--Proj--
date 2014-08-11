
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

    List<Details> Details = new ArrayList();
    ListView DetailslistView;
    EditText classtxt;
    EditText dobtxt;
    EditText markstxt;
    EditText nametxt;

    public void (String string,String string2, String string3, String string4) {
        this.Details.add(new Details(string, string2, string3, string4));
    }

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);

        setContentView(MyActivity);

        nametxt = (EditText)(findViewById(R.id.textstud_name));
        dobtxt = (EditText)(findViewById(R.id.textdob));
        classtxt = (EditText)(findViewById(R.id.textClass));
        markstxt = (EditText)(findViewById(R.id.textmarks));
        DetailslistView = (ListView)(findViewById(R.id.listView));
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
                @Override
                public void onClick(View View) {


        button.setOnClickListener(new View.OnClickListener(){                           //(error) will be looked up later.
                MyActivity.this.addDetails(MyActivity.this.nametxt.getText().toString(), MyActivity.this.dobtxt.getText().toString(), MyActivity.this.classtxt.getText().toString(), MyActivity.this.markstxt.getText().toString());
                MyActivity.this.populatelist();
                Toast.makeText((Context)(MyActivity.this.getApplicationContext()), (CharSequence)("Your details has been added to list!"), (int)(0)).show();
            }
        }));
        
        nametxt.addTextChangedListener(new TextWatcher(){
        
            public void afterTextChanged(Editable editable) {
            }

            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }


            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Button button = button;
                boolean bl = !(MyActivity.this.nametxt.getText().toString().trim().isEmpty());
                button.setEnabled(bl);
            }
        }));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(2131165184, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 2131230738) return super.onOptionsItemSelected(menuItem);
        return true;
    }

    public void populatelist() {
        DetailslistAdapter detailslistAdapter = new DetailslistAdapter();
        this.DetailslistView.setAdapter(detailslistAdapter);
    }

    public class DetailslistAdapter
            extends ArrayAdapter<Details> {
        public DetailslistAdapter() {
            super(MyActivity.this, DetailslistAdapter, MyActivity.this.Details);
        }

        public View getView(int n, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = MyActivity.this.getLayoutInflater().inflate(DetailslistView, viewGroup, false);
            }
            Details details = (MyActivity.this.Details.get(n));
            (TextView)(view.findViewById(R.id.textView)).setText.details.getName();
            (TextView)(view.findViewById(R.id.textView)).setText.details.getDob();
            (TextView)(view.findViewById(R.id.textView)).setText.details.getClas();
            (TextView)(view.findViewById(R.id.textView)).setText.details.getMarks();
            return view;
        }
    }

}

