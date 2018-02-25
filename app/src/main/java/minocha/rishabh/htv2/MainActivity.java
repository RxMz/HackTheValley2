package minocha.rishabh.htv2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button getSafe = (Button)findViewById(R.id.getSafe);
        getSafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this, AlternativeDirectionActivity.class);
                startActivity(i);
            }
        });
        Button fallDetector = (Button)findViewById(R.id.fallButton);
        fallDetector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent fall=new Intent(MainActivity.this, ShakeDetector.class);
                startService(fall);
            }
        });
        Button giveRev = (Button)findViewById(R.id.btnGiveReview);
        giveRev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i1=new Intent(MainActivity.this, GiveReview.class);
                startActivity(i1);
            }
        });
        Button showRev = (Button)findViewById(R.id.btnShowReview);
        showRev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i2=new Intent(MainActivity.this, ShowReviews.class);
                startActivity(i2);
            }
        });
        Button wallet = (Button)findViewById(R.id.btnWallet);
        wallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this, TokenWallet.class);
                startActivity(intent);
            }
        });
    }
}
