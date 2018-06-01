package aait.se.mobileprogrammingcourse.khalid.android.database;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        progress = new ProgressDialog(this);
        Button b = findViewById(R.id.login);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress.setTitle("Validating User");
                progress.show();
                EditText e = findViewById(R.id.emailEditText);
                EditText p = findViewById(R.id.passwordEditText);
                String email = e.getText().toString();
                String password = p.getText().toString();
                signIn(email,password);
            }
        });
        Button c = findViewById(R.id.registerButton);
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(i);
            }
        });
    }

    private void signIn(String email, String password) {
        if (email.length()>=1 && password.length()>=1) {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        progress.dismiss();
                        Log.d("TAG", "signInWithEmail:success");
                        FirebaseUser user = mAuth.getCurrentUser();
                        Toast.makeText(MainActivity.this,"Successfully Logged in",Toast.LENGTH_SHORT).show();
                        ArrayList a = new Admins().getAdmins();
                        if (a.indexOf(user.getUid())!=-1){
                            Intent i = new Intent(MainActivity.this,AdminActivity.class);
                            startActivity(i);
                        }
                        else{
                            Intent i = new Intent(MainActivity.this,ClientActivity.class);
                            startActivity(i);

                        }
                    }
                    else {
                        progress.dismiss();
                        Log.w("TAG", "signInWithEmail:failure", task.getException());
                        Toast.makeText(MainActivity.this, "Invalid Email/Password.", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}
