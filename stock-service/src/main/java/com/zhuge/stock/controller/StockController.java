package com.zhuge.stock.controller;

import com.zhuge.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;
    @Autowired
    private Registration registration;

    @GetMapping(value = "/deduct/{productId}/{stockCount}")
    public String deductStock(@PathVariable("productId") Long productId,
                              @PathVariable("stockCount") Integer stockCount) {
        return stockService.deductStock(productId, stockCount);
    }

    @GetMapping("/getIpAndPort")
    public String getIpAndPort(@RequestParam("company") String company) {
        return company + " : " + registration.getHost() + ":" + registration.getPort();
    }
}
