package org.lanqiao.dao;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseDao<T> {
    private static ComboPooledDataSource dataSource;//连接池
    private Class<T> clazz;


    static {
        try {
            //加载配置文件，导入一个核心类。
            dataSource = new ComboPooledDataSource();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //反射获得clazz
    public BaseDao() {
        clazz = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }


    //提供获得连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    //关闭资源
    private void closeAll(Connection conn, Statement stmt, ResultSet rs) {
        try {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void closeAll(Connection conn, Statement stmt) {
        try {
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DML
    protected int executeUpdate(String sql, Object[] obj) {
        Connection conn = null;
        PreparedStatement stat = null;
        int ret = 0;
        try {
            conn = getConnection();
            // 3、创建传输对象statmemnt
            stat = conn.prepareStatement(sql);// ？不确定:类型、数量
            // 3+、绑定替换数据
            for (int i = 0; i < obj.length; i++) {
                stat.setObject(i + 1, obj[i]);
            }
            // 4、发送sql语句，并且接收返回结果 : DML -> executeUpdate ; DQL -> executeQuery
            ret = stat.executeUpdate();
            //打印sql语句
            printSql(sql, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, stat);
        }
        return ret;
    }

    // DQL
    protected List<T> executeQuery(String sql, Object[] obj) {
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<T>();
        try {
            conn = getConnection();
            // 3、创建传输对象statmemnt
            stat = conn.prepareStatement(sql);// ？不确定:类型、数量
            // 3+、绑定替换数据
            for (int i = 0; i < obj.length; i++) {
                stat.setObject(i + 1, obj[i]);
            }
            // 4、发送sql语句，并且接收返回结果 : DML -> executeUpdate ; DQL -> executeQuery
            rs = stat.executeQuery();
            // 5、如果返回rs类型的数据，需要将数据转换成list
            ResultSetMetaData rsmd = rs.getMetaData();//列名信息
            int columuCount = rsmd.getColumnCount();//列的数量
            while (rs.next()) {
                T t = (T) clazz.newInstance();//创建对象
                for (int i = 0; i < columuCount; i++) {//封装数据
                    try {
                        Field f = clazz.getDeclaredField(rsmd.getColumnName(i + 1));//列名->属性名->属性对象
                        f.setAccessible(true);
                        f.set(t, rs.getObject(i + 1));//将rs列中的值赋给属性
                    } catch (Exception e) {
                        System.out.println("对象中没有该属性：" + rsmd.getColumnName(i + 1));
                    }
                }
                list.add(t);
            }
            //打印sql语句
            printSql(sql, obj);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, stat, rs);
        }
        return list;
    }

    // DQL
    protected List<T> executeQuery(String sql) {
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<T> list = new ArrayList<T>();
        try {
            conn = getConnection();
            // 3、创建传输对象statmemnt
            stat = conn.prepareStatement(sql);// ？不确定:类型、数量
            // 3+、绑定替换数据
            // 4、发送sql语句，并且接收返回结果 : DML -> executeUpdate ; DQL -> executeQuery
            rs = stat.executeQuery();
            // 5、如果返回rs类型的数据，需要将数据转换成list
            ResultSetMetaData rsmd = rs.getMetaData();//列名信息
            int columuCount = rsmd.getColumnCount();//列的数量
            while (rs.next()) {
                T t = (T) clazz.newInstance();//创建对象
                for (int i = 0; i < columuCount; i++) {//封装数据
                    try {
                        Field f = clazz.getDeclaredField(rsmd.getColumnName(i + 1));//列名->属性名->属性对象
                        f.setAccessible(true);
                        f.set(t, rs.getObject(i + 1));//将rs列中的值赋给属性
                    } catch (Exception e) {
                        System.out.println("对象中没有该属性：" + rsmd.getColumnName(i + 1));
                    }
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, stat, rs);
        }
        return list;
    }

    // DQL
    protected int getRecordCount(String sql) {//select count(*) from msg;
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        int count = 0;
        try {
            conn = getConnection();
            // 3、创建传输对象statmemnt
            stat = conn.prepareStatement(sql);// ？不确定:类型、数量
            // 3+、绑定替换数据
            // 4、发送sql语句，并且接收返回结果 : DML -> executeUpdate ; DQL -> executeQuery
            rs = stat.executeQuery();
            // 5、如果返回rs类型的数据，需要将数据转换成list
            if (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeAll(conn, stat, rs);
        }
        return count;
    }

    // 输出预编译的sql语句的具体内容(便于调试)
    protected void printSql(String sql, Object[] params) {
        StringBuffer sb = new StringBuffer(sql);
        int fromIndex = 0;
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                int index = sb.indexOf("?", fromIndex);
                if (index == -1) {
                    sb.append(" ---> error: value too many   ");
                    break;
                }
                if (params[i] instanceof String) {
                    sb.replace(index, index + 1, "'" + this.valueOf(params[i]) + "'");
                } else if (params[i] instanceof Number) {
                    sb.replace(index, index + 1, this.valueOf(params[i]));
                } else if (params[i] instanceof Character) {
                    sb.replace(index, index + 1, "'" + this.valueOf(params[i]) + "'");
                } else if (params[i] instanceof Boolean) {
                    sb.replace(index, index + 1, "'" + this.valueOf(params[i]) + "'");
                } else if (params[i] instanceof Object[]) {
                    sb.replace(index, index + 1, "'" + this.valueOf(params[i]) + "'");
                } else if (params[i] instanceof Date) {
                    sb.replace(index, index + 1, " date '" + this.valueOf(params[i]) + "'");
                } else if (params[i] instanceof java.util.Date) {
                    sb.replace(index, index + 1, "'java.util.Date'");
                }
                fromIndex = index + 1;
            }
        }
        System.out.println(sb.toString());
    }

    private String valueOf(Object obj) {
        return (obj == null) ? "" : obj.toString();
    }
}
