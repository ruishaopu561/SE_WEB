package rsp.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import rsp.demo1.repository.BookReporitory;
import rsp.demo1.repository.CartRepository;
import rsp.demo1.module.Cart;
import rsp.demo1.module.Book;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartRepository cp;

    @Autowired
    private BookReporitory bp;

    @ResponseBody
    @GetMapping(value = "/cart")
    public Iterable<Cart> getCarts(){
        return cp.findAll();
    }

    @ResponseBody
    @PostMapping(value = "/cart")
    public Iterable<Cart> getCarts(@RequestBody String useremail){
//        System.out.println(useremail);
        return cp.findAllByUseremail(useremail);
    }

    @ResponseBody
    @PostMapping(value = "/addcart")
    public void createCart(@RequestBody Cart c){
        try{
            Cart cart = cp.findByUseremailAndBookname(c.getUseremail(),c.getBookname());
            if(cart == null){
                cp.save(c);
            }else{
                cart.setAmount(cart.getAmount() + 1);
                cp.saveAndFlush(cart);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Modifying
    @ResponseBody
    @PostMapping(value = "/modifyCart")
    public void setAmount(@RequestBody Cart c){
        try{
//            for(Cart c:modifyCarts){
//                System.out.println(c.getBookname());
//            System.out.println(c.getUseremail());
                Cart dbCart = cp.findByUseremailAndBookname(c.getUseremail(), c.getBookname());
                dbCart.setAmount(c.getAmount());
                dbCart.setPaied(true);


                System.out.println(c.getBookname());
                Book dbBook = bp.findByName(c.getBookname());
                System.out.println(dbBook);

//                if(dbBook != null){
                dbBook.setInventory(dbBook.getInventory()-c.getAmount());
                System.out.println(dbBook.getInventory()-c.getAmount());
                cp.saveAndFlush(dbCart);
                bp.saveAndFlush(dbBook);
//                }
//            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Modifying
    @Transactional
    @ResponseBody
    @PostMapping(value="/deletecart")
    public void deleteCarts(@RequestBody Cart c){
        try{
//            System.out.println(c.getBookname());
//            System.out.println(c.getUseremail());
            cp.deleteByUseremailAndBookname(c.getUseremail(), c.getBookname());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//    @ResponseBody
//    @PostMapping(value = "/cart")
//    public void createCart(Cart c){
//        cp.save(c);
//    }

//    @Modifying
//    @ResponseBody
//    @PostMapping(value = "/modifyCart")
//    public void setAmount(Cart c){
//        try{
//            Cart dbCart = cp.findByUseremailAndBookname(c.getUseremail(), c.getBookname());
//            dbCart.setAmount(c.getAmount());
//            dbCart.setPaied(c.isPaied());
//            cp.saveAndFlush(dbCart);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
//
//    @Modifying
//    @Transactional
//    @ResponseBody
//    @DeleteMapping(value = "/cart")
//    public void deleteCart(String useremail, String bookname){
//        try{
//            cp.deleteByUseremailAndBookname(useremail, bookname);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//    }
}
