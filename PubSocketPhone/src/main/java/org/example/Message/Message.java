package org.example.Message;

import org.example.Instruction.Instruction;
import org.example.Instruction.InstructionTypes;

import java.util.ArrayList;
import java.util.List;

public class Message {


    private String userID;
    private String userIP;
    private String userMAC;
    private MessageTypes type;
    Instruction instruction;

    public Message(String userID,String userIP,String userMAC,MessageTypes type, Instruction instructions){
        this.userID = userID;
        this.userIP = userIP;
        this.userMAC = userMAC;
        this.type = type;
        this.instruction = instructions;
    }

    public String toString(){return String.format("[%s,%s,%s,%s,%s]",userID,userIP,userMAC,type,instruction);}

    public String getStringType(){
        return this.type.toString();
    }
    public String getStringInstructions(){
        return this.instruction.toString();
    }

    public Instruction getInstruction(){return this.instruction;}
    public MessageTypes getMessageTypes(){return this.type;}

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }


    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }

    public String getUserMAC() {
        return userMAC;
    }

    public void setUserMAC(String userMAC) {
        this.userMAC = userMAC;
    }

    public void setInstruction(Instruction i){
        this.instruction = i;
    }
    public void setMessageType(MessageTypes mt){
        this.type = mt;
    }

}
