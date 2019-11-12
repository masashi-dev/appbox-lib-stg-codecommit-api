package jp.co.fnj.storage.api.entity.model.generat;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TSequence implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sequence.ID_NAME
     *
     * @mbg.generated
     */
    private String idName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sequence.SEQUENCE_VALUE
     *
     * @mbg.generated
     */
    private Long sequenceValue;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sequence.CREATE_USER
     *
     * @mbg.generated
     */
    private String createUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sequence.CREATE_DATE
     *
     * @mbg.generated
     */
    private LocalDateTime createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sequence.UPDATE_USER
     *
     * @mbg.generated
     */
    private String updateUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_sequence.UPDATE_DATE
     *
     * @mbg.generated
     */
    private LocalDateTime updateDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_sequence
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sequence.ID_NAME
     *
     * @return the value of t_sequence.ID_NAME
     *
     * @mbg.generated
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
     * @mbg.generated
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
     * @mbg.generated
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
     * @mbg.generated
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
     * @mbg.generated
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
     * @mbg.generated
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
     * @mbg.generated
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sequence.CREATE_DATE
     *
     * @param createDate the value for t_sequence.CREATE_DATE
     *
     * @mbg.generated
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_sequence.UPDATE_USER
     *
     * @return the value of t_sequence.UPDATE_USER
     *
     * @mbg.generated
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
     * @mbg.generated
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
     * @mbg.generated
     */
    public LocalDateTime getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_sequence.UPDATE_DATE
     *
     * @param updateDate the value for t_sequence.UPDATE_DATE
     *
     * @mbg.generated
     */
    public void setUpdateDate(LocalDateTime updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sequence
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", idName=").append(idName);
        sb.append(", sequenceValue=").append(sequenceValue);
        sb.append(", createUser=").append(createUser);
        sb.append(", createDate=").append(createDate);
        sb.append(", updateUser=").append(updateUser);
        sb.append(", updateDate=").append(updateDate);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sequence
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        TSequence other = (TSequence) that;
        return (this.getIdName() == null ? other.getIdName() == null : this.getIdName().equals(other.getIdName()))
            && (this.getSequenceValue() == null ? other.getSequenceValue() == null : this.getSequenceValue().equals(other.getSequenceValue()))
            && (this.getCreateUser() == null ? other.getCreateUser() == null : this.getCreateUser().equals(other.getCreateUser()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getUpdateUser() == null ? other.getUpdateUser() == null : this.getUpdateUser().equals(other.getUpdateUser()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_sequence
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getIdName() == null) ? 0 : getIdName().hashCode());
        result = prime * result + ((getSequenceValue() == null) ? 0 : getSequenceValue().hashCode());
        result = prime * result + ((getCreateUser() == null) ? 0 : getCreateUser().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getUpdateUser() == null) ? 0 : getUpdateUser().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        return result;
    }
}