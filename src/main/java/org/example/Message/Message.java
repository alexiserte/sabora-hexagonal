package org.example.Message;

import org.example.Instruction.Instruction;
import org.example.Instruction.InstructionTypes;
import org.example.Utils.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Message {


    private MessageTypes type;
    List<Instruction> instructions = new ArrayList<>();

    public Message(MessageTypes type, List<Instruction> instructions){
        this.type = type;
        this.instructions = instructions;
    }


    public static void main(String[] args){
        Message prueba = new Message(MessageTypes.START,List.of(new Instruction(InstructionTypes.BACK_TO_MENU,null)) );
        System.out.println(prueba.instructions.toString());
    }
}
