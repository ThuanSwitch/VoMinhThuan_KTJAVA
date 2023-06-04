package com.example.vominhthuan.Repository;

import com.example.vominhthuan.Model.NhanVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanvienRepository  extends JpaRepository<NhanVien,String> {
}
