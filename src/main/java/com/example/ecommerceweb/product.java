package com.example.ecommerceweb;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;

public class product {
    private SimpleIntegerProperty id;
    private SimpleStringProperty name;
    private SimpleDoubleProperty price;

    public product(int id, String name, Double price) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
    }
public static ObservableList<product> AllProducts(){
        String sellectAll="SELECT id,name,price FROM product";
        return featchData(sellectAll);
}
public static ObservableList<product> featchData(String query){
        ObservableList<product> data= FXCollections.observableArrayList();
        DBconnection conn=new DBconnection();
        try {
            ResultSet res = conn.getQueryTable(query);
            while (res.next()){
                product pro=new product(res.getInt("id"), res.getString("name"),res.getDouble("price") );
                data.add(pro);

            }
            return data;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
}
    public int getId() {
        return id.get();
    }



    public String getName() {
        return name.get();
    }



    public double getPrice() {
        return price.get();
    }


}
