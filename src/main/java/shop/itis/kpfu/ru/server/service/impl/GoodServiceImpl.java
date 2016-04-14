package shop.itis.kpfu.ru.server.service.impl;

import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shop.itis.kpfu.ru.server.repository.GoodRepository;
import shop.itis.kpfu.ru.client.service.GoodService;
import shop.itis.kpfu.ru.shared.model.Good;

import java.util.List;

/**
 * Created by eljah32 on 4/15/2016.
 */
@Service("goodService")
public class GoodServiceImpl implements GoodService{
    @Autowired
    GoodRepository goodRepository;

    @Override
    public String addGood(Good good) {
        good.setName("asda");
        goodRepository.save(good); return good.getName();
    }

    @Override
    public void buyGood(long id) {
        Good good=goodRepository.findOneById(id);
        good.setBought(true);
        goodRepository.save(good);
    }

    @Override
    public List<Good> getAllGoods() {
        return goodRepository.findAll();
    }
}
