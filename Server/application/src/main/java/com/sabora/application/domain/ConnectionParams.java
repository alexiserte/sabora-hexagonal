package com.sabora.application.domain;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ConnectionParams {
    private String name;
    private String localIp;
    private String remoteIp;

    @Override
    public String toString() {
        return "Name: " + name + " Local IP: " + localIp + " Remote IP: " + remoteIp;
    }
}
