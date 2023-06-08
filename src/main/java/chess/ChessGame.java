package chess;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChessGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            System.out.println("명령을 입력하세요.");
            String command = br.readLine();
            if(command.equals("start")) {
                Board board = new Board();
                board.initialize();
                System.out.println(board.showBoard());
            } else if(command.equals("end")) {
                System.out.println("게임을 종료합니다.");
                break;
            } else {
                System.out.println("올바른 명령어를 입력하세요.");
            }
        }
        br.close();
    }
}
