package com.devqt.kubg.info;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class KUBG_main extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    public Elements content;
    public ArrayList<String> titleList = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kubg_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        listView = (ListView) findViewById(R.id.listview);
        new NewThread().execute();
        adapter = new ArrayAdapter<>(this, R.layout.listview_row, R.id.pro_item, titleList);
        adapter = new ArrayAdapter<>(this, R.layout.listview_row, R.id.pic, titleList);

        }





    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.kubg_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();


        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.il)  {

        } else if (id == R.id.pi) {

        } else if (id == R.id.izh) {

        } else if (id == R.id.im) {

        } else if (id == R.id.ifil) {

        } else if (id == R.id.iff) {

        } else if (id == R.id.fity) {

        } else if (id == R.id.fpmv) {

        } else if (id == R.id.fz) {

        } else if (id == R.id.yk) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public class NewThread extends AsyncTask<String, Void, String>{


        @Override
        protected String doInBackground(String... arg) {
            Document document;
            try {
                document = Jsoup.connect("http://kubg.edu.ua/prouniversitet/news/studentam.html").get();
                content = document.select("contentheading");
                titleList.clear();
                for (Element contents: content){
                    titleList.add(contents.text());
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            listView.setAdapter(adapter);
        }
    }


}
