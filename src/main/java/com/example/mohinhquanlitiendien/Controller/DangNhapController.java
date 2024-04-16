package com.example.mohinhquanlitiendien.Controller;
//import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.example.mohinhquanlitiendien.HelloApplication;
import com.example.mohinhquanlitiendien.Util.ConnectionUtil;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

//import javax.swing.*;

import static java.util.logging.Level.SEVERE;


public class DangNhapController  implements Initializable {

    @FXML
    private Button btdangky;

    @FXML
    private Button btquaylai;
    @FXML
    private Label lbthongbao;

    @FXML
    private Button dangnhap;

    @FXML
    private PasswordField matkhau;

    @FXML
    private TextField tendangnhap;
    @FXML
    private Label lbError;
    @FXML
    private Button dangky;

    @FXML
    private PasswordField matkhaudk;

    @FXML
    private TextField tendangky;

    private Connection connect;
    private PreparedStatement prepar;
    private ResultSet result;

    private Statement statement;

    @FXML
    private Button btdnthoat;
    @FXML
    private PasswordField nhaplaimk;

    
     public  Connection connectDB(){
         try {
             String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName=qltd;encrypt=true;trustServerCertificate=true";
             Connection connect = DriverManager.getConnection(connectionUrl, "sa","Hothanhluc25@");
             return connect;
         } catch ( SQLException e) {
             e.printStackTrace();
             return null;
         }
     }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
             connect=connectDB();


    }


    public void handleButtonAction(ActionEvent event) {

        if(event.getSource()==dangnhap){

            if(dangnhap().equals("Thành công")){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText(null);
                alert.setContentText("Đăng nhập thành công");
                alert.showAndWait();

                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();


                try {
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/example/mohinhquanlitiendien/View/Giaodienchinh.fxml")));
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }else if(event.getSource()==btdangky) {
            Node node = (Node) event.getSource();
            Stage stage = (Stage) node.getScene().getWindow();
            stage.close();

            try {
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/example/mohinhquanlitiendien/View/DangKyView.fxml")));
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                System.err.println(e.getMessage());
            }


        }else if (event.getSource() == dangky) {
            dangky();

        }else if(event.getSource()==btquaylai){
            Node node1=(Node) event.getSource();
            Stage stage1 = (Stage)node1.getScene().getWindow();
            stage1.close();
            try {
                Scene scene1=new Scene(FXMLLoader.load(getClass().getResource("/com/example/mohinhquanlitiendien/View/DangNhapView.fxml")));
                stage1.setScene(scene1);
                stage1.show();
            }catch (IOException e){
                System.err.println(e.getMessage());
            }

        }
    }

    public void close(javafx.event.ActionEvent event) {
        if(event.getSource()==btdnthoat){
            System.exit(0);
        }
    }

    private String dangnhap(){
            try {


                String sql="SELECT * FROM dangnhap where users =? and pass=? ";
              prepar=connect.prepareStatement(sql);
              prepar.setString(1,tendangnhap.getText());
              prepar.setString(2,matkhau.getText());
              result=prepar.executeQuery();

                if(result.next()){
                    lbError.setTextFill(Color.GREEN);
                    lbError.setText("Đăng nhập thành công");
                    return "Thành công";
                }else{

                    lbError.setTextFill(Color.TOMATO);
                    lbError.setText("Tên đăng nhập hoặc mật khẩu sai");
                    return "Lỗi";
                }

        } catch (SQLException e) {
            Logger.getLogger(DangNhapController.class.getName()).log(SEVERE,null,e);
            return "Ngoại lệ";
        }

    }
    private void dangky() {


        if (tendangky.getText().isEmpty() || matkhaudk.getText().isEmpty()) {
            lbthongbao.setText("Tên đăng ký hoặc mật khẩu trống");
            lbthongbao.setTextFill(Color.TOMATO);
        } else if(!nhaplaimk.getText().equals(matkhaudk.getText())){
            lbthongbao.setTextFill(Color.TOMATO);
            lbthongbao.setText("Mật khẩu không khớp");
            nhaplaimk.setText("");
            matkhaudk.setText("");

        }else {
            String kiemtratendn="SELECT users FROM dangnhap WHERE users='"+tendangky.getText()+"'";
            try {
                statement=connect.createStatement();
                result=statement.executeQuery(kiemtratendn);

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(result.next()) {
                    lbthongbao.setTextFill(Color.TOMATO);
                    lbthongbao.setText("Tên đăng nhập đã tồn tại");


                }else{
                       String insert = "INSERT INTO dangnhap"
                               + "(users,pass)" + "VALUES(?,?)";
                       try {
                           prepar=connect.prepareStatement(insert);
                           prepar.setString(1,tendangky.getText());
                           prepar.setString(2,matkhaudk.getText());
                           prepar.executeUpdate();

                           tendangky.setText("");
                           matkhaudk.setText("");
                           nhaplaimk.setText("");

                           lbthongbao.setText("Đăng ký thành công");
                           lbthongbao.setTextFill(Color.GREEN);

                       } catch (SQLException e) {
                           e.printStackTrace();
                       }
                   }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }

    }
}
