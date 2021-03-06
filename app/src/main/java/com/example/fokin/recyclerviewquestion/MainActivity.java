package com.example.fokin.recyclerviewquestion;

import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RelativeLayout mRelativeLayout;
    private Button btnNext;
    private Boolean trying = false;
    private DrawerLayout mDrawerLayout;
    private int count = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNext = findViewById(R.id.btnNext);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mRelativeLayout = findViewById(R.id.content_frame);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        FragmentQuestion fragmentQuestion = new FragmentQuestion();
        FragmentResult fragmentResult = new FragmentResult();
        /**Счетчик вопросов и переключение на фрагмент с результатом теста**/
        if(count == 1) {
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.frame_fragment, fragmentQuestion);
            fragmentTransaction.commit();
        }
        else{
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.frame_fragment, fragmentResult);
            fragmentTransaction.commit();
            if(trying){
                mRelativeLayout.setBackground(getDrawable(R.drawable.suhgood));
            }
            else{
                mRelativeLayout.setBackground(getDrawable(R.drawable.notgood));
            }
            btnNext.setText("Пройти тест заново");

        }

    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }




}
