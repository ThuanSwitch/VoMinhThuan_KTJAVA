package com.example.vominhthuan.Service;

import com.example.vominhthuan.Model.NhanVien;
import com.example.vominhthuan.Repository.NhanvienRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanvienService {
    @Autowired
    private NhanvienRepository nhanvienRepository;

    public List<NhanVien> GetAll () {
        return nhanvienRepository.findAll();
    }
    public void add(NhanVien product) { nhanvienRepository.save(product);}
    public void delete (String id)
    {
        nhanvienRepository.deleteById(id);
    }
    public  NhanVien getProductById (String id)
    {
        Optional<NhanVien> optional = nhanvienRepository.findById(id);
        NhanVien product = null;
        if(optional.isPresent())
        {
            product =optional.get();
        }
        else
        {
            throw  new RuntimeException();
        }
        return product;
    }

}
