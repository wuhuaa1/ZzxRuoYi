package com.ruoyi.news.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 新闻信息对象 zzx_news
 * 
 * @author ruoyi
 * @date 2022-07-28
 */
@Data
@ApiModel("新闻信息对象")
public class ZzxNews
{
    private static final long serialVersionUID = 1L;

    /** 新闻ID */
    @ApiModelProperty(value = "新闻ID")
    private Long newsId;

    /** 新闻名称 */
    @Excel(name = "新闻名称")
    @ApiModelProperty(value = "新闻名称")
    private String newsName;

    /** 新闻发布人*/
    @Excel(name = "新闻发布人")
    @ApiModelProperty(value = "新闻发布人")
    private String newsAuthor;

    /** 新闻内容
 */
    @Excel(name = "新闻内容 ")
    @ApiModelProperty(value = "新闻内容")
    private String newsContent;

    /** 新闻发布时间 */
    @ApiModelProperty(value = "新闻发布时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "新闻发布时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date newsCreatetime;

    /** 更改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "新闻更改时间")
    @Excel(name = "更改时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date newsUpdatetime;

    /** 浏览次数 */
    @ApiModelProperty(value = "浏览次数")
    @Excel(name = "浏览次数")
    private Long newsSum;
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("newsId", getNewsId())
            .append("newsName", getNewsName())
            .append("newsAuthor", getNewsAuthor())
            .append("newsContent", getNewsContent())
            .append("newsCreatetime", getNewsCreatetime())
            .append("newsUpdatetime", getNewsUpdatetime())
            .append("newsSum", getNewsSum())
            .toString();
    }
}
