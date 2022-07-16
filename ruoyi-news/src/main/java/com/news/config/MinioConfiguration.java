
package com.news.config;
import com.news.util.MinioUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MinIO配置
 *
 * @author william@StarImmortal
 * @date 2022/04/19
 */
@Configuration
@Slf4j
@Data
public class MinioConfiguration {

    @Value("${minio.endpoint}")
    private String endpoint;

    @Value("${minio.bucket}")
    private String bucketName;

    @Value("${minio.access-key}")
    private String accessKey;

    @Value("${minio.secret-key}")
    private String secretKey;

    /**
     * 初始化客户端
     *
     * @return 客户端
     */
    @Bean
    public MinioUtil minioClient() {
        return new MinioUtil(endpoint, bucketName, accessKey, secretKey);
    }
}
