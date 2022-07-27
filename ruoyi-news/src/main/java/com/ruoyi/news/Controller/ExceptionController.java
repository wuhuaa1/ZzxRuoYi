package com.ruoyi.news.Controller;


/**
 *
 * 异常类练习 控制器
 *
 */


import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.framework.web.exception.BusinessErrorException;
import com.ruoyi.framework.web.exception.BusinessMsgEnum;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@Api(tags = "异常类定义控制类")
@RequestMapping("/yc")
public class ExceptionController {


    @ApiOperation(value = "发送自定义异常")
    @PostMapping("/sendException")
    public AjaxResult sendException(int i)
    {
        try
        {
            if(i==1) {

                throw new BusinessErrorException(BusinessMsgEnum.PARMETER_BIG_EXCEPTION);
            }
            else if(i==2){
                throw new BusinessErrorException(BusinessMsgEnum.SERVICE_TIME_OUT);
            }else  if(i==3){
                throw new BusinessErrorException(BusinessMsgEnum.PARMETER_EXCEPTION);
            }
        }
        catch (BusinessErrorException e)
        {
             log.error(e.getMessage());
             return AjaxResult.error(e.getCode(),e.getMessage());
           // e.printStackTrace();
        }
        return AjaxResult.success("没有异常");
    }
}
