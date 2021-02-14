package rsp.ebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import rsp.ebook.entity.Order;
import rsp.ebook.service.OrderService;

import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private OrderService os;

    @ResponseBody
    @GetMapping(value = "/order")
    public Iterable<Order> getAllOrders(){
        return os.getAllOrders();
    }

    @ResponseBody
    @PostMapping(value = "/order")
    public Iterable<Order> getOrders(@RequestBody Map<String, String> map) {
        return os.getOrders(map);
    }

    @ResponseBody
    @PostMapping(value = "/order/add")
    public void createOrder(@RequestBody List<Map<String, String>> maps) {
        os.addOrder(maps);
    }

    @ResponseBody
    @PutMapping(value = "/order")
    public void modifyOrder(@RequestBody Order order) {
        os.modifyOrder(order);
    }

    @ResponseBody
    @DeleteMapping(value = "/order")
    public void deleteOrder(@RequestBody Order order) {
        os.deleteOrder(order);
    }
}
