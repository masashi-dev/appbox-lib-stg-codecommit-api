package jp.co.fnj.storage.entity.mapper.generat;

import java.util.List;
import jp.co.fnj.storage.entity.model.generat.TSortOrder;
import jp.co.fnj.storage.entity.model.generat.TSortOrderExample;
import org.apache.ibatis.annotations.Param;

public interface TSortOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sort_order
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    int countByExample(TSortOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sort_order
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    int deleteByExample(TSortOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sort_order
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    int deleteByPrimaryKey(Integer sortOrderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sort_order
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    int insert(TSortOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sort_order
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    int insertSelective(TSortOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sort_order
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    List<TSortOrder> selectByExample(TSortOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sort_order
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    TSortOrder selectByPrimaryKey(Integer sortOrderId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sort_order
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    int updateByExampleSelective(@Param("record") TSortOrder record, @Param("example") TSortOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sort_order
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    int updateByExample(@Param("record") TSortOrder record, @Param("example") TSortOrderExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sort_order
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    int updateByPrimaryKeySelective(TSortOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sort_order
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    int updateByPrimaryKey(TSortOrder record);
}