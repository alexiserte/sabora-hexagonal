package org.example.Message;

import org.example.Instruction.Instruction;
import org.example.Instruction.InstructionTypes;

import java.util.ArrayList;
import java.util.List;

public class Message {


    public enum DeviceType{MOBILE,COMPUTER,VR_GLASSES};
    private String userID;
    private String userIP;
    private String userMAC;
    private DeviceType deviceType;
    private MessageTypes type;
    Instruction instruction;

    public Message(String userID,String userIP,String userMAC,DeviceType deviceType,MessageTypes type, Instruction instructions){
        this.userID = userID;
        this.userIP = userIP;
        this.userMAC = userMAC;
        this.deviceType = deviceType;
        this.type = type;
        this.instruction = instructions;
    }

    public String toString(){return String.format("[%s,%s,%s,%s,%s]",userID,userIP,userMAC,type,instruction);}

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    // Getters and Setters for userIP
    public String getUserIP() {
        return userIP;
    }

    public void setUserIP(String userIP) {
        this.userIP = userIP;
    }

    // Getters and Setters for userMAC
    public String getUserMAC() {
        return userMAC;
    }

    public void setUserMAC(String userMAC) {
        this.userMAC = userMAC;
    }

    public DeviceType getDeviceType(){
        return this.deviceType;
    }
    public void setDeviceType(DeviceType deviceType){
        this.deviceType = deviceType;
    }

    // Getters and Setters for type
    public MessageTypes getType() {
        return type;
    }

    public void setType(MessageTypes type) {
        this.type = type;
    }

    // Getters and Setters for instruction
    public Instruction getInstruction() {
        return instruction;
    }

    public void setInstruction(Instruction instruction) {
        this.instruction = instruction;
    }

}
