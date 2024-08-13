package web.thaiticketmajor.Models.user;

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

// Thư viện lập trình Java Web do lập trình viên tự phát triển:
// import Tên_Công_Ty.Tên_Dự_Án.dvl.DvlUser;
// import Tên_Công_Ty.Tên_Dự_Án.tdl.User;


/**
 * User performs Actions on UI/View
 * Client Computer sends Http Requets -> Server Computer
 * (Http Requets: GET, POST, PUT, DELETE)
 * Server uses Url Routes Mapping Table to forward
 * requests to Spring Controllers
 * Each Controller itself forward requets to its Actions
 * Client có nhiều yêu cầu & truy vấn thông qua giao thức Http Get/Post
 * Server có nhiều Controller phục vụ, đáp ứng
 * Lập trình viên cần định tuyến cho rõ ràng:
 * Controller (Action) nào phục vụ Request(Get/Post) nào ?
 * Đừng thay đổi @Mapping, mà chỉ nên thay đổi Action Name
 * 
 * View Actions: List, Add, Delete, Edit, Details (LADE)
 * Data Actions: List, Create, Delete, Update, Read (CRUD)
 * SQL Actions: Select, Insert, Delete, Update (SIDU)
 */

@Controller
public class QdlUser 
{
    @Autowired
    private DvlUser dvl; // cung cấp các dịch vụ thao tác dữ liệu

    //@Autowired
    //private DvlBảngNgoại dvlBangNgoai; // cung cấp các dịch vụ thao tác dữ liệu

    
    @GetMapping({
            "/user",
            "/user/duyet"
    })
    public String getDuyet(Model model) 
    {
        // Đọc dữ liệu bảng rồi chứa vào biến tạm
        List<User> list = dvl.duyệtUser();

        // Gửi danh sách sang giao diện View HTML
        model.addAttribute("ds", list);

        // Nội dung riêng của trang...
        model.addAttribute("content", "user/index.html"); // duyet.html

        // ...được đặt vào bố cục chung của toàn website
        return "layout.html"; 
    }

    @GetMapping("/user/them")
    public String getThem(Model model) {
        User dl = new User();

        // Gửi đối tượng dữ liệu sang bên view
        // để còn ràng buộc vào html form
        model.addAttribute("dl", dl);

        // Nội dung riêng của trang...
        model.addAttribute("content", "user/them.html"); 
//        model.addAttribute("dsBangNgoai", this.dvlBangNgoai.dsBangNgoai());

        // ...được đặt vào bố cục chung của toàn website
        return "layout.html"; 
    }

    // @GetMapping("/user/sua/{id}")
    @GetMapping("/user/sua")
    public String getSua(Model model, @RequestParam("id") int id) {
        // trangSua(Model model, @PathVariable(value = "id") int id) {
        // Lấy ra bản ghi theo id
        User dl = dvl.xemUser(id);

        // Gửi đối tượng dữ liệu sang bên view
        model.addAttribute("dl", dl);
//        model.addAttribute("dsBangNgoai", this.dvlBangNgoai.dsBangNgoai());

        // Hiển thị giao diện view html
        // Nội dung riêng của trang...
        model.addAttribute("content", "user/sua.html"); // sua.html

        // ...được đặt vào bố cục chung của toàn website
        return "layout.html"; // layout.html
    }

    // @GetMapping("/user/xoa/{id}")
    // public String // Giao diện xác nhận xoá
    // trangXoa(Model model, @PathVariable(value = "id") int id) {
    @GetMapping("/user/xoa")
    public String getXoa(Model model, @RequestParam(value = "id") int id) {
        // Lấy ra bản ghi theo id
        User dl = dvl.tìmUserTheoId(id);

        // Gửi đối tượng dữ liệu sang bên view
        model.addAttribute("dl", dl);

        // Hiển thị view giao diện
        // Nội dung riêng của trang...
        model.addAttribute("content", "user/xoa.html"); // xoa.html

        // ...được đặt vào bố cục chung của toàn website
        return "layout.html"; // layout.html
    }

    @GetMapping("/user/xem/{id}")
    public String getXem(Model model, @PathVariable(value = "id") int id) 
    {
        // Lấy ra bản ghi theo id
        User dl = dvl.xemUser(id);

        // Gửi đối tượng dữ liệu sang bên view
        model.addAttribute("dl", dl);

        // Hiển thị view giao diện
        // Nội dung riêng của trang...
        model.addAttribute("content", "user/xem.html"); 

        // ...được đặt vào bố cục chung của toàn website
        return "layout.html";    // layout.html
    }

    // nên là createAction()
    // https://javarevisited.blogspot.com/2022/04/how-to-use-session-attributes-in-spring.html#axzz89tnfpu78
    // https://stackoverflow.com/questions/55882706/how-to-remove-attribute-from-session-using-thymeleaf
    // https://stackoverflow.com/questions/46744586/thymeleaf-show-a-success-message-after-clicking-on-submit-button
    // @PostMapping("/user/add") why not ??? it's okay right ?
    @PostMapping("/user/them")
    public String postThem(@ModelAttribute("User") User dl, RedirectAttributes redirectAttributes) {
        // System.out.print("save action...");
        
        //@todo sửa chỗ này đi
        //dl.setNgayTao(LocalDate.now());
        //dl.setNgaySua(LocalDate.now());
        
        dvl.lưuUser(dl);

        // Gửi thông báo thành công từ view Add/Edit sang view List
        redirectAttributes.addFlashAttribute("THONG_BAO_OK", "Đã thêm mới thành công !");

        return "redirect:/user/duyet";
    }

    // How to send success message to List View
    // https://www.appsloveworld.com/springmvc/100/17/how-to-add-success-notification-after-form-submit
  
    @PostMapping("/user/sua")
    public String postSua(@ModelAttribute("User") User dl, RedirectAttributes redirectAttributes) {
        
        //@todo sửa chỗ này đi
        
        //dl.setNgaySua(LocalDate.now());
        
        dvl.lưuUser(dl);

        // Gửi thông báo thành công từ view Add/Edit sang view List
        redirectAttributes.addFlashAttribute("THONG_BAO_OK", "Đã sửa thành công !");

        return "redirect:/user/duyet";
    }

    // @PostMapping("/user/xoabo/{id}")
    // public String // Hàm xử lý yêu cầu xoá 1 bản ghi
    //         xoabo(Model model, @PathVariable(value = "id") int id) 
    
    @PostMapping("/user/xoa")
    public String postXoa(Model model, @RequestParam("Id") int id) // request param phải khớp với name="Id" của thẻ html input
    {
        // Xoá dữ liệu
        this.dvl.xóaUser(id);

        // Điều hướng sang trang giao diện
        return "redirect:/user/duyet";
    }



}// end class
