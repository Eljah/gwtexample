package shop.itis.kpfu.ru.shared.model;

import javax.persistence.*;

/**
 * Created by eljah32 on 4/14/2016.
 */

@Entity
@Table(name = "users")
public class Good {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
