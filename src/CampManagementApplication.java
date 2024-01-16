import model.Score;
import model.Student;
import model.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Notification
 * Java, 객체지향이 아직 익숙하지 않은 분들은 위한 소스코드 틀입니다.
 * main 메서드를 실행하면 프로그램이 실행됩니다.
 * model 의 클래스들과 아래 (// 기능 구현...) 주석 부분을 완성해주세요!
 * 프로젝트 구조를 변경하거나 기능을 추가해도 괜찮습니다!
 * 구현에 도움을 주기위한 Base 프로젝트입니다. 자유롭게 이용해주세요!
 */
public class CampManagementApplication {
    // 데이터 저장소
    private static List<Student> studentStore; // 고유 번호, 이름, 과목 목록, 점수 목록
    private static List<Subject> subjectStore; // 고유 번호, 과목명, 과목타입(필수, 선택)
    private static List<Score> scoreStore; // 과목 고유 번호, 수강생 고유 번호, 회차, 점수, 등급

    // 과목 타입
    private static String SUBJECT_TYPE_MANDATORY = "MANDATORY";
    private static String SUBJECT_TYPE_CHOICE = "CHOICE";

    // index 관리 필드
    private static int studentIndex;
    private static final String INDEX_TYPE_STUDENT = "ST";
    private static int subjectIndex;
    private static final String INDEX_TYPE_SUBJECT = "SU";
    private static int scoreIndex;
    private static final String INDEX_TYPE_SCORE = "SC";

    // 스캐너
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        setInitData();
        try {
            displayMainView();
        } catch (Exception e) {
            System.out.println("\n오류 발생!\n프로그램을 종료합니다.");
        }
    }

    // 초기 데이터 생성
    private static void setInitData() {
        studentStore = new ArrayList<>();
        subjectStore = List.of(
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Java",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "객체지향",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "JPA",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MySQL",
                        SUBJECT_TYPE_MANDATORY
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "디자인 패턴",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Spring Security",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "Redis",
                        SUBJECT_TYPE_CHOICE
                ),
                new Subject(
                        sequence(INDEX_TYPE_SUBJECT),
                        "MongoDB",
                        SUBJECT_TYPE_CHOICE
                )
        );
        scoreStore = new ArrayList<>();
    }

    // index 자동 증가
    private static String sequence(String type) {
        switch (type) {
            case INDEX_TYPE_STUDENT:
                studentIndex++;
                return INDEX_TYPE_STUDENT + studentIndex;
            case INDEX_TYPE_SUBJECT:
                subjectIndex++;
                return INDEX_TYPE_SUBJECT + subjectIndex;
            default:
                scoreIndex++;
                return INDEX_TYPE_SCORE + scoreIndex;
        }
    }

    private static void displayMainView() throws InterruptedException {
        boolean flag = true;
        while (flag) {
            System.out.println("\n==================================");
            System.out.println("내일배움캠프 수강생 관리 프로그램 실행 중...");
            System.out.println("1. 수강생 관리");
            System.out.println("2. 점수 관리");
            System.out.println("3. 프로그램 종료");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    displayStudentView();
                    break;
                case 2:
                    displayScoreView();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다.\n되돌아갑니다!");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }

        }
        System.out.println("프로그램을 종료합니다.");
    }

    private static void displayStudentView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("수강생 관리 실행 중...");
            System.out.println("1. 수강생 등록");
            System.out.println("2. 수강생 목록 조회");
            System.out.println("3. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    inquireStudent();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                    break;
            }
        }
    }

    // 수강생 등록
    private static void createStudent() {
        System.out.println("\n수강생을 등록합니다...");
        System.out.print("수강생 이름 입력: ");
        String studentName = sc.next();
        // 기능 구현 (필수 과목, 선택 과목)
        Student student = new Student(); // 수강생 인스턴스 생성 예시 코드
        student.setStudentId(sequence(INDEX_TYPE_STUDENT));
        student.setStudentName(studentName);
        System.out.println("\n[ 필수 과목 ]");
        for (int i = 0; i < subjectStore.size(); i++) {
            if (subjectStore.get(i).getSubjectType().equals("MANDATORY")) {
                System.out.println("과목명: "+subjectStore.get(i).getSubjectName() +" | 과목코드: "+ subjectStore.get(i).getSubjectId());
            }
        }

        System.out.println("\n[ 선택 과목 ]");
        for (int i = 0; i < subjectStore.size(); i++) {
            if (subjectStore.get(i).getSubjectType().equals("CHOICE")) {
                System.out.println("과목명: " + subjectStore.get(i).getSubjectName()+" | 과목코드: "+subjectStore.get(i).getSubjectId());
            }
        }

        List<Subject> mandatorySubjects;
        do {
            System.out.print("필수 과목 입력(','로 구분, 과목 코드로 입력) *주의: 3개이상 입력: ");
            sc.nextLine();
            mandatorySubjects = subjectinput("MANDATORY");
        } while (mandatorySubjects.size()<3);

        List<Subject> choiceSubjects;
        do{
            System.out.print("선택 과목 입력(','로 구분, 과목 코드로 입력) *주의: 2개이상 입력: ");
            choiceSubjects = subjectinput("CHOICE");
        } while (choiceSubjects.size()<2);

        student.setSelectedmandatoryList(mandatorySubjects);
        student.setSelectedchoiceList(choiceSubjects);

        System.out.println("- 선택된 과목 -");
        System.out.print("[필수 과목] ");
        for(Subject c : student.getSelectedmandatoryList()){
            System.out.print(c.getSubjectName() + ", ");
        }
        System.out.println();
        System.out.print("[선택된 과목] ");
        for(Subject c : student.getSelectedchoiceList()){
            System.out.print(c.getSubjectName() + ", ");
        }
        System.out.println();
        // 기능 구현
        System.out.println("수강생 등록 성공!\n");
        studentStore.add(student);
    }
    private static List<Subject> subjectinput(String subjectType){
        String input = sc.next();
        String[] values = input.split(",");

        List<Subject> temp = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            for (int j = 0; j < subjectStore.size(); j++) {
                if (values[i].equals(subjectStore.get(j).getSubjectId())
                        && subjectStore.get(j).getSubjectType().equals(subjectType)) {
                    temp.add(subjectStore.get(j));
                }
            }
        }
        return temp;
    }
    // 수강생 목록 조회
    private static void inquireStudent() {
        System.out.println("\n수강생 목록을 조회합니다...");
        for (Student student : studentStore) {
            System.out.println("학생 이름: " + student.getStudentName());
            System.out.println("학생 번호: " + student.getStudentId());
            System.out.println("선택한 필수 과목:");
            for (Subject mand : student.getSelectedmandatoryList()) {
                System.out.print("  - 과목 이름: " + mand.getSubjectName());
                System.out.println(" / 과목 유형: " + "필수 과목");
            }

            System.out.println("선택한 선택 과목:");
            for (Subject choice : student.getSelectedchoiceList()) {
                System.out.print("  - 과목 이름: " + choice.getSubjectName());
                System.out.println(" / 과목 유형: " + "선택 과목");
            }

            System.out.println("---------------");
        }
        // 기능 구현
        System.out.println("\n수강생 목록 조회 성공!");
    }

    private static void displayScoreView() {
        boolean flag = true;
        while (flag) {
            System.out.println("==================================");
            System.out.println("점수 관리 실행 중...");
            System.out.println("1. 수강생의 과목별 시험 회차 및 점수 등록");
            System.out.println("2. 수강생의 과목별 회차 점수 수정");
            System.out.println("3. 수강생의 특정 과목 회차별 등급 조회");
            System.out.println("4. 메인 화면 이동");
            System.out.print("관리 항목을 선택하세요...");
            int input = sc.nextInt();

            switch (input) {
                case 1:
                    createScore();
                    break;
                case 2:
                    updateRoundScoreBySubject();
                    break;
                case 3:
                    inquireRoundGradeBySubject();
                    break;
                case 4:
                    flag = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다.\n메인 화면 이동...");
                    flag = false;
                    break;
            }

        }
    }

    private static String getStudentId() {
        System.out.print("\n관리할 수강생의 번호를 입력하시오...");
        return sc.next();
    }

    // 수강생의 과목별 시험 회차 및 점수 등록
    private static void createScore() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        System.out.println("시험 점수를 등록합니다...");
        System.out.println("과목 목록:");

        for (Student student : studentStore){
            if(studentId.equals(student.getStudentId())){
                System.out.println("- " + student.getStudentName() + " 학생의 과목 -");
                System.out.println("[필수과목]");
                for(Subject subject:student.getSelectedmandatoryList()){
                    System.out.println("과목 이름: "+ subject.getSubjectName() + " | 과목 코드: " + subject.getSubjectId());
                }
                System.out.println("[선택과목]");
                for(Subject subject:student.getSelectedchoiceList()){
                    System.out.println("과목 이름: "+ subject.getSubjectName() + " | 과목 코드: " + subject.getSubjectId());
                }
            }
        }

        Student selectedStudent = null;
        for (Student storedStudent : studentStore) {
            if (storedStudent.getStudentId().equals(studentId)) {
                selectedStudent = storedStudent;
                break;
            }
        }

        System.out.print("과목을 선택하세요: ");
        String selectedSubjectId = sc.next();
        Subject selectedSubject = null;
        for (Subject subject : subjectStore) {
            if (subject.getSubjectId().equals(selectedSubjectId) &&
                    (selectedStudent.getSelectedmandatoryList().contains(subject) || selectedStudent.getSelectedchoiceList().contains(subject))){
                selectedSubject = subject;
                break;
            }
        }

        if (selectedSubject == null) {
            System.out.println("잘못된 과목 선택입니다.");
            return;
        }

        System.out.print("시험 회차를 입력하세요: ");
        int round = sc.nextInt();

        System.out.print("시험 점수를 입력하세요: ");
        int scoreValue = sc.nextInt();

        Score score = new Score(sequence(INDEX_TYPE_SCORE), studentId, selectedSubject, round, scoreValue);
        scoreStore.add(score);
        // 기능 구현
        System.out.println("\n점수 등록 성공!");
    }

    // 수강생의 과목별 회차 점수 수정
    private static void updateRoundScoreBySubject() {
        String studentId = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현 (수정할 과목 및 회차, 점수)

        Student selectedStudent = null;
        for (Student storedStudent : studentStore) {
            if (storedStudent.getStudentId().equals(studentId)) {
                selectedStudent = storedStudent;
                break;
            }
        }

        if (selectedStudent == null) {
            System.out.println("없는 학생입니다.");
            return;
        }


        for (Student student : studentStore){
            if(studentId.equals(student.getStudentId())){
                System.out.println("- " + student.getStudentName() + " 학생의 과목 -");
                System.out.println("[필수과목]");
                for(Subject subject:student.getSelectedmandatoryList()){
                    System.out.println("과목 이름: "+ subject.getSubjectName() + " | 과목 코드: " + subject.getSubjectId());
                }
                System.out.println("[선택과목]");
                for(Subject subject:student.getSelectedchoiceList()){
                    System.out.println("과목 이름: "+ subject.getSubjectName() + " | 과목 코드: " + subject.getSubjectId());
                }
            }
        }

        System.out.print("조회할 과목: ");
        String selectedSubjectId = sc.next();
        Subject selectedSubject = null;
        for (Subject subject : subjectStore) {
            if (subject.getSubjectId().equals(selectedSubjectId)) {
                selectedSubject = subject;
                break;
            }
        }

        System.out.print("조회할 회차를 입력하세요: ");
        int round = sc.nextInt();

        for (Score score : scoreStore) {
            if (score.getStudentId().equals(studentId)
                    && score.getSubject().equals(selectedSubject)
                    && score.getRound() == round) {
                System.out.println("점수: " + score.getScoreValue());
                System.out.println("시험 점수를 수정합니다...");
                System.out.print("점수를 입력하세요: ");
                int num = sc.nextInt();

                score.setScoreValue(num);
                System.out.println("점수: " + score.getScoreValue());

                break;
            }
        }

        // 기능 구현

        System.out.println("\n점수 수정 성공!");
    }

    // 수강생의 특정 과목 회차별 등급 조회
    private static void inquireRoundGradeBySubject() {
        System.out.println("- 현재 존재하는 수강생 -");
        for(Student student: studentStore){
            System.out.println(student.getStudentId() +" : " + student.getStudentName());
        }
        String studentId_inquire = getStudentId(); // 관리할 수강생 고유 번호
        // 기능 구현 (조회할 특정 과목)
        for (Student student : studentStore){
            if(studentId_inquire.equals(student.getStudentId())){
                System.out.println("- " + student.getStudentName() + " 학생의 과목 -");
                System.out.println("[필수과목]");
                for(Subject subject:student.getSelectedmandatoryList()){
                    System.out.println("과목 이름: "+ subject.getSubjectName() + " | 과목 코드: " + subject.getSubjectId());
                }
                System.out.println("[선택과목]");
                for(Subject subject:student.getSelectedchoiceList()){
                    System.out.println("과목 이름: "+ subject.getSubjectName() + " | 과목 코드: " + subject.getSubjectId());
                }
            }
        }
        String subjectId_inquire = getSubjectId();
        //System.out.println("해당 과목의 회차별 등급을 조회합니다...");
        // 기능 구현
        String selectedStudent = null;
        for (Student student : studentStore){
            if(studentId_inquire.equals(student.getStudentId())){
                selectedStudent = student.getStudentName();
            }
        }
        String selectedSubject = null;
        for (Subject subject : subjectStore){
            if(subjectId_inquire.equals(subject.getSubjectId())){
                selectedSubject = subject.getSubjectName();
            }
        }
        System.out.println(selectedStudent + " 수강생의 "+selectedSubject+" 과목의 회차별 점수를 조회합니다...");
        for (int i = 0; i < scoreStore.size(); i++){
            if(studentId_inquire.equals(scoreStore.get(i).getStudentId()) && subjectId_inquire.equals(scoreStore.get(i).getSubject().getSubjectId())){
                System.out.println(scoreStore.get(i).getSubject().getSubjectName() +" 과목의 "+ scoreStore.get(i).getRound() + "회차 점수: " + scoreStore.get(i).getScoreValue() + " / 등급: " + scoreStore.get(i).getGrade());
            }
        }
        System.out.println("\n등급 조회 성공!");
    }
    private static String getSubjectId(){
        System.out.print("\n조회할 과목의 번호를 입력하시오...");
        return sc.next();
    }

}