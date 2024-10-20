package web.thaiticketmajor.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.thaiticketmajor.Models.User;
import web.thaiticketmajor.Repositories.KdlUser;

@Service
public class DvlUser 
{
    @Autowired private KdlUser kdl;// kho dữ liệu;

    public List<User> dsUser() // getAllUser()
    {
  
        // return null;

        // mã bởi lập trình viên:
        return kdl.findAll();
    }

    public List<User>  duyệtUser() 
    {
        return kdl.findAll();
    }

    public User  tìmUserTheoId(int id)// 
    {
        // TODO Auto-generated method stub
        // return null;

        // return kdl.findById(id);

        User dl = null;

        Optional<User> optional = kdl.findById(id);

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

    public User xemUser(int id)// 
    {

        User dl = null;

        Optional<User> optional = kdl.findById(id);

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

    
    public void lưuUser(User dl)
    {
        // TODO Auto-generated method stub
        this.kdl.save(dl);
    }

    
    public void xóaUser(int id)
    {
        // TODO Auto-generated method stub
        this.kdl.deleteById(id);
    }

}
