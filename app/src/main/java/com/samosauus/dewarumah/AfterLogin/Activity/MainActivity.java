package com.samosauus.dewarumah.AfterLogin.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.samosauus.dewarumah.AfterLogin.Adapter.AdapterHome;
import com.samosauus.dewarumah.AfterLogin.Adapter.ViewPagerAdapter;
import com.samosauus.dewarumah.BeforLogin.Activity.LoginActivity;
import com.samosauus.dewarumah.BeforLogin.Activity.SignUpActivity;
import com.samosauus.dewarumah.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Animation fabOpen, fabClose, rotateFwd, rotateBwd;
    FloatingActionButton fab_login, fab_signUp;
    boolean isOpen = false;

    AdapterHome AHome;
    ViewPagerAdapter adapter;
    ViewPager vPager;
    TextView txtNamaAgent;
    String nama,data;
//    FloatingActionButton fab;
    ImageView btnBonus,btnProspek,btnToko;
    Button btnClickLogin,btnClickDaftar;
    LinearLayout llmenu;

    String[] NProject = {
            "Alana",
            "Amaya",
            "Ayana",
            "Greenville Cileungsi",
            "Felicity Festival",
            "Felicity Hill",
            "Greenland Healthful Living",
            "Greenland Foresthill",
            "Greenland River Villa",
            "Greenville Darul Istiqomah",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        fab = (FloatingActionButton) findViewById(R.id.fab);
        btnBonus = (ImageView)findViewById(R.id.btnBonus);
        btnProspek = (ImageView)findViewById(R.id.btnProspek);
        btnToko = (ImageView)findViewById(R.id.btnToko);
        btnClickDaftar = (Button)findViewById(R.id.btnClickDaftar);
        btnClickLogin = (Button)findViewById(R.id.btnClickLogin);
        llmenu = (LinearLayout)findViewById(R.id.llMenu);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        data = null;

        data = getIntent().getStringExtra("nama");

        if (data == null){
            setMenu();
            llmenu.setVisibility(View.GONE);
            SetUpRecycler();
            SetUpViewPager();
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
//            FloatingActionButton();

        } else if (data != null){
            btnClickLogin.setVisibility(View.GONE);
            btnClickDaftar.setVisibility(View.GONE);
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            setMenu();
            SetUpViewPager();
            SetUpNav();
            SetUpRecycler();

//            fab.setVisibility(View.INVISIBLE);

        }

    }

    public void setMenu(){

        btnBonus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),ALBonus.class));

            }
        });

        btnClickLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                finish();

            }
        });

        btnProspek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),ALProspek.class));

            }
        });

        btnToko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(getApplicationContext(),TokoActivity.class));

            }
        });

        btnClickDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),SignUpActivity.class));
            }
        });

    }

//    public void FloatingActionButton(){
//
//        // inisialisasi animation
//
//        fabOpen = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_open);
//        fabClose = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fab_close);
//        rotateBwd = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_backward);
//        rotateFwd = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_forward);
//
//        // inisialisasi Fab
//        fab_login = (FloatingActionButton) findViewById(R.id.fab_login);
//        fab_signUp = (FloatingActionButton) findViewById(R.id.fab_signUp);
//
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (isOpen) {
//                    fab.startAnimation(rotateBwd);
//                    fab_login.startAnimation(fabClose);
//                    fab_signUp.startAnimation(fabClose);
//                    isOpen = false;
//                    fab_login.setClickable(false);
//                    fab_signUp.setClickable(false);
//                } else {
//                    fab.startAnimation(rotateFwd);
//                    fab_login.startAnimation(fabOpen);
//                    fab_signUp.startAnimation(fabOpen);
//                    isOpen = true;
//                    fab_login.setVisibility(View.VISIBLE);
//                    fab_signUp.setVisibility(View.VISIBLE);
//                    fab_login.setClickable(true);
//                    fab_signUp.setClickable(true);
//                }
//
//
//            }
//        });
//
//        fab_login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getApplicationContext(),LoginActivity.class));
//            }
//        });
//
//        fab_signUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent i = new Intent(getApplicationContext(),SignUpActivity.class);
//
//            }
//        });
//
//    }

    public void SetUpRecycler(){

        RecyclerView rvListProject = (RecyclerView) findViewById(R.id.rvListProject);

        rvListProject.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));
        AHome = new AdapterHome(getApplicationContext(), NProject);
        rvListProject.setAdapter(AHome);

    }

    public void SetUpViewPager(){

        vPager = (ViewPager) findViewById(R.id.vPager);
        adapter = new ViewPagerAdapter(this);
        vPager.setAdapter(adapter);

    }

    public void SetUpNav(){

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);

        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        txtNamaAgent = (TextView) navigationView.getHeaderView(0).findViewById(R.id.txtnamaAgent);
        txtNamaAgent.setText(data);

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

//            startActivity(new Intent(getApplicationContext(), SignUpActivity.class));

            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

            Intent i = new Intent(getApplicationContext(), ALBonus.class);
            startActivity(i);

        } else if (id == R.id.nav_gallery) {

            Intent i = new Intent(getApplicationContext(), ALInputProspek.class);
            startActivity(i);

        } else if (id == R.id.nav_slideshow) {

            Intent i = new Intent(getApplicationContext(), ALProfil.class);
            startActivity(i);

        } else if (id == R.id.nav_manage) {

            Intent i = new Intent(getApplicationContext(), ALProspek.class);
            startActivity(i);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;

    }

}
