package installtracking.com.installtrackingexampleapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by mehmetdelikaya on 1.12.2019.
 */
public class MainActivity extends AppCompatActivity {

    private TextView txUtmSource;
    private TextView txUtmMedium;
    private TextView txUtmCampaign;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        showUtmData();
    }

    private void findViews() {
        txUtmCampaign = findViewById(R.id.txUtmCampaign);
        txUtmMedium = findViewById(R.id.txUtmMedium);
        txUtmSource = findViewById(R.id.txUtmSource);
    }


    private void showUtmData() {
        if (Globals.getInstance().getUtmCampaign(this)!=null){
            txUtmCampaign.setText(Globals.getInstance().getUtmCampaign(this));
        }
        if (Globals.getInstance().getUtmMedium(this)!=null){
            txUtmMedium.setText(Globals.getInstance().getUtmMedium(this));
        }
        if (Globals.getInstance().getUtmSource(this)!=null){
            txUtmSource.setText(Globals.getInstance().getUtmSource(this));
        }
    }
}
