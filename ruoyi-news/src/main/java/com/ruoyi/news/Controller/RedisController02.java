package com.ruoyi.news.Controller;


import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@RestController
@Api(tags = "redis控制器")
@RequestMapping("/redis")
public class RedisController02 {


    @Autowired
    RedisTemplate redisTemplate;

    /**\
     * 添加redis键
     * @param value
     * @return
     */
    @PostMapping("/add")
    @ApiOperation(value = "添加redis数据带时间")
    public AjaxResult add(String value)
    {
        //获取当前时间
        LocalTime time = LocalTime.now();
        //设置格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        //时间转换格式并存储为value
        String getValue =value+"time:"+time.format(formatter);

        redisTemplate.opsForValue().set("addRedis"+value,getValue,3, TimeUnit.MINUTES);
        return AjaxResult.success("添加redis"+getValue+"成功");

    }

    /**\
     * 添加redis键
     * @param key
     * @return
     */
    @GetMapping("/add2")
    @ApiOperation(value = "添加redis2")
    public AjaxResult add2( String key)
    {
        redisTemplate.opsForValue().set("addRedis"+key,key,3, TimeUnit.MINUTES);
        return AjaxResult.success("添加redis2"+key+"成功");

    }

    /**\
     * 验证redis key是否存在
     key     * @return
     */
    @GetMapping(value = "/select")
    @ApiOperation("验证redis key是否存在")
    public AjaxResult select(@ApiParam(value = "验证rediskey", name = "rediskey") String rediskey)
    {

        String key = "addRedis" + rediskey;
        if (redisTemplate.hasKey(key)) {
            return AjaxResult.success("key" + key + "存在");
        } else {
            return AjaxResult.success("key" + key + "不存在");
        }

    }




}
