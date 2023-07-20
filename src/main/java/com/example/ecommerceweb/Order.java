package com.example.ecommerceweb;

import java.sql.ResultSet;

public class Order {
    public static boolean placeOrder(Customer customer,product product){

        String getOrderId="select max(group_order_id)+1 id from orders";
        DBconnection conn=new DBconnection();
        try{
            ResultSet res= conn.getQueryTable(getOrderId);
            if(res.next()){
                String placeOrder="insert into orders(group_order_id,customer_id,product_id) values("+res.getInt("id")+1+","+customer.getId()+","+product.getId()+")";
                 return conn.getUpdateTable(placeOrder)!=0;
            }
        }catch (Exception e){
         e.printStackTrace();
        }
        return false;
    }
}
