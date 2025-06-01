package com.sabora.database.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConnectionParamsMO {
    private String name;
    private String localIp;
    private String remoteIp;

    @Override
    public String toString() {
        return "Name: " + name + " Local IP: " + localIp + " Remote IP: " + remoteIp;
    }
}
