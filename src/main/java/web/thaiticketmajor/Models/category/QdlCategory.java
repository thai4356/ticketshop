package web.thaiticketmajor.Models.category;

//package Tên_Công_Ty.Tên_Dự_Án.qdl;

// Thư viện chuẩn: Java Standard (JavaSE)
import java.util.List;

// Thư viện web: Java Spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class QdlCategory 
{
    @Autowired
    private DvlCategory dvl;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private HttpSession session;

    @GetMapping({
            "/category",
            "/category/duyet"
    })
    public String getDuyet(Model model) 
    {
        // Đọc dữ liệu bảng rồi chứa vào biến tạm
        List<Category> list = dvl.duyệtCategory();
        Category dl = new Category();

        // Gửi danh sách sang giao diện View HTML
        model.addAttribute("ds", list);
        model.addAttribute("dl", dl);

        // Nội dung riêng của trang...
        model.addAttribute("content", "admin/pages/category-manager.html"); // duyet.html

        // ...được đặt vào bố cục chung của toàn website
        return "admin/index.html"; 
    }

    @GetMapping("/category/them")
    public String getThem(Model model) {
        Category dl = new Category();

        // Gửi đối tượng dữ liệu sang bên view
        // để còn ràng buộc vào html form
        model.addAttribute("dl", dl);

        model.addAttribute("action", "/category/them");
        // Nội dung riêng của trang...
        model.addAttribute("content", "admin/pages/category-manager.html"); 
//        model.addAttribute("dsBangNgoai", this.dvlBangNgoai.dsB  angNgoai());

        // ...được đặt vào bố cục chung của toàn website
        return "admin/index.html"; 
    }

    // @GetMapping("/tên_đường_dẫn/sua/{id}")
    @GetMapping("/tên_đường_dẫn/sua")
    public String getSua(Model model, @RequestParam("id") int id) {
        // trangSua(Model model, @PathVariable(value = "id") int id) {
        // Lấy ra bản ghi theo id
        Category dl = dvl.xemCategory(id);

        // Gửi đối tượng dữ liệu sang bên view
        model.addAttribute("dl", dl);
//        model.addAttribute("dsBangNgoai", this.dvlBangNgoai.dsBangNgoai());

        // Hiển thị giao diện view html
        // Nội dung riêng của trang...
        model.addAttribute("content", "tên_đường_dẫn/sua.html"); // sua.html

        // ...được đặt vào bố cục chung của toàn website
        return "layout.html"; // layout.html
    }

    // @GetMapping("/tên_đường_dẫn/xoa/{id}")
    // public String // Giao diện xác nhận xoá
    // trangXoa(Model model, @PathVariable(value = "id") int id) {
    @GetMapping("/category/xoa")
    public String getXoa(Model model, @RequestParam(value = "id") int id) {
        // Lấy ra bản ghi theo id
        Category dl = dvl.tìmCategoryTheoId(id);

        // Gửi đối tượng dữ liệu sang bên view
        model.addAttribute("dl", dl);

        // Hiển thị view giao diện
        // Nội dung riêng của trang...
        model.addAttribute("content", "tên_đường_dẫn/xoa.html"); // xoa.html

        // ...được đặt vào bố cục chung của toàn website
        return "layout.html"; // layout.html
    }

    @GetMapping("/category/xoa/ajax")
    public String getXoaAjax(Model model, @RequestParam("id") int id) 
    {
        // if( Qdl.NhanVienChuaDangNhap(request) )
        //     return "redirect:/qdl/nhanvien/dangnhap";

        // Lấy ra bản ghi theo mã định danh
        var dl = dvl.xemCategory(id);

        // Gửi đối tượng dữ liệu sang giao diện (ui view) html form
        model.addAttribute("dl", dl);
        model.addAttribute("action", "/category/xoa");

        return "category/duyet.html"; // layout.html
    }

    @GetMapping("/tên_đường_dẫn/xem/{id}")
    public String getXem(Model model, @PathVariable(value = "id") int id) 
    {
        // Lấy ra bản ghi theo id
        Category dl = dvl.xemCategory(id);

        // Gửi đối tượng dữ liệu sang bên view
        model.addAttribute("dl", dl);

        // Hiển thị view giao diện
        // Nội dung riêng của trang...
        model.addAttribute("content", "tên_đường_dẫn/xem.html"); 

        // ...được đặt vào bố cục chung của toàn website
        return "layout.html";    // layout.html
    }

    // nên là createAction()
    // https://javarevisited.blogspot.com/2022/04/how-to-use-session-attributes-in-spring.html#axzz89tnfpu78
    // https://stackoverflow.com/questions/55882706/how-to-remove-attribute-from-session-using-thymeleaf
    // https://stackoverflow.com/questions/46744586/thymeleaf-show-a-success-message-after-clicking-on-submit-button
    // @PostMapping("/tên_đường_dẫn/add") why not ??? it's okay right ?
    @PostMapping("/category/them")
    public String postThem(@ModelAttribute("Category") Category dl, RedirectAttributes redirectAttributes) {
        // System.out.print("save action...");
        
        //@todo sửa chỗ này đi
        //dl.setNgayTao(LocalDate.now());
        //dl.setNgaySua(LocalDate.now());
        
        dvl.lưuCategory(dl);

        // Gửi thông báo thành công từ view Add/Edit sang view List
        session.setAttribute("message", "Đã hoàn tất việc thêm mới !");

        return "redirect:/category/duyet";
    }

    // How to send success message to List View
    // https://www.appsloveworld.com/springmvc/100/17/how-to-add-success-notification-after-form-submit
  
    @GetMapping("category/suaajax")
    public String getSuaAjax(Model model, @RequestParam("id") int id) 
    {

        // Lấy ra bản ghi theo mã định danh
        var dl = dvl.xemCategory(id);

        // Gửi đối tượng dữ liệu sang giao diện (ui view) html form
        model.addAttribute("dl", dl);
        model.addAttribute("action", "/category/sua");

        // Hiển thị giao diện view html
        // Nội dung riêng của trang...
        // model.addAttribute("content", "nhasanxuat/sua.html"); // sua.html

        // ...được đặt vào bố cục chung của toàn website
        // return "nhasanxuat/form-sua-bs4.html"; // layout.html
        return "admin/pages/sua-cat-modal.html"; // layout.html
    }

    // @PostMapping("/tên_đường_dẫn/xoabo/{id}")
    // public String // Hàm xử lý yêu cầu xoá 1 bản ghi
    //         xoabo(Model model, @PathVariable(value = "id") int id) 
    
    @PostMapping("/category/sua")
    public String postSua(@ModelAttribute("Category") Category dl) 
    {
        
        dvl.lưuCategory(dl);
        // dvl.luu(dl);

        // Gửi thông báo thành công từ view Add/Edit sang view List
        session.setAttribute("message", "Đã hoàn tất việc cập nhật !");

        return "redirect:/category/duyet";
    }
    
    @PostMapping("/category/xoa")
    public String postXoa(Model model, @RequestParam("id") int id) // request param phải khớp với name="Id" của thẻ html input
    {
        // Xoá dữ liệu
        this.dvl.xóaCategory(id);

        // Điều hướng sang trang giao diện
        return "redirect:/category/duyet";
    }



}// end class
