package org.example;

import org.example.Instruction.Instruction;
import org.example.Instruction.InstructionFactory;
import org.example.Instruction.InstructionTypes;
import org.example.Socket.PubSocket;
import org.example.Utils.*;
import static org.example.Socket.PubSocket.generateID;

public class Main {
    static{deviceID = PubSocket.generateID();}
    public static String deviceID;
}