package com.example.ecommerceweb;

import java.sql.ResultSet;

public class Login {

    public Customer customerLogin(String userName,String password){

        String LoginQuery= "select * from  customer where email='"+userName+"' and password='"+password+"'";
        DBconnection conn=new DBconnection();
        ResultSet res=conn.getQueryTable(LoginQuery);
        try{
            if(res.next()){
            return new Customer(res.getInt("id"), res.getString("name"),
                    res.getString("email"),res.getString("mobile") );

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Login login=new Login();
        Customer costomer=login.customerLogin("suhail@gmail.com","suhail");
        System.out.println(costomer.getName());

    }
}
