package rsp.demo1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rsp.demo1.entity.Orders;
import rsp.demo1.service.OrderService;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private OrderService os;

    @ResponseBody
    @PostMapping(value = "/order")
    public Iterable<Orders> getOrders(@RequestBody Map<String, String> map){ return os.getOrders(map); }

    @ResponseBody
    @PostMapping(value = "/addorder")
    public void createOrder(@RequestBody List<Map<String, String>> maps){ os.addOrder(maps); }

    @ResponseBody
    @PostMapping(value = "modifyorder")
    public void modifyOrder(@RequestBody Orders order){
        os.modifyOrder(order);
    }

    @ResponseBody
    @PostMapping(value = "/deleteorder")
    public void deleteOrders(@RequestBody Orders order){ os.deleteOrder(order); }
}
