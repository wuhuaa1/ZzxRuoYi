package com.ruoyi.news.service;

import com.ruoyi.news.domain.ZzxNews;

import java.util.List;

/**
 * 新闻信息Service接口
 * 
 * @author ruoyi
 * @date 2022-07-28
 */
public interface IZzxNewsService 
{
    /**
     * 查询新闻信息
     * 
     * @param newsId 新闻信息主键
     * @return 新闻信息
     */
    public ZzxNews selectZzxNewsByNewsId(Long newsId);

    /**
     * 查询新闻信息列表
     * 
     * @param zzxNews 新闻信息
     * @return 新闻信息集合
     */
    public List<ZzxNews> selectZzxNewsList(ZzxNews zzxNews);

    /**
     * 新增新闻信息
     * 
     * @param zzxNews 新闻信息
     * @return 结果
     */
    public int insertZzxNews(ZzxNews zzxNews);

    /**
     * 修改新闻信息
     * 
     * @param zzxNews 新闻信息
     * @return 结果
     */
    public int updateZzxNews(ZzxNews zzxNews);

    /**
     * 批量删除新闻信息
     * 
     * @param newsIds 需要删除的新闻信息主键集合
     * @return 结果
     */
    public int deleteZzxNewsByNewsIds(Long[] newsIds);

    /**
     * 删除新闻信息信息
     * 
     * @param newsId 新闻信息主键
     * @return 结果
     */
    public int deleteZzxNewsByNewsId(Long newsId);
}
