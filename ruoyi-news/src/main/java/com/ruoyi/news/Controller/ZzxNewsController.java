package com.ruoyi.news.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.news.domain.ZzxNews;
import com.ruoyi.news.service.IZzxNewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 新闻信息Controller
 * 
 * @author ruoyi
 * @date 2022-07-28
 */
@Api(tags = "新闻信息Controller")
@RestController
@RequestMapping("/system/news")
public class ZzxNewsController extends BaseController
{
    @Autowired
    private IZzxNewsService zzxNewsService;

    /**
     * 查询新闻信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:news:list')")
    @ApiOperation(value = "查询新闻信息列表")
    @GetMapping("/list")
    public TableDataInfo list(@ApiParam ZzxNews zzxNews)
    {
        startPage();
        List<ZzxNews> list = zzxNewsService.selectZzxNewsList(zzxNews);
        return getDataTable(list);
    }

    /**
     * 导出新闻信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:news:export')")
    @ApiOperation(value = "导出新闻信息列表")
    @PostMapping("/export")
    public void export(HttpServletResponse response, ZzxNews zzxNews)
    {
        List<ZzxNews> list = zzxNewsService.selectZzxNewsList(zzxNews);
        ExcelUtil<ZzxNews> util = new ExcelUtil<ZzxNews>(ZzxNews.class);
        util.exportExcel(response, list, "新闻信息数据");
    }

    /**
     * 获取新闻信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:news:query')")
    @ApiOperation(value = "获取新闻信息详细信息")
    @GetMapping(value = "/{newsId}")
    public AjaxResult getInfo(@PathVariable("newsId") Long newsId)
    {
        return AjaxResult.success(zzxNewsService.selectZzxNewsByNewsId(newsId));
    }

    /**
     * 新增新闻信息
     */
    @PreAuthorize("@ss.hasPermi('system:news:add')")
    @ApiOperation(value = "新增新闻信息")
    @PostMapping
    public AjaxResult add(@ApiParam @RequestBody ZzxNews zzxNews) {
        Date cur=DateUtils.parseDate(DateUtils.getTime());
        zzxNews.setNewsCreatetime(cur);
        zzxNews.setNewsUpdatetime(cur);
        return toAjax(zzxNewsService.insertZzxNews(zzxNews));
    }

    /**
     * 修改新闻信息
     */
    @PreAuthorize("@ss.hasPermi('system:news:edit')")
    @ApiOperation(value = "修改新闻信息")
    @PutMapping
    public AjaxResult edit(@ApiParam @RequestBody ZzxNews zzxNews) {
      //将当前时间传入更新时间
        Date cur=DateUtils.parseDate(DateUtils.getTime());
        zzxNews.setNewsUpdatetime(cur);
        return toAjax(zzxNewsService.updateZzxNews(zzxNews));
    }

    /**
     * 删除新闻信息
     */
    @PreAuthorize("@ss.hasPermi('system:news:remove')")
    @ApiOperation(value = "删除新闻信息")
	@DeleteMapping("/{newsIds}")
    public AjaxResult remove(@PathVariable Long[] newsIds)
    {
        return toAjax(zzxNewsService.deleteZzxNewsByNewsIds(newsIds));
    }
}
