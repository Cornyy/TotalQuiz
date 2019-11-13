package com.hfad.totalquiz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity
{
    FirebaseAuth mAuth;
    EditText email;
    EditText password;
    SharedPreferences utils;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        email = (EditText) findViewById(R.id.editTextEmail);
        password = (EditText) findViewById(R.id.editTextPassword);
        progressDialog =  new ProgressDialog(this);
        utils = getSharedPreferences("loginPref", Activity.MODE_PRIVATE);
        LoginIfSaved();
    }
    @Override
    public void onStart()
    {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }
    private void DoLogin()
    {
        mAuth.signInWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        if (task.isSuccessful())
                        {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(" ", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            if(utils.getBoolean("isSaved",false)==false)
                            {
                                setDialog();
                            }
                            else goToMenu();

                        }
                        else {
                            // If sign in fails, display a message to the user.
                            Log.w(" ", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Błędne dane",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });
    }
    private void LoginIfSaved()
    {
        if(utils.getBoolean("isSaved",false)==true)
        {
            progressDialog.setMessage("Proszę czekać");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setIndeterminate(true);
            progressDialog.setCancelable(false);
            progressDialog.show();
            loadData();
            DoLogin();
        }
    }
    public void buttonZalogujOnClick(View view)
    {
        if(email.getText().toString().trim().length() == 0 || password.getText().toString().trim().length() == 0)
        {
            Toast.makeText(MainActivity.this,"Wypełnij wszystkie pola !",Toast.LENGTH_LONG)
                    .show();
        }
        else {
            DoLogin();
        }
    }
    private void setDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Czy chcesz zapisać dane logowania ?");
        builder.setPositiveButton("Tak", new DialogInterface.OnClickListener()
        {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {

                saveData();
                goToMenu();
            }
        });
        builder.setNegativeButton("Nie", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                goToMenu();
            }
        });
        builder.show();
    }
    public void onResume()
    {
        super.onResume();
        super.onStart();
        email.setText("");
        password.setText("");
    }

    private void loadData()
    {
        String loadEmailFromPref = utils.getString("email","");
        String loadPasswordFromPref = utils.getString("password","");
        email.setText(loadEmailFromPref);
        password.setText(loadPasswordFromPref);
    }
    private void saveData()
    {
        SharedPreferences.Editor editor = utils.edit();
        editor.putString("email",email.getText().toString());
        editor.putString("password",password.getText().toString());
        editor.putBoolean("isSaved",true);
        editor.commit();
    }
    public void goToMenu()
    {
        Intent intent = new Intent(MainActivity.this, MenuActivity.class);
        progressDialog.dismiss();
        Toast.makeText(MainActivity.this, "Zalogowano!",
                Toast.LENGTH_SHORT).show();
        startActivity(intent);
    }

    public void buttonZarejestrujOnClick(View view)
    {
        Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
        startActivity(intent);
    }

}

