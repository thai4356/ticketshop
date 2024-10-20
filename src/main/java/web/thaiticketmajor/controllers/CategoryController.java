package web.thaiticketmajor.controllers;

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

import web.thaiticketmajor.Models.Category;
import web.thaiticketmajor.Services.DvlCategory;

@Controller
public class QdlCategory {
    @Autowired
    private DvlCategory dvl;

    @GetMapping({
            "/tên_đường_dẫn",
            "/tên_đường_dẫn/duyet"
    })
    public String getDuyet(Model model) {

        List<Category> list = dvl.duyệtCategory();

        model.addAttribute("ds", list);

        model.addAttribute("content", "tên_đường_dẫn/duyet.html");

        return "layout.html";
    }

    @GetMapping("/tên_đường_dẫn/them")
    public String getThem(Model model) {
        Category dl = new Category();

        model.addAttribute("dl", dl);

        model.addAttribute("content", "tên_đường_dẫn/them.html");

        return "layout.html";
    }

    @GetMapping("/tên_đường_dẫn/sua")
    public String getSua(Model model, @RequestParam("id") int id) {

        Category dl = dvl.xemCategory(id);

        model.addAttribute("dl", dl);

        model.addAttribute("content", "tên_đường_dẫn/sua.html");

        return "layout.html";
    }

    @GetMapping("/tên_đường_dẫn/xoa")
    public String getXoa(Model model, @RequestParam(value = "id") int id) {

        Category dl = dvl.tìmCategoryTheoId(id);

        model.addAttribute("dl", dl);

        model.addAttribute("content", "tên_đường_dẫn/xoa.html");

        return "layout.html";
    }

    @GetMapping("/tên_đường_dẫn/xem/{id}")
    public String getXem(Model model, @PathVariable(value = "id") int id) {

        Category dl = dvl.xemCategory(id);

        model.addAttribute("dl", dl);

        model.addAttribute("content", "tên_đường_dẫn/xem.html");

        return "layout.html";
    }

    @PostMapping("/tên_đường_dẫn/them")
    public String postThem(@ModelAttribute("Category") Category dl, RedirectAttributes redirectAttributes) {

        dvl.lưuCategory(dl);

        redirectAttributes.addFlashAttribute("THONG_BAO_OK", "Đã thêm mới thành công !");

        return "redirect:/tên_đường_dẫn/duyet";
    }

    @PostMapping("/tên_đường_dẫn/sua")
    public String postSua(@ModelAttribute("Category") Category dl, RedirectAttributes redirectAttributes) {

        dvl.lưuCategory(dl);

        redirectAttributes.addFlashAttribute("THONG_BAO_OK", "Đã sửa thành công !");

        return "redirect:/tên_đường_dẫn/duyet";
    }

    @PostMapping("/tên_đường_dẫn/xoa")
    public String postXoa(Model model, @RequestParam("Id") int id) {

        this.dvl.xóaCategory(id);

        return "redirect:/tên_đường_dẫn/duyet";
    }

}
