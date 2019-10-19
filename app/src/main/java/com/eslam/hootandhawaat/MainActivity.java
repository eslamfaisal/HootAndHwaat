package com.eslam.hootandhawaat;

import android.os.Bundle;

import com.eslam.hootandhawaat.fragments.MainFragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = getSupportFragmentManager();
    MainFragment mainFragment = new MainFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        replaceFragment(mainFragment);

    }

    private void replaceFragment(Fragment fragment) {

        fragmentManager.beginTransaction().add(R.id.container, fragment).commit();
    }
}
