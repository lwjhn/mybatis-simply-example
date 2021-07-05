package com.rongji.egov.example.service.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.rongji.egov.example.service.SQLSelectorDeserializer;
import com.rongji.egov.mybatis.base.model.SQLCriteria;
import com.rongji.egov.mybatis.base.model.SQLField;
import com.rongji.egov.mybatis.base.model.SQLJoin;

import java.util.List;

/**
 * @Author: lwjhn
 * @Date: 2021/6/13
 * <p>
 * <p>
 * SELECT [predicate] { * | table.* | [table.]field1 [AS alias1] [, [table.]field2 [AS alias2] [, ...]]}
 * FROM tableexpression [, ...][IN外部数据库]
 * [WHERE...]
 * ]
 * [GROUP BY...]
 * ]
 * [HAVING...]
 * ]
 * [ORDER BY...]
 * ]
 * [WITH OWNERACCESS OPTION]
 * [UNION [ALL] [TABLE] query]
 */
public class SQLSelector1 {
    private String predicate;   //[ALL | DISTINCT | DISTINCTROW | [TOP n [PERCENT]]
    private List<SQLField> fields;  //SUM(column_name) AS alias_name , 允许使用表达式
    @JSONField(deserializeUsing= SQLSelectorDeserializer.class)
    private Object table;   //FROM表格表达式 [IN外部数据库]  subscript table expression , SQLSelector . example expression: table1 as t1, table2 as t2
    private List<SQLJoin> join;   //FROM表1 [ LEFT | RIGHT ] JOIN表2 ON 表1.字段1 compopr 表2. 字段2
    private SQLCriteria where;  //WHERE选择准则
    private Object group; //[GROUP BY 分组字段表]  List<String> or Set<String> or SQLCriteria
    private SQLCriteria having;  // [HAVING分组准则] HAVING 与 WHERE 类似，可使用 GROUP BY对这些记录分组后，HAVING 会决定应显示的记录
    private List<String> order; //[ORDER BY字段1 [ASC | DESC ][, 字段2 [ASC | DESC ]][, ...]]]
    private List<Integer> limit;    //[LIMIT n, n + k]
    private List<SQLSelector1> union;    //[TABLE] query1 UNION [TABLE] query2 [UNION [TABLE] queryn [ ... ]]
    private List<SQLSelector1> unionAll; //[TABLE] query1 UNION ALL [TABLE] query2 [UNION ALL [TABLE] queryn [ ... ]]
    private Class<?> model;     //for example , com.rongji.egov.dutyManage.model.SubmitReport
    private List<Object> args;
    private String tableAlias; //using for outter selector , for example: select tableAlias.col1 from (select col1 from table) as tableAlias, (select col1 from table1) as tableAlias2

    public SQLCriteria getHaving() {
        return having;
    }

    public void setHaving(SQLCriteria having) {
        this.having = having;
    }

    public List<SQLJoin> getJoin() {
        return join;
    }

    public void setJoin(List<SQLJoin> join) {
        this.join = join;
    }

    public List<SQLSelector1> getUnion() {
        return union;
    }

    public void setUnion(List<SQLSelector1> union) {
        this.union = union;
    }

    public List<SQLSelector1> getUnionAll() {
        return unionAll;
    }

    public void setUnionAll(List<SQLSelector1> unionAll) {
        this.unionAll = unionAll;
    }

    public String getPredicate() {
        return predicate;
    }

    public void setPredicate(String predicate) {
        this.predicate = predicate;
    }

    public Object getTable() {
        return table;
    }

    public void setTable(Object table) {
        this.table = table;
    }

    public List<Object> getArgs() {
        return args;
    }

    public List<Object> setArgs(List<Object> args) {
        return this.args = args;
    }

    public List<SQLField> getFields() {
        return fields;
    }

    public void setFields(List<SQLField> fields) {
        this.fields = fields;
    }

    public SQLCriteria getWhere() {
        return where;
    }

    public void setWhere(SQLCriteria where) {
        this.where = where;
    }

    public List<String> getOrder() {
        return order;
    }

    public void setOrder(List<String> order) {
        this.order = order;
    }

    public Object getGroup() {
        return group;
    }

    public void setGroup(Object group) {
        this.group = group;
    }

    public List<Integer> getLimit() {
        return limit;
    }

    public void setLimit(List<Integer> limit) {
        this.limit = limit;
    }

    public Class<?> getModel() {
        return model;
    }

    public void setModel(Class<?> model) {
        this.model = model;
    }

    public String getTableAlias() {
        return tableAlias;
    }

    public void setTableAlias(String tableAlias) {
        this.tableAlias = tableAlias;
    }
}
