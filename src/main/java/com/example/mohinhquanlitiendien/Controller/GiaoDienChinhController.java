package com.example.mohinhquanlitiendien.Controller;

import com.example.mohinhquanlitiendien.HelloApplication;
import com.example.mohinhquanlitiendien.Model.*;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import javax.swing.*;
import javax.swing.text.html.ImageView;
import java.io.IOException;
import java.net.URL;
import java.sql.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.Date;


import static java.lang.CharSequence.compare;
import static java.lang.String.valueOf;

public class GiaoDienChinhController extends Application implements Initializable {

    @FXML
    private AnchorPane PaneThongKe;

    @FXML
    private Button btHoadon;

    @FXML
    private Button btSodien;

    @FXML
    private Button btThongke;

    @FXML
    private Button btSua1;

    @FXML
    private Button btThem1;

    @FXML
    private Button btThoat;

    @FXML
    private Button btThongtin;

    @FXML
    private Button btXoa1;

    @FXML
    private TextField lbTimkiem1;
    @FXML
    private Button btTimkiemdsThongtin;

    @FXML
    private AnchorPane paneQLHD;

    @FXML
    private AnchorPane paneThongtin1;

    @FXML
    private TableView<NguoiDung> tableView1;

    @FXML
    private TableColumn<NguoiDung, String > tbCMNN1;

    @FXML
    private TableColumn<NguoiDung, String > tbNgatdk1;

    @FXML
    private TableColumn<NguoiDung, String > tbSDT1;

    @FXML
    private TableColumn<NguoiDung, String > tbdiachi1;

    @FXML
    private TableColumn<NguoiDung, String > tbgioitinh1;

    @FXML
    private TableColumn<NguoiDung, String > tbmaKH1;

    @FXML
    private TableColumn<NguoiDung, String > tbngaysinh1;

    @FXML
    private TableColumn<NguoiDung, String > tbtenKH1;

    @FXML
    private TableView<Quanlihoadon> tableViewQLHD;
    @FXML
    private TableColumn<NguoiDung, String > tnmakhQLHD;
    @FXML
    private TableColumn<NguoiDung, String > tbtenkhQLHD;
    @FXML
    private TableColumn<NguoiDung, String > tbldttQLHD;
    @FXML
    private TableColumn<NguoiDung, String > tbtienQLHD;

    @FXML
    private TextField txtCMNN1;

    @FXML
    private DatePicker txtNgaydk1;

    @FXML
    private TextField txtSDT1;

    @FXML
    private TextField txtdiachi1;

    @FXML
    private ComboBox<String > txtgioitinh1;

    @FXML
    private TextField txtmaKH1;

    @FXML
    private DatePicker txtngaysinh1;

    @FXML
    private TextField txttenKH1;
    @FXML
    private AnchorPane paneSodien;


    @FXML
    private Button btTat;
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    @FXML
    private Button btSuaSodien;
    @FXML
    private Button btThemsodien;
    @FXML
    private TableColumn<SoDien, Integer> tbChisocu;

    @FXML
    private TableColumn<SoDien, Integer> tbChisomoi;

    @FXML
    private TableColumn<SoDien, String> tbMakhsodien;
    @FXML
    private TableView<SoDien> tbViewSodien;
    @FXML
    private TableColumn<SoDien, String> tbmathangSodien;
    @FXML
    private TextField txtChisocu;

    @FXML
    private TextField txtChisomoi;
    @FXML
    private ComboBox<String> txtmaKhSodien;
    @FXML
    private TableColumn<SoDien, String> tbmathangQLHD;

    @FXML
    private TextField txtmaThangSodien;

    @FXML
    private TextField txtmakhQLHD;

    @FXML
    private TextField txtmathangQLHD;

    @FXML
    private TextField txtldttQLHD;

    @FXML
    private TextField txttienQLHD;

    @FXML
    private TextField txthotenQLHD ;
    @FXML
    private BarChart<String, Integer> thongKeDoanhThu;

    @FXML
    private LineChart<String, Number> thongKeNguoiDung;

    @FXML
    private BarChart<String, Integer> thongKeldtt;
    @FXML
    private Label lbLuongNguoiQLhd;
    @FXML
    private Label lbTongtienQLHD;
    @FXML
    private Label lbtongdienQLHD;
    @FXML
    private Button btLaphoadon;
    @FXML
    private Label lbDiachiHoadon;

    @FXML
    private Label lbLdttHoadon;

    @FXML
    private Label lbTienHoadon;

    @FXML
    private Label lbchiSocuoiHoadon;

    @FXML
    private Label lbchiSodauHoadon;
    @FXML
    private Label lbSoccdHoadon;

    @FXML
    private Label lbmakhHoadon;

    @FXML
    private Label lbmathangHoadon;

    @FXML
    private Label lbtenKhHoadon;
    @FXML
    private Label lbsdtHoadon;
    @FXML
    private AnchorPane paneHoadon;
    @FXML
    private Button btInhoadon;
    @FXML
    private Button btXongHoaDon;
    @FXML
    private Button btDanhsachthanhtoan;
    @FXML
    private AnchorPane paneThanhToan;
    @FXML
    private TableColumn<ChuaTT, String> TTdiachi1;

    @FXML
    private TableColumn<DaTT, String> TTdiachi2;

    @FXML
    private TableColumn<ChuaTT, String> TTgioitinh1;

    @FXML
    private TableColumn<DaTT, String> TTgioitinh2;

    @FXML
    private TableColumn<ChuaTT, String> TTmakh1;

    @FXML
    private TableColumn<DaTT, String> TTmakh2;

    @FXML
    private TableColumn<ChuaTT, String> TTngaydk1;

    @FXML
    private TableColumn<DaTT, String> TTngaydk2;

    @FXML
    private TableColumn<ChuaTT, String> TTngaysinh1;

    @FXML
    private TableColumn<DaTT, String> TTngaysinh2;

    @FXML
    private TableColumn<ChuaTT, String> TTsdt1;

    @FXML
    private TableColumn<DaTT, String> TTsdt2;

    @FXML
    private TableColumn<ChuaTT, String> TTsoCMNN1;

    @FXML
    private TableColumn<DaTT, String> TTsoCMNN2;

    @FXML
    private TableColumn<ChuaTT, String> TTtenKH1;

    @FXML
    private TableColumn<DaTT, String> TTtenKH2;

    @FXML
    private TableView<ChuaTT> tbViewchuaTT;

