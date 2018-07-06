package sourav.inmobi_interstitial;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.inmobi.sdk.InMobiSdk;
import com.inmobi.ads.InMobiAdRequestStatus;
import com.inmobi.ads.InMobiInterstitial;

import com.google.android.gms.ads.MobileAds;

import java.util.Map;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Interstitial";
    Button show;

    Button LoadAdmob;


    InMobiInterstitial interstitialAd;

    private InterstitialAd admobinterstitialad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        show=(Button) findViewById(R.id.show);
        LoadAdmob=(Button) findViewById(R.id.ADMOBLOAD);


        /**** admob part***/
       MobileAds.initialize(this, "ca-app-pub-7599894810320338~7728407866");
        admobinterstitialad= new InterstitialAd(this);
        admobinterstitialad.setAdUnitId("ca-app-pub-7599894810320338/3789146948"); //my::  ca-app-pub-7599894810320338/3789146948  // inmobi :: ca-app-pub-7124338768015628/9148926799

        admobinterstitialad.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                show.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
                show.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
            }
        });





    }





    public  void ShowAd(View v){

/**** admob show ****/
admobinterstitialad.show();

    }

/*****admobload******/
    public  void Loadadmobad(View v){

admobinterstitialad.loadAd(new AdRequest.Builder().build());


    }


    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onStop() {
        super.onStop();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {

        super.onDestroy();
    }


}
