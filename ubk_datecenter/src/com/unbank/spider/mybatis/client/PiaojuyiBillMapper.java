package com.unbank.spider.mybatis.client;

import com.unbank.spider.mybatis.vo.PiaojuyiBill;
import com.unbank.spider.mybatis.vo.PiaojuyiBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PiaojuyiBillMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table piaojuyi_bill
     *
     * @mbggenerated Thu Jan 22 13:23:26 CST 2015
     */
    int countByExample(PiaojuyiBillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table piaojuyi_bill
     *
     * @mbggenerated Thu Jan 22 13:23:26 CST 2015
     */
    int deleteByExample(PiaojuyiBillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table piaojuyi_bill
     *
     * @mbggenerated Thu Jan 22 13:23:26 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table piaojuyi_bill
     *
     * @mbggenerated Thu Jan 22 13:23:26 CST 2015
     */
    int insert(PiaojuyiBill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table piaojuyi_bill
     *
     * @mbggenerated Thu Jan 22 13:23:26 CST 2015
     */
    int insertSelective(PiaojuyiBill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table piaojuyi_bill
     *
     * @mbggenerated Thu Jan 22 13:23:26 CST 2015
     */
    List<PiaojuyiBill> selectByExample(PiaojuyiBillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table piaojuyi_bill
     *
     * @mbggenerated Thu Jan 22 13:23:26 CST 2015
     */
    PiaojuyiBill selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table piaojuyi_bill
     *
     * @mbggenerated Thu Jan 22 13:23:26 CST 2015
     */
    int updateByExampleSelective(@Param("record") PiaojuyiBill record, @Param("example") PiaojuyiBillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table piaojuyi_bill
     *
     * @mbggenerated Thu Jan 22 13:23:26 CST 2015
     */
    int updateByExample(@Param("record") PiaojuyiBill record, @Param("example") PiaojuyiBillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table piaojuyi_bill
     *
     * @mbggenerated Thu Jan 22 13:23:26 CST 2015
     */
    int updateByPrimaryKeySelective(PiaojuyiBill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table piaojuyi_bill
     *
     * @mbggenerated Thu Jan 22 13:23:26 CST 2015
     */
    int updateByPrimaryKey(PiaojuyiBill record);
}