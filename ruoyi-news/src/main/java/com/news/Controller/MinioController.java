package com.news.Controller;


import com.github.pagehelper.Constant;
import com.news.config.MinioConfiguration;
import com.news.util.MinioUtil;
import com.ruoyi.common.core.domain.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Api(value = "这是Minio操作接口",tags = "这是Minio操作接口")
@RestController
@RequestMapping("/Minio")
public class MinioController {
    @Autowired
    private  MinioUtil minioUtil;

    @Autowired
    private MinioConfiguration configuration;


    /**
     * 通过流上传文件请求
     */
    @PostMapping ("/addFile")
    @ApiOperation("添加文件")
    public AjaxResult uploadFile()
    {
        String BucketName=configuration.getBucketName();


        return AjaxResult.success("添加成功桶"+BucketName);

    }




}
