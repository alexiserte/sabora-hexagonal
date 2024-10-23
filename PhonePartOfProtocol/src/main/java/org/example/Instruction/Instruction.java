package org.example.Instruction;

public class Instruction {

    private InstructionTypes type;
    private String param;

    public Instruction(InstructionTypes type, Object param){
        this.type = type;
        this.param = param.toString();
    }

    public InstructionTypes getType(){
        return this.type;
    }

    public Object getParam(){
        return this.param;
    }

    public void setType(InstructionTypes type){
        this.type = type;
    }

    public void setParam(Object param){
        this.param = param.toString();
    }

    @Override
    public String toString(){
        return String.format("{%s,%s}",this.type,this.param);
    }
}
