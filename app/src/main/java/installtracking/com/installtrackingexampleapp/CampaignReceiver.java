package installtracking.com.installtrackingexampleapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by mehmetdelikaya on 1.12.2019.
 */
public class CampaignReceiver extends BroadcastReceiver {

    public static final String UTM_CAMPAIGN = "utm_campaign";
    public static final String UTM_SOURCE = "utm_source";
    public static final String UTM_MEDIUM = "utm_medium";
    public static final String UTM_TERM = "utm_term";
    public static final String UTM_CONTENT = "utm_content";

    private final String[] sources = {
            UTM_CAMPAIGN, UTM_SOURCE, UTM_MEDIUM, UTM_TERM, UTM_CONTENT
    };

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle extras = intent.getExtras();
        if(extras!=null) {
            String referrerString = extras.getString("referrer");
            Log.d("Referrer", referrerString);
            if(referrerString!=null) {
                try {
                    Map<String, String> getParams = getHashMapFromQuery(referrerString);

                    for (String sourceType : sources) {
                        String source = getParams.get(sourceType);

                        if (source != null) {

                            Log.d("CAMPAIGN",sourceType + " - " + source);

                            if (sourceType.equals(UTM_CAMPAIGN)) {
                                Globals.getInstance().setUtmCampaign(context, source);
                            } else if (sourceType.equals(UTM_MEDIUM)) {
                                Globals.getInstance().setUtmMedium(context, source);
                            } else if (sourceType.equals(UTM_SOURCE)) {
                                Globals.getInstance().setUtmSource(context, source);
                            } else {

                            }
                        }
                    }
                } catch (UnsupportedEncodingException e) {
                    Log.d("Referrer Error", e.getMessage());
                }
            }
        }
    }

    public Map<String, String> getHashMapFromQuery(String query)
            throws UnsupportedEncodingException {

        Map<String, String> query_pairs = new LinkedHashMap<String, String>();

        String[] pairs = query.split("&");
        for (String pair : pairs) {
            int idx = pair.indexOf("=");
            query_pairs.put(URLDecoder.decode(pair.substring(0, idx), "UTF-8"),
                    URLDecoder.decode(pair.substring(idx + 1), "UTF-8"));
        }
        return query_pairs;
    }
}
