
### 2024-01-03
- chat API
  * 레퍼런스
  * 작업과정
    - [ ] 인터페이스
      * GET /diary/${yyyymm}
        - out
          * diary: []
            - day: yyyymmdd
            - content
            - keyword
            - point
      * GET /chat/${yyyymmdd}
        - out
          * messages: []
            - timestamp: 
            - content: 
      * POST /feedback
        - in
          * messages: []
            - timestamp: 
            - content: 
          * yyyymmdd
        - out
          * feedback
          * <s>title</s> (삭제)
          * keyword
          * point
          * saveId
      * POST /save/${saveId}
        - in
          * keyword
          * point
        - out
          * result
    - [ ] Data 연동 
      * DB Scheme
      * DAO, VO


### 2024-01-01
- GPT API를 이용해서 일기 피드백 받기
  * 레퍼런스 
    - https://youtu.be/7LgRqbTSY8U?si=659zLEXlurcQ6B5K
    - https://www.baeldung.com/spring-boot-chatgpt-api-openai
    - https://platform.openai.com/playground/p/default-grammar?mode=chat
    
  * 작업과정
    - [x] GPT 패키지를 만들고
    - [x] Service와 테스트를 만들고
    - [x] Request, Reseponse
    - [x] 일기 피드백
    - [x] 리팩토링