package repository;

import model.Energy;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import static java.lang.Class.forName;

public class EnergyRepo {
    Connection con = null;

    public EnergyRepo  () {

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
    public List<Energy> getEnergy()
    {
        List<Energy> SourceList = new ArrayList<>();
        String sql = "select * from Energy";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Energy eng = new Energy();
                eng.setId(rs.getInt(1));
                eng.setType(rs.getString(2));
                eng.setVolt(rs.getString(3));

                SourceList.add(eng);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return SourceList;
    }


    // insert into the database

    public void insertEnergy(Energy Energy){
        String sql = "insert into Energy values (?,?,?,?,?) ";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,Energy.getId());
            st.setString(2,Energy.getType());
            st.setString(3,Energy.getVolt());
            st.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //update the representation
    public void updateEnergy(Energy Energy){
        String sql = "update Energy set Id=?,type=?,volt=? ";
        try {
            PreparedStatement st = con.prepareStatement(sql);


            st.setInt(1,Energy.getId());
            st.setString(2,Energy.getType());
            st.setString(3,Energy.getVolt());

        }catch (Exception e){
            System.out.println(e);
        }
    }

    //delete method
    public void Energy(int id) {

        String sql = "delete from Energy where id = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);
            st.executeUpdate();

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void deleteEnergy(int id) {
    }
}