    @FXML
    private TableView<DaTT> tbViewdaTT;



    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("/com/example/mohinhquanlitiendien/View/Giaodienchinh.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MÔ HÌNH QUẢN LÍ TIỀN ĐIỆN");
        stage.setScene(scene);
        stage.show();
    }

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

    //Panel Quan lí thông tin
    public ObservableList<NguoiDung> addUser() {
        ObservableList<NguoiDung> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM userdata";

        try {
            connect=connectDB();
//            Kết nối với CSDL
            prepare = connect.prepareStatement(sql);
//            Chuẩn bị câu lệnh
            result = prepare.executeQuery();
//              Thực hiện câu lệnh
            while (result.next()) {
            NguoiDung nguoiDungDT = new NguoiDung(result.getString("makh")
                        , result.getString("hoten")
                        , result.getString("soCccd")
                        , result.getString("diachi")
                        , result.getString("gioitinh")
                        , result.getDate("ngaysinh")
                        , result.getString("sdt")
                        , result.getDate("ngayDk"));
                list.add(nguoiDungDT);
            }



        } catch (Exception e) {
            e.printStackTrace();

        }

        return list;
    }
    private String[] gioitinhList={"Nam","Nữ","Khác"};
    //    Phương thưc để thêm danh sách giới tính vào ComboBox
    public void themDSgioitinh(){
//      Khai báo danh sách mới để chứa danh sách từ gioitinhList
        List<String> gioiTinhL=new ArrayList<>();
//      Lặp qua từng phần tử để thêm từng phần tử vào danh sách
        for (String data:gioitinhList){
            gioiTinhL.add(data);
        }

        ObservableList<String> ObList=FXCollections.observableArrayList(gioiTinhL);
        txtgioitinh1.setItems(ObList);
    }

    private ObservableList<NguoiDung> addUserListDT;

    // Phương thức để hiển thị dữ liệu từ danh sách NguoiDung lên TableView
    public void addUserShowListData(){
//        gọi phương thức addUser để lấy danh sách NguoiDung
      addUserListDT=addUser();
//     Thiết lập dữ liệu trong ObservableList sẽ được ánh xạ vào các cột của Table View
      tbmaKH1.setCellValueFactory(new PropertyValueFactory<>("makh"));
      tbtenKH1.setCellValueFactory(new PropertyValueFactory<>("hoten"));
      tbCMNN1.setCellValueFactory(new PropertyValueFactory<>("soCccd"));
      tbdiachi1.setCellValueFactory(new PropertyValueFactory<>("diachi"));
      tbgioitinh1.setCellValueFactory(new PropertyValueFactory<>("gioitinh"));
      tbngaysinh1.setCellValueFactory(new PropertyValueFactory<>("ngaysinh"));
      tbSDT1.setCellValueFactory(new PropertyValueFactory<>("sdt"));
      tbNgatdk1.setCellValueFactory(new PropertyValueFactory<>("ngayDk"));

      tableView1.setItems(addUserListDT);

  }


  public void chontuds(){
//        Lấy đối tượng Nguoidung được trong TableView
      NguoiDung nguoiDung=tableView1.getSelectionModel().getSelectedItem();
      int num=tableView1.getSelectionModel().getSelectedIndex();

      if((num)<0){
          return;
      }

//      Hiển thị thng tin lên các trường dữ liệu
      txtmaKH1.setText(valueOf(nguoiDung.getMakh()));
      txttenKH1.setText(valueOf(nguoiDung.getHoten()));
      txtCMNN1.setText(valueOf(nguoiDung.getSoCccd()));
      txtdiachi1.setText(valueOf(nguoiDung.getDiachi()));
      txtngaysinh1.setValue(LocalDate.parse(String.valueOf(nguoiDung.getNgaysinh())));
      txtgioitinh1.setValue(nguoiDung.getGioitinh());
      txtSDT1.setText(valueOf(nguoiDung.getSdt()));
      txtNgaydk1.setValue(LocalDate.parse(String.valueOf(nguoiDung.getNgayDk())));

  }


  public void themdsThongtin(ActionEvent event){
      if(event.getSource()==btThem1){
          String them="INSERT INTO userdata(makh,hoten,soCccd,diachi,gioitinh,ngaysinh,sdt,ngayDk) VALUES(?,?,?,?,?,?,?,?)";
          connect=connectDB();

              try {
                  Alert alert;
                  if (txtmaKH1.getText().isEmpty() || txttenKH1.getText().isEmpty() || txtCMNN1.getText().isEmpty() || txtdiachi1.getText().isEmpty() || txtgioitinh1.getItems().isEmpty()||txtngaysinh1.getValue()==null||txtSDT1.getText().isEmpty()||txtNgaydk1.getValue()==null) {
                      alert = new Alert(Alert.AlertType.ERROR);
                      alert.setTitle("Lỗi");
                      alert.setHeaderText(null);
                      alert.setContentText("Lỗi!Dữ liệu bị trống . Vui lòng nhập lại ");
                      alert.showAndWait();
                  }else {
                      String kiemtrads = "SELECT makh FROM userdata WHERE makh = '"+txtmaKH1.getText()+"'";
                      statement=connect.createStatement();
                      result=statement.executeQuery(kiemtrads);

                      if (result.next()) {
                          alert = new Alert(Alert.AlertType.ERROR);
                          alert.setTitle("Lỗi");
                          alert.setHeaderText(null);
                          alert.setContentText("Mã khách hàng:" + txtmaKH1.getText() + " đã tồn tại");
                          alert.showAndWait();
                      }else{
                          prepare = connect.prepareStatement(them);

//                      Đặt giá trị cho các tham số trong câu lệnh SQL đã chuẩn bị

                          prepare.setString(1, txtmaKH1.getText());
                          prepare.setString(2, txttenKH1.getText());
                          prepare.setString(3, txtCMNN1.getText());
                          prepare.setString(4, txtdiachi1.getText());
                          prepare.setString(5, txtgioitinh1.getValue());
                          prepare.setString(6, String.valueOf(txtngaysinh1.getValue()));
                          prepare.setString(7, txtSDT1.getText());
                          prepare.setString(8, String.valueOf(txtNgaydk1.getValue()));
                          prepare.executeUpdate();
                          alert = new Alert(Alert.AlertType.INFORMATION);
                          alert.setTitle("Thông báo");
                          alert.setHeaderText(null);
                          alert.setContentText("Bạn đã thêm thành công mã khách hàng " + txtmaKH1.getText());
                          alert.showAndWait();


                          addUserShowListData();
                          SoLuongkhachang();
                          ThongKeNguoidung();
                          String qlhd="INSERT INTO qlhd(makh,hoten,mathang,ldtt,tien) VALUES(?,?,?,?,?)";
                          prepare=connect.prepareStatement(qlhd);
                          prepare.setString(1,txtmaKH1.getText());
                          prepare.setString(2,txttenKH1.getText());
                          prepare.setString(3, String.valueOf(0));
                          prepare.setString(4, String.valueOf(0));
                          prepare.setString(5,String.valueOf(0));
                          prepare.executeUpdate();

                          String themChuaTT="INSERT INTO ChuaTT(makh,hoten,soCccd,diachi,gioitinh,ngaysinh,sdt,ngayDk) VALUES(?,?,?,?,?,?,?,?)";
                          prepare=connect.prepareStatement(themChuaTT);
                          prepare.setString(1, txtmaKH1.getText());
                          prepare.setString(2, txttenKH1.getText());
                          prepare.setString(3, txtCMNN1.getText());
                          prepare.setString(4, txtdiachi1.getText());
                          prepare.setString(5, txtgioitinh1.getValue());
                          prepare.setString(6, String.valueOf(txtngaysinh1.getValue()));
                          prepare.setString(7, txtSDT1.getText());
                          prepare.setString(8, String.valueOf(txtNgaydk1.getValue()));
                          prepare.executeUpdate();

                          listMakh();
                        addShowListPayDT();
                          hienthidsHoadon();
                          lammoithongtin() ;

                      }
                  }



              }catch (Exception e){
                  e.printStackTrace();
          }
      }
  }
    private String dateToString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
    public void UserSearch() {

        String searchKeyword= lbTimkiem1.getText();
        ObservableList<NguoiDung> searchResults = searchUser(searchKeyword);
        tableView1.setItems(searchResults);
    }

    public ObservableList<NguoiDung> searchUser(String searchKeyword){

        ObservableList<NguoiDung> searchResults=FXCollections.observableArrayList();
        String sql="SELECT * FROM userdata WHERE makh LIKE ? OR hoten LIKE ?";

        try{
            connect=connectDB();
            prepare=connect.prepareStatement(sql);
            prepare.setString(1,"%"+searchKeyword+"%");
            prepare.setString(2,"%"+searchKeyword+"%");

            result=prepare.executeQuery();
            System.out.println("Search Results:");
            while (result.next()){
//                Lặp qua các kết quả trả về từ truy vấn
                System.out.println(result.getString("makh"));

                NguoiDung nguoiDungDT=new NguoiDung(
                        result.getString("makh"),
                        result.getString("hoten"),
                        result.getString("soCccd"),
                        result.getString("diachi"),
                        result.getString("gioitinh"),
                        result.getDate("ngaysinh"),
                        result.getString("sdt"),
                        result.getDate("ngayDk")
                );
                searchResults.add(nguoiDungDT);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return searchResults;
    }


    public void lammoithongtin(){
      txtmaKH1.setText("");
      txttenKH1.setText("");
      txtCMNN1.setText("");
      txtdiachi1.setText("");
      txtgioitinh1.getSelectionModel().clearSelection();
      txtngaysinh1.setValue(null);
      txtSDT1.setText("");
      txtNgaydk1.setValue(null);
  }

    public void suadsThongtin(ActionEvent event){
        if(event.getSource()==btSua1){
            String sql="UPDATE userdata SET makh=?,hoten=?,soCccd=?,diachi=?,gioitinh=?,ngaysinh=?,sdt=?,ngayDk=? WHERE makh=?";
            connect=connectDB();

            try {
                Alert alert;
                if (txtmaKH1.getText().isEmpty() || txttenKH1.getText().isEmpty() || txtCMNN1.getText().isEmpty() || txtdiachi1.getText().isEmpty() || txtgioitinh1.getSelectionModel().getSelectedItem()==null || txtngaysinh1.getValue()==null || txtSDT1.getText().isEmpty() ||txtNgaydk1.getValue()==null ) {
                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Lỗi");
                    alert.setHeaderText(null);
                    alert.setContentText("Lỗi!Dữ liệu bị trống . Vui lòng nhập lại ");
                    alert.showAndWait();
                }else {
                   {
                        prepare=connect.prepareStatement(sql);


                        prepare.setString(1,txtmaKH1.getText());
                        prepare.setString(2,txttenKH1.getText());
                        prepare.setString(3,txtCMNN1.getText());
                        prepare.setString(4,txtdiachi1.getText());
                        prepare.setString(5,(String) txtgioitinh1.getSelectionModel().getSelectedItem());
                        prepare.setString(6, String.valueOf(txtngaysinh1.getValue()));
                        prepare.setString(7,txtSDT1.getText());
                        prepare.setString(8, String.valueOf(txtNgaydk1.getValue()));
                       prepare.setString(9,txtmaKH1.getText());


                       prepare.executeUpdate();

                       String sua="UPDATE qlhd SET makh=?,hoten=? where makh=?";
                       prepare=connect.prepareStatement(sua);
                       prepare.setString(1,txtmaKH1.getText());
                       prepare.setString(2,txttenKH1.getText());
                       prepare.setString(3,txtmaKH1.getText());
                       prepare.executeUpdate();

                        alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("Thông báo");
                        alert.setHeaderText(null);
                        alert.setContentText("Bạn đã sửa thành công mã khách hàng " + txtmaKH1.getText());
                        alert.showAndWait();
                      addUserShowListData();
                      lammoithongtin();
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void xoadsThongtin(ActionEvent event){
      if(event.getSource()==btXoa1){

          String sql="DELETE FROM userdata WHERE makh=? ";
          connect=connectDB();
          try {
              Alert alert;
              if (txtmaKH1.getText().isEmpty() || txttenKH1.getText().isEmpty() || txtCMNN1.getText().isEmpty() || txtdiachi1.getText().isEmpty() || txtgioitinh1.getSelectionModel().getSelectedItem()==null || txtngaysinh1.getValue()==null || txtSDT1.getText().isEmpty() ||txtNgaydk1.getValue()==null ) {
                  alert = new Alert(Alert.AlertType.ERROR);
                  alert.setTitle("Lỗi");
                  alert.setHeaderText(null);
                  alert.setContentText("Lỗi!Dữ liệu bị trống . Vui lòng nhập lại ");
                  alert.showAndWait();
              }else{
                  alert=new Alert(Alert.AlertType.INFORMATION);
                  alert.setTitle("Thông báo");
                  alert.setHeaderText(null);
                  alert.setContentText("Bạn có muốn xóa mã KH: "+txtmaKH1.getText()+" không ?");
                  Optional<ButtonType> optional=alert.showAndWait();

                  if(optional.isPresent()&&optional.get().equals(ButtonType.OK)){
                      prepare = connect.prepareStatement(sql);
                      prepare.setString(1, String.valueOf(txtmaKH1.getText()));

                      prepare.executeUpdate();

                      String xoaqlhd="DELETE FROM qlhd WHERE makh=? ";
                      prepare=connect.prepareStatement(xoaqlhd);
                      prepare.setString(1,txtmaKH1.getText());
                      prepare.executeUpdate();

                      String xoaSodien="DELETE FROM sodien WHERE makh=? ";
                      prepare=connect.prepareStatement(xoaSodien);
                      prepare.setString(1,txtmaKH1.getText());
                      prepare.executeUpdate();
                      alert = new Alert(Alert.AlertType.INFORMATION);
                      alert.setTitle("Thông báo");
                      alert.setHeaderText(null);
                      alert.setContentText("Xóa thành công");
                      alert.showAndWait();
                      addUserShowListData();
                      ThongKeNguoidung();
                      lammoithongtin();
                  }
              }
          }catch (Exception e){
              e.printStackTrace();
          }


      }
    }


  //Panel quản lí thông tin


   //Panel Cập nhật số điện
  public ObservableList<SoDien> capnhatsodien(){
      ObservableList<SoDien> listdata=FXCollections.observableArrayList();
      String sql="SELECT * FROM sodien";

      try {
          prepare=connect.prepareStatement(sql);
          result=prepare.executeQuery();

          while (result.next()){
              SoDien soDien=new SoDien(result.getString("makh")
                      ,result.getString("mathang")
                      ,result.getInt("chisocu")
                      ,result.getInt("chisomoi"));
              listdata.add(soDien);
          }
      }catch (Exception e){
          e.printStackTrace();
      }
      return listdata;
  }




  public void listMakh() {

      if (txtmaKhSodien != null && txtmaKhSodien.getItems() != null) {
          String list = "SELECT * FROM userdata";
          connect = connectDB();
          try {
              if (connect != null) {
                  prepare = connect.prepareStatement(list);
                  result = prepare.executeQuery();
                  ObservableList<String> list1 = FXCollections.observableArrayList();

                  while (result.next()) {
                      list1.add(result.getString("makh"));
                  }
                  txtmaKhSodien.setItems(list1);
              } else {
                  System.out.println("Không thể kết nối đến CSDL.");
              }
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
  }







  private ObservableList<SoDien> themSodiends;

  public void hienthidanhsachSodien(){
      themSodiends=capnhatsodien();

      tbMakhsodien.setCellValueFactory(new PropertyValueFactory<>("makh"));
      tbmathangSodien.setCellValueFactory(new PropertyValueFactory<>("mathang"));
      tbChisocu.setCellValueFactory(new PropertyValueFactory<>("chisocu"));
      tbChisomoi.setCellValueFactory(new PropertyValueFactory<>("chisomoi"));


      tbViewSodien.setItems(themSodiends);
  }

  public void chontudsSodien(){
      SoDien soDienlist=tbViewSodien.getSelectionModel().getSelectedItem();
      int num=tbViewSodien.getSelectionModel().getSelectedIndex();


      if((num )<0){
          return;
      }
      txtmaKhSodien.setValue(soDienlist.getMakh());
      txtmaThangSodien.setText(soDienlist.getMathang());
      txtChisocu.setText(valueOf(soDienlist.getChisocu()));
      txtChisomoi.setText(valueOf(soDienlist.getChisomoi()));


  }


  public void themdsSodien(ActionEvent event){

      if(event.getSource()==btThemsodien) {
          String spl12 = "INSERT INTO sodien(makh,mathang,chisocu,chisomoi) VALUES(?,?,?,?)";
          connect=connectDB();

          try {
              Alert alert;
              if (txtmaKhSodien.getItems().isEmpty() || txtmaThangSodien.getText().isEmpty() || txtChisocu.getText().isEmpty() || txtChisomoi.getText().isEmpty()) {
                  alert = new Alert(Alert.AlertType.ERROR);
                  alert.setTitle("Lỗi");
                  alert.setHeaderText(null);
                  alert.setContentText("Lỗi!Dữ liệu bị trống . Vui lòng nhập lại ");
                  alert.showAndWait();
              } else {
                  String kiemtradata = "SELECT makh FROM sodien WHERE makh = '"+txtmaKhSodien.getValue()+"'";
                  statement=connect.createStatement();
                  result=statement.executeQuery(kiemtradata);

                  if (result.next()) {
                      alert = new Alert(Alert.AlertType.ERROR);
                      alert.setTitle("Lỗi");
                      alert.setHeaderText(null);
                      alert.setContentText("Mã số điện:" + txtmaKhSodien.getItems() + " đã tồn tại");
                      alert.showAndWait();
                  } else {
                      prepare = connect.prepareStatement(spl12);
                      prepare.setString(1, (String) txtmaKhSodien.getSelectionModel().getSelectedItem());
                      prepare.setString(2, txtmaThangSodien.getText());
                      prepare.setInt(3, Integer.parseInt(txtChisocu.getText()));
                      prepare.setInt(4, Integer.parseInt(txtChisomoi.getText()));

                      prepare.executeUpdate();

                      try {
                          // Cập nhật dữ liệu trong bảng qlhd
                          String updateQlhdQuery = "UPDATE qlhd SET mathang=?, ldtt=ldtt+?, tien=tien+? WHERE makh=?";
                          prepare = connect.prepareStatement(updateQlhdQuery);

                          // Tính toán cho ldtt và tien
                          int  chisocu = Integer.parseInt(txtChisocu.getText());
                          int  chisomoi = Integer.parseInt(txtChisomoi.getText());
                          int  ldtt = chisomoi - chisocu;
                          int  tien = ldtt * 3500;

                          prepare.setString(1, txtmaThangSodien.getText());
                          prepare.setInt(2, ldtt);
                          prepare.setInt(3, tien);
                          prepare.setString(4, (String) txtmaKhSodien.getSelectionModel().getSelectedItem());

                          prepare.executeUpdate();
                          tableViewQLHD.refresh();

                          thongkeDoanhthu();
                          thongkeLDTT();


                      } catch (SQLException | NumberFormatException e) {
                          // Xử lý lỗi nếu có
                          e.printStackTrace();
                      }

                      alert = new Alert(Alert.AlertType.INFORMATION);
                      alert.setTitle("Thông báo");
                      alert.setHeaderText(null);
                      alert.setContentText("Bạn đã thêm thành công mã khách hàng " + txtmaKhSodien.getItems());
                      alert.showAndWait();


                       hienthidanhsachSodien();
                      lammoiThongtinSodien();

                      Tongtien();
                      tongLdtt();

                  }
              }

          } catch (Exception e) {
              e.printStackTrace();
          }
      }
  }

  public void lammoiThongtinSodien(){
      txtmaKhSodien.setItems(null);
      txtmaThangSodien.setText("");
      txtChisocu.setText("");
      txtChisomoi.setText("");

  }

  public void suadsSodien(ActionEvent event){
      if(event.getSource()==btSuaSodien){
//
          String sua = "UPDATE sodien SET  mathang = ?, chisocu = ?, chisomoi = ? WHERE makh = ?";

          connect=connectDB();
          try {
              Alert alert;
              if (txtmaKhSodien.getItems().isEmpty() || txtmaThangSodien.getText().isEmpty() || txtChisocu.getText().isEmpty() || txtChisomoi.getText().isEmpty()) {
                  alert = new Alert(Alert.AlertType.ERROR);
                  alert.setTitle("Lỗi");
                  alert.setHeaderText(null);
                  alert.setContentText("Lỗi!Dữ liệu bị trống . Vui lòng nhập lại ");
                  alert.showAndWait();
              }else {
                  alert=new Alert(Alert.AlertType.CONFIRMATION);
                  alert.setTitle("Thông báo");
                  alert.setHeaderText(null);
                  alert.setContentText("Bạn có muốn sửa Mã KH :"+txtmaKhSodien.getValue()+" không ?");
                  Optional<ButtonType> optional=alert.showAndWait();


                  if (optional.isPresent() && optional.get().equals(ButtonType.OK)) {
                      prepare = connect.prepareStatement(sua);
                      prepare.setString(1, txtmaThangSodien.getText());
                      prepare.setInt(2, Integer.parseInt(txtChisocu.getText()));
                      prepare.setInt(3, Integer.parseInt(txtChisomoi.getText()));
                      prepare.setString(4, (String) txtmaKhSodien.getSelectionModel().getSelectedItem());


                      prepare.executeUpdate();

                      alert = new Alert(Alert.AlertType.INFORMATION);
                      alert.setTitle("Thông báo");
                      alert.setHeaderText(null);
                      alert.setContentText("Sửa thành công");
                      alert.showAndWait();

                      String suaqlhd = "UPDATE qlhd SET mathang=?,ldtt=?,tien=? WHERE makh=?";
                      prepare = connect.prepareStatement(suaqlhd);

                      int chisocu=Integer.parseInt(txtChisocu.getText());
                      int chisomoi=Integer.parseInt(txtChisomoi.getText());
                      int ldtt=chisomoi-chisocu;
                      int tien=(chisomoi-chisocu)*3500;

                      prepare.setString(1,txtmaThangSodien.getText());
                      prepare.setInt(2,ldtt);
                      prepare.setInt(3,tien);
                      prepare.setString(4,txtmaKhSodien.getSelectionModel().getSelectedItem());
                      prepare.executeUpdate();

                      tableViewQLHD.refresh();

                      thongkeDoanhthu();
                      thongkeLDTT();


                      hienthidanhsachSodien();
                      lammoiThongtinSodien();


                  }else {
                      return;
                  }

              }
          }catch (Exception e){
              e.printStackTrace();
          }

      }
  }




  //Panel Cập nhật số điện

  //Panel Quản lí hóa đơn


    public ObservableList<Quanlihoadon> addUserQLHD(){
      ObservableList<Quanlihoadon> list=FXCollections.observableArrayList();
      String sql="SELECT *FROM qlhd";
      try {
         prepare=connect.prepareStatement(sql);
         result=prepare.executeQuery();
         while (result.next()){
             Quanlihoadon quanlihoadon=new Quanlihoadon(
                     result.getString("makh"),
                             result.getString("hoten"),
                             result.getString("mathang"),
                             result.getInt("ldtt"),
                             result.getInt("tien"));
             list.add(quanlihoadon);
         }
      }catch (Exception e){
          e.printStackTrace();
      }
      return list;
    }


    private ObservableList<Quanlihoadon> themdsQLHD;


    public void hienthidsHoadon(){
      themdsQLHD=addUserQLHD();
      tnmakhQLHD.setCellValueFactory(new PropertyValueFactory<>("makh") );
      tbtenkhQLHD.setCellValueFactory(new PropertyValueFactory<>("hoten"));
      tbmathangQLHD.setCellValueFactory(new PropertyValueFactory<>("mathang"));
      tbldttQLHD.setCellValueFactory(new PropertyValueFactory<>("ldtt"));
      tbtienQLHD.setCellValueFactory(new PropertyValueFactory<>("tien"));
        tableViewQLHD.setItems(themdsQLHD);
    }


    public void chondsHoadon(){
        Quanlihoadon ql=tableViewQLHD.getSelectionModel().getSelectedItem();
        int num=tableViewQLHD.getSelectionModel().getSelectedIndex();

        if(num<0){
            return;
        }
        txtmakhQLHD.setText(ql.getMakh());
        txthotenQLHD.setText(ql.getHoten());
        txtmathangQLHD.setText(ql.getMathang());
        txtldttQLHD.setText(String.valueOf(ql.getLdtt()));
        txttienQLHD.setText(String.valueOf(ql.getTien()));

    }

    public void lammoi(){
        txtmakhQLHD.setText("");
        txthotenQLHD.setText("");
        txtmathangQLHD.setText("");
        txtldttQLHD.setText("");
        txttienQLHD.setText("");

    }
    public void Thanhtoan(ActionEvent event){
        if(event.getSource()==btLaphoadon){

            Alert alert;

            if(txtmakhQLHD.getText().isEmpty() || txthotenQLHD.getText().isEmpty() || txtmathangQLHD.getText().isEmpty() || txtldttQLHD.getText().isEmpty() || txttienQLHD.getText().isEmpty()){
                alert =new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText(null);
                alert.setContentText("Lỗi.Dữ liệu bị trống ." +
                        "Vui lòng chọn vào khách hàng cần thanh toán" );
                alert.showAndWait();


            }else {
                String sql="SELECT * FROM userdata WHERE makh=?";
                connect=connectDB();
                try {
                    prepare=connect.prepareStatement(sql);
                    prepare.setString(1,txtmakhQLHD.getText());
                    result=prepare.executeQuery();

                    while (result.next()){
                        String makh=result.getString("makh");
                        String hoten=result.getString("hoten");
                        String soCccd=result.getString("soCccd");
                        String diachi=result.getString("diachi");
                        String gioitinh=result.getString("gioitinh");
                        LocalDate ngaysinh =result.getDate("ngaysinh").toLocalDate();
                        String sdt=result.getString("sdt");
                        LocalDate ngayDk =result.getDate("ngayDk").toLocalDate();

                        String sqldaTT="INSERT INTO DaTT(makh,hoten,soCccd,diachi,gioitinh,ngaysinh,sdt,ngayDk) VALUES(?,?,?,?,?,?,?,?)";
                        try {
                            connect=connectDB();
                            prepare=connect.prepareStatement(sqldaTT);
                            prepare.setString(1,makh);
                            prepare.setString(2,hoten);
                            prepare.setString(3,soCccd);
                            prepare.setString(4,diachi);
                            prepare.setString(5,gioitinh);
                            prepare.setObject(6,ngaysinh);
                            prepare.setString(7,sdt);
                            prepare.setObject(8,ngayDk);


                            prepare.executeQuery();



                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                String xoaChuaDk="DELETE FROM ChuaTT WHERE makh=?";
                connect=connectDB();
                try {
                    prepare=connect.prepareStatement(xoaChuaDk);
                    prepare.setString(1,txtmakhQLHD.getText());
                    prepare.executeQuery();
                }catch (Exception e){
                    e.printStackTrace();
                }
                addShowListPayDT();
                addShowListPayDT1();

                alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText(null);
                alert.setContentText("Thanh toán thành côngg");
                alert.showAndWait();

                lammoi();



            }


        }else if(event.getSource()==btInhoadon){
            Alert alert;

            if(txtmakhQLHD.getText().isEmpty() || txthotenQLHD.getText().isEmpty() || txtmathangQLHD.getText().isEmpty() || txtldttQLHD.getText().isEmpty() || txttienQLHD.getText().isEmpty()){
                alert =new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Thông báo");
                alert.setHeaderText(null);
                alert.setContentText("Lỗi.Dữ liệu bị trống ." +
                        "Vui lòng chọn vào khách hàng cần thanh toán" );
                alert.showAndWait();


            }else {
                paneHoadon.setVisible(true);
                paneThongtin1.setVisible(false);
                paneQLHD.setVisible(false);
                PaneThongKe.setVisible(false);
                paneSodien.setVisible(false);
                paneThanhToan.setVisible(false);


                String sql="SELECT makh,hoten,diachi,soCccd,sdt FROM userdata WHERE makh=?";
                connect=connectDB();
                try {
                    prepare=connect.prepareStatement(sql);
                    prepare.setString(1,txtmakhQLHD.getText());
                    result=prepare.executeQuery();

                    if (result.next()){
                        String makh1=result.getString("makh");
                        String hoten1=result.getString("hoten");
                        String diachi=result.getString("diachi");
                        String soCccd1=result.getString("soCccd");
                        String sdt1=result.getString("sdt");

                        lbmakhHoadon.setText(makh1);
                        lbtenKhHoadon.setText(hoten1);
                        lbDiachiHoadon.setText(diachi);
                        lbSoccdHoadon.setText(soCccd1);
                        lbsdtHoadon.setText(sdt1);

                    }



                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                String sql1="SELECT mathang,ldtt,tien FROM qlhd WHERE makh=?";
                connect=connectDB();
                try {
                    prepare=connect.prepareStatement(sql1);
                    prepare.setString(1,txtmakhQLHD.getText());
                    result=prepare.executeQuery();

                    if (result.next()){
                        String mathang1=result.getString("mathang");
                        String ldtt=result.getString("ldtt");
                        String tongtien=result.getString("tien");

                        lbmathangHoadon.setText(mathang1);
                        lbLdttHoadon.setText(ldtt+ " KWh");
                        lbTienHoadon.setText(tongtien+" VNĐ");

                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

                String sql2="SELECT chisocu,chisomoi FROM sodien WHERE makh=?";
                connect=connectDB();

                try {
                    prepare=connect.prepareStatement(sql2);
                    prepare.setString(1,txtmakhQLHD.getText());
                    result=prepare.executeQuery();

                    if (result.next()){
                        int chisocu=result.getInt("chisocu");
                        int chimoimoi=result.getInt("chisomoi");

                        lbchiSodauHoadon.setText(String.valueOf(chisocu)+" KWh");
                        lbchiSocuoiHoadon.setText(String.valueOf(chimoimoi)+ " KWh");
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }

            }
        }else if(event.getSource()==btXongHoaDon){
            paneHoadon.setVisible(false);
            paneThongtin1.setVisible(false);
            paneQLHD.setVisible(true);
            PaneThongKe.setVisible(false);
            paneSodien.setVisible(false);
            paneThanhToan.setVisible(false);

            lammoi();
        }

    }


    //Panel Quản lí hóa đơn

    //Panel Danh sách Thanh toán


    public ObservableList<ChuaTT> addListPay(){
        ObservableList<ChuaTT> list =FXCollections.observableArrayList();
        String sql="SELECT * FROM ChuaTT";

        try {
            connect=connectDB();
            prepare=connect.prepareStatement(sql);
            result=prepare.executeQuery();

            while (result.next()){
                ChuaTT chuaTT =new ChuaTT(result.getString("makh")
                        , result.getString("hoten")
                        , result.getString("soCccd")
                        , result.getString("diachi")
                        , result.getString("gioitinh")
                        , result.getDate("ngaysinh")
                        , result.getString("sdt")
                        , result.getDate("ngayDk"));

                list.add(chuaTT);



            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;

    }

    private ObservableList<ChuaTT> addListPayDT;


    public void addShowListPayDT(){
        addListPayDT=addListPay();

        TTmakh1.setCellValueFactory(new PropertyValueFactory<>("makh"));
        TTtenKH1.setCellValueFactory(new PropertyValueFactory<>("hoten"));
        TTsoCMNN1.setCellValueFactory(new PropertyValueFactory<>("soCccd"));
        TTdiachi1.setCellValueFactory(new PropertyValueFactory<>("diachi"));
        TTgioitinh1.setCellValueFactory(new PropertyValueFactory<>("gioitinh"));
        TTngaysinh1.setCellValueFactory(new PropertyValueFactory<>("ngaysinh"));
        TTsdt1.setCellValueFactory(new PropertyValueFactory<>("sdt"));
        TTngaydk1.setCellValueFactory(new PropertyValueFactory<>("ngayDk"));

        tbViewchuaTT.setItems(addListPayDT);


    }


    public ObservableList<DaTT> addListPay1(){
        ObservableList<DaTT> list =FXCollections.observableArrayList();
        String sql="SELECT * FROM DaTT";

        try {
            connect=connectDB();
            prepare=connect.prepareStatement(sql);
            result=prepare.executeQuery();

            while (result.next()){
                DaTT daTT=new DaTT(result.getString("makh")
                        , result.getString("hoten")
                        , result.getString("soCccd")
                        , result.getString("diachi")
                        , result.getString("gioitinh")
                        , result.getDate("ngaysinh")
                        , result.getString("sdt")
                        , result.getDate("ngayDk"));

                list.add(daTT);



            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return list;

    }

    private ObservableList<DaTT> addListPayDT1;


    public void addShowListPayDT1(){
        addListPayDT1=addListPay1();

        TTmakh2.setCellValueFactory(new PropertyValueFactory<>("makh"));
        TTtenKH2.setCellValueFactory(new PropertyValueFactory<>("hoten"));
        TTsoCMNN2.setCellValueFactory(new PropertyValueFactory<>("soCccd"));
        TTdiachi2.setCellValueFactory(new PropertyValueFactory<>("diachi"));
        TTgioitinh2.setCellValueFactory(new PropertyValueFactory<>("gioitinh"));
        TTngaysinh2.setCellValueFactory(new PropertyValueFactory<>("ngaysinh"));
        TTsdt2.setCellValueFactory(new PropertyValueFactory<>("sdt"));
        TTngaydk2.setCellValueFactory(new PropertyValueFactory<>("ngayDk"));

        tbViewdaTT.setItems(addListPayDT1);


    }


    //Panel Danh sách Thanh toán





    //Panel Thống kê

    public void SoLuongkhachang(){
        Date date=new Date();
        java.sql.Date sqlDate=new java.sql.Date(date.getTime());
        String sql="SELECT COUNT(makh) as soluong FROM userdata";
        connect=connectDB();

        try {
            prepare=connect.prepareStatement(sql);

            result=prepare.executeQuery();

            if(result.next()){
               int soluong=result.getInt("soluong");
                lbLuongNguoiQLhd.setText(String.valueOf(soluong));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void Tongtien(){
        String sql="SELECT SUM(tien) as tongtien FROM qlhd where tien is not null";
        connect=connectDB();

        try {
            prepare=connect.prepareStatement(sql);
            result=prepare.executeQuery();
            if(result.next()){
                int tongtien=result.getInt("tongtien");
                lbTongtienQLHD.setText(String.valueOf(tongtien));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void tongLdtt(){
        String sql="SELECT SUM(ldtt) as tongldtt FROM qlhd WHERE ldtt IS NOT NULL";
        connect=connectDB();
        try {
            prepare=connect.prepareStatement(sql);
            result=prepare.executeQuery();
            if(result.next()){
                int tongldtt=result.getInt("tongldtt");
                lbtongdienQLHD.setText(String.valueOf(tongldtt));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


public void ThongKeNguoidung() {
    connect = connectDB();

//    String[] queries = new String[]{
//            "SELECT COUNT(makh) as soluongt1 FROM userdata WHERE MONTH(ngayDk)=1",
//            "SELECT COUNT(makh) as soluongt2 FROM userdata WHERE MONTH(ngayDk)=2",
//            "SELECT COUNT(makh) as soluongt3 FROM userdata WHERE MONTH(ngayDk)=3",
//            "SELECT COUNT(makh) as soluongt4 FROM userdata WHERE MONTH(ngayDk)=4",
//            "SELECT COUNT(makh) as soluongt5 FROM userdata WHERE MONTH(ngayDk)=5",
//            "SELECT COUNT(makh) as soluongt6 FROM userdata WHERE MONTH(ngayDk)=6",
//            "SELECT COUNT(makh) as soluongt7 FROM userdata WHERE MONTH(ngayDk)=7",
//            "SELECT COUNT(makh) as soluongt8 FROM userdata WHERE MONTH(ngayDk)=8",
//            "SELECT COUNT(makh) as soluongt9 FROM userdata WHERE MONTH(ngayDk)=9",
//            "SELECT COUNT(makh) as soluongt10 FROM userdata WHERE MONTH(ngayDk)=10",
//            "SELECT COUNT(makh) as soluongt11 FROM userdata WHERE MONTH(ngayDk)=11",
//            "SELECT COUNT(makh) as soluongt12 FROM userdata WHERE MONTH(ngayDk)=12"
//    };



        String[] months = {"T1", "T2", "T3", "T4", "T5", "T6", "T7", "T8", "T9", "T10", "T11", "T12"};

        try {
            XYChart.Series<String, Number> series = new XYChart.Series<>();

            for (int i = 0; i < months.length; i++) {
                String query = "SELECT COUNT(makh) as soluong FROM userdata WHERE MONTH(ngayDk)=" + (i + 1);
                prepare = connect.prepareStatement(query);
                result = prepare.executeQuery();

                if (result.next()) {
                    int soluong = result.getInt(1);
                    series.getData().add(new XYChart.Data<>(months[i], soluong));
                }
            }

            thongKeNguoiDung.getData().add(series);

        } catch (SQLException e) {
            e.printStackTrace();
        }

}


public void thongkeDoanhthu(){
        connect=connectDB();


        String[] thang=new String[]{"T1","T2","T3","T4","T5","T6","T7","T8","T9","T10","T11","T12"};
        try {
            XYChart.Series series = new XYChart.Series();
            for (int i = 0; i < thang.length; i++) {
                String querys="SELECT SUM(tien) as tongtient1 from qlhd where mathang='T"+(i+1)+"-2023'";
                prepare=connect.prepareStatement(querys);
                result=prepare.executeQuery();
                if(result.next()){
                    int tongtien=result.getInt(1);
                    series.getData().add(new XYChart.Data<>(thang[i],tongtien));
                }
            }
            thongKeDoanhThu.getData().add(series);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
}

    public void thongkeLDTT(){
        connect=connectDB();

//        String[] query= new String[]{
//                "SELECT SUM(ldtt) as tongdient1 from qlhd where mathang='T1-2023'",
//                "SELECT SUM(ldtt) as tongdient2 from qlhd where mathang='T2-2023'",
//                "SELECT SUM(ldtt) as tongdient3 from qlhd where mathang='T3-2023'",
//                "SELECT SUM(ldtt) as tongdient4 from qlhd where mathang='T4-2023'",
//                "SELECT SUM(ldtt) as tongdient5 from qlhd where mathang='T5-2023'",
//                "SELECT SUM(ldtt) as tongdient6 from qlhd where mathang='T6-2023'",
//                "SELECT SUM(ldtt) as tongdient7 from qlhd where mathang='T7-2023'",
//                "SELECT SUM(ldtt) as tongdient8 from qlhd where mathang='T8-2023'",
//                "SELECT SUM(ldtt) as tongdient9 from qlhd where mathang='T9-2023'",
//                "SELECT SUM(ldtt) as tongdient10 from qlhd where mathang='T10-2023'",
//                "SELECT SUM(ldtt) as tongdient11 from qlhd where mathang='T11-2023'",
//                "SELECT SUM(ldtt) as tongdient12 from qlhd where mathang='T12-2023'",
//
//
//        };

        String[] thang=new String[]{"T1","T2","T3","T4","T5","T6","T7","T8","T9","T10","T11","T12"};
        try {
            XYChart.Series series = new XYChart.Series();
            for (int i = 0; i < thang.length; i++) {
                String querys="SELECT SUM(ldtt) as tongdient1 from qlhd where mathang='T"+(i+1)+"-2023'";
                prepare=connect.prepareStatement(querys);
                result=prepare.executeQuery();
                if(result.next()){
                    int tongdien=result.getInt(1);
                    series.getData().add(new XYChart.Data<>(thang[i],tongdien));
                }
            }
            thongKeldtt.getData().add(series);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }







    //Panel Thống kế


    public void switchForm(javafx.event.ActionEvent event) {
        if (event.getSource() == btThongtin) {
            btThongtin.setStyle("-fx-background-color:linear-gradient(to bottom right,#3f82ae,#26bf7d)");
            btSodien.setStyle("-fx-background-color: transparent");
            btHoadon.setStyle("-fx-background-color: transparent");
            btThongke.setStyle("-fx-background-color: transparent");
            btDanhsachthanhtoan.setStyle("-fx-background-color: transparent");



            paneThongtin1.setVisible(true);
            paneQLHD.setVisible(false);
            PaneThongKe.setVisible(false);
            paneSodien.setVisible(false);
            paneThanhToan.setVisible(false);

            addUserShowListData();
            themDSgioitinh();




        }else if(event.getSource()==btHoadon){
            btHoadon.setStyle("-fx-background-color:linear-gradient(to bottom right,#3f82ae,#26bf7d)");
            btSodien.setStyle("-fx-background-color: transparent");
            btThongtin.setStyle("-fx-background-color: transparent");
            btThongke.setStyle("-fx-background-color: transparent");
            btDanhsachthanhtoan.setStyle("-fx-background-color: transparent");


            paneThongtin1.setVisible(false);
            paneQLHD.setVisible(true);
            PaneThongKe.setVisible(false);
            paneSodien.setVisible(false);
            paneThanhToan.setVisible(false);

            hienthidsHoadon();

        }else if(event.getSource()==btSodien){
            btSodien.setStyle("-fx-background-color:linear-gradient(to bottom right,#3f82ae,#26bf7d)");
            btHoadon.setStyle("-fx-background-color: transparent");
            btThongtin.setStyle("-fx-background-color: transparent");
            btThongke.setStyle("-fx-background-color: transparent");
            btDanhsachthanhtoan.setStyle("-fx-background-color: transparent");


            paneThongtin1.setVisible(false);
            paneQLHD.setVisible(false);
            PaneThongKe.setVisible(false);
            paneSodien.setVisible(true);
            paneThanhToan.setVisible(false);


            hienthidanhsachSodien();
            listMakh();

        }else if(event.getSource()==btThongke) {
            btThongke.setStyle("-fx-background-color:linear-gradient(to bottom right,#3f82ae,#26bf7d)");
            btHoadon.setStyle("-fx-background-color: transparent");
            btThongtin.setStyle("-fx-background-color: transparent");
            btSodien.setStyle("-fx-background-color: transparent");
            btDanhsachthanhtoan.setStyle("-fx-background-color: transparent");


            paneThongtin1.setVisible(false);
            paneQLHD.setVisible(false);
            PaneThongKe.setVisible(true);
            paneSodien.setVisible(false);
            paneThanhToan.setVisible(false);


        }else if(event.getSource()==btDanhsachthanhtoan){
            btThongke.setStyle("-fx-background-color: transparent");
            btHoadon.setStyle("-fx-background-color: transparent");
            btThongtin.setStyle("-fx-background-color: transparent");
            btSodien.setStyle("-fx-background-color: transparent");
            btDanhsachthanhtoan.setStyle("-fx-background-color:linear-gradient(to bottom right,#3f82ae,#26bf7d)");



            paneThongtin1.setVisible(false);
            paneQLHD.setVisible(false);
            PaneThongKe.setVisible(false);
            paneSodien.setVisible(false);
            paneThanhToan.setVisible(true);

        }

    }

    public void close(javafx.event.ActionEvent event) {
        if(event.getSource()==btTat){
            System.exit(0);
        }
    }


    public void quaylaiDangnhap(javafx.event.ActionEvent event) {
        if (event.getSource() == btThoat) {

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle(null);
            alert.setHeaderText(null);
            alert.setContentText("Quay về đăng nhập");

            Optional<ButtonType> optional = alert.showAndWait();

            if (optional.get().equals(ButtonType.OK)) {
                Node node = (Node) event.getSource();
                Stage stage = (Stage) node.getScene().getWindow();
                stage.close();

                try {
                    Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/com/example/mohinhquanlitiendien/View/DangNhapView.fxml")));
                    stage.setScene(scene);
                    stage.show();

                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }


            } else return;
        }
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
      connect=connectDB();
        addUserShowListData();
        themDSgioitinh();
        hienthidanhsachSodien();
        listMakh();
        SoLuongkhachang();
        tongLdtt();
        Tongtien();
        ThongKeNguoidung();
        thongkeDoanhthu();
        thongkeLDTT();
        addShowListPayDT();
        addShowListPayDT1();






    }
}
