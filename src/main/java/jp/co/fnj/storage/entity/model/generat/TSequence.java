package jp.co.fnj.storage.entity.model.generat;

import java.util.Date;

public class TSequence {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sequence.ID_NAME
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    private String idName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sequence.SEQUENCE_VALUE
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    private Long sequenceValue;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sequence.CREATE_USER
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    private String createUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sequence.CREATE_DATE
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    private Date createDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sequence.UPDATE_USER
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    private String updateUser;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sequence.UPDATE_DATE
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    private Date updateDate;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sequence.ID_NAME
     *
     * @return the value of t_sequence.ID_NAME
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    public String getIdName() {
        return idName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sequence.ID_NAME
     *
     * @param idName the value for t_sequence.ID_NAME
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    public void setIdName(String idName) {
        this.idName = idName == null ? null : idName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sequence.SEQUENCE_VALUE
     *
     * @return the value of t_sequence.SEQUENCE_VALUE
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    public Long getSequenceValue() {
        return sequenceValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sequence.SEQUENCE_VALUE
     *
     * @param sequenceValue the value for t_sequence.SEQUENCE_VALUE
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    public void setSequenceValue(Long sequenceValue) {
        this.sequenceValue = sequenceValue;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sequence.CREATE_USER
     *
     * @return the value of t_sequence.CREATE_USER
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    public String getCreateUser() {
        return createUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sequence.CREATE_USER
     *
     * @param createUser the value for t_sequence.CREATE_USER
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    public void setCreateUser(String createUser) {
        this.createUser = createUser == null ? null : createUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sequence.CREATE_DATE
     *
     * @return the value of t_sequence.CREATE_DATE
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sequence.CREATE_DATE
     *
     * @param createDate the value for t_sequence.CREATE_DATE
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sequence.UPDATE_USER
     *
     * @return the value of t_sequence.UPDATE_USER
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    public String getUpdateUser() {
        return updateUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sequence.UPDATE_USER
     *
     * @param updateUser the value for t_sequence.UPDATE_USER
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser == null ? null : updateUser.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sequence.UPDATE_DATE
     *
     * @return the value of t_sequence.UPDATE_DATE
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sequence.UPDATE_DATE
     *
     * @param updateDate the value for t_sequence.UPDATE_DATE
     *
     * @mbggenerated Wed Nov 06 14:03:48 JST 2019
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}