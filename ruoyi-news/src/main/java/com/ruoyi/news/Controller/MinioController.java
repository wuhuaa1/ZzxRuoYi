package com.ruoyi.news.Controller;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.news.Dto.ResUploadDto;
import com.ruoyi.news.config.MinioConfig;
import com.ruoyi.news.util.MinioUtils02;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@Api(tags = "Minio控制器")
@RequestMapping("/minio")
public class MinioController {
    @Autowired
    private MinioUtils02 minioUtils02;
    @Value("${minio.bucketName}")
    private String bucketName;


    @ApiOperation(value = "zzx文件上传",tags = "zzx文件上传")
    @PostMapping("/upload")
    public AjaxResult upload(@ApiParam(value = "文件") MultipartFile file) {
        try {
            String filename = file.getOriginalFilename();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            // 文件存储的目录结构
            String objectName = sdf.format(new Date()) + "/" + filename;
            String contentType=file.getContentType();
            // 存储文件
            minioUtils02.putObject(bucketName,file, objectName,contentType);
            String url = minioUtils02.getObjectUrl(bucketName, objectName);
            ResUploadDto resUploadDto = new ResUploadDto();
            resUploadDto.setUrl(url);
            resUploadDto.setFileName(objectName);
            return AjaxResult.success(resUploadDto);
        } catch (Exception e) {
            return AjaxResult.error("上传失败"+e.getMessage());
        }
    }





    @ApiOperation(value="zzx获取所有文件列表",tags = "zzx获取所有文件列表")
    @GetMapping("/listFile")
    public  AjaxResult ListFile(@ApiParam(value = "桶名称") String bucketName)
    {
        try{

            List<String> listFile= minioUtils02.listObjectNames(bucketName);
            return  AjaxResult.success(listFile);

        }
        catch (Exception e)
        {
            return  AjaxResult.error("文件列表查询失败"+e.getMessage());
        }
    }

    @ApiOperation(value = "zzx文件下载",tags = "通过文件名下载")
    @GetMapping("/download")
    public AjaxResult download(@ApiParam(value = "文件名") String fileName,HttpServletResponse response) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 文件存储的目录结构
        String objectName = sdf.format(new Date()) + "/" + fileName;
        //执行文件下载
        minioUtils02.downloadFile(bucketName,fileName,objectName,response);
        return  AjaxResult.success();

    }

    @ApiOperation(value="zzx文件删除",notes = "zzx文件删除")
    @DeleteMapping("/delete")
    public AjaxResult deleteFiles(@RequestParam("time") String time, @RequestParam("filename") String filename) {

        try {
            //tring fileUrl=minioService.getObjectUrl(bucketName,filename);
            String objectName=time+"/"+filename;
            //删除文件
            minioUtils02.removeObject(bucketName,objectName);
            ResUploadDto resDeleteDto = new ResUploadDto();
            resDeleteDto.setFileName("删除文件名为："+filename);
            resDeleteDto.setUrl("删除路径为"+objectName);
            return AjaxResult.success(resDeleteDto);
        } catch (Exception e) {
            return AjaxResult.error("删除失败"+e.getMessage());
        }
    }






}
