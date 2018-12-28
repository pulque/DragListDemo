package com.lizheblogs.draglistdemo;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.lizheblogs.draglistdemo.fragment.CodeFragment;
import com.lizheblogs.draglistdemo.fragment.DragGridFragment;
import com.lizheblogs.draglistdemo.fragment.DragListFragment;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    if (listFragment == null) {
                        listFragment = DragListFragment.newInstance();
                    }
                    updateFragment(listFragment);
                    return true;
                case R.id.navigation_dashboard:
                    if (gridFragment == null) {
                        gridFragment = DragGridFragment.newInstance();
                    }
                    updateFragment(gridFragment);
                    return true;
                case R.id.navigation_notifications:
                    if (codeFragment == null) {
                        codeFragment = CodeFragment.newInstance();
                    }
                    updateFragment(codeFragment);
                    return true;
            }
            return false;
        }
    };


    private DragListFragment listFragment;
    private DragGridFragment gridFragment;
    private CodeFragment codeFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            listFragment = DragListFragment.newInstance();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, listFragment)
                    .commitNow();
        }

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private void updateFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .commitNow();
    }

}
