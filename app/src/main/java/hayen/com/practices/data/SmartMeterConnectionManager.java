package hayen.com.practices.data;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

/**
 * Created by ahmet.macit on 10/19/2016.
 */

public class SmartMeterConnectionManager {

    private static final String TAG = SmartMeterConnectionManager.class.getName();
    private static String SERVICE_ROOT_URL = "http://10.1.1.30/OSOS/External/OperationService.svc/FindMeterByFlagCodeSerialNumber?" +
            "token=%2245FB883F-225E-44A6-8721-15435D2C73DA%22&" +
            "flagCode=VIK&" +
            "serialNumber=13" ;


    /**
     * will check whether smart meter is registered in db or not
     * */
    public static void checkSmartMeterExistance(Context context, Response.Listener<String> responseListener, Response.ErrorListener errorListener)
    {
        RequestQueue queue = Volley.newRequestQueue(context);
        try {
            StringRequest request = new StringRequest(Request.Method.GET,SERVICE_ROOT_URL, responseListener, errorListener);

            queue.add(request);
        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
