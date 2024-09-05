package web.thaiticketmajor.Models.user;

import java.util.List;

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
public class QdlUser 
{
    @Autowired
    private DvlUser dvl; 
    
    @GetMapping({
            "/user",
            "/user/duyet"
    })
    public String getDuyet(Model model) 
    {
        
        List<User> list = dvl.duyệtUser();

        
        model.addAttribute("ds", list);


        
        model.addAttribute("content", "user/html/index.html"); 
        // Nội dung riêng của trang...
        model.addAttribute("content", "admin/pages/user-manager.html"); // duyet.html

        // ...được đặt vào bố cục chung của toàn website
        return "admin/index.html"; 


        
        return "layout.html";
        }

    @GetMapping("/user/them")
    public String getThem(Model model) {
        User dl = new User();

        
        
        model.addAttribute("dl", dl);

        
        return "user/html/login.html"; 
    }

    
    @GetMapping("/user/sua")
    public String getSua(Model model, @RequestParam("id") int id) {
        
        
        User dl = dvl.xemUser(id);

        
        model.addAttribute("dl", dl);


        
        
        model.addAttribute("content", "user/sua.html"); 

        
        return "layout.html"; 
    }

    
    
    
    @GetMapping("/user/xoa")
    public String getXoa(Model model, @RequestParam(value = "id") int id) {
        
        User dl = dvl.tìmUserTheoId(id);

        
        model.addAttribute("dl", dl);

        
        
        model.addAttribute("content", "user/xoa.html"); 

        
        return "layout.html"; 
    }

    @GetMapping("/user/xem/{id}")
    public String getXem(Model model, @PathVariable(value = "id") int id) 
    {
        
        User dl = dvl.xemUser(id);

        
        model.addAttribute("dl", dl);

        
        
        model.addAttribute("content", "user/xem.html"); 

        
        return "layout.html";    
    }

    
    
    
    
    
    @PostMapping("/user/them")
    public String postThem(@ModelAttribute("User") User dl, RedirectAttributes redirectAttributes) {
        
        
        
        
        
        
        dvl.lưuUser(dl);

        
        redirectAttributes.addFlashAttribute("THONG_BAO_OK", "Đã thêm mới thành công !");

        return "redirect:/user/duyet";
    }

    
    
  
    @PostMapping("/user/sua")
    public String postSua(@ModelAttribute("User") User dl, RedirectAttributes redirectAttributes) {
        
        
        
        
        
        dvl.lưuUser(dl);

        
        redirectAttributes.addFlashAttribute("THONG_BAO_OK", "Đã sửa thành công !");

        return "redirect:/user/duyet";
    }

    
    
    
    
    @PostMapping("/user/xoa")
    public String postXoa(Model model, @RequestParam("Id") int id) 
    {
        
        this.dvl.xóaUser(id);

        
        return "redirect:/user/duyet";
    }

    
    

    
    


}
