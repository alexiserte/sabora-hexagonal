package org.example.Message;

import org.example.Instruction.Instruction;
import org.example.Instruction.InstructionTypes;

import java.util.ArrayList;
import java.util.List;

public class Message {


    private MessageTypes type;
    Instruction instruction;

    public Message(MessageTypes type, Instruction instructions){
        this.type = type;
        this.instruction = instructions;
    }

    public String toString(){

        return null;
    }

    public String getStringType(){
        return this.type.toString();
    }

    public String getStringInstructions(){
        return this.instruction.toString();
    }
    public Instruction getInstruction(){return this.instruction;}



}
