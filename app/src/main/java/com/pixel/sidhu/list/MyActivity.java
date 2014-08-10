
package com.pixel.sidhu.list;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.Toast;
import com.pixel.sidhu.list.Details;
import java.lang.CharSequence;
import java.lang.Object;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("ResourceType")
public class MyActivity
        extends Activity {
    List<Details> Details = new ArrayList();
    ListView DetailslistView;
    EditText classtxt;
    EditText dobtxt;
    EditText markstxt;
    EditText nametxt;

    public void addDetails(String string, String string2, String string3, String string4) {
        this.Details.add((Object)(new Details(string, string2, string3, string4)));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.setContentView(2130903040);
        this.nametxt = (EditText)(this.findViewById(2131230722));
        this.dobtxt = (EditText)(this.findViewById(2131230723));
        this.classtxt = (EditText)(this.findViewById(2131230724));
        this.markstxt = (EditText)(this.findViewById(2131230725));
        this.DetailslistView = (ListView)(this.findViewById(2131230729));
        TabHost tabHost = (TabHost)(this.findViewById(2131230720));
        tabHost.setup();
        TabHost.TabSpec tabSpec = tabHost.newTabSpec("Creator");
        tabSpec.setContent(2131230721);
        tabSpec.setIndicator((CharSequence)("Creator"));
        tabHost.addTab(tabSpec);
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec("List");
        tabSpec2.setContent(2131230727);
        tabSpec2.setIndicator((CharSequence)("List"));
        tabHost.addTab(tabSpec2);
        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec("About us");
        tabSpec3.setContent(2131230730);
        tabSpec3.setIndicator((CharSequence)("About us"));
        tabHost.addTab(tabSpec3);
        Button button = (Button)(this.findViewById(2131230726));
        button.setOnClickListener((View.OnClickListener)(new View.OnClickListener(){

            public void onClick(View view) {
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
        this.DetailslistView.setAdapter((ListAdapter)(detailslistAdapter));
    }

    public class DetailslistAdapter
            extends ArrayAdapter<Details> {
        public DetailslistAdapter() {
            super((Context)(MyActivity.this), 2130903041, MyActivity.this.Details);
        }

        public View getView(int n, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = MyActivity.this.getLayoutInflater().inflate(2130903041, viewGroup, false);
            }
            Details details = (Details)(MyActivity.this.Details.get(n));
            (TextView)(view.findViewById(2131230734)).setText((CharSequence)(details.getName()));
            (TextView)(view.findViewById(2131230735)).setText((CharSequence)(details.getDob()));
            (TextView)(view.findViewById(2131230736)).setText((CharSequence)(details.getClas()));
            (TextView)(view.findViewById(2131230737)).setText((CharSequence)(details.getMarks()));
            return view;
        }
    }

}

