package com.vishal.fragmentbasictest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.vishal.fragmentbasictest.com.vishal.fragmentbasictest.fragments.TestFragmentOne;
import com.vishal.fragmentbasictest.com.vishal.fragmentbasictest.fragments.TestFragmentTwo;

import java.util.List;

public class MainActivity extends FragmentActivity implements TestFragmentOne.OnFragmentInteractionListener, TestFragmentTwo.OnFragmentInteractionListener{

    Fragment fragmentOne, fragmentTwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.v("FRAGMENT-TEST", "R.id.fragment1 = " + R.id.fragment1);
        Log.v("FRAGMENT-TEST", "R.id.fragment2 = " + R.id.fragment2);
        FragmentManager fm = getSupportFragmentManager();
        List<Fragment> fragments = fm.getFragments();
        for(Fragment fragment : fragments) {
            Log.v("FRAGMENT-TEST", "fragment-id : " + fragment.getId());
            if(fragment.getId() == R.id.fragment1) {
                fragmentOne = fragment;
            } else if(fragment.getId() == R.id.fragment2) {
                fragmentTwo = fragment;
            }
        }

    }

    @Override
    public void msgFromFragmentOne(String msg) {

        ((TestFragmentTwo)fragmentTwo).setMessage(msg);
    }

    @Override
    public void msgFromFragmentTwo(String msg) {

        ((TestFragmentOne)fragmentOne).setMessage(msg);
    }
}
