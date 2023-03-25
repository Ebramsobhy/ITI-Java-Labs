
package rowset;

import java.sql.SQLException;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;


class MyRowSetListener implements RowSetListener {
    
    @Override
    public void cursorMoved(RowSetEvent event) {
        System.out.println("Cursor Moved");
    }
    
    @Override
    public void rowChanged(RowSetEvent event) {
        System.out.println("Row Changed");
    }
    
    @Override
    public void rowSetChanged(RowSetEvent event) {
        System.out.println("RowSet Changed");
    }
}

public class RowSetDemo {
    
    public void run() {
        try {
            RowSetFactory factory = RowSetProvider.newFactory();
            JdbcRowSet jdbcSet = factory.createJdbcRowSet();
            jdbcSet.setUrl("jdbc:mysql://localhost:3306/ebram");
            jdbcSet.setUsername("root");
            jdbcSet.setPassword("");
            jdbcSet.setCommand("SELECT * FROM students");
            jdbcSet.execute();
            MyRowSetListener rowSetObj = new MyRowSetListener();
            jdbcSet.addRowSetListener(rowSetObj);
            jdbcSet.first();
            jdbcSet.next();
            jdbcSet.previous();
            jdbcSet.absolute(2);
            jdbcSet.updateString(2, "Magdy");
            jdbcSet.updateRow();
            System.out.println("Student ID: " + jdbcSet.getString(1) + ":::" + "Student Name: " + jdbcSet.getString(2)
                    + ":::" + "Student Age: "
                    + jdbcSet.getString(3));
            jdbcSet.moveToInsertRow();
            jdbcSet.updateString(2, "Abanoub");
            jdbcSet.updateInt(3, 20);
            jdbcSet.updateString(4, "pd");
            jdbcSet.updateString(5, "abanoub@hotmail.com");
            jdbcSet.insertRow();
            jdbcSet.moveToCurrentRow();
            System.out.println("Student ID: " + jdbcSet.getString(1) + ":::" + "Student Name: " + jdbcSet.getString(2)
                    + ":::" + "Student Age: "
                    + jdbcSet.getString(3));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        RowSetDemo rowSetDemo = new RowSetDemo();
        rowSetDemo.run();
    }
}

