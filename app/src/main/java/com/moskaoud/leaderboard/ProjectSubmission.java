package com.moskaoud.leaderboard;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.moskaoud.leaderboard.services.DataService;
import com.moskaoud.leaderboard.services.ServiceBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProjectSubmission extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_submission);

        EditText firstNameET = findViewById(R.id.first_name_et);
        EditText lastNameET = findViewById(R.id.last_name_et);
        EditText emailET = findViewById(R.id.email_et);
        EditText urlET = findViewById(R.id.url_et);
        Button submit = findViewById(R.id.submit_btn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = firstNameET.getText().toString();
                String lastName = lastNameET.getText().toString();
                String email = emailET.getText().toString();
                String url = urlET.getText().toString();

                DataService taskService = ServiceBuilder.buildService(DataService.class);
                Call<Void> call = taskService.submitProject(firstName, lastName, email, url);

                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> request, Response<Void> response) {
                        AlertDialog alertDialog = new AlertDialog.Builder(ProjectSubmission.this)
                                .setIcon(R.drawable.ic_success)
                                .setTitle("Submission Successful")
//                                .setIconAttribute(R.drawable.ic_success)
                                .create();
                        alertDialog.show();
                    }

                    @Override
                    public void onFailure(Call<Void> request, Throwable t) {
                        //((TextView)findViewById(R.id.message)).setText("Request Failed");
                        AlertDialog alertDialog = new AlertDialog.Builder(ProjectSubmission.this)
                                .setTitle("Submission not Successful")
                                .setIcon(R.drawable.ic_not_success)
                                .create();
                        alertDialog.show();
                    }
                });

            }
        });
    }
}