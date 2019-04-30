package com.example.project4;

import android.widget.ArrayAdapter;

//singleton - a class filled with stuff acccccebile by everything
public class Core
{
    public static LinkedListOfCreditCards theCreditCardsLL = new LinkedListOfCreditCards();
    public static LinkedlistOfLoyaltyProgram theLoyaltyProgramsLL = new LinkedlistOfLoyaltyProgram();
    public static CreditCardArrayAdapterForLinkedLists getCcCustomAdapter;
    public static LoyaltyProgramArrayAdapterForLinkedlists lpCustomAdapter;
    //public static CreditCard[] theCreditCards = new CreditCard[1000];
   // public static LoyaltyProgram[] theLoyaltyPrograms = new LoyaltyProgram[1000];
    //public static String[] theLoyaltyProgramStrings = new String[1000];
  //  public static String[] theCreditCardStrings = new String[1000];
    //public static int creditCardCount = 0;
    //public static int loyaltyProgramCount = 0;



    public static CreditCardArrayAdapterForLinkedLists ccCustomAdapter;

    //encapsulated
    public static void addLoyaltyProgram(LoyaltyProgram lp)
    {
        //happens in a static context
        Core.theLoyaltyProgramsLL.addAtEnd(lp);
        Core.lpCustomAdapter.notifyDataSetChanged();
        //Core.loyaltyProgramCount++;
       // Core.lpAdapter.notifyDataSetChanged();
    }

    public static void addCreditCard(CreditCard cc)
    {
        Core.theCreditCardsLL.addEnd(cc);
       // Core.theCreditCards[Core.creditCardCount] = cc;
       // Core.theCreditCardStrings[Core.creditCardCount] = cc.toString();
        //Core.creditCardCount++;
        Core.ccCustomAdapter.notifyDataSetChanged();
    }
}
