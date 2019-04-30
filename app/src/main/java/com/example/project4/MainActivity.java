package com.example.project4;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private ListView creditCardLV, loyaltyProgramLV;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
          FirebaseDatabase database = FirebaseDatabase.getInstance();
          DatabaseReference creditCardRef = database.getReference("creditCards");
       DatabaseReference myRef = database.getReference("blah");
        CreditCard cc   = new CreditCard("Chase Sapphire","1/1/19",3000,50000);
        creditCardRef.push().setValue(cc);
       // myRef.setValue("Hello, World!");
        //myRef2.setValue("lol");



        this.creditCardLV = (ListView)this.findViewById(R.id.creditCardListView);
        this.loyaltyProgramLV = (ListView)this.findViewById(R.id.loyaltyProgramListView);
        //Core.ccAdapter = new ArrayAdapter(this, R.layout.student_listview_row, Core.theCreditCardStrings);
        Core.ccCustomAdapter = new CreditCardArrayAdapterForLinkedLists(this, R.layout.custom_credit_card_row, Core.theCreditCardsLL);
        Core.lpCustomAdapter = new LoyaltyProgramArrayAdapterForLinkedlists(this, R.layout.loyalty_program__custom_row,Core.theLoyaltyProgramsLL);

        .
        this.creditCardLV.setAdapter(Core.ccCustomAdapter);
        this.loyaltyProgramLV.setAdapter(Core.lpCustomAdapter);

    }

    public void onAddCreditCardButtonPressed(View v)
    {
        Intent i = new Intent(this, AddCreditCardActivity.class);
        this.startActivity(i);
    }

    public void onAddLoyaltyProgramButtonPressed(View v)
    {
        Intent i = new Intent(this, AddLoyaltyProgramActivity.class);
        this.startActivity(i);
    }

}
