/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecrudwithdb.control;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import simplecrudwithdb.model.Peserta;

/**
 *
 * @author zword
 */
public class PesertaDB {
    
    private static String table="peserta";
    
    public void Input(Peserta p)throws SQLException{
        PreparedStatement statement = DBRegister.getConnection().
                prepareStatement("insert into "+table
                                    +" (nama,pendidikan,komentar)"
                                    +"values"+"(?,?,?)");
        statement.setString(1, p.getNama());
        statement.setString(2, p.getPendidikan());
        statement.setString(3, p.getKomentar());
        statement.executeUpdate();
        
    }
    
    public void Hapus (Peserta p) throws SQLException{
        PreparedStatement prepare = DBRegister.getConnection().
                                    prepareStatement("delete from "+table
                                    +" where nama = ? ");
            prepare.setString(1, p.getNama());
            prepare.executeUpdate();
    }
    
    public List<Peserta> load() throws SQLException {
        Statement statement = DBRegister.getConnection().createStatement();
        ResultSet result = statement.executeQuery("select * from "+table);
        List<Peserta> list = new ArrayList<Peserta>();
        while(result.next()){
            Peserta p = new Peserta();
            p.setNama(result.getString("nama"));
            p.setPendidikan(result.getString("pendidikan"));
            p.setKomentar(result.getString("Komentar"));
            list.add(p);
        }
        return list;
    }
    
}
