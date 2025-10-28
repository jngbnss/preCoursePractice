package theater.view;

import camp.nextstep.edu.missionutils.Console;
import theater.model.Seat;

public class View {


    public void printSeatMap(Seat[][] seats){
        System.out.println("\n====== 현재 좌석 현황 ======");
        System.out.print(" "); // 열 번호 앞에 4칸 (행 이름 자리 확보)

        // 열 번호 출력
        for (int j = 0; j < seats[0].length; j++) {
            System.out.printf("%3d", j + 1);
            // 3칸 정렬
        }
        System.out.println();

        for (int i = 0; i < seats.length; i++) {
            System.out.print((char)('A'+i)+" ");
            for (int j = 0; j < seats[i].length; j++) {
                // 음 이건 뭐지? 아 첫번째 행의 있는 열의 갯수?
                System.out.print(seats[i][j]+" ");
            }
            System.out.println();
        }
    }public int showMianMenuAndGetChoice(){
        System.out.println("\n===== 메뉴 =====");
        System.out.println("1. 좌석 예약");
        System.out.println("2. 예약 취소");
        System.out.println("3. 좌석 현황 보기");
        System.out.println("4. 종료");
        System.out.print("선택 > ");
        return getIntInput();
    }

    private int getIntInput() {

        try{
            String input = Console.readLine();
            return Integer.parseInt(input.trim());
        }catch(NumberFormatException e){
            return -1;
        }
    }
    public String askForSeatInput(){
        System.out.println("좌석 입력 (예 : A1,A2) : ");
        return  Console.readLine().trim();
    }
    public void showMessage(String msg){
        System.out.println(msg);
    }
}
