package jp.co.fnj.storage.api.entity.mapper.generat;

import java.util.List;
import jp.co.fnj.storage.api.entity.model.generat.TFolder;
import jp.co.fnj.storage.api.entity.model.generat.TFolderExample;
import org.apache.ibatis.annotations.Param;

public interface TFolderMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_FOLDER
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	long countByExample(TFolderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_FOLDER
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	int deleteByExample(TFolderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_FOLDER
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	int deleteByPrimaryKey(String folderId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_FOLDER
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	int insert(TFolder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_FOLDER
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	int insertSelective(TFolder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_FOLDER
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	List<TFolder> selectByExample(TFolderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_FOLDER
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	TFolder selectByPrimaryKey(String folderId);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_FOLDER
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	int updateByExampleSelective(@Param("record") TFolder record, @Param("example") TFolderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_FOLDER
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	int updateByExample(@Param("record") TFolder record, @Param("example") TFolderExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_FOLDER
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	int updateByPrimaryKeySelective(TFolder record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table T_FOLDER
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	int updateByPrimaryKey(TFolder record);
}