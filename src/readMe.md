# ApplicationContext 제공하는 부가 기능

메세지 소스를 활용한 국제화 기능[MessageSource]
예를 들어서 한국에서 들어오면 한국어로 , 영어권에서 들어오면 영어로 출력
- 환경 변수 [EnviromentCapable]
  - 로컬,개발,운영등을 구분해서 처리
- 애플리케이션 이벤트[ApplicationEventPublisher]
  - 이벤트를 발생하고 구독하는 모델을 편리하게 지원
- 편리한 리소스 조회 [ResourceLoader]
  - 파일, 클래스 패스, 외부 등에서 리소스를 편리하게 조회