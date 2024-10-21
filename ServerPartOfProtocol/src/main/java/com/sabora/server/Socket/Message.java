package com.sabora.server.Socket;

public class Message {


        private String userID;
        private String userIP;
        private String userMAC;
        private String deviceType;
        private String type;
        private String instruction;

        // Getters y Setters
        public String getUserID() {
            return userID;
        }

        public void setUserID(String userID) {
            this.userID = userID;
        }

        public String getUserIP() {
            return userIP;
        }

        public void setUserIP(String userIP) {
            this.userIP = userIP;
        }

        public String getUserMAC() {
            return userMAC;
        }

        public void setUserMAC(String userMAC) {
            this.userMAC = userMAC;
        }

        public String getDeviceType() {
            return deviceType;
        }

        public void setDeviceType(String deviceType) {
            this.deviceType = deviceType;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getInstruction() {
            return instruction;
        }

        public void setInstruction(String instruction) {
            this.instruction = instruction;
        }

        @Override
        public String toString() {
            return "UserConnection{" +
                    "userID='" + userID + '\'' +
                    ", userIP='" + userIP + '\'' +
                    ", userMAC='" + userMAC + '\'' +
                    ", deviceType='" + deviceType + '\'' +
                    ", type='" + type + '\'' +
                    ", instruction='" + instruction + '\'' +
                    '}';
        }
}


