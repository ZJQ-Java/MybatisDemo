package com.qiu.util;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDateHandler implements TypeHandler<Date>  {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    // 设置sql中指定索引的参数，即将javaType转化为jdbcType
    public void setParameter(PreparedStatement ps, int i, Date parameter, JdbcType jdbcType) throws SQLException {
        //设置数据存储到数据库中的格式
        ps.setString(i, sdf.format(parameter));
    }

    @Override
    // 根据列名称从结果集获取值，并将jdbcType转换成javaType
    public Date getResult(ResultSet rs, String columnName) throws SQLException {
        String columnValue = rs.getString(columnName);
        if (null != columnValue) {
            Date parse = null;
            try {
                 parse = sdf.parse(columnValue);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return parse;
        }
        return null;
    }

    @Override
    // 根据列名称从结果集获取值，并将jdbcType转换成javaType
    public Date getResult(ResultSet rs, int columnIndex) throws SQLException {
        String columnValue = rs.getString(columnIndex);
        if (null != columnValue) {
            Date parse = null;
            try {
                parse = sdf.parse(columnValue);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return parse;
        }
        return null;
    }

    @Override
    public Date getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String columnValue = cs.getString(columnIndex);
        if (null != columnValue) {
            Date parse = null;
            try {
                parse = sdf.parse(columnValue);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return parse;
        }
        return null;
    }

    public static void main(String[] args) throws ParseException {
        String str = "2020-11-12 14:46:22";
        ParsePosition pos = new ParsePosition(0);
        Date parse = sdf.parse(str,pos);
        System.out.println(DateFormat.getDateTimeInstance().format(parse));
    }
}
