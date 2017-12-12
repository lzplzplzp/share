package com.code.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JxActivityUrlBuildExample {
    /**
     * .
    jx_activity_url_build
     */
    protected String orderByClause;

    /**
     * .
    jx_activity_url_build
     */
    protected boolean distinct;

    /**
     * .
    jx_activity_url_build
     */
    protected List<Criteria> oredCriteria;

    public JxActivityUrlBuildExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * 本类代码由mybatis - gen生成.
     * 此类对应数据库中的表： jx_activity_url_build
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andFileOldNameIsNull() {
            addCriterion("file_old_name is null");
            return (Criteria) this;
        }

        public Criteria andFileOldNameIsNotNull() {
            addCriterion("file_old_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileOldNameEqualTo(String value) {
            addCriterion("file_old_name =", value, "fileOldName");
            return (Criteria) this;
        }

        public Criteria andFileOldNameNotEqualTo(String value) {
            addCriterion("file_old_name <>", value, "fileOldName");
            return (Criteria) this;
        }

        public Criteria andFileOldNameGreaterThan(String value) {
            addCriterion("file_old_name >", value, "fileOldName");
            return (Criteria) this;
        }

        public Criteria andFileOldNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_old_name >=", value, "fileOldName");
            return (Criteria) this;
        }

        public Criteria andFileOldNameLessThan(String value) {
            addCriterion("file_old_name <", value, "fileOldName");
            return (Criteria) this;
        }

        public Criteria andFileOldNameLessThanOrEqualTo(String value) {
            addCriterion("file_old_name <=", value, "fileOldName");
            return (Criteria) this;
        }

        public Criteria andFileOldNameLike(String value) {
            addCriterion("file_old_name like", value, "fileOldName");
            return (Criteria) this;
        }

        public Criteria andFileOldNameNotLike(String value) {
            addCriterion("file_old_name not like", value, "fileOldName");
            return (Criteria) this;
        }

        public Criteria andFileOldNameIn(List<String> values) {
            addCriterion("file_old_name in", values, "fileOldName");
            return (Criteria) this;
        }

        public Criteria andFileOldNameNotIn(List<String> values) {
            addCriterion("file_old_name not in", values, "fileOldName");
            return (Criteria) this;
        }

        public Criteria andFileOldNameBetween(String value1, String value2) {
            addCriterion("file_old_name between", value1, value2, "fileOldName");
            return (Criteria) this;
        }

        public Criteria andFileOldNameNotBetween(String value1, String value2) {
            addCriterion("file_old_name not between", value1, value2, "fileOldName");
            return (Criteria) this;
        }

        public Criteria andFileNewNameIsNull() {
            addCriterion("file_new_name is null");
            return (Criteria) this;
        }

        public Criteria andFileNewNameIsNotNull() {
            addCriterion("file_new_name is not null");
            return (Criteria) this;
        }

        public Criteria andFileNewNameEqualTo(String value) {
            addCriterion("file_new_name =", value, "fileNewName");
            return (Criteria) this;
        }

        public Criteria andFileNewNameNotEqualTo(String value) {
            addCriterion("file_new_name <>", value, "fileNewName");
            return (Criteria) this;
        }

        public Criteria andFileNewNameGreaterThan(String value) {
            addCriterion("file_new_name >", value, "fileNewName");
            return (Criteria) this;
        }

        public Criteria andFileNewNameGreaterThanOrEqualTo(String value) {
            addCriterion("file_new_name >=", value, "fileNewName");
            return (Criteria) this;
        }

        public Criteria andFileNewNameLessThan(String value) {
            addCriterion("file_new_name <", value, "fileNewName");
            return (Criteria) this;
        }

        public Criteria andFileNewNameLessThanOrEqualTo(String value) {
            addCriterion("file_new_name <=", value, "fileNewName");
            return (Criteria) this;
        }

        public Criteria andFileNewNameLike(String value) {
            addCriterion("file_new_name like", value, "fileNewName");
            return (Criteria) this;
        }

        public Criteria andFileNewNameNotLike(String value) {
            addCriterion("file_new_name not like", value, "fileNewName");
            return (Criteria) this;
        }

        public Criteria andFileNewNameIn(List<String> values) {
            addCriterion("file_new_name in", values, "fileNewName");
            return (Criteria) this;
        }

        public Criteria andFileNewNameNotIn(List<String> values) {
            addCriterion("file_new_name not in", values, "fileNewName");
            return (Criteria) this;
        }

        public Criteria andFileNewNameBetween(String value1, String value2) {
            addCriterion("file_new_name between", value1, value2, "fileNewName");
            return (Criteria) this;
        }

        public Criteria andFileNewNameNotBetween(String value1, String value2) {
            addCriterion("file_new_name not between", value1, value2, "fileNewName");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNull() {
            addCriterion("file_path is null");
            return (Criteria) this;
        }

        public Criteria andFilePathIsNotNull() {
            addCriterion("file_path is not null");
            return (Criteria) this;
        }

        public Criteria andFilePathEqualTo(String value) {
            addCriterion("file_path =", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotEqualTo(String value) {
            addCriterion("file_path <>", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThan(String value) {
            addCriterion("file_path >", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("file_path >=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThan(String value) {
            addCriterion("file_path <", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLessThanOrEqualTo(String value) {
            addCriterion("file_path <=", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathLike(String value) {
            addCriterion("file_path like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotLike(String value) {
            addCriterion("file_path not like", value, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathIn(List<String> values) {
            addCriterion("file_path in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotIn(List<String> values) {
            addCriterion("file_path not in", values, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathBetween(String value1, String value2) {
            addCriterion("file_path between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andFilePathNotBetween(String value1, String value2) {
            addCriterion("file_path not between", value1, value2, "filePath");
            return (Criteria) this;
        }

        public Criteria andBuileFileNameIsNull() {
            addCriterion("buile_file_name is null");
            return (Criteria) this;
        }

        public Criteria andBuileFileNameIsNotNull() {
            addCriterion("buile_file_name is not null");
            return (Criteria) this;
        }

        public Criteria andBuileFileNameEqualTo(String value) {
            addCriterion("buile_file_name =", value, "buileFileName");
            return (Criteria) this;
        }

        public Criteria andBuileFileNameNotEqualTo(String value) {
            addCriterion("buile_file_name <>", value, "buileFileName");
            return (Criteria) this;
        }

        public Criteria andBuileFileNameGreaterThan(String value) {
            addCriterion("buile_file_name >", value, "buileFileName");
            return (Criteria) this;
        }

        public Criteria andBuileFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("buile_file_name >=", value, "buileFileName");
            return (Criteria) this;
        }

        public Criteria andBuileFileNameLessThan(String value) {
            addCriterion("buile_file_name <", value, "buileFileName");
            return (Criteria) this;
        }

        public Criteria andBuileFileNameLessThanOrEqualTo(String value) {
            addCriterion("buile_file_name <=", value, "buileFileName");
            return (Criteria) this;
        }

        public Criteria andBuileFileNameLike(String value) {
            addCriterion("buile_file_name like", value, "buileFileName");
            return (Criteria) this;
        }

        public Criteria andBuileFileNameNotLike(String value) {
            addCriterion("buile_file_name not like", value, "buileFileName");
            return (Criteria) this;
        }

        public Criteria andBuileFileNameIn(List<String> values) {
            addCriterion("buile_file_name in", values, "buileFileName");
            return (Criteria) this;
        }

        public Criteria andBuileFileNameNotIn(List<String> values) {
            addCriterion("buile_file_name not in", values, "buileFileName");
            return (Criteria) this;
        }

        public Criteria andBuileFileNameBetween(String value1, String value2) {
            addCriterion("buile_file_name between", value1, value2, "buileFileName");
            return (Criteria) this;
        }

        public Criteria andBuileFileNameNotBetween(String value1, String value2) {
            addCriterion("buile_file_name not between", value1, value2, "buileFileName");
            return (Criteria) this;
        }

        public Criteria andBuileFilePathIsNull() {
            addCriterion("buile_file_path is null");
            return (Criteria) this;
        }

        public Criteria andBuileFilePathIsNotNull() {
            addCriterion("buile_file_path is not null");
            return (Criteria) this;
        }

        public Criteria andBuileFilePathEqualTo(String value) {
            addCriterion("buile_file_path =", value, "buileFilePath");
            return (Criteria) this;
        }

        public Criteria andBuileFilePathNotEqualTo(String value) {
            addCriterion("buile_file_path <>", value, "buileFilePath");
            return (Criteria) this;
        }

        public Criteria andBuileFilePathGreaterThan(String value) {
            addCriterion("buile_file_path >", value, "buileFilePath");
            return (Criteria) this;
        }

        public Criteria andBuileFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("buile_file_path >=", value, "buileFilePath");
            return (Criteria) this;
        }

        public Criteria andBuileFilePathLessThan(String value) {
            addCriterion("buile_file_path <", value, "buileFilePath");
            return (Criteria) this;
        }

        public Criteria andBuileFilePathLessThanOrEqualTo(String value) {
            addCriterion("buile_file_path <=", value, "buileFilePath");
            return (Criteria) this;
        }

        public Criteria andBuileFilePathLike(String value) {
            addCriterion("buile_file_path like", value, "buileFilePath");
            return (Criteria) this;
        }

        public Criteria andBuileFilePathNotLike(String value) {
            addCriterion("buile_file_path not like", value, "buileFilePath");
            return (Criteria) this;
        }

        public Criteria andBuileFilePathIn(List<String> values) {
            addCriterion("buile_file_path in", values, "buileFilePath");
            return (Criteria) this;
        }

        public Criteria andBuileFilePathNotIn(List<String> values) {
            addCriterion("buile_file_path not in", values, "buileFilePath");
            return (Criteria) this;
        }

        public Criteria andBuileFilePathBetween(String value1, String value2) {
            addCriterion("buile_file_path between", value1, value2, "buileFilePath");
            return (Criteria) this;
        }

        public Criteria andBuileFilePathNotBetween(String value1, String value2) {
            addCriterion("buile_file_path not between", value1, value2, "buileFilePath");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCuserIdIsNull() {
            addCriterion("cuser_id is null");
            return (Criteria) this;
        }

        public Criteria andCuserIdIsNotNull() {
            addCriterion("cuser_id is not null");
            return (Criteria) this;
        }

        public Criteria andCuserIdEqualTo(Integer value) {
            addCriterion("cuser_id =", value, "cuserId");
            return (Criteria) this;
        }

        public Criteria andCuserIdNotEqualTo(Integer value) {
            addCriterion("cuser_id <>", value, "cuserId");
            return (Criteria) this;
        }

        public Criteria andCuserIdGreaterThan(Integer value) {
            addCriterion("cuser_id >", value, "cuserId");
            return (Criteria) this;
        }

        public Criteria andCuserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("cuser_id >=", value, "cuserId");
            return (Criteria) this;
        }

        public Criteria andCuserIdLessThan(Integer value) {
            addCriterion("cuser_id <", value, "cuserId");
            return (Criteria) this;
        }

        public Criteria andCuserIdLessThanOrEqualTo(Integer value) {
            addCriterion("cuser_id <=", value, "cuserId");
            return (Criteria) this;
        }

        public Criteria andCuserIdIn(List<Integer> values) {
            addCriterion("cuser_id in", values, "cuserId");
            return (Criteria) this;
        }

        public Criteria andCuserIdNotIn(List<Integer> values) {
            addCriterion("cuser_id not in", values, "cuserId");
            return (Criteria) this;
        }

        public Criteria andCuserIdBetween(Integer value1, Integer value2) {
            addCriterion("cuser_id between", value1, value2, "cuserId");
            return (Criteria) this;
        }

        public Criteria andCuserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("cuser_id not between", value1, value2, "cuserId");
            return (Criteria) this;
        }

        public Criteria andCuserNameIsNull() {
            addCriterion("cuser_name is null");
            return (Criteria) this;
        }

        public Criteria andCuserNameIsNotNull() {
            addCriterion("cuser_name is not null");
            return (Criteria) this;
        }

        public Criteria andCuserNameEqualTo(String value) {
            addCriterion("cuser_name =", value, "cuserName");
            return (Criteria) this;
        }

        public Criteria andCuserNameNotEqualTo(String value) {
            addCriterion("cuser_name <>", value, "cuserName");
            return (Criteria) this;
        }

        public Criteria andCuserNameGreaterThan(String value) {
            addCriterion("cuser_name >", value, "cuserName");
            return (Criteria) this;
        }

        public Criteria andCuserNameGreaterThanOrEqualTo(String value) {
            addCriterion("cuser_name >=", value, "cuserName");
            return (Criteria) this;
        }

        public Criteria andCuserNameLessThan(String value) {
            addCriterion("cuser_name <", value, "cuserName");
            return (Criteria) this;
        }

        public Criteria andCuserNameLessThanOrEqualTo(String value) {
            addCriterion("cuser_name <=", value, "cuserName");
            return (Criteria) this;
        }

        public Criteria andCuserNameLike(String value) {
            addCriterion("cuser_name like", value, "cuserName");
            return (Criteria) this;
        }

        public Criteria andCuserNameNotLike(String value) {
            addCriterion("cuser_name not like", value, "cuserName");
            return (Criteria) this;
        }

        public Criteria andCuserNameIn(List<String> values) {
            addCriterion("cuser_name in", values, "cuserName");
            return (Criteria) this;
        }

        public Criteria andCuserNameNotIn(List<String> values) {
            addCriterion("cuser_name not in", values, "cuserName");
            return (Criteria) this;
        }

        public Criteria andCuserNameBetween(String value1, String value2) {
            addCriterion("cuser_name between", value1, value2, "cuserName");
            return (Criteria) this;
        }

        public Criteria andCuserNameNotBetween(String value1, String value2) {
            addCriterion("cuser_name not between", value1, value2, "cuserName");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Date value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Date value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Date value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Date> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNull() {
            addCriterion("is_del is null");
            return (Criteria) this;
        }

        public Criteria andIsDelIsNotNull() {
            addCriterion("is_del is not null");
            return (Criteria) this;
        }

        public Criteria andIsDelEqualTo(Integer value) {
            addCriterion("is_del =", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotEqualTo(Integer value) {
            addCriterion("is_del <>", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThan(Integer value) {
            addCriterion("is_del >", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_del >=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThan(Integer value) {
            addCriterion("is_del <", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelLessThanOrEqualTo(Integer value) {
            addCriterion("is_del <=", value, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelIn(List<Integer> values) {
            addCriterion("is_del in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotIn(List<Integer> values) {
            addCriterion("is_del not in", values, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelBetween(Integer value1, Integer value2) {
            addCriterion("is_del between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andIsDelNotBetween(Integer value1, Integer value2) {
            addCriterion("is_del not between", value1, value2, "isDel");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(Integer value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(Integer value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(Integer value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(Integer value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(Integer value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<Integer> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<Integer> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(Integer value1, Integer value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andBatchNumIsNull() {
            addCriterion("batch_num is null");
            return (Criteria) this;
        }

        public Criteria andBatchNumIsNotNull() {
            addCriterion("batch_num is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNumEqualTo(Byte value) {
            addCriterion("batch_num =", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumNotEqualTo(Byte value) {
            addCriterion("batch_num <>", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumGreaterThan(Byte value) {
            addCriterion("batch_num >", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumGreaterThanOrEqualTo(Byte value) {
            addCriterion("batch_num >=", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumLessThan(Byte value) {
            addCriterion("batch_num <", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumLessThanOrEqualTo(Byte value) {
            addCriterion("batch_num <=", value, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumIn(List<Byte> values) {
            addCriterion("batch_num in", values, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumNotIn(List<Byte> values) {
            addCriterion("batch_num not in", values, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumBetween(Byte value1, Byte value2) {
            addCriterion("batch_num between", value1, value2, "batchNum");
            return (Criteria) this;
        }

        public Criteria andBatchNumNotBetween(Byte value1, Byte value2) {
            addCriterion("batch_num not between", value1, value2, "batchNum");
            return (Criteria) this;
        }
    }

    /**
     * 本类代码由mybatis - gen生成.
     * 此类对应数据库中的表： jx_activity_url_build
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * 本类代码由mybatis - gen生成.
     * 此类对应数据库中的表： jx_activity_url_build
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