package com.xzj.lotterysystem.dao.dataobject;


import lombok.Data;

@Data
public class Encryppt {
    private String value;
    public Encryppt(){}
    public Encryppt(String value)
    {
        this.value = value;
    }
}
