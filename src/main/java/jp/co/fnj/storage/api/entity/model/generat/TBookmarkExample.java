package jp.co.fnj.storage.api.entity.model.generat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TBookmarkExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_BOOKMARK
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_BOOKMARK
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table T_BOOKMARK
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_BOOKMARK
     *
     * @mbg.generated
     */
    public TBookmarkExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_BOOKMARK
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_BOOKMARK
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_BOOKMARK
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_BOOKMARK
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_BOOKMARK
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_BOOKMARK
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_BOOKMARK
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_BOOKMARK
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_BOOKMARK
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_BOOKMARK
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_BOOKMARK
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBookmarkIdIsNull() {
            addCriterion("BOOKMARK_ID is null");
            return (Criteria) this;
        }

        public Criteria andBookmarkIdIsNotNull() {
            addCriterion("BOOKMARK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBookmarkIdEqualTo(Integer value) {
            addCriterion("BOOKMARK_ID =", value, "bookmarkId");
            return (Criteria) this;
        }

        public Criteria andBookmarkIdNotEqualTo(Integer value) {
            addCriterion("BOOKMARK_ID <>", value, "bookmarkId");
            return (Criteria) this;
        }

        public Criteria andBookmarkIdGreaterThan(Integer value) {
            addCriterion("BOOKMARK_ID >", value, "bookmarkId");
            return (Criteria) this;
        }

        public Criteria andBookmarkIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("BOOKMARK_ID >=", value, "bookmarkId");
            return (Criteria) this;
        }

        public Criteria andBookmarkIdLessThan(Integer value) {
            addCriterion("BOOKMARK_ID <", value, "bookmarkId");
            return (Criteria) this;
        }

        public Criteria andBookmarkIdLessThanOrEqualTo(Integer value) {
            addCriterion("BOOKMARK_ID <=", value, "bookmarkId");
            return (Criteria) this;
        }

        public Criteria andBookmarkIdIn(List<Integer> values) {
            addCriterion("BOOKMARK_ID in", values, "bookmarkId");
            return (Criteria) this;
        }

        public Criteria andBookmarkIdNotIn(List<Integer> values) {
            addCriterion("BOOKMARK_ID not in", values, "bookmarkId");
            return (Criteria) this;
        }

        public Criteria andBookmarkIdBetween(Integer value1, Integer value2) {
            addCriterion("BOOKMARK_ID between", value1, value2, "bookmarkId");
            return (Criteria) this;
        }

        public Criteria andBookmarkIdNotBetween(Integer value1, Integer value2) {
            addCriterion("BOOKMARK_ID not between", value1, value2, "bookmarkId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNull() {
            addCriterion("FILE_ID is null");
            return (Criteria) this;
        }

        public Criteria andFileIdIsNotNull() {
            addCriterion("FILE_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFileIdEqualTo(Integer value) {
            addCriterion("FILE_ID =", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotEqualTo(Integer value) {
            addCriterion("FILE_ID <>", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThan(Integer value) {
            addCriterion("FILE_ID >", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("FILE_ID >=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThan(Integer value) {
            addCriterion("FILE_ID <", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdLessThanOrEqualTo(Integer value) {
            addCriterion("FILE_ID <=", value, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdIn(List<Integer> values) {
            addCriterion("FILE_ID in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotIn(List<Integer> values) {
            addCriterion("FILE_ID not in", values, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdBetween(Integer value1, Integer value2) {
            addCriterion("FILE_ID between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFileIdNotBetween(Integer value1, Integer value2) {
            addCriterion("FILE_ID not between", value1, value2, "fileId");
            return (Criteria) this;
        }

        public Criteria andFolderIdIsNull() {
            addCriterion("FOLDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andFolderIdIsNotNull() {
            addCriterion("FOLDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andFolderIdEqualTo(Integer value) {
            addCriterion("FOLDER_ID =", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdNotEqualTo(Integer value) {
            addCriterion("FOLDER_ID <>", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdGreaterThan(Integer value) {
            addCriterion("FOLDER_ID >", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("FOLDER_ID >=", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdLessThan(Integer value) {
            addCriterion("FOLDER_ID <", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdLessThanOrEqualTo(Integer value) {
            addCriterion("FOLDER_ID <=", value, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdIn(List<Integer> values) {
            addCriterion("FOLDER_ID in", values, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdNotIn(List<Integer> values) {
            addCriterion("FOLDER_ID not in", values, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdBetween(Integer value1, Integer value2) {
            addCriterion("FOLDER_ID between", value1, value2, "folderId");
            return (Criteria) this;
        }

        public Criteria andFolderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("FOLDER_ID not between", value1, value2, "folderId");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("CREATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("CREATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(String value) {
            addCriterion("CREATE_USER =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(String value) {
            addCriterion("CREATE_USER <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(String value) {
            addCriterion("CREATE_USER >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("CREATE_USER >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(String value) {
            addCriterion("CREATE_USER <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(String value) {
            addCriterion("CREATE_USER <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLike(String value) {
            addCriterion("CREATE_USER like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotLike(String value) {
            addCriterion("CREATE_USER not like", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<String> values) {
            addCriterion("CREATE_USER in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<String> values) {
            addCriterion("CREATE_USER not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(String value1, String value2) {
            addCriterion("CREATE_USER between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(String value1, String value2) {
            addCriterion("CREATE_USER not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(LocalDateTime value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(LocalDateTime value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(LocalDateTime value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(LocalDateTime value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<LocalDateTime> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<LocalDateTime> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("UPDATE_USER is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("UPDATE_USER is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(String value) {
            addCriterion("UPDATE_USER =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(String value) {
            addCriterion("UPDATE_USER <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(String value) {
            addCriterion("UPDATE_USER >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(String value) {
            addCriterion("UPDATE_USER <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("UPDATE_USER <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLike(String value) {
            addCriterion("UPDATE_USER like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotLike(String value) {
            addCriterion("UPDATE_USER not like", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<String> values) {
            addCriterion("UPDATE_USER in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<String> values) {
            addCriterion("UPDATE_USER not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(String value1, String value2) {
            addCriterion("UPDATE_USER between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(String value1, String value2) {
            addCriterion("UPDATE_USER not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("UPDATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("UPDATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(LocalDateTime value) {
            addCriterion("UPDATE_DATE =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(LocalDateTime value) {
            addCriterion("UPDATE_DATE <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(LocalDateTime value) {
            addCriterion("UPDATE_DATE >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(LocalDateTime value) {
            addCriterion("UPDATE_DATE >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(LocalDateTime value) {
            addCriterion("UPDATE_DATE <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(LocalDateTime value) {
            addCriterion("UPDATE_DATE <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<LocalDateTime> values) {
            addCriterion("UPDATE_DATE in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<LocalDateTime> values) {
            addCriterion("UPDATE_DATE not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("UPDATE_DATE between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(LocalDateTime value1, LocalDateTime value2) {
            addCriterion("UPDATE_DATE not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUserIdLikeInsensitive(String value) {
            addCriterion("upper(USER_ID) like", value.toUpperCase(), "userId");
            return (Criteria) this;
        }

        public Criteria andCreateUserLikeInsensitive(String value) {
            addCriterion("upper(CREATE_USER) like", value.toUpperCase(), "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLikeInsensitive(String value) {
            addCriterion("upper(UPDATE_USER) like", value.toUpperCase(), "updateUser");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_BOOKMARK
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table T_BOOKMARK
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}