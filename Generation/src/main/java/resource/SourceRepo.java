package resource;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import static java.lang.Class.forName;

public class SourceRepo {
    Connection con = null;

    public SourceRepo  () {

        String url = "jdbc:mysql://localhost:3306/Generation";
        String username = "root";
        String password = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //to get the representation from the database
    public List<Source> getSource()
    {
        List<Source> SourceList = new ArrayList<>();
        String sql = "select * from Source";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Source soe = new Source();
                soe.setId(rs.getInt(1));
                soe.setName(rs.getString(2));
                soe.setType(rs.getString(3));
                soe.setType(rs.getString(4));
                SourceList.add(soe);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return SourceList;
    }


    // insert into the database

    public void insertSource(Source Source){
        String sql = "insert into Source values (?,?,?,?,?) ";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,Source.getId());
            st.setString(2,Source.getName());
            st.setString(3,Source.getPlace());
            st.setString(4,Source.getType());
            st.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //update the representation
    public void updateSource(Source Source){
        String sql = "update Source set id=?,Name=?,place=?,type=? ";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,Source.getId());
            st.setString(2,Source.getName());
            st.setString(3,Source.getPlace());
            st.setString(4,Source.getType());


        }catch (Exception e){
            System.out.println(e);
        }
    }

    //delete method
    public void Source(int id) {

        String sql = "delete from Source where id = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            st.executeUpdate();

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void deleteSource(int id) {
    }
}

