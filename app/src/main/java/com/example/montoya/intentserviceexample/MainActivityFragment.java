package com.example.montoya.intentserviceexample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.montoya.intentserviceexample.Services.MiService;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private Button mStartService;
    private Button mScheduleService;

    public MainActivityFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView =inflater.inflate(R.layout.fragment_main, container, false);


        //
        mStartService=(Button)rootView.findViewById(R.id.btnStartService);
        mScheduleService=(Button) rootView.findViewById(R.id.btnScheduleService);




        // Listeners
        mStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startService();
            }
        });



        mScheduleService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





            }
        });














        return rootView;
    }



    private void startService(){

        Intent intent=new Intent (getActivity(), MiService.class);
        intent.putExtra(MiService.TRIGGER_METHOD,"Button");
        getActivity().startService(intent);


    }








}
