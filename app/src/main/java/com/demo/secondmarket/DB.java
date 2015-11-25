package com.demo.secondmarket;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Collection;

/**
 * Created by Administrator on 2015/11/20 0020.
 */
public class DB  {
    public static String selectPwd(String S_name){
        String result=null;
        Collection con;
        Statement st=null;
        String drivername="com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String dburl="jdbc:sqlserver://localhost:1489";
        try{
            Class.forName(drivername);
            con= (Collection) DriverManager.getConnection(dburl,"sa","123");

            String sql="select S_pwd from uers where S_name='"+S_name+"";

            ResultSet rs=st.executeQuery(sql);
            if(rs.next()){
                result=rs.getString(1);
            }
            rs.close();
            st.close();

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
