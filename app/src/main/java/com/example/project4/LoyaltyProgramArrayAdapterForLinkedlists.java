package com.example.project4;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



public class LoyaltyProgramArrayAdapterForLinkedlists extends ArrayAdapter {
    private Context mContext;
    private LinkedlistOfLoyaltyProgram LinkedListOfLoyaltyProgramlist;
    private int textViewResourceId;


    public LoyaltyProgramArrayAdapterForLinkedlists(Context context, int textViewResourceId,
                                                    LinkedlistOfLoyaltyProgram list) {
        super(context, textViewResourceId);
        this.mContext = context;
        this.LinkedListOfLoyaltyProgramlist = list;
        this.textViewResourceId = textViewResourceId;
    }


    @Override
    public int getCount() {
        return this.LinkedListOfLoyaltyProgramlist.length();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(mContext).
                    inflate(this.textViewResourceId, parent, false);
        }

        TextView lpName = (TextView) listItem.findViewById(R.id.loyaltyNameET);
        TextView lpBank = (TextView) listItem.findViewById(R.id.loyaltyBankNameET);
        TextView lpPoint = (TextView) listItem.findViewById(R.id.loyaltyCurrPointsET);

        LoyaltyProgram lp = this.LinkedListOfLoyaltyProgramlist.getAtIndex(position);

        lpName.setText(lp.getName());
        lpBank.setText(lp.getBank());
        lpPoint.setText(""+lp.getPoint_balance());

        return listItem;
    }
}