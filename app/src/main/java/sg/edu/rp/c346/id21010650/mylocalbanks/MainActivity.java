package sg.edu.rp.c346.id21010650.mylocalbanks;

import androidx.annotation.NonNull;
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
    TextView DBS;
    TextView OCBC;
    TextView UOB;
    String wordClicked = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBS = findViewById(R.id.DBS);
        OCBC = findViewById(R.id.OCBC);
        UOB = findViewById(R.id.UOB);
        registerForContextMenu(DBS);
        registerForContextMenu(OCBC);
        registerForContextMenu(UOB);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.EnglishSelection) {
            DBS.setText("                                 DBS");
            OCBC.setText("                                 OCBC");
            UOB.setText("                                  UOB");
            return true;
        } else if (id == R.id.ChineseSelection) {
            DBS.setText("                               星展银行");
            OCBC.setText("                              华侨银行");
            UOB.setText("                              大华银行");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu,View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu,v,menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");

        if (v == DBS) {
            wordClicked = "DBS";
        } else if (v == OCBC) {
            wordClicked = "OCBC";
        } else if (v == UOB) {
            wordClicked = "UOB";
        }
    }
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 0) {
            if (wordClicked.equalsIgnoreCase("DBS")) {
                Intent intent1 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent1);
                return true;
            } else if (wordClicked.equalsIgnoreCase("OCBC")) {
                Intent intent2 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.ocbc.com"));
                startActivity(intent2);
                return true;
            } else if (wordClicked.equalsIgnoreCase("UOB")) {
                Intent intent3 = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.uob.com.sg"));
                startActivity(intent3);
                return true;
            } else if (item.getItemId() == 1) {
                if (wordClicked.equalsIgnoreCase("DBS")) {
                    Intent intentCallDBS = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + 1800111111));
                    startActivity(intentCallDBS);
                } else if (wordClicked.equalsIgnoreCase("OCBC")) {
                    Intent intentCallOCBC = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + 1800363333));
                    startActivity(intentCallOCBC);
                } else if (wordClicked.equalsIgnoreCase("UOB")) {
                    Intent intentCallUOB = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:" + 1800222212));
                    startActivity(intentCallUOB);
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
}