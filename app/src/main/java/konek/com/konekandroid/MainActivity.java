package konek.com.konekandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Intent intent = new Intent(this, MainActivity.class);

        final ImageButton loginGPlus = (ImageButton) findViewById(R.id.logingplus);
        final ImageButton loginFB = (ImageButton) findViewById(R.id.loginfb);
        final TextView signInWithEmail = (TextView) findViewById(R.id.signInWithEmail);
        final TextView skip = (TextView) findViewById(R.id.skip);
        View.OnClickListener handler = null;
        loginGPlus.setOnClickListener(handler);
        loginFB.setOnClickListener(handler);
        handler = new View.OnClickListener() {
            public void onClick(View v) {
                if (v == loginGPlus) ;
                if (v == loginFB) ;
                if (v == signInWithEmail) {
                    Intent emailIntent = new Intent(MainActivity.this, EmailSignInActivity.class);
                    startActivity(emailIntent);
                }}
        };
    }

    public void OnClickSkip(View v){
        Intent home = new Intent(MainActivity.this, HomeActivity.class);
        startActivity(home);
    }
    public void OnClickSignInWithEmail (View v){
        Intent emailIntent = new Intent(MainActivity.this, EmailSignInActivity.class);
        startActivity(emailIntent);
    }
}
