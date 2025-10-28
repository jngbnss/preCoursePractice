package theater.service;

import theater.model.TheaterModel;

public class TheaterService {
    private final TheaterModel theater;

    public TheaterService(TheaterModel theater) {
        this.theater = theater;
    }

    //좌석 예약
    public String reserveSeat(String seatId){
        if(!theater.isValid(seatId)){
            return "❌ 존재하지 않는 좌석입니다.";
        }
        if(theater.isReserved(seatId)){
            return "⚠️ 이미 예약된 좌석입니다.";
        }
        theater.reserve(seatId);
        return "✅ " + seatId + " 좌석 예약 완료!";
    }

    // 예약 취소
    public String cancelSeat(String seatId) {
        if (!theater.isValid(seatId)) {
            return "❌ 존재하지 않는 좌석입니다.";
        }
        if (!theater.isReserved(seatId)) {
            return "⚠️ 예약되지 않은 좌석입니다.";
        }
        theater.cancel(seatId);
        return "✅ " + seatId + " 좌석 취소 완료!";
    }

    // 전체 좌석 출력용 (뷰에서 호출할 수도 있음)
    public void printSeats() {
        var seats = theater.getSeats();
        for (var row : seats) {
            for (var seat : row) {
                System.out.print(seat + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    // 통계
    public void printStatus() {
        System.out.println("총 좌석 수: " + theater.getTotalSeats());
        System.out.println("예약된 좌석 수: " + theater.getReservedCount());
        System.out.println("남은 좌석 수: " + theater.getAvailableCount());
    }

}
