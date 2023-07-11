package com.example.ecommerceweb;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class UserInterface {
    GridPane loginPage;
    HBox headerBar;
    HBox footerBar;
    Button signIn;
    Label welcom;
    VBox body;
    productList productlist=new productList();
    VBox productpage=new VBox();
    Customer customerLoginCustomer;
   public BorderPane createContent(){
        BorderPane root=new BorderPane();
       // root.getChildren().add(loginPage);
      // root.setCenter(loginPage);
       productpage =productlist.getAllproduct();

       root.setTop(headerBar);
       root.setBottom(footerBar);
       body=new VBox();
       body.setPadding(new Insets(10));
       body.setAlignment(Pos.CENTER);
   root.setCenter(body);
       body.getChildren().addAll(productpage);
        root.setPrefSize(800,600);
        return root;
    }
    UserInterface(){

       createLoginPage();

       CreateHeaderBar();

       CreateFooterBar();
    }

    private void createLoginPage(){
        Text userName=new Text("user Name");
        Text Password=new Text("Password");
        TextField Username=new TextField();
        PasswordField password=new PasswordField();
        Username.setPromptText("Eneter youer userName ");
        password.setPromptText("Eneter youer Password");
        Button loginButton=new Button("login");
        Label messagelabel=new Label("hi");
        loginPage=new GridPane();
        loginPage.setHgap(10);
        loginPage.setVgap(10);
        loginPage.add(userName,0,0);
        loginPage.add(Password,0,1);
        loginPage.add(Username,1,0);
        loginPage.add(password,1,1);
        loginPage.add(loginButton,1,2);
        loginPage.add(messagelabel,1,3);

        loginPage.setAlignment(Pos.CENTER);
        loginButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
               String name=Username.getText();
               String pass=password.getText();

               Login login=new Login();
               customerLoginCustomer=login.customerLogin(name,pass);
               if(customerLoginCustomer!=null){
                  messagelabel.setText(customerLoginCustomer.getName());
                   welcom.setText("welcome  "+customerLoginCustomer.getName());
                   headerBar.getChildren().add(welcom);
                   body.getChildren().clear();
                   body.getChildren().addAll(productpage);
               }else{
                   messagelabel.setText("user name or password icorrect");
               }

            }
        });
    }

    private void CreateHeaderBar(){
 TextField searchBar=new TextField();
 searchBar.setPromptText("saerch here");
 searchBar.setPrefWidth(280);
 Button searchButton=new Button("search");
 headerBar=new HBox();
 signIn=new Button("signIn");
 headerBar.getChildren().addAll(searchBar,searchButton,signIn);
 headerBar.setSpacing(10);
 headerBar.setAlignment(Pos.CENTER);
 headerBar.setPadding(new Insets(10));
 welcom=new Label();
 signIn.setOnAction(new EventHandler<ActionEvent>() {
     @Override
     public void handle(ActionEvent actionEvent) {
         body.getChildren().clear();;
         body.getChildren().addAll(loginPage);
         headerBar.getChildren().remove(signIn);


     }
 });
    }
    private void CreateFooterBar(){

        Button buyNow=new Button("BuyNow");
        footerBar=new HBox();

        footerBar.getChildren().addAll(buyNow);
        footerBar.setSpacing(10);
       footerBar.setAlignment(Pos.CENTER);
        footerBar.setPadding(new Insets(10));

    }
}
