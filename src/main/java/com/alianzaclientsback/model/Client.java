package com.alianzaclientsback.model;

import lombok.Data;

@Data
public class Client {

    private String codeClient;
    private String name;
    private String phone;
    private String email;
    private String startDate;

}
