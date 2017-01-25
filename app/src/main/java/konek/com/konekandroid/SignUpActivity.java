package konek.com.konekandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setContentView(R.layout.activity_signup);
        super.onCreate(savedInstanceState);
    }

    public void OnClickSignUp(View v){
        Intent signIn = new Intent(SignUpActivity.this, CategoryActivity.class);
        startActivity(signIn);
    }
}
