package com.example.project4;

public class LoyaltyProgramNode
{
    private LoyaltyProgramNode nextNode;
    private LoyaltyProgram payload;

    public LoyaltyProgramNode(LoyaltyProgram payload)
    {
        this.payload = payload;
        this.nextNode = null;

    }

    public void setNextNode(LoyaltyProgramNode nextNode) {
        this.nextNode = nextNode;
    }

    public void setPayload(LoyaltyProgram payload) {
        this.payload = payload;
    }

    public LoyaltyProgramNode getNextNode() {
        return nextNode;
    }

    public LoyaltyProgram getPayload() {
        return payload;
    }
}
