package com.sabora.api.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConnectionObjectDTO {
    private String name;
    private String localIp;
}