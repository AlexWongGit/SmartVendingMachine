package com.alex.vm.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@ApiModel(value = "基础类")
public class BaseEntity implements Serializable {
    public static final String CONTROL = "100";
    public static final String STATUS_NORMAL = "0";
    public static final String STATUS_DELETE = "1";
    public static final String STATUS_DISABLE = "2";

    public static final String ID_SEPARATOR = ",";
    /**
     * id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "id")
    private Integer id;

    /**
     * 创建人登录名称
     */
    @TableField(value = "create_by", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人登录名称")
    private String createBy;

    /**
     * 创建人用户名
     */
    @TableField(value = "create_name", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建人用户名")
    private String createName;
    /**
     * 创建日期
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建日期")
    private LocalDateTime createTime;
    /**
     * 更新人登录名称
     */
    @TableField(value = "update_by", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新人登录名称")
    private String updateBy;

    /**
     * 更新人用户名
     */
    @TableField(value = "update_name", fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新人用户名")
    private String updateName;
    /**
     * 更新日期
     */
    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE, update = "now()")
    @ApiModelProperty(value = "更新日期")
    private LocalDateTime updateTime;
    /**
     * 备注
     */
    @TableField(value = "remarks")
    @ApiModelProperty(value = "备注")
    private String remarks;
    /**
     * 状态 0启用 1禁用
     */
    @TableField(value = "status")
    @TableLogic(value = "0", delval = "1")
    @ApiModelProperty(value = "状态 0启用 1删除 2禁用")
    private String status;

    public static final String COL_ID = "id";

    public static final String COL_STATUS = "status";

    public static final String COL_CREATE_BY = "create_by";

    public static final String COL_CREATE_NAME = "create_name";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_BY = "update_by";

    public static final String COL_UPDATE_NAME = "update_name";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_REMARKS = "remarks";

}

