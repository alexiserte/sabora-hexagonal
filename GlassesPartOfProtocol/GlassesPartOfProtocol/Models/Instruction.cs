using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GlassesPartOfProtocol.Models
{
    class Instruction
    {
        public enum InstructionType
        {
            START_EXPERIENCE,
            STOP_EXPERIENCE,
            PAUSE_EXPERIENCE,
            RESUME_EXPERIENCE,
            INCREASE_VOLUME,
            DECREASE_VOLUME,
            STOP_SOUND,
            PLAY_SOUND,
            MUTE,
            FULL_VOLUME,
            INCREASE_BRIGHTNESS,
            DECREASE_BRIGHTNESS,
            BLINDNESS,
            FULL_LIGTH,
            CHANGE_SCENARIO,
            BACK_TO_MENU
        }

        private InstructionType type { get; set; }
        private string param { get; set; }
        
        public Instruction(InstructionType type, Object param) {
            this.type = type;
            this.param = param.ToString();
        }


    }
}
