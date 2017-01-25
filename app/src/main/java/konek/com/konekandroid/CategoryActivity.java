package konek.com.konekandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CategoryActivity extends AppCompatActivity {
    CheckBox checkBox1;
    CheckBox checkBox2;
    TextView tv;
    ImageButton addBtn;
    TextView qty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        setSubcategoryRows();
    }

    private void setSubcategoryRows(){
        TableLayout ll = (TableLayout) findViewById(R.id.categoryTable);

        for (int i = 0; i <2; i++) {
            TableRow row= new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT,1.0f);
            row.setLayoutParams(lp);
            checkBox1 = new CheckBox(this);
            checkBox1.setLayoutParams(new TableRow.LayoutParams(0));
            checkBox1.setText("hello");
            row.addView(checkBox1);
            checkBox2 = new CheckBox(this);
            checkBox2.setLayoutParams(new TableRow.LayoutParams(1));
            checkBox2.setText("helo2");
            row.addView(checkBox2);
            addBtn = new ImageButton(this);
            //addBtn.setImageResource(R.drawable.add);
            ll.addView(row,i);
        }
    }

    public void OnClickCategoryNext(View v){
        Intent OnClickCategoryNext = new Intent(CategoryActivity.this, HomeActivity.class);
        startActivity(OnClickCategoryNext);
    }
}
