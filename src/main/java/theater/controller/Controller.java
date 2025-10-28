package theater.controller;
import camp.nextstep.edu.missionutils.Console;
import theater.service.TheaterService;

public class Controller {

    private final TheaterService service;

    public Controller(TheaterService service) {
        this.service = service;
    }
    public void run(){
        while(true){
            System.out.println("🎬 [1] 좌석 보기  [2] 예약  [3] 취소  [4] 통계  [0] 종료");
            System.out.print("선택: ");
            String input = Console.readLine();  // Scanner 대신 Console 사용

            switch (input) {
                case "1" -> service.printSeats();
                case "2" -> {
                    System.out.print("예약할 좌석 ID 입력: ");
                    String seatId = Console.readLine();  // 입력 받기
                    System.out.println(service.reserveSeat(seatId));
                }
                case "3" -> {
                    System.out.print("취소할 좌석 ID 입력: ");
                    String seatId = Console.readLine();
                    System.out.println(service.cancelSeat(seatId));
                }
                case "4" -> service.printStatus();
                case "0" -> {
                    System.out.println("🎭 프로그램을 종료합니다.");
                    return;
                }
                default -> System.out.println("❗ 잘못된 입력입니다.");
            }
        }
    }
}
