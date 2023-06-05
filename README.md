# be-java-chess-max
2023 마스터즈 맥스 보너스 프로젝트 체스

## 미션 첫째주(6/5 ~ 6/9) 구현계획
| 날짜    | 6/5(월)                | 6/6(화)                | 6/7(수)            |6/8(목)|6/9(금)|
|-------|-----------------------|-----------------------|-------------------|---|---|
| 구현 내용 | 체스 구현 시작하기<br>체스판 생성 | 체스판 초기화<br>모든 기물 배치하기 | 보드에 위치 부여 및 점수 계산 |기물 이동 구현|예외 처리|

## 구현 내용
### 체스 구현 시작하기
- 개발 환경 설정
  - [x] gradle project 생성하기
  - [x] build.gradle 수정하기
- Pawn Test 생성
  - [x] createWhitePawn() 메서드 작성: 컴파일도 되지 않는 메서드 생성
- Pawn Class 생성
  - [x] create() 메서드 작성: createWhitePawn() 메서드가 컴파일만 되고 실패하게 Pawn Class 생성
- PawnTest 수정하기
  - [x] createWhitePawn()을 createPawns 테스트로 변경: 검은색 Pawn을 생성하고 실패하는 테스트 작성
- Pawn Class 수정하기
  - [x] createPawns() 테스트가 통과하게 Pawn 클래스 수정하기
- 리팩토링
  - [x] createPawns() 테스트에 local variable을 추가해서 코드의 중복제거
  - [x] PawnTest Class에 verifyPawnColor메서드를 생성하여 메서드 분리하기

### 체스판 생성
- Pawn 수정하기
  - [x] 색깔 상수 만들기 
  - [x] 기본 생성자 추가하기: 기본적으로 color가 white이게 생성
- PawnTest 수정하기
  - [x] verifyPawnColor 메서드 삭제: 테스트 흐름상 메서드 분리를 하지 않는 것이 문맥에 자연스럽다고 생각합니다. 따라서 삭제합니다.
  - [x] createPawns() 메서드 분리: createWhitePawn과 createBlackPawn으로 분리
  - [x] createPawnUsingDefaultConstructor() 생성: 기본 생성자를 사용하여 pawn생성을 검증
- Board 구현
  - [x] 필드로 ArrayList를 가지게 설계
  - [x] add(): pawn을 board에 추가하는 메서드
  - [x] getSize(): board의 크기를 알려주는 메서드
  - [x] contains(): pawn이 리스트에 있는지 확인하는 메서드
- BoardTest 구현
  - [ ] createBoard(): Board 인스턴스가 잘 생성됐는지 확인
  - [ ] addWhitePawn(): white pawn이 잘 추가되는지 확인
  - [ ] addBlackPawn(): black pawn이 잘 추가되는지 확인
  - [ ] addMultiplePawns(): pawn들이 잘 추가되는지 확인
  - [ ] addNotPawn(): pawn 인스턴스가 아닌 다른 요소를 추가해보고 error 발생 확인
- 패키지 분리
  - [ ] Pawn class를 pieces 패키지로 옮김