# Java Project - 캠프 관리 프로그램
Java를 이용한 수강생 관리 프로그램

## ⛺요구사항
캠프에는 필수 과목과 선택 과목이 존재
-필수과목(Java, 객체지향, Spring, JPA, MySQL)
-선택과목(디자인 패턴, Spring Security, Redis, MongoDB)

수강생들은 최소 3개 이상의 필수 과목과 2개 이상의 선택 과목 선택

점수에 따라 등급이 매겨짐

필수과목
|A|B|C|D|F|N|
|------|---|---|
|95 ~ 100|90 ~ 94|80 ~ 89|70 ~ 79|60 ~ 69|60점 미만|

선택과목
|A|B|C|D|F|N|
|------|---|---|
|90 ~ 100|80 ~ 89|70 ~ 79|60 ~ 69|50 ~ 59|50점 미만|

## 📌주요기능

createStudent() - 수강생 등록
inquireStudent() - 수강생 목록 조회
createScore() - 수강생의 과목별 시험 회차 및 점수 등록
updateRoundScoreBySubject() - 수강생의 과목별 회차 점수 수정
inquireRoundGradeBySubject() - 수강생의 특정 과목 회차별 등급 조회

