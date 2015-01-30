package com.unbank.spider.mybatis.client;

import com.unbank.spider.mybatis.vo.Jdbill;
import com.unbank.spider.mybatis.vo.JdbillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JdbillMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    int countByExample(JdbillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    int deleteByExample(JdbillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    int insert(Jdbill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    int insertSelective(Jdbill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    List<Jdbill> selectByExample(JdbillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    Jdbill selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    int updateByExampleSelective(@Param("record") Jdbill record, @Param("example") JdbillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    int updateByExample(@Param("record") Jdbill record, @Param("example") JdbillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    int updateByPrimaryKeySelective(Jdbill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jd_bill
     *
     * @mbggenerated Fri Dec 26 14:31:22 CST 2014
     */
    int updateByPrimaryKey(Jdbill record);
}