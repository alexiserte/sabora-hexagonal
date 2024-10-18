package org.example;

import org.example.Instruction.Instruction;
import org.example.Instruction.InstructionFactory;
import org.example.Instruction.InstructionTypes;
import org.example.Utils.*;

public class Main {
    public static void main(String[] args) {

        InstructionFactory insFactory = new InstructionFactory();
        Instruction i = insFactory.createScenarioInstruction(InstructionTypes.BACK_TO_MENU,null);
        System.out.println(i);
    }
}