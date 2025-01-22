package com.sabora.server.Models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ConnectionParams {
    private String name;
    private String localIp;
    private String remoteIp;

    @Override
    public String toString(){
        return "Name: " + name + " Local IP: " + localIp + " Remote IP: " + remoteIp;
    }
}
