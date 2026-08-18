package com.xzj.lotterysystem.dao.dataobject;

import cn.hutool.core.date.DateTime;
import lombok.Data;

import java.io.Serializable;

@Data
public class BaseDO implements Serializable {
    private Long id;
    private DateTime gmt_create;
    private DateTime gmt_modified;
}
