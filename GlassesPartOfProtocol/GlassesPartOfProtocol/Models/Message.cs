using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GlassesPartOfProtocol.Models
{
    class Message
    {
        private string userID = Utils.UserData.generateID();
        private string userIP = Utils.UserData.ObtenerDireccionIP().Result;
        private string userMAC = Utils.UserData.ObtenerDireccionMac();

        public enum Devices { MOBILE,SERVER,VR_GLASSES}
        private Devices deviceType { get; set; }
        private string type { get; set; }

        private Dictionary<string, string> messageParameters = new Dictionary<string, string>();
        private Instruction instruction { get; set; }

        public enum messageType { SEARCH, REGISTER, CONNECTION, DISCONNECTION, START, STOP, ACTION, DATA, TEST }

        public override string ToString()
        {
            return $"UserConnection{{ userID='{userID}', userIP='{userIP}', userMAC='{userMAC}', deviceType='{deviceType}', type='{type}', messageParameters={string.Join(", ", messageParameters)}, instruction='{instruction}' }}";
        }

        public Message(string userID, string userIP, string userMAC, Devices deviceType, string type, Dictionary<string, string> messageParameters, Instruction instruction) {
            this.userID = userID;
            this.userIP = userIP;
            this.userMAC = userMAC;
            this.deviceType = deviceType;
            this.type = type;
            this.instruction = instruction;
        }




    }
}
