package com.example.project4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.LinkedList;

public class AirportMonthDetailActivity extends AppCompatActivity
{
    private ListView destinationsLV;
    private AirportMonthDetailActivity myself;
    private LinkedList<String> ll;
    private ArrayAdapter<String> aa;
    private String cityName, airportCode, monthNum, monthLastDay;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport_month_detail);

        this.myself = this;
        final TextView airportTV = this.findViewById(R.id.airportTV);
        this.destinationsLV = this.findViewById(R.id.destinationsLV);

        this.ll = new LinkedList<String>();
        this.aa = new ArrayAdapter<String>(this, R.layout.another_row, ll);
        this.destinationsLV.setAdapter(aa);

        this.destinationsLV.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long row_id)
            {
                String selectedAirport = ll.get(position).trim();

                //alternative way of getting code and name
                //String ac = selectedAirport.substring(selectedAirport.length()-3);
                //String city = selectedAirport.substring(0, selectedAirport.length()-3);

                String[] parts = selectedAirport.split(" ");

                Intent i = new Intent(myself, AirportMonthDetailActivity.class);
                i.putExtra("airportCode", parts[parts.length-1].trim());
                String cityName = "";
                for(int j = 0; j < parts.length-1; j++)
                {
                    cityName = cityName + parts[j] + " ";
                }
                i.putExtra("cityName", cityName);
                i.putExtra("monthNum", monthNum);
                i.putExtra("monthLastDay", monthLastDay);
                //Core.currentItinerary.push(cityName + " " + parts[parts.length-1].trim());
                myself.startActivity(i);
            }
        });

        this.monthLastDay = this.getIntent().getStringExtra("monthLastDay");
        this.monthNum = this.getIntent().getStringExtra("monthNum");
        this.cityName = this.getIntent().getStringExtra("cityName");
        this.airportCode = this.getIntent().getStringExtra("airportCode");
        airportCode = airportCode.replaceAll("\"","");
        airportTV.setText(cityName + " - " + airportCode);
        AirportDestinationThread adt = new AirportDestinationThread(this.airportCode, this.monthNum, this.monthLastDay, ll, aa);
        adt.setPriority(Thread.MAX_PRIORITY);
        adt.start();
        //Can't get airport stuff from cache
        //NetworkThread nt = new NetworkThread(airportCode, aa, ll);
        //nt.setPriority(Thread.MAX_PRIORITY);
        //nt.start();

        //strip the " from both ends of the airport code

    }
}
