package sg.edu.rp.c346.id20039583.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS, tvOCBC, tvUOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.tvDBS);
        tvOCBC = findViewById(R.id.tvOCBC);
        tvUOB = findViewById(R.id.tvUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 0, 0, "Website");
        menu.add(0, 1, 1, "Contact the Bank");


    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
            //code for action
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg/index/default.page"));
            startActivity(Browserintent);
            return true;


        } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
            //code for action
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 87654321));
            startActivity(intentCall);
            return true;


        } else if (id == R.id.tvOCBC || item.getItemId() == 0) {
            Intent Browserintent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com/group/gateway.page"));
            startActivity(Browserintent);
            return true;

        } else if (id == R.id.tvOCBC || item.getItemId() == 1) { //check if the selected menu item ID is 1
            //code for action
            Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + 12345678));
            startActivity(intentCall);
            return true;  //menu item successfully handled
        }


        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        getMenuInflater().inflate(R.menu.menu2, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.ChineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");


            return true;
        }
        return false;
    }
}




