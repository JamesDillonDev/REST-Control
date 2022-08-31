package com.example.restapp;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.Timer;
import java.util.TimerTask;
import androidx.lifecycle.LifecycleObserver;

public class MainActivity extends AppCompatActivity implements LifecycleObserver {
    Button relay1On;
    Button relay1Off;
    Button relay1Toggle;

    Button relay2On;
    Button relay2Off;
    Button relay2Toggle;

    Button relay3On;
    Button relay3Off;
    Button relay3Toggle;

    Button relay4On;
    Button relay4Off;
    Button relay4Toggle;

    Timer timer = new Timer();
    String baseurl = "http://10.3.141.1:5000";
    RequestQueue queue;
    Handler handler;
    Boolean inForground = false;
    Integer sinceLastMessage = 0;

    @Override
    protected void onPause() {
        super.onPause();
        inForground = true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        inForground = false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relay1Toggle = findViewById(R.id.relay1Toggle);
        relay1Off = findViewById(R.id.relay1Off);
        relay1On = findViewById(R.id.relay1On);

        relay2Toggle = findViewById(R.id.relay2Toggle);
        relay2Off = findViewById(R.id.relay2Off);
        relay2On = findViewById(R.id.relay2On);

        relay3Toggle = findViewById(R.id.relay3Toggle);
        relay3Off = findViewById(R.id.relay3Off);
        relay3On = findViewById(R.id.relay3On);

        relay4Toggle = findViewById(R.id.relay4Toggle);
        relay4Off = findViewById(R.id.relay4Off);
        relay4On = findViewById(R.id.relay4On);

        relay1Off.setBackgroundColor(Color.rgb(105,105,105));
        relay2Off.setBackgroundColor(Color.rgb(105,105,105));
        relay3Off.setBackgroundColor(Color.rgb(105,105,105));
        relay4Off.setBackgroundColor(Color.rgb(105,105,105));

        relay1On.setBackgroundColor(Color.rgb(105,105,105));
        relay2On.setBackgroundColor(Color.rgb(105,105,105));
        relay3On.setBackgroundColor(Color.rgb(105,105,105));
        relay4On.setBackgroundColor(Color.rgb(105,105,105));

        queue = Volley.newRequestQueue(MainActivity.this);

        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(inForground == false)
                {
                    getRequest(baseurl+"/relayData", null);
                }
            }
        }, 2*1000, 2*1000);

        relay1On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putRequest(baseurl+"/relay1/on", null);
            }
        });

        relay1Off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putRequest(baseurl+"/relay1/off", null);
            }
        });

        relay1Toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putRequest(baseurl+"/relay1/toggle", null);
            }
        });

        relay2On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putRequest(baseurl+"/relay2/on", null);
            }
        });

        relay2Off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putRequest(baseurl+"/relay2/off", null);
            }
        });

        relay2Toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putRequest(baseurl+"/relay2/toggle", null);
            }
        });

        relay3On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putRequest(baseurl+"/relay3/on", null);
            }
        });

        relay3Off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putRequest(baseurl+"/relay3/off", null);
            }
        });

        relay3Toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putRequest(baseurl+"/relay3/toggle", null);
            }
        });

        relay4On.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putRequest(baseurl+"/relay4/on", null);
            }
        });

        relay4Off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putRequest(baseurl+"/relay4/off", null);
            }
        });

        relay4Toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                putRequest(baseurl+"/relay4/toggle", null);
            }
        });
    }

    public void Relay1ButtonRGB(Boolean relay1)
    {
        if(relay1 == true)
        {
            relay1On.setBackgroundColor(Color.rgb(107,142,35));
            relay1Off.setBackgroundColor(Color.rgb(105,105,105));
        }
        else
        {
            relay1On.setBackgroundColor(Color.rgb(105,105,105));
            relay1Off.setBackgroundColor(Color.rgb(210, 4, 45));
        }
    }

    public void Relay2ButtonRGB(Boolean relay2)
    {
        if(relay2 == true)
        {
            relay2On.setBackgroundColor(Color.rgb(107,142,35));
            relay2Off.setBackgroundColor(Color.rgb(105,105,105));
        }
        else
        {
            relay2On.setBackgroundColor(Color.rgb(105,105,105));
            relay2Off.setBackgroundColor(Color.rgb(210, 4, 45));
        }
    }

    public void Relay3ButtonRGB(Boolean relay3)
    {
        if(relay3 == true)
        {
            relay3On.setBackgroundColor(Color.rgb(107,142,35));
            relay3Off.setBackgroundColor(Color.rgb(105,105,105));
        }
        else
        {
            relay3On.setBackgroundColor(Color.rgb(105,105,105));
            relay3Off.setBackgroundColor(Color.rgb(210, 4, 45));
        }
    }

    public void Relay4ButtonRGB(Boolean relay4)
    {
        if(relay4 == true)
        {
            relay4On.setBackgroundColor(Color.rgb(107,142,35));
            relay4Off.setBackgroundColor(Color.rgb(105,105,105));
        }
        else
        {
            relay4On.setBackgroundColor(Color.rgb(105,105,105));
            relay4Off.setBackgroundColor(Color.rgb(210, 4, 45));
        }
    }

    public void getRequest(String url, JSONObject jsonData){
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, jsonData, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    Boolean relay1Data = response.getBoolean("relay1");
                    Boolean relay2Data = response.getBoolean("relay2");
                    Boolean relay3Data = response.getBoolean("relay3");
                    Boolean relay4Data = response.getBoolean("relay4");

                    Relay1ButtonRGB(relay1Data);
                    Relay2ButtonRGB(relay2Data);
                    Relay3ButtonRGB(relay3Data);
                    Relay4ButtonRGB(relay4Data);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if(sinceLastMessage == 0)
                {
                    sinceLastMessage = 3;
                    Toast.makeText(MainActivity.this, "Unable to Refresh, Are you sure you are connected to the right Network?", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    sinceLastMessage--;
                }
            }
        });

        queue.add(jsonObjectRequest);
    }

    public void putRequest(String url, JSONObject jsonData) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.PUT, url, jsonData, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "No Response, Are you sure you are connected to the right Network?", Toast.LENGTH_SHORT).show();
            }
        });

        queue.add(jsonObjectRequest);
    }
}