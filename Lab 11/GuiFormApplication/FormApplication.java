/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formapplication;

import com.mysql.cj.jdbc.MysqlDataSource;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;


/**
 *
 * @author Adel
 */
public class FormApplication extends Application {
    int currentIndex=0;
    boolean recordNew=false;
    @Override
    public void start(Stage primaryStage) {
        
        FXMLDatabaseBase root = new FXMLDatabaseBase() ;

 Properties props = new Properties();
        OutputStream output=null;
        try {
            output = new FileOutputStream("db.properties");
            props.setProperty("MYSQL_DB_URL","jdbc:mysql://localhost:3306/javatoturial");
            props.setProperty("MYSQL_DB_USERNAME","root");
            props.setProperty("MYSQL_DB_PASSWORD","");
            props.store(output,null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormApplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FormApplication.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            if(output!=null)
            {
                try{
                    output.close();
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }
        
//        showing all data
        showData(root,false);
        

// next button
        root.nextBtn.setOnAction((ActionEvent e) -> {
            currentIndex++;
            showData(root,false);
            root.pervBtn.setDisable(false); // Re-enable the "Previous" button
        });
        
//        prev button
        root.pervBtn.setOnAction((ActionEvent e) -> {
            currentIndex--;
            showData(root,false);
            if (currentIndex == 0) {
                root.pervBtn.setDisable(true); // Disable the "Previous" button if we are on the first row of data
            }
            root.nextBtn.setDisable(false); // Re-enable the "Next" button
        });
        
//        last button
        root.lastBtn.setOnAction(e->{
            showData(root,true);
        });
//        first button
        root.firstBtn.setOnAction(e->{
        currentIndex = 0;
        showData(root,false);
        root.pervBtn.setDisable(true); // Disable the "Previous" button since we are on the first row of data
        root.nextBtn.setDisable(false); // Re-enable the "Next" button
        });
// delete button
        root.deleteBtn.setOnAction((ActionEvent e) -> {
            try {
                DataSource ds = FormApplication.getmyDataSource();
                Connection con = ds.getConnection();
                Statement stmt = con.createStatement();
                String id = root.idFeild.getText();
                stmt.executeUpdate("DELETE FROM employees WHERE id=" + id);
                // if the deletion was successful, reset the form and show the first row of data
                root.idFeild.setText("");
                root.firstNameFeild.setText("");
                root.lastNameFeild.setText("");
                root.emailFeild.setText("");
                root.phoneFeild.setText("");
                currentIndex = 0;
                showData(root,false);
            } catch (SQLException ex) {
                Logger.getLogger(FormApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        // Update button
        root.updateBtn.setOnAction(e -> {
            try {
                if(recordNew==false){
                DataSource ds = FormApplication.getmyDataSource();
                Connection con = ds.getConnection();
                Statement stmt = con.createStatement();
                String sql = "UPDATE employees SET firstName = ?, lastName = ?, email = ?, phone = ? WHERE id = ?";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setString(1, root.firstNameFeild.getText());
                pstmt.setString(2, root.lastNameFeild.getText());
                pstmt.setString(3, root.emailFeild.getText());
                pstmt.setString(4, root.phoneFeild.getText());
                pstmt.setInt(5, Integer.parseInt(root.idFeild.getText()));
                pstmt.executeUpdate();
                con.close();
                showData(root,false);                    
                }else{
                DataSource ds = FormApplication.getmyDataSource();
                Connection con = ds.getConnection();
                Statement stmt = con.createStatement();
                String sql = "INSERT INTO employees (id,firstName,lastName,email,phone) values (?,?,?,?,?) ";
                PreparedStatement pstmt = con.prepareStatement(sql);
                pstmt.setInt(1, Integer.parseInt(root.idFeild.getText()));
                pstmt.setString(2, root.firstNameFeild.getText());
                pstmt.setString(3, root.lastNameFeild.getText());
                pstmt.setString(4, root.emailFeild.getText());
                pstmt.setInt(5, Integer.parseInt(root.phoneFeild.getText()));
                pstmt.executeUpdate();
                con.close();
                showData(root,false);      
                }

            } catch (SQLException ex) {
                Logger.getLogger(FormApplication.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
//      new

        root.newBtn.setOnAction(e->{
        recordNew=true;
        root.idFeild.setText("");
        root.firstNameFeild.setText("");
        root.lastNameFeild.setText("");
        root.emailFeild.setText("");
        root.phoneFeild.setText("");
        });

        

        Scene scene = new Scene(root, 600, 600);
        
        primaryStage.setTitle("Employees Data");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private void showData(FXMLDatabaseBase root, boolean isLast) {
    try {
        DataSource ds = FormApplication.getmyDataSource();
        Connection con = ds.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs;
        if (isLast) {
            rs = stmt.executeQuery("SELECT * FROM employees ORDER BY id DESC LIMIT 1");    
            currentIndex = rs.getInt(1); // Set currentIndex to -1 to indicate we are on the last row
        } else {
            rs = stmt.executeQuery("SELECT * FROM employees LIMIT " + currentIndex + ",1");
        }
        if (rs.next()) {
            root.idFeild.setText(rs.getString(1));
            root.firstNameFeild.setText(rs.getString(2));
            root.lastNameFeild.setText(rs.getString(3));
            root.emailFeild.setText(rs.getString(4));
            root.phoneFeild.setText(rs.getString(5));
        } else {
            root.nextBtn.setDisable(true);
        }
        if (currentIndex == -1) {
            root.nextBtn.setDisable(true); // Disable the "Next" button if we are on the last row
            root.pervBtn.setDisable(false); // Re-enable the "Previous" button if we are on the last row
        } else if (currentIndex == 0) {
            root.pervBtn.setDisable(true); // Disable the "Previous" button if we are on the first row of data
        } else {
            root.pervBtn.setDisable(false); // Re-enable the "Previous" button
            root.nextBtn.setDisable(false); // Re-enable the "Next" button
        }
    } catch (SQLException ex) {
        Logger.getLogger(FormApplication.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    /**
     * @param args the command line arguments
     */
    public static DataSource getmyDataSource(){
        Properties props = new Properties();
        FileInputStream fis=null;
        MysqlDataSource mysqlDS=null;
        try{
            fis = new FileInputStream("db.properties");
            props.load(fis);
            mysqlDS = new MysqlDataSource();
            mysqlDS.setURL(props.getProperty("MYSQL_DB_URL"));
            mysqlDS.setUser(props.getProperty("MYSQL_DB_USERNAME"));
            mysqlDS.setPassword(props.getProperty("MYSQL_DB_PASSWORD"));
        }catch(IOException e){
            e.printStackTrace();
        }
        return mysqlDS;
    }
    public static void main(String[] args) {
       
        launch();
   
    }
    
    
}
