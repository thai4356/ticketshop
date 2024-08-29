package web.thaiticketmajor.Models.category;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DvlCategory
{
    @Autowired private KdlCategory kdl;// kho dữ liệu;

    public List<Category> dsCategory() // getAllCategory()
    {
  
        // return null;

        // mã bởi lập trình viên:
        return kdl.findAll();
    }

    public List<Category>  duyệtCategory() 
    {
        return kdl.findAll();
    }

    public Category  tìmCategoryTheoId(int id)// 
    {
        // TODO Auto-generated method stub
        // return null;

        // return kdl.findById(id);

        Category dl = null;

        Optional<Category> optional = kdl.findById(id);

        if// nếu
        (optional.isPresent()) // tìm thấy bản ghi trong kho
        {
            dl = optional.get();
        } else// ngược lại
        {
            //throw new RuntimeException("Không tìm thấy thú cưng ! Ko tim thay thu cung !");
        }

        return dl;

    }

    public Category xemCategory(int id)// 
    {

        Category dl = null;

        Optional<Category> optional = kdl.findById(id);

        if// nếu
        (optional.isPresent()) // tìm thấy bản ghi trong kho
        {
            dl = optional.get();
        } else// ngược lại
        {
            //throw new RuntimeException("Không tìm thấy thú cưng ! Ko tim thay thu cung !");
        }

        return dl;

    }

        public void lưuCategory(Category dl)
    {
        // TODO Auto-generated method stub
        this.kdl.save(dl);
    }

        public void xóaCategory(int id)
    {
        // TODO Auto-generated method stub
        this.kdl.deleteById(id);
    }

     

}
