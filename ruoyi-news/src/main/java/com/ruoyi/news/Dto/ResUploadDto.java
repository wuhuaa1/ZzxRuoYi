package com.ruoyi.news.Dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel("文件出参")
@Data
public class ResUploadDto {
    @ApiModelProperty("文件名")
    private String fileName;
    @ApiModelProperty("文件地址")
    private String url;
}
