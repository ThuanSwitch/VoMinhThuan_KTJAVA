package com.example.vominhthuan.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "PhongBan")
public class PhongBan {
    @Id
    @NotBlank(message = "Trường này không được phép bỏ trống")
    @Length(min = 2, max = 2, message = "Phải nhập vào 2 ký tự chữ viết tắt")
    private String maphong;

    @Length(min = 2, max = 30, message = "Phải nhập vào tên phòng")
    private String tenphong;
    @OneToMany(mappedBy = "phongban", fetch = FetchType.LAZY)
    private List<NhanVien> listNhanviens;
}
