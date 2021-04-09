package com.example.activity2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    EditText edemail, edpassword;
    String Email ,Password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin=findViewById(R.id.btSignIn);
        edemail=findViewById(R.id.edEmail);
        edpassword=findViewById(R.id.edPassword);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Email = edemail.getText().toString();

                Password = edpassword.getText().toString();

                String email="admin@gmail.com";
                String pass="123";

                if (Email.equals(email) || Password.equals(pass))
                {
                    Toast t = Toast.makeText(getApplicationContext(),
                            "Login Sukses", Toast.LENGTH_LONG);
                    t.show();
                }
                else
                {
                    if (email.equals(email) && Password.equals(pass))
                    {
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Gagal", Toast.LENGTH_LONG);
                        t.show();

                        Bundle b = new Bundle();

                        b.putString("a", email.trim());

                        b.putString("b", Password.trim());

                        Intent i = new Intent(getApplicationContext(), ActivityHasil.class);

                        i.putExtras(b);

                        startActivity(i);
                    } else {

                        Toast t = Toast.makeText(getApplicationContext(),
                                "LOGIN GAGAL", Toast.LENGTH_LONG);

                        t.show();
                    }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.mnDaftar)
        {
            Intent i = new Intent(getApplicationContext(), Home_Activity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }
}