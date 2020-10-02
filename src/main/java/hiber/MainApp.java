package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
      User carable = new User("Aaa", "Aovich", "asd@mail.ru");
      Car car = new Car("Testla", 3);
      carable.setCar(car);
      userService.add(carable);
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
      User another = new User("Qwe", "Qwevovich", "aqq@mail.ri");
      another.setCar(new Car("Vovla", 2));
      userService.add(another);
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println(user.toString());
      }
      System.out.println(userService.getUserByCar(car));
      context.close();
   }
}
