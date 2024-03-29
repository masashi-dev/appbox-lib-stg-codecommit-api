package jp.co.fnj.storage.api.entity.mapper.generat;

import java.util.List;
import jp.co.fnj.storage.api.entity.model.generat.TExternalServiceObject;
import jp.co.fnj.storage.api.entity.model.generat.TExternalServiceObjectExample;
import org.apache.ibatis.annotations.Param;

public interface TExternalServiceObjectMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_EXTERNAL_SERVICE_OBJECT
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	long countByExample(TExternalServiceObjectExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_EXTERNAL_SERVICE_OBJECT
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	int deleteByExample(TExternalServiceObjectExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_EXTERNAL_SERVICE_OBJECT
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	int deleteByPrimaryKey(String fileId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_EXTERNAL_SERVICE_OBJECT
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	int insert(TExternalServiceObject record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_EXTERNAL_SERVICE_OBJECT
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	int insertSelective(TExternalServiceObject record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_EXTERNAL_SERVICE_OBJECT
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	List<TExternalServiceObject> selectByExample(TExternalServiceObjectExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_EXTERNAL_SERVICE_OBJECT
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	TExternalServiceObject selectByPrimaryKey(String fileId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_EXTERNAL_SERVICE_OBJECT
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	int updateByExampleSelective(@Param("record") TExternalServiceObject record,
			@Param("example") TExternalServiceObjectExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_EXTERNAL_SERVICE_OBJECT
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	int updateByExample(@Param("record") TExternalServiceObject record,
			@Param("example") TExternalServiceObjectExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_EXTERNAL_SERVICE_OBJECT
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	int updateByPrimaryKeySelective(TExternalServiceObject record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_EXTERNAL_SERVICE_OBJECT
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	int updateByPrimaryKey(TExternalServiceObject record);
}