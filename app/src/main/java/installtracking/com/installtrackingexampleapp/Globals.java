package installtracking.com.installtrackingexampleapp;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by mehmetdelikaya on 1.12.2019.
 */
public class Globals {

    public static final String SHARED_PREF_KEY = "EXAMPLE_APP";
    private static final String UTM_CAMPAIGN = "UTM_CAMPAIGN";
    private static final String UTM_MEDIUM = "UTM_MEDIUM";
    private static final String UTM_SOURCE = "UTM_SOURCE";
    private static Globals sGlobals;

    public static Globals getInstance(){
        if(sGlobals==null){
            sGlobals= new Globals();
        }
        return sGlobals;
    }

    public void setUtmCampaign(Context context, String utmCampaign) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_KEY,Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(UTM_CAMPAIGN, utmCampaign).apply();
    }

    public String getUtmMedium(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_KEY,Context.MODE_PRIVATE);
        return sharedPreferences.getString(UTM_MEDIUM,null);
    }

    public void setUtmMedium(Context context, String utmMedium) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_KEY,Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(UTM_MEDIUM, utmMedium).apply();
    }

    public String getUtmCampaign(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_KEY,Context.MODE_PRIVATE);
        return sharedPreferences.getString(UTM_CAMPAIGN,null);
    }

    public void setUtmSource(Context context, String utmSource) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_KEY,Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(UTM_SOURCE, utmSource).apply();
    }

    public String getUtmSource(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(SHARED_PREF_KEY,Context.MODE_PRIVATE);
        return sharedPreferences.getString(UTM_SOURCE,null);
    }
}
