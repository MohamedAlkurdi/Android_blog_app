package com.example.blogappproject;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TaskFactory extends Fragment {

    EditText titleInput;
    EditText descriptionInput;
    Button createTaskButton;
    FirebaseAuth auth;
    FirebaseUser user;
    String author;

    public TaskFactory() {
        // Required empty public constructor
    }

    public interface OnNewTaskListener {
        void onNewTaskCreated(Task task);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialization that doesn't involve views goes here
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task_factory, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        titleInput = view.findViewById(R.id.task_title_input);
        descriptionInput = view.findViewById(R.id.task_description_input);
        createTaskButton = view.findViewById(R.id.create_task_button);
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        author = user.getEmail().toString();

        createTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleInput.getText().toString();
                String description = descriptionInput.getText().toString();

                if(!title.isEmpty() && !description.isEmpty() && !author.isEmpty()){
                    Task task = new Task(title,description);
                    task.setAuthor(author);
                    //some logic to send the new task to the main fragment
                    titleInput.setText("");
                    descriptionInput.setText("");
                    Toast.makeText(requireContext(), "Added successfully.", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(requireContext(), "Review the task creation process, there is an error.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}