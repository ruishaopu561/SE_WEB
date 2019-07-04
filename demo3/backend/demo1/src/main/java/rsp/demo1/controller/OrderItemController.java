package rsp.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import rsp.demo1.service.OrderItemService;

@Controller
public class OrderItemController {

    @Autowired
    private OrderItemService ois;
//
//    @PostMapping(value = "/addorderitem")
//    public void addOrderItem(@RequestBody Map<String, String> map){
//        ois.addOrderItem(map);
//    }
//
//    @PostMapping(value = "/addorderitems")
//    public void addOrderItems(@RequestBody List<Map<String,String>> maps){
//        try{
//            for(Map<String,String> map:maps){
//                System.out.println(map);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
