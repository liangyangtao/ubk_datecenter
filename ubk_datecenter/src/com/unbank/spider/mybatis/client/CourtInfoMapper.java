package com.unbank.spider.mybatis.client;

import com.unbank.spider.mybatis.vo.CourtInfo;
import com.unbank.spider.mybatis.vo.CourtInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourtInfoMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table court_announcement
	 * @mbggenerated  Mon Jan 05 17:44:53 CST 2015
	 */
	int countByExample(CourtInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table court_announcement
	 * @mbggenerated  Mon Jan 05 17:44:53 CST 2015
	 */
	int deleteByExample(CourtInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table court_announcement
	 * @mbggenerated  Mon Jan 05 17:44:53 CST 2015
	 */
	int deleteByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table court_announcement
	 * @mbggenerated  Mon Jan 05 17:44:53 CST 2015
	 */
	int insert(CourtInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table court_announcement
	 * @mbggenerated  Mon Jan 05 17:44:53 CST 2015
	 */
	int insertSelective(CourtInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table court_announcement
	 * @mbggenerated  Mon Jan 05 17:44:53 CST 2015
	 */
	List<CourtInfo> selectByExampleWithBLOBs(CourtInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table court_announcement
	 * @mbggenerated  Mon Jan 05 17:44:53 CST 2015
	 */
	List<CourtInfo> selectByExample(CourtInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table court_announcement
	 * @mbggenerated  Mon Jan 05 17:44:53 CST 2015
	 */
	CourtInfo selectByPrimaryKey(Integer id);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table court_announcement
	 * @mbggenerated  Mon Jan 05 17:44:53 CST 2015
	 */
	int updateByExampleSelective(@Param("record") CourtInfo record,
			@Param("example") CourtInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table court_announcement
	 * @mbggenerated  Mon Jan 05 17:44:53 CST 2015
	 */
	int updateByExampleWithBLOBs(@Param("record") CourtInfo record,
			@Param("example") CourtInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table court_announcement
	 * @mbggenerated  Mon Jan 05 17:44:53 CST 2015
	 */
	int updateByExample(@Param("record") CourtInfo record,
			@Param("example") CourtInfoExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table court_announcement
	 * @mbggenerated  Mon Jan 05 17:44:53 CST 2015
	 */
	int updateByPrimaryKeySelective(CourtInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table court_announcement
	 * @mbggenerated  Mon Jan 05 17:44:53 CST 2015
	 */
	int updateByPrimaryKeyWithBLOBs(CourtInfo record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table court_announcement
	 * @mbggenerated  Mon Jan 05 17:44:53 CST 2015
	 */
	int updateByPrimaryKey(CourtInfo record);
}