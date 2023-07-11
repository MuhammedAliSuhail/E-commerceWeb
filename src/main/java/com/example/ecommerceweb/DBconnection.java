package com.example.ecommerceweb;
import java.sql.*;
public class DBconnection {
    private final String Url="jdbc:mysql://localhost:3306/ecommerce";
    private final String name="root";
    private final String password="Suhail@123";
    private Statement getStatement(){
        try{
            Connection connection=DriverManager.getConnection(Url,name,password);
            return connection.createStatement();
        }catch(Exception e){
           e.printStackTrace();
        }
        return null;
    }

    public ResultSet getQueryTable(String Query){
        try{
            Statement statement=getStatement();
            return statement.executeQuery(Query);
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        DBconnection connection=new DBconnection();
        ResultSet res= connection.getQueryTable("select * from customer");
        if(res!=null){
            System.out.println("connected sucssefully");
        }else{
            System.out.println("connection failed");
        }
    }
}
