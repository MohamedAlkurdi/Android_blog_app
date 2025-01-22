package com.example.blogappproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class profile extends Fragment {


    private int tasksNumber;
    private int completeTasksNumber;
    TextView totalTasksText;
    TextView completeTasksText;
    FirebaseAuth auth;
    FirebaseUser user;
    TextView title;


    public profile(){}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialization that doesn't involve views goes here
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        tasksNumber = 9; //will find out a way to track the number properly.
        completeTasksNumber = 9; //will find out a way to track the number properly.
        totalTasksText = view.findViewById(R.id.totalTasks);
        completeTasksText = view.findViewById(R.id.completeTasks);
        if(user != null){
        title = view.findViewById(R.id.profile_title);
            if (title != null) {
                title.setText(user.getEmail().toString());
            }
            totalTasksText.setText("Created Tasks: "+String.valueOf(tasksNumber));
            completeTasksText.setText("Created Tasks: "+String.valueOf(completeTasksNumber));
        }

        Button logoutBtn = view.findViewById(R.id.logout_btn);

        logoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getActivity(), Login.class);
                startActivity(intent);
                getActivity().finish();
            }
        });

        // Initialize other views here
    }
}