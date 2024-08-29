package web.thaiticketmajor.Models.concert;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DvlConcert
{
    @Autowired private KdlConcert kdl;// kho dữ liệu;

     public List<Concert> dsConcert() // getAllConcert()
    {
  
        // return null;

        // mã bởi lập trình viên:
        return kdl.findAll();
    }

     public List<Concert>  duyệtConcert() 
    {
        return kdl.findAll();
    }

     public Concert  tìmConcertTheoId(int id)// 
    {
        // TODO Auto-generated method stub
        // return null;

        // return kdl.findById(id);

        Concert dl = null;

        Optional<Concert> optional = kdl.findById(id);

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

     public Concert xemConcert(int id)// 
    {

        Concert dl = null;

        Optional<Concert> optional = kdl.findById(id);

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

    
    public void lưuConcert(Concert dl)
    {
        // TODO Auto-generated method stub
        this.kdl.save(dl);
    }

    
    public void xóaConcert(int id)
    {
        // TODO Auto-generated method stub
        this.kdl.deleteById(id);
    }

}
