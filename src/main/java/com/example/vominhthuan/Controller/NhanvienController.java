package com.example.vominhthuan.Controller;

import com.example.vominhthuan.Model.NhanVien;
import com.example.vominhthuan.Service.NhanvienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.UUID;

@Controller
@RequestMapping("nhanvien")
public class NhanvienController {
    @Autowired
    private NhanvienService nhanvienService;

    @GetMapping("/index")
    public String index (Model model)
    {
        model.addAttribute("listnhanvien",nhanvienService.GetAll());
        return "nhanvien/index";
    }
    @GetMapping("/create")
    public String create (Model model)
    {
        model.addAttribute("nhanvien",new NhanVien());
        return "nhanvien/create";
    }
    @PostMapping("/create")
    public String create (@Valid NhanVien newProduct, Model model)
    {

        nhanvienService.add(newProduct);
        return "redirect:/index";
    }
    @GetMapping("delete/{id}")
    public String delete (@PathVariable("id")String id)
    {
        nhanvienService.delete(id);
        return "redirect:/nhanvien";
    }
    @GetMapping("update/{id}")
    public String delete (@PathVariable("id")String id, Model model)
    {
        NhanVien nhanVien = nhanvienService.getProductById(id);
        model.addAttribute("nhanvien",nhanVien);
        return "nhanvien/edit";
    }
    @PostMapping("/update")
    public String edit (@Valid NhanVien newProduct, Model model)
    {

        nhanvienService.add(newProduct);
        return "redirect:/index";
    }





}
