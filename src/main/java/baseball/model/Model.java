package baseball.model;

import baseball.dto.StrikeBallResultDto;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Model {
    //1~9 어떻게 만들면 좋을까
    private List<Integer> answer;
    // 왜 리스트 인티저로 받는게 좋은거지?
    /**
     * 동적으로 추가 가능
     * 중복 검사 용이
     * 리스트는 순서를 유지
     * 배열과 비교
     * 배열도 가능하지만 크기를 미리 지정해야하고, 중복 체크를 하려면 번거로움
     */
    private int cnt;

    public int getCnt() {
        return cnt;
    }

    public Model() {
        answer = generateAnswer();
        //System.out.println("정답(디버깅용) = "+answer);
    }

    private List<Integer> generateAnswer(){
        List<Integer> numbers = new ArrayList<>();
        for(int i=1;i<10;i++){
            numbers.add(i);
        }
        Collections.shuffle(numbers);
       //answer = numbers.subList(0,4);
        // subList를 새 ArrayList로 감싸서 안전하게 복사
        return  new ArrayList<>(numbers.subList(0, 4));
    }



    public StrikeBallResultDto checkGuess(List<Integer>guess){

        int strike = 0;
        int ball = 0;

        for(int i=0;i<4;i++){
            if(guess.get(i).equals(answer.get(i))){
                strike++;
            }else if(answer.contains(guess.get(i))){
                ball++;
                //리스트 메서드를 알면 좋을것같은데 컬렉션 공부를 해볼까

            }
        }
        cnt++;
        return new StrikeBallResultDto(strike,ball,cnt);
    }

    // 정답을 외부에서 볼 수 있게 하는 메서드
    public List<Integer> getAnswer() {
        return new ArrayList<>(answer); // 복사해서 안전하게 반환
    }

}