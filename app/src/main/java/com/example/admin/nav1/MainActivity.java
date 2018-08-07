package com.example.admin.nav1;

import android.arch.lifecycle.ViewModelProviders;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.admin.nav1.controller.FragmentHelper;
import com.example.admin.nav1.controller.Metrics;
import com.example.admin.nav1.model.ChapterRoomDatabase;
import com.example.admin.nav1.model.ChapterViewModel;
import com.example.admin.nav1.model.PopulateDB;
import com.example.admin.nav1.ui.ChapterDialogFragment;
import com.example.admin.nav1.ui.PictureFragment;
import com.example.admin.nav1.ui.RVFagment;
import com.example.admin.nav1.ui.TextFragment;

import static com.example.admin.nav1.model.ChapterRoomDatabase.rdc;
import static com.example.admin.nav1.ui.TextFragment.addButton;
import static com.example.admin.nav1.ui.TextFragment.setText;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    Context context;
    public static FragmentManager fragmentManager;
    public static FragmentTransaction fragmentTransaction;
    public static RecyclerView recyclerView;
    public static FragmentHelper fragmentHelper;
    public static RVFagment rvFagment;
    public static PictureFragment pictureFragment;
    public static TextFragment textFragment;
    public static ChapterDialogFragment chapterDialogFragment;
    public static ChapterRoomDatabase db;
    public static Metrics metrics;
    Configuration configuration;
    public static ChapterViewModel model;
    SharedPreferences preferences;
    final String DB_CREATED = "db_room";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        final FrameLayout container = findViewById(R.id.container);

        rvFagment = new RVFagment();
        pictureFragment = new PictureFragment();
        textFragment = new TextFragment();

        recyclerView = findViewById(R.id.rv);

        fragmentHelper = new FragmentHelper(this);
        chapterDialogFragment = new ChapterDialogFragment();
        configuration = getResources().getConfiguration();


        final String currentPreferences = getPreferences(MODE_PRIVATE).getString(DB_CREATED,"");

        if(currentPreferences.compareTo("room_db")!=0) {


            db = ChapterRoomDatabase.getDatabase(this);

            SupportSQLiteDatabase supportSQLiteDatabase = db.getOpenHelper().getWritableDatabase();


            rdc.onOpen(supportSQLiteDatabase);

            preferences = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString(DB_CREATED,"room_db");
            editor.commit();
        } else db = ChapterRoomDatabase.getDatabase(this);

        model = ViewModelProviders.of(this).get(ChapterViewModel.class);

        if(model.getWidthView()==0){

            onConfigurationChanged(configuration);
        }

        if (savedInstanceState==null){

            fragmentHelper.replaceFragment(model.getData());
        }

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
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {

            case R.id.nav_camera:


                model.getCurrentFragment(chapterDialogFragment);
                chapterDialogFragment.show(getSupportFragmentManager(),"dialog_fragment");

                break;
            case R.id.nav_gallery:

                model.getCurrentFragment(rvFagment);
                fragmentHelper.replaceFragment(rvFagment);

                break;

                        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void onUserSelectValue(Integer selectedValue) {

        addButton = false;
        setText (Integer.toString(selectedValue));

        TextFragment selectTextFragment = new TextFragment();
        model.getCurrentFragment(selectTextFragment);
        fragmentHelper.replaceFragment(selectTextFragment);

        //selected item from 0
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        DisplayMetrics displayMetrics = this.getResources().getDisplayMetrics();

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){

            model.setWidthView(displayMetrics.widthPixels);

        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE)

                {
                    model.setWidthView(displayMetrics.heightPixels);
                }
    }
}
