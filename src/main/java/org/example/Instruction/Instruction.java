package org.example.Instruction;

public class Instruction {

    private InstructionTypes type;
    private Object param;

    public Instruction(InstructionTypes type, Object param){
        this.type = type;
        this.param = param;
    }

    @Override
    public String toString(){
        return String.format("{%s,%s}",this.type,this.param);
    }
}
