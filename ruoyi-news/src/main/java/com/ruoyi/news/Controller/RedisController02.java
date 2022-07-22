package com.ruoyi.news.Controller;


import com.ruoyi.common.core.domain.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

@RestController
@Api(value = "redis控制器")
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
    @ApiOperation(value = "添加redis数据")
    public AjaxResult add(@ApiParam  String value)
    {
        //获取当前时间
        LocalTime time = LocalTime.now();
        //设置格式
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        //时间转换格式并存储为value
        String getValue =value+"time:"+time.format(formatter);

        redisTemplate.opsForValue().set("addRedis"+value,getValue,3, TimeUnit.MINUTES);
        return AjaxResult.success("添加"+getValue+"成功");

    }
    /**\
     * 添加redis键
     * @param value
     * @return
     */
    @PostMapping("/add2")
    @ApiOperation(value = "添加redis数据不带时间")
    public AjaxResult add2(@ApiParam  String value)
    {
        redisTemplate.opsForValue().set("addRedis"+value,value,3, TimeUnit.MINUTES);
        return AjaxResult.success("添加"+value+"成功");

    }

    /**\
     * 验证redis key是否存在
     * @param value
     * @return
     */
    @PostMapping("/select")
    @ApiOperation(value = "验证redis key是否存在")
    public AjaxResult select(@ApiParam  String value)
    {

        String key = "addRedis" + value;
        if (redisTemplate.hasKey(key)) {
            return AjaxResult.success("key" + value + "存在");
        } else {
            return AjaxResult.success("key" + value + "不存在");
        }

    }




}
