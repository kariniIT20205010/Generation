package repository;
import model.Transformar;
import resource.Source;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import static java.lang.Class.forName;
public class TransformarRepo {
    Connection con = null;

    public TransformarRepo  () {

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
    public List<Transformar> getTransformar()
    {
        List<Transformar> TransformarList = new ArrayList<>();
        String sql = "select * from Transformar";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Transformar trf = new Transformar();
                trf.setId(rs.getInt(1));
                trf.seten_Id(rs.getInt(2));
                trf.setactive(rs.getString(3));
                trf.setdate(rs.getString(4));

                TransformarList.add(trf);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return TransformarList;
    }


    // insert into the database

    public void insertTransformar(Transformar Transformar){
        String sql = "insert into Transformar values (?,?,?,?,?) ";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1,Transformar.getId());
            st.setInt(2,Transformar.geten_Id());
            st.setString(3,Transformar.getactive());
            st.setString(4,Transformar.getdate());
            st.executeUpdate();
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //update the representation
    public void updateTransformar(Transformar Transformar){
        String sql = "update Transformar set Id=?,en_Id=?,active=?,date=? ";
        try {
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, Transformar.getId());
            st.setInt(2,Transformar.geten_Id());
            st.setString(3,Transformar.getactive());
            st.setString(4,Transformar.getdate());


        }catch (Exception e){
            System.out.println(e);
        }
    }

    //delete method
    public void Transformar(int Id) {

        String sql = "delete from Transformar where Id = ?";
        try {
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, Id);
            st.executeUpdate();

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void deleteTransformar(int id) {
    }
}
