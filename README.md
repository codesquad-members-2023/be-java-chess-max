# be-java-chess-max
2023 마스터즈 맥스 보너스 프로젝트 체스

## 미션 첫째주(6/5 ~ 6/9) 구현계획
| 날짜    | 6/5(월)                | 6/6(화)                | 6/7(수)            |6/8(목)|6/9(금)|
|-------|-----------------------|-----------------------|-------------------|---|---|
| 구현 내용 | 체스 구현 시작하기<br>체스판 생성 | 체스판 초기화<br>모든 기물 배치하기 | 보드에 위치 부여 및 점수 계산 |기물 이동 구현|예외 처리|

## 구현 내용
### 체스 구현 시작하기
#### 개발 환경 설정
  - [x] gradle project 생성하기
  - [x] build.gradle 수정하기 
#### Pawn Test 생성
  - [x] createWhitePawn() 메서드 작성: 컴파일도 되지 않는 메서드 생성
#### Pawn Class 생성
  - [x] create() 메서드 작성: createWhitePawn() 메서드가 컴파일만 되고 실패하게 Pawn Class 생성
#### PawnTest 수정하기
  - [x] createWhitePawn()을 createPawns 테스트로 변경: 검은색 Pawn을 생성하고 실패하는 테스트 작성
#### Pawn Class 수정하기
  - [x] createPawns() 테스트가 통과하게 Pawn 클래스 수정하기
#### 리팩토링
  - [x] createPawns() 테스트에 local variable을 추가해서 코드의 중복제거
  - [x] PawnTest Class에 verifyPawnColor메서드를 생성하여 메서드 분리하기

### 체스판 생성
#### Pawn 수정하기
  - [x] 색깔 상수 만들기 
  - [x] 기본 생성자 추가하기: 기본적으로 color가 white이게 생성
#### PawnTest 수정하기
  - [x] verifyPawnColor 메서드 삭제: 테스트 흐름상 메서드 분리를 하지 않는 것이 문맥에 자연스럽다고 생각합니다. 따라서 삭제합니다.
  - [x] createPawns() 메서드 분리: createWhitePawn과 createBlackPawn으로 분리
  - [x] createPawnUsingDefaultConstructor() 생성: 기본 생성자를 사용하여 pawn생성을 검증
#### Board 구현
  - [x] 필드로 ArrayList를 가지게 설계
  - [x] add(): pawn을 board에 추가하는 메서드
  - [x] getSize(): board의 크기를 알려주는 메서드
  - [x] contains(): pawn이 리스트에 있는지 확인하는 메서드
#### BoardTest 구현
  - [x] createBoard(): Board 인스턴스가 잘 생성됐는지 확인
  - [x] addWhitePawn(): white pawn이 잘 추가되는지 확인
  - [x] addBlackPawn(): black pawn이 잘 추가되는지 확인
  - [x] addPawns(): pawn들이 잘 추가되는지 확인
#### 패키지 분리
  - [x] Pawn class를 pieces 패키지로 옮김

### 보드 초기화하기
#### Pawn 수정하기
  - [x] 필드로 figure 추가하기
  - [x] 상수로 BLACK_FIGURE, WHITE_FIGURE 추가
  - [x] 생성자를 통해 figure 값을 입력받고 필드에 할당하기
  - [x] getFigure() 생성: figure를 리턴
  - [x] PawnTest에 figure 관련 테스트 만들기
#### Board 수정하기
  - [x] initialize() 생성: 
  - [x] print() 생성: board의 상태를 출력
    - [x] printBlackPawns(): board에 있는 검은 폰들을 출력
    - [x] printWhitePawns(): board에 있는 하얀 폰들을 출력
    - [x] printEmptyLine(): 빈 줄을 출력
  - [x] BoardTest에 관련 테스트 만들기
#### ChessGame 구현
  - [x] start를 입력하면 board를 초기화하기
  - [x] end 입력시 keepPlaying을 false로 변경
  - [x] printResult()생성: 게임 실행결과를 출력
  - [x] ChessGameTest 생성
#### Application 구현
  - [x] 스캐너를 통해 사용자로부터 문자열 입력받기
  - [x] 반복문을 사용하여 end가 입력될 때까지 게임 진행
#### 코드 재구조화(코드 넘나 드러운 것...)
  - Pawn 재구조화
    - 상수 네이밍 변경: 통일성을 위해 COLOR_WHITE, COLOR_BLACK을 WHITE_COLOR, BLACK_COLOR로 변경
    - isBlack(), isWhite() 메서드 추가
  - Board 재구조화
    - 상수 생성: emptyLine과 crlf의 모양정보, 폰의 최대 갯수를 따로 저장
    - initiatlize()에 초기화 기능 추가: 기존의 방식에서는 initialize()를 연속 호출하면 pawn들이 계속 추가되어 수정

### 모든 기물 배치하기
####  StringUtil 생성하기
- [x] appendNewLine() 생성: String에 lineSeperator를 추가해서 반환하는 메서드
- [x] Board 및 테스트 코드에서 appendNewLine()을 사용하게 변경
- [x] appendNewLine() 테스트 코드 작성
#### Pawn 변경
- [x] Piece로 이름 변경
- [x] 필드로 name 추가
- [x] 생성자를 private으로 변경하고 factory method 사용하여 생성하기
- [x] 변경된 내용에 맞게 다른 클래스 변경하기

### 보드에 위치 부여 및 점수 계산
#### Piece에 enum 생성
- [x] 색을 관리하는 Color 생성
- [x] 타입을 관리하는 Type 생성
- [x] 빈 Piece를 생성하는 createBlank() 생성
- [x] enum을 쓰도록 Piece의 메서드 변경
- [x] Piece의 메서드를호출하는 다른 클래스 변경
#### 보드에 위치 부여
- [x] Rank 클래스 생성: 체스의 한 줄을 관리하는 클래스
- [x] pieces를 Map<Integer, Rank>로 변경
- [x] 변경에 따른 클래스의 코드 변경
- [x] getPieceAt(): 좌표를 입력시 해당하는 기물을 반환
- [x] insert(): 해당 좌표에 Piece를 삽입
#### 점수 부여하기
- [x] Type enum에 점수 추가하기
- [x] board의 기물 상태에 따른 점수 계산하기
  - [x] Pawn의 경우 다르게 계산한기

### 이쯤에서 하는 재구조화
#### 패키지 정리
- [x] pieces 패키지에 Rank와 Board 추가하기
- [x] Controller 패키지에 ChessGame 추가하기
- [x] 테스트 코드들도 각각 패키지를 만들어서 관리하기
#### Piece 변경안
- [x] 이넘에 있는 메서드 삭제: 이넘의 메서드에서 이넘의 픨드를 접근하는게 불필요하다고 생각했습니다. Piece에서 모든 값을 제어하게 했습니다.
- [x] is~메서드 정리: 각 타입, 색깔에 대한 메서드를 만드니 많은 메서드를 가지게 되었습니다.   
    코드의 중복이 많기에 재사용이 가능한 코드를 만들고자 isBlank()를 제외한 is~ 메서드를 isColor(), isType()으로 메서드를 변경했습니다.
- [x] getColor(), getType() 삭제: isType(), isColor()메서드로 대체가능하다고 생각합니다. 불필요한 메서드여서 삭제합니다.
#### Rank 변경안
- [x] count 메서드 정리: 수많은 count메서드가 있는데 매개변수로 color, type을 입력하는 메서드로 변경하여 재사용성을 높였습니다.
