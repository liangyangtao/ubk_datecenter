package com.unbank.spider.mybatis.client;

import com.unbank.spider.mybatis.vo.ChinaventureMergerevent;
import com.unbank.spider.mybatis.vo.ChinaventureMergereventExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChinaventureMergereventMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chinaventure_mergerevent
     *
     * @mbggenerated Thu Jan 08 15:23:53 CST 2015
     */
    int countByExample(ChinaventureMergereventExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chinaventure_mergerevent
     *
     * @mbggenerated Thu Jan 08 15:23:53 CST 2015
     */
    int deleteByExample(ChinaventureMergereventExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chinaventure_mergerevent
     *
     * @mbggenerated Thu Jan 08 15:23:53 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chinaventure_mergerevent
     *
     * @mbggenerated Thu Jan 08 15:23:53 CST 2015
     */
    int insert(ChinaventureMergerevent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chinaventure_mergerevent
     *
     * @mbggenerated Thu Jan 08 15:23:53 CST 2015
     */
    int insertSelective(ChinaventureMergerevent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chinaventure_mergerevent
     *
     * @mbggenerated Thu Jan 08 15:23:53 CST 2015
     */
    List<ChinaventureMergerevent> selectByExample(ChinaventureMergereventExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chinaventure_mergerevent
     *
     * @mbggenerated Thu Jan 08 15:23:53 CST 2015
     */
    ChinaventureMergerevent selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chinaventure_mergerevent
     *
     * @mbggenerated Thu Jan 08 15:23:53 CST 2015
     */
    int updateByExampleSelective(@Param("record") ChinaventureMergerevent record, @Param("example") ChinaventureMergereventExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chinaventure_mergerevent
     *
     * @mbggenerated Thu Jan 08 15:23:53 CST 2015
     */
    int updateByExample(@Param("record") ChinaventureMergerevent record, @Param("example") ChinaventureMergereventExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chinaventure_mergerevent
     *
     * @mbggenerated Thu Jan 08 15:23:53 CST 2015
     */
    int updateByPrimaryKeySelective(ChinaventureMergerevent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table chinaventure_mergerevent
     *
     * @mbggenerated Thu Jan 08 15:23:53 CST 2015
     */
    int updateByPrimaryKey(ChinaventureMergerevent record);
}