package com.ruoyi.news.service.impl;

import java.util.List;

import com.ruoyi.news.mapper.ZzxNewsMapper;
import com.ruoyi.news.domain.ZzxNews;
import com.ruoyi.news.service.IZzxNewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 新闻信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-28
 */
@Service
public class ZzxNewsServiceImpl implements IZzxNewsService
{
    @Autowired
    private ZzxNewsMapper zzxNewsMapper;

    /**
     * 查询新闻信息
     * 
     * @param newsId 新闻信息主键
     * @return 新闻信息
     */
    @Override
    public ZzxNews selectZzxNewsByNewsId(Long newsId)
    {
        return zzxNewsMapper.selectZzxNewsByNewsId(newsId);
    }

    /**
     * 查询新闻信息列表
     * 
     * @param zzxNews 新闻信息
     * @return 新闻信息
     */
    @Override
    public List<ZzxNews> selectZzxNewsList(ZzxNews zzxNews)
    {
        return zzxNewsMapper.selectZzxNewsList(zzxNews);
    }

    /**
     * 新增新闻信息
     * 
     * @param zzxNews 新闻信息
     * @return 结果
     */
    @Override
    public int insertZzxNews(ZzxNews zzxNews)
    {
        return zzxNewsMapper.insertZzxNews(zzxNews);
    }

    /**
     * 修改新闻信息
     * 
     * @param zzxNews 新闻信息
     * @return 结果
     */
    @Override
    public int updateZzxNews(ZzxNews zzxNews)
    {
        return zzxNewsMapper.updateZzxNews(zzxNews);
    }

    /**
     * 批量删除新闻信息
     * 
     * @param newsIds 需要删除的新闻信息主键
     * @return 结果
     */
    @Override
    public int deleteZzxNewsByNewsIds(Long[] newsIds)
    {
        return zzxNewsMapper.deleteZzxNewsByNewsIds(newsIds);
    }

    /**
     * 删除新闻信息信息
     * 
     * @param newsId 新闻信息主键
     * @return 结果
     */
    @Override
    public int deleteZzxNewsByNewsId(Long newsId)
    {
        return zzxNewsMapper.deleteZzxNewsByNewsId(newsId);
    }
}
