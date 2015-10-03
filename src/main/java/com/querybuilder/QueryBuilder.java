package com.querybuilder;

import com.util.Pair;

import java.util.List;

/**
 * Created by manjtsingh on 10/3/2015.
 */
public class QueryBuilder {

    private StringBuilder queryString;
    private String tableName;
    public QueryBuilder(String tableName) {
        this.queryString = new StringBuilder();
        this.tableName=tableName;
    }

    public QueryBuilder selectAll(){
        queryString.append("SELECT * FROM ").append(tableName).append(" ");
        return this;
    }

    public QueryBuilder insert()
    {
        queryString.append("INSERT INTO TABLE ").append(tableName);
        return this;
    }

    public QueryBuilder update()
    {
        queryString.append("UPDATE ").append(tableName).append(" SET ");
        return this;
    }

    public QueryBuilder where(List<Pair> keyValueList, boolean andOrFlag)
    {
        queryString.append("WHERE ");
        int size = keyValueList.size();
        for(Pair  keyValue : keyValueList)
        {
            if(keyValue.getValue() instanceof String)
            queryString.append(keyValue.getKey()).append("=").append("'").append(keyValue.getValue()).append("'");
            if(keyValue.getValue() instanceof Number)
            queryString.append(keyValue.getKey()).append("=").append(keyValue.getValue());
            size--;
            if(size!=0) {
                if(andOrFlag)
                queryString.append(" AND ");
                else
                    queryString.append(" OR ");
            }
        }
        return this;
    }

    public QueryBuilder  andClause(Pair keyValue)
    {
        queryString.append("AND ").append(keyValue.getKey()).append("=");
        if(keyValue.getValue() instanceof  String)
        {
            queryString.append("'").append(keyValue.getValue()).append("'");
        }
        if(keyValue.getValue() instanceof Number)
        {
            queryString.append(keyValue.getValue());
        }
        return this;
    }

    public String getQueryString()
    {
        return queryString.toString();
    }

    public QueryBuilder clearQuery()
    {
        queryString=null;
        queryString=new StringBuilder();
        return this;
    }


}
