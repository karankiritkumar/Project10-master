package com.example.project4;

public class LinkedlistOfLoyaltyProgram

{
    private LoyaltyProgramNode head;
    private  int count;

    public LinkedlistOfLoyaltyProgram()
    {
        this.head = null;
        this.count= 0;

    }
    public  int length()
    {
        return this.count;
    }
    public void addAtEnd(LoyaltyProgram payload)
    {
        LoyaltyProgramNode lpn = new LoyaltyProgramNode(payload);
        if(this.head == null)
        {
            this.head = lpn;
        }
        else
        {
            LoyaltyProgramNode currNode = this.head;
            while (currNode.getNextNode() != null)
            {
                currNode = currNode.getNextNode();
            }
        }
        this.count++;
    }

    public LoyaltyProgram getAtIndex(int index)
    {
        LoyaltyProgramNode currNode = this.head;
        for (int i = 0; i < index; i++)
        {
            currNode = currNode.getNextNode();
        }
        return currNode.getPayload();
    }
}

