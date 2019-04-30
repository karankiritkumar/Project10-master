package com.example.project4;

import java.util.LinkedList;

public class ItineraryStack
{
    private ItineraryStackNode top;
    private int count;

    public ItineraryStack()
    {
        this.top = null;
        this.count = 0;
    }

    public ItineraryStackNode peek()
    {
        return this.top;
    }

    public void push(String destination)
    {
        ItineraryStackNode isn = new ItineraryStackNode(destination);
        if(this.top == null)
        {
            this.top = isn;
        }
        else
        {
            isn.setNextNode(this.top);
            this.top = isn;
        }
        this.count++;
    }

    public ItineraryStackNode pop()
    {
        ItineraryStackNode nodeToReturn = this.top;
        if(this.top != null)
        {
            this.top = this.top.getNextNode();
            nodeToReturn.setNextNode(null);
            this.count--;
        }
        return nodeToReturn;
    }

    public LinkedList<String> getAsList()
    {
        LinkedList<String> ll = new LinkedList<String>();
        ItineraryStackNode currNode = this.top;
        while(currNode != null)
        {
            ll.addFirst(currNode.getPayload());
            currNode = currNode.getNextNode();
        }
        return ll;
    }

    public void display()
    {
        ItineraryStackNode currNode = this.top;
        System.out.println("*** Itinerary: ");
        while(currNode != null)
        {
            currNode.display();
            currNode = currNode.getNextNode();
        }
        System.out.println("");
    }
}
