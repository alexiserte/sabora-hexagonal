package org.example.Instruction;

public class Instruction {

    private InstructionTypes action;
    private Object param;

    public Instruction(InstructionTypes action, Object param){
        this.action = action;
        this.param = param;
    }

    @Override
    public String toString(){
        return String.format("{%s,%s}",this.action,this.param);
    }

    public InstructionTypes getAction(){return this.action;}

    public Object getParam(){return this.param;}
}
