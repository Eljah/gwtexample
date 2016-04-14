package shop.itis.kpfu.ru.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import shop.itis.kpfu.ru.client.service.GoodService;
import shop.itis.kpfu.ru.shared.model.Good;

import java.util.List;

/**
 * Created by eljah32 on 4/15/2016.
 */
@Controller(value = "/goods")
public class GoodController {
    @Autowired
    GoodService goodService;

    @RequestMapping(value = "/all")
    public String getIndexPage(Model model)

    {
        List<Good> goods=goodService.getAllGoods();
        model.addAttribute("goods",goods);
        //return "redirect:/goods";
        return "hello";
    }

    @RequestMapping(value = "/buy")
    public String buyAGood(@RequestParam(value = "id", required = false) long id,Model model)

    {
        goodService.buyGood(id);
        return "redirect:/goods/all";
    }


}
