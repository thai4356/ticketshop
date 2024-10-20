package web.thaiticketmajor.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.thaiticketmajor.Models.Concert;
import web.thaiticketmajor.Models.Image;
import web.thaiticketmajor.Repositories.KdlConcert;
import web.thaiticketmajor.Repositories.Kdl_img;

@Service
public class DvlConcert
{
    @Autowired private KdlConcert kdl;// kho dữ liệu;

     public List<Concert> dsConcert() // getAllConcert()
    {
        return kdl.findAll();
    }

     public List<Concert>  duyệtConcert() 
    {
        return kdl.findAll();
    }

    @Autowired private Kdl_img kdls;
    public List<Image>  duyệtImage() 
    {
        return kdls.findAll();
    }


     public Concert  tìmConcertTheoId(int id)// 
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
