package com.example.ecommerceweb;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

public class productList {
    private TableView<product> productTable;
    public VBox craeteTable(ObservableList<product> data){
        TableColumn id=new TableColumn("ID");
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        TableColumn name=new TableColumn("NAME");
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        TableColumn price=new TableColumn("PRICE");
        price.setCellValueFactory(new PropertyValueFactory<>("price"));


        productTable=new TableView<>();
        productTable.setItems(data);
        productTable.getColumns().addAll(id,name,price);
        productTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        VBox vBox=new VBox();
        vBox.setPadding(new Insets(10));
        vBox.getChildren().addAll(productTable);
        return vBox;

    }
    public VBox getAllproduct(){
        ObservableList data=product.AllProducts();
        return craeteTable(data);
    }
}
