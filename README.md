#  Parisien project

Spring MVC 기반으로 구현한 파리 여행 일정 생성 웹 애플리케이션입니다.
사용자가 아침/점심/저녁 옵션을 선택하면,
선택한 장소를 기반으로 하루 일정과 이동 구간을 계산하여 반환합니다.


##  프로젝트 목적

- Spring MVC 동작 흐름 이해
- Controller → Service → DTO 구조 학습
- 의존성 주입(Dependency Injection) 개념 이해
- REST API 기반 데이터 처리 경험


##  기술 스택

- Java 17
- Spring Boot
- Spring Web (REST Controller)
- Validation
- Gradle


##  프로젝트 구조
com.example.parisien
├── day
│ ├── DayPlanController
│ ├── DayPlanService
│ ├── DayPlan
│ ├── DayChoiceRequest
│ ├── DayItineraryResponse
│ ├── DayOption / DaySlot
│
├── place
│ ├── Place
│ ├── PlaceService
│
├── geo
│ ├── DistanceService
│
├── itinerary
│ ├── ItineraryLeg
│ ├── ItineraryStop
│ ├── TravelEstimator
│
└── ParisienApplication


##  핵심 기능

- 하루 일정 템플릿 조회
- 옵션 선택 기반 장소 매핑
- 장소 간 이동 거리 계산
- 이동 시간 추정
- 최종 일정 응답 반환


##  실행 방법

1. ParisienApplication 실행 또는 ./gradlew bootRun
2. 서버가 실행되면 http://localhost:8080 접속
3. API는 /days 또는 /days/{day}/submit 엔드포인트로 호출
