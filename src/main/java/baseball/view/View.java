package baseball.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private final Scanner scanner = new Scanner(System.in);
    //Model model = new Model();

    public List<Integer> getUserInput(){
        System.out.println("숫자를 입력하세요 (예: 1234)");

        // 문자가 들어왔을때 예외처리하기
        String input = scanner.nextLine().trim();
        List<Integer>guess = new ArrayList<>();
        //입출력만 담당하니까

        for(var c: input.toCharArray()){
            guess.add(c-'0');
        }
        return guess;
    }

    public void printResult(int strike,int ball){
        if(strike==0&&ball==0){
            System.out.println("낫싱!");
        }else{
            System.out.println(strike+" 스트라이크, "+ball+" 볼!");
        }
    }

    public void printWinMessage(int cnt){
        System.out.println("\uD83C\uDF89 정답입니다! 게임 종료 \uD83C\uDF89"+cnt+"회");
    }
    public void printAnswer(List<Integer>answer){
        System.out.println("정답(테스트용) = "+answer);
    }


}
