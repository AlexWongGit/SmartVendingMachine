package com.alex.vm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("vm_device")
public class VmDevice extends BaseEntity{

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String deviceName;

    private String deviceType;

    private String deviceStatus;

    private String lng;

    private String lat;
}
