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

@Controller
public class QdlCategory 
{
    @Autowired
    private DvlCategory dvl;
    @GetMapping({
            "/tên_đường_dẫn",
            "/tên_đường_dẫn/duyet"
    })
    public String getDuyet(Model model) 
    {
        // Đọc dữ liệu bảng rồi chứa vào biến tạm
        List<Category> list = dvl.duyệtCategory();

        // Gửi danh sách sang giao diện View HTML
        model.addAttribute("ds", list);

        // Nội dung riêng của trang...
        model.addAttribute("content", "tên_đường_dẫn/duyet.html"); // duyet.html

        // ...được đặt vào bố cục chung của toàn website
        return "layout.html"; 
    }

    @GetMapping("/tên_đường_dẫn/them")
    public String getThem(Model model) {
        Category dl = new Category();

        // Gửi đối tượng dữ liệu sang bên view
        // để còn ràng buộc vào html form
        model.addAttribute("dl", dl);

        // Nội dung riêng của trang...
        model.addAttribute("content", "tên_đường_dẫn/them.html"); 
//        model.addAttribute("dsBangNgoai", this.dvlBangNgoai.dsBangNgoai());

        // ...được đặt vào bố cục chung của toàn website
        return "layout.html"; 
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
    @GetMapping("/tên_đường_dẫn/xoa")
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
    @PostMapping("/tên_đường_dẫn/them")
    public String postThem(@ModelAttribute("Category") Category dl, RedirectAttributes redirectAttributes) {
        // System.out.print("save action...");
        
        //@todo sửa chỗ này đi
        //dl.setNgayTao(LocalDate.now());
        //dl.setNgaySua(LocalDate.now());
        
        dvl.lưuCategory(dl);

        // Gửi thông báo thành công từ view Add/Edit sang view List
        redirectAttributes.addFlashAttribute("THONG_BAO_OK", "Đã thêm mới thành công !");

        return "redirect:/tên_đường_dẫn/duyet";
    }

    // How to send success message to List View
    // https://www.appsloveworld.com/springmvc/100/17/how-to-add-success-notification-after-form-submit
  
    @PostMapping("/tên_đường_dẫn/sua")
    public String postSua(@ModelAttribute("Category") Category dl, RedirectAttributes redirectAttributes) {
        
        //@todo sửa chỗ này đi
        
        //dl.setNgaySua(LocalDate.now());
        
        dvl.lưuCategory(dl);

        // Gửi thông báo thành công từ view Add/Edit sang view List
        redirectAttributes.addFlashAttribute("THONG_BAO_OK", "Đã sửa thành công !");

        return "redirect:/tên_đường_dẫn/duyet";
    }

    // @PostMapping("/tên_đường_dẫn/xoabo/{id}")
    // public String // Hàm xử lý yêu cầu xoá 1 bản ghi
    //         xoabo(Model model, @PathVariable(value = "id") int id) 
    
    @PostMapping("/tên_đường_dẫn/xoa")
    public String postXoa(Model model, @RequestParam("Id") int id) // request param phải khớp với name="Id" của thẻ html input
    {
        // Xoá dữ liệu
        this.dvl.xóaCategory(id);

        // Điều hướng sang trang giao diện
        return "redirect:/tên_đường_dẫn/duyet";
    }



}// end class
