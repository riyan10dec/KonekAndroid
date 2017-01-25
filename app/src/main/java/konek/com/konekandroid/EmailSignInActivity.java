package konek.com.konekandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class EmailSignInActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emailsignin);
    }

    public void OnClickForgotPassword(View v){
        Intent forgotPassword = new Intent(EmailSignInActivity.this, SignUpActivity.class);
        startActivity(forgotPassword);
    }

    public void OnClickSignUp(View v){
        Intent signUp = new Intent(EmailSignInActivity.this, SignUpActivity.class);
        startActivity(signUp);
    }
}
