package org.example.Instruction;

import org.example.Instruction.Exception.ControlInstructionException;
import org.example.Instruction.Exception.LightInstructionException;
import org.example.Instruction.Exception.ScenarioInstructionException;
import org.example.Instruction.Exception.SoundInstructionException;

import java.util.List;

public class InstructionFactory {
    public InstructionFactory() {}

    public Instruction createControlInstruction(InstructionTypes type, Object param){
        try {
            List<String> possibleInstructions = List.of("START_EXPERIENCE", "STOP_EXPERIENCE", "PAUSE_EXPERIENCE", "RESUME_EXPERIENCE");
            if (!possibleInstructions.contains(type.toString())) {
                throw new ControlInstructionException("The specified instruction is not valid");
            }
            return new Instruction(type,param);
        }catch(ControlInstructionException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Instruction createSoundInstruction(InstructionTypes type, Object param){
        try {
            List<String> possibleInstructions = List.of("INCREASE_VOLUME", "DECREASE_VOLUME", "STOP_SOUND", "PLAY_SOUND", "MUTE", "FULL_VOLUME");
            if (!possibleInstructions.contains(type.toString())) {
                throw new SoundInstructionException("The specified instruction is not valid");
            }
            return new Instruction(type,param);
        }catch(SoundInstructionException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Instruction createLightInstruction(InstructionTypes type, Object param){
        try {
            List<String> possibleInstructions = List.of("INCREASE_BRIGHTNESS","DECREASE_BRIGHTNESS","BLINDNES","FULL_LIGTH");
            if (!possibleInstructions.contains(type.toString())) {
                throw new LightInstructionException("The specified instruction is not valid");
            }
            return new Instruction(type,param);
        }catch(LightInstructionException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

    public Instruction createScenarioInstruction(InstructionTypes type, Object param){
        try {
            List<String> possibleInstructions = List.of("CHANGE_SCENARIO","BACK_TO_MENU");
            if (!possibleInstructions.contains(type.toString())) {
                throw new ScenarioInstructionException("The specified instruction is not valid");
            }
            return new Instruction(type,param);
        }catch(ScenarioInstructionException e){
            System.err.println(e.getMessage());
            return null;
        }
    }

}