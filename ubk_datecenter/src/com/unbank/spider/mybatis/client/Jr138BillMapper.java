package com.unbank.spider.mybatis.client;

import com.unbank.spider.mybatis.vo.Jr138Bill;
import com.unbank.spider.mybatis.vo.Jr138BillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Jr138BillMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jr138_bill
     *
     * @mbggenerated Thu Jan 22 11:31:58 CST 2015
     */
    int countByExample(Jr138BillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jr138_bill
     *
     * @mbggenerated Thu Jan 22 11:31:58 CST 2015
     */
    int deleteByExample(Jr138BillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jr138_bill
     *
     * @mbggenerated Thu Jan 22 11:31:58 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jr138_bill
     *
     * @mbggenerated Thu Jan 22 11:31:58 CST 2015
     */
    int insert(Jr138Bill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jr138_bill
     *
     * @mbggenerated Thu Jan 22 11:31:58 CST 2015
     */
    int insertSelective(Jr138Bill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jr138_bill
     *
     * @mbggenerated Thu Jan 22 11:31:58 CST 2015
     */
    List<Jr138Bill> selectByExample(Jr138BillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jr138_bill
     *
     * @mbggenerated Thu Jan 22 11:31:58 CST 2015
     */
    Jr138Bill selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jr138_bill
     *
     * @mbggenerated Thu Jan 22 11:31:58 CST 2015
     */
    int updateByExampleSelective(@Param("record") Jr138Bill record, @Param("example") Jr138BillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jr138_bill
     *
     * @mbggenerated Thu Jan 22 11:31:58 CST 2015
     */
    int updateByExample(@Param("record") Jr138Bill record, @Param("example") Jr138BillExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jr138_bill
     *
     * @mbggenerated Thu Jan 22 11:31:58 CST 2015
     */
    int updateByPrimaryKeySelective(Jr138Bill record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table jr138_bill
     *
     * @mbggenerated Thu Jan 22 11:31:58 CST 2015
     */
    int updateByPrimaryKey(Jr138Bill record);
}