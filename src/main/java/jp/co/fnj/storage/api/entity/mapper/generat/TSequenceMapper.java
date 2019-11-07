package jp.co.fnj.storage.api.entity.mapper.generat;

import java.util.List;
import jp.co.fnj.storage.api.entity.model.generat.TSequence;
import jp.co.fnj.storage.api.entity.model.generat.TSequenceExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

@Mapper
public interface TSequenceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEQUENCE
     *
     * @mbg.generated
     */
    long countByExample(TSequenceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEQUENCE
     *
     * @mbg.generated
     */
    int deleteByExample(TSequenceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEQUENCE
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String idName);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEQUENCE
     *
     * @mbg.generated
     */
    int insert(TSequence record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEQUENCE
     *
     * @mbg.generated
     */
    int insertSelective(TSequence record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEQUENCE
     *
     * @mbg.generated
     */
    List<TSequence> selectByExampleWithRowbounds(TSequenceExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEQUENCE
     *
     * @mbg.generated
     */
    List<TSequence> selectByExample(TSequenceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEQUENCE
     *
     * @mbg.generated
     */
    TSequence selectByPrimaryKey(String idName);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEQUENCE
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TSequence record, @Param("example") TSequenceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEQUENCE
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TSequence record, @Param("example") TSequenceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEQUENCE
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TSequence record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_SEQUENCE
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TSequence record);
}