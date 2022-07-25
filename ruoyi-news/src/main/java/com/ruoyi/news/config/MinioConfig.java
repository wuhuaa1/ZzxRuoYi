package com.ruoyi.news.config;
import com.ruoyi.news.util.MinioUtils02;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
/**
 * @Author: zrs
 * @Date: 2020/12/01/17:05
 * @Description: 创建Bean
 */
@Configuration
@Slf4j
@Data
public class MinioConfig {
 
  @Value("${minio.endpoint}")
  private String endpoint;
  @Value("${minio.bucketName}")
  private String bucketName;
  @Value("${minio.accessKey}")
  private String accessKey;
  @Value("${minio.secretKey}")
  private String secretKey;
 
  @Bean
  public MinioUtils02 creatMinioClient() {
    return new MinioUtils02(endpoint, bucketName, accessKey, secretKey);
  }
 
}