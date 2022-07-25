package com.ruoyi.news.Controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.news.util.MinioUtilS;
import com.ruoyi.news.util.MinioUtils02;
import io.minio.errors.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
@Slf4j
@Api(tags = "Minio控制器")
@RequestMapping("/minio")
public class MinioController {
    @Autowired
    private MinioUtilS minioUtilS;
    @Autowired
    private MinioUtils02 minioUtils02;
    @Value("${minio.endpoint}")
    private String address;
    @Value("${minio.bucketName}")
    private String bucketName;


    // 第一个工具类 接口
    @ApiOperation(value = "上传文件",notes = "上传文件")
    @PostMapping("/upload")
    public AjaxResult upload(MultipartFile file) {

        List<String> upload = minioUtilS.upload(new MultipartFile[]{file});
          String Result=address+"/"+bucketName+"/"+upload.get(0);
        return AjaxResult.success(Result);
    }

    @ApiOperation(value = "下载文件",notes = "下载文件")
    @PostMapping("/download")
    public AjaxResult download(String fileName) {


          minioUtilS.download(fileName);
        return AjaxResult.success("下载成功");
    }

    //第二个工具类接口
    @ApiOperation(value = "上传文件02",notes = "上传文件02")
    @PostMapping("/upload2")
    public AjaxResult upload2(MultipartFile file) throws IOException, InvalidResponseException, InvalidKeyException, NoSuchAlgorithmException, ServerException, ErrorResponseException, XmlParserException, InvalidBucketNameException, InsufficientDataException, InternalException {
        String objectName = "ZZX02_"+file.getOriginalFilename();
        String contentType=file.getContentType();
          minioUtils02.putObject(bucketName, file,objectName,contentType);
          return AjaxResult.success("上传文件"+objectName+"."+contentType+"成功");
    }

    @ApiOperation(value = "下载文件02",notes = "下载文件02")
    @GetMapping("/download2")
    public AjaxResult download02( String fileName,HttpServletResponse response) {
        String objectName = "ZZX02_"+fileName;
        minioUtils02.getObject(bucketName,objectName,fileName);
        response.addHeader("Content-Disposition", "attachment; filename=" +fileName);
    //    minioUtils02.download(fileName);
        return AjaxResult.success("下载"+fileName+"成功");
    }






}
