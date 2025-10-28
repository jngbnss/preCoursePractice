package baseball.controller;


import baseball.dto.StrikeBallResultDto;
import baseball.model.Model;
import baseball.view.View;
import java.util.List;

public class Controller {
    private final View view = new View();
    private final Model model = new Model();



    public void run(){
        //정답 출력 (원하면 삭제 가능)
        view.printAnswer(model.getAnswer());

        boolean isCorrect = false;
        while(!isCorrect){
            List<Integer> guess = view.getUserInput();
            StrikeBallResultDto dto = model.checkGuess(guess);

            view.printResult(dto.getStrike(),dto.getBall());
            if(dto.getStrike()==4){
                view.printWinMessage(model.getCnt());
                isCorrect=true;
            }
        }
    }

}
