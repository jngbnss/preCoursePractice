package baseball.dto;
public class StrikeBallResultDto {
    private final int strike;
    private final int ball;
    private final int cnt;
    public StrikeBallResultDto(int strike, int ball,int cnt) {
        this.strike = strike;
        this.ball = ball;
        this.cnt = cnt;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
    //여기에 게터가 필요한가?


    @Override
    public String toString() {
        return strike + " 스트라이크, " + ball + " 볼, 시도 횟수 : "+cnt;
    }
}

