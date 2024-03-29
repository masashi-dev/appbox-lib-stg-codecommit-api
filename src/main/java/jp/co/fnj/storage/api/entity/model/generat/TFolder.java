package jp.co.fnj.storage.api.entity.model.generat;

import java.time.LocalDateTime;

public class TFolder {

	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_FOLDER.FOLDER_ID
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	private String folderId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_FOLDER.PARENT_FOLDER_ID
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	private String parentFolderId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_FOLDER.FOLDER_GROUP
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	private Integer folderGroup;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_FOLDER.FOLDER_NAME
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	private String folderName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_FOLDER.S3_FOLDER_NAME
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	private String s3FolderName;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_FOLDER.DEVELOPER_ID
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	private String developerId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_FOLDER.MANSION_ID
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	private String mansionId;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_FOLDER.S3_OBJECT_KEY
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	private String s3ObjectKey;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_FOLDER.DELETE_FLG
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	private Boolean deleteFlg;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_FOLDER.PRIVATE_FLG
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	private Boolean privateFlg;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_FOLDER.EXPLANATORY_TEXT
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	private String explanatoryText;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_FOLDER.CREATE_USER
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	private String createUser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_FOLDER.CREATE_DATE
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	private LocalDateTime createDate;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_FOLDER.UPDATE_USER
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	private String updateUser;
	/**
	 * This field was generated by MyBatis Generator. This field corresponds to the database column T_FOLDER.UPDATE_DATE
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	private LocalDateTime updateDate;

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_FOLDER.FOLDER_ID
	 * @return  the value of T_FOLDER.FOLDER_ID
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public String getFolderId() {
		return folderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_FOLDER.FOLDER_ID
	 * @param folderId  the value for T_FOLDER.FOLDER_ID
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public void setFolderId(String folderId) {
		this.folderId = folderId == null ? null : folderId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_FOLDER.PARENT_FOLDER_ID
	 * @return  the value of T_FOLDER.PARENT_FOLDER_ID
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public String getParentFolderId() {
		return parentFolderId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_FOLDER.PARENT_FOLDER_ID
	 * @param parentFolderId  the value for T_FOLDER.PARENT_FOLDER_ID
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public void setParentFolderId(String parentFolderId) {
		this.parentFolderId = parentFolderId == null ? null : parentFolderId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_FOLDER.FOLDER_GROUP
	 * @return  the value of T_FOLDER.FOLDER_GROUP
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public Integer getFolderGroup() {
		return folderGroup;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_FOLDER.FOLDER_GROUP
	 * @param folderGroup  the value for T_FOLDER.FOLDER_GROUP
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public void setFolderGroup(Integer folderGroup) {
		this.folderGroup = folderGroup;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_FOLDER.FOLDER_NAME
	 * @return  the value of T_FOLDER.FOLDER_NAME
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public String getFolderName() {
		return folderName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_FOLDER.FOLDER_NAME
	 * @param folderName  the value for T_FOLDER.FOLDER_NAME
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public void setFolderName(String folderName) {
		this.folderName = folderName == null ? null : folderName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_FOLDER.S3_FOLDER_NAME
	 * @return  the value of T_FOLDER.S3_FOLDER_NAME
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public String getS3FolderName() {
		return s3FolderName;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_FOLDER.S3_FOLDER_NAME
	 * @param s3FolderName  the value for T_FOLDER.S3_FOLDER_NAME
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public void setS3FolderName(String s3FolderName) {
		this.s3FolderName = s3FolderName == null ? null : s3FolderName.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_FOLDER.DEVELOPER_ID
	 * @return  the value of T_FOLDER.DEVELOPER_ID
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public String getDeveloperId() {
		return developerId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_FOLDER.DEVELOPER_ID
	 * @param developerId  the value for T_FOLDER.DEVELOPER_ID
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public void setDeveloperId(String developerId) {
		this.developerId = developerId == null ? null : developerId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_FOLDER.MANSION_ID
	 * @return  the value of T_FOLDER.MANSION_ID
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public String getMansionId() {
		return mansionId;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_FOLDER.MANSION_ID
	 * @param mansionId  the value for T_FOLDER.MANSION_ID
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public void setMansionId(String mansionId) {
		this.mansionId = mansionId == null ? null : mansionId.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_FOLDER.S3_OBJECT_KEY
	 * @return  the value of T_FOLDER.S3_OBJECT_KEY
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public String getS3ObjectKey() {
		return s3ObjectKey;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_FOLDER.S3_OBJECT_KEY
	 * @param s3ObjectKey  the value for T_FOLDER.S3_OBJECT_KEY
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public void setS3ObjectKey(String s3ObjectKey) {
		this.s3ObjectKey = s3ObjectKey == null ? null : s3ObjectKey.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_FOLDER.DELETE_FLG
	 * @return  the value of T_FOLDER.DELETE_FLG
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public Boolean getDeleteFlg() {
		return deleteFlg;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_FOLDER.DELETE_FLG
	 * @param deleteFlg  the value for T_FOLDER.DELETE_FLG
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public void setDeleteFlg(Boolean deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_FOLDER.PRIVATE_FLG
	 * @return  the value of T_FOLDER.PRIVATE_FLG
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public Boolean getPrivateFlg() {
		return privateFlg;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_FOLDER.PRIVATE_FLG
	 * @param privateFlg  the value for T_FOLDER.PRIVATE_FLG
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public void setPrivateFlg(Boolean privateFlg) {
		this.privateFlg = privateFlg;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_FOLDER.EXPLANATORY_TEXT
	 * @return  the value of T_FOLDER.EXPLANATORY_TEXT
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public String getExplanatoryText() {
		return explanatoryText;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_FOLDER.EXPLANATORY_TEXT
	 * @param explanatoryText  the value for T_FOLDER.EXPLANATORY_TEXT
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public void setExplanatoryText(String explanatoryText) {
		this.explanatoryText = explanatoryText == null ? null : explanatoryText.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_FOLDER.CREATE_USER
	 * @return  the value of T_FOLDER.CREATE_USER
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public String getCreateUser() {
		return createUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_FOLDER.CREATE_USER
	 * @param createUser  the value for T_FOLDER.CREATE_USER
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public void setCreateUser(String createUser) {
		this.createUser = createUser == null ? null : createUser.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_FOLDER.CREATE_DATE
	 * @return  the value of T_FOLDER.CREATE_DATE
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public LocalDateTime getCreateDate() {
		return createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_FOLDER.CREATE_DATE
	 * @param createDate  the value for T_FOLDER.CREATE_DATE
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_FOLDER.UPDATE_USER
	 * @return  the value of T_FOLDER.UPDATE_USER
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public String getUpdateUser() {
		return updateUser;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_FOLDER.UPDATE_USER
	 * @param updateUser  the value for T_FOLDER.UPDATE_USER
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser == null ? null : updateUser.trim();
	}

	/**
	 * This method was generated by MyBatis Generator. This method returns the value of the database column T_FOLDER.UPDATE_DATE
	 * @return  the value of T_FOLDER.UPDATE_DATE
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	/**
	 * This method was generated by MyBatis Generator. This method sets the value of the database column T_FOLDER.UPDATE_DATE
	 * @param updateDate  the value for T_FOLDER.UPDATE_DATE
	 * @mbg.generated  Wed Nov 06 10:45:58 JST 2019
	 */
	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
}