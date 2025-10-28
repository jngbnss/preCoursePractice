package theater;


import theater.controller.Controller;
import theater.model.TheaterModel;
import theater.service.TheaterService;

public class Application {
    public static void main(String[] args) {
        TheaterModel model = new TheaterModel(5, 5); // 5x5 좌석 예시
        TheaterService service = new TheaterService(model);
        Controller controller = new Controller(service);

        controller.run();
    }
}
