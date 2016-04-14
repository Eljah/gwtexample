package shop.itis.kpfu.ru.server;

import shop.itis.kpfu.ru.client.GreetingService;
import org.springframework.stereotype.Service;

@Service("greetingService")
public class GreetingServiceImpl implements GreetingService {

    @Override
    public String greet(String name) {
        return "Hello, " + name + "!";
    }
}
