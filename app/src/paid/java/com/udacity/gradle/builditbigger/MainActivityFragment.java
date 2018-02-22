package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.riso.android.jokes.JimmyCarr;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {
    private static final String JOKE = "joke";
    private Button button;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

//        AdView mAdView = (AdView) root.findViewById(R.id.adView);
//        // Create an ad request. Check logcat output for the hashed device ID to
//        // get test ads on a physical device. e.g.
//        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
//        AdRequest adRequest = new AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
//                .build();
//        mAdView.loadAd(adRequest);

        button = root.findViewById(R.id.jokeButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EndpointsAsyncTask().execute(MainActivityFragment.this);
            }
        });

        return root;
    }

    public void showJoke(String vtip){
        Intent intent = new Intent(getActivity(), JimmyCarr.class);
        intent.putExtra(JOKE, vtip);
        getActivity().startActivity(intent);
    }
}
