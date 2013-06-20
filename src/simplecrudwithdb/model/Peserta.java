/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecrudwithdb.model;

import java.util.Objects;

/**
 *
 * @author zword
 */
public class Peserta {
    String nama;
    String pendidikan;
    String komentar;

    public String getKomentar() {
        return komentar;
    }

    public void setKomentar(String komentar) {
        this.komentar = komentar;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getPendidikan() {
        return pendidikan;
    }

    public void setPendidikan(String pendidikan) {
        this.pendidikan = pendidikan;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Peserta other = (Peserta) obj;
        if (!Objects.equals(this.nama, other.nama)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.nama);
        return hash;
    }
    
    
}
