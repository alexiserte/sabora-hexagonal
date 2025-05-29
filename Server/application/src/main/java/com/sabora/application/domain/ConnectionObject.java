package com.sabora.application.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConnectionObject {
    private String name;
    private String localIp;
}
