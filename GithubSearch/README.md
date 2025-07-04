## 깃허브 유저 검색

메인 페이지.

 shimmerFrameLayout                                                                                                                           | 메인 페이지                                                                                                               
----------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------
 <img src="https://github.com/HamBeomJoon/Android-Toy-Project/assets/37996727/b0394b42-184d-408c-be00-42baa1605083" width="260" height="600"> | <img src="https://github.com/user-attachments/assets/78beb19c-aaf3-419e-b595-0f9416c098a8" width="260" height="600"> 

- 20명 랜덤 프로필 가져오기 (since 매개변수로 해당 id 이후 사람들 조회 가능, 1부터 1억 사이 랜덤값 넣어 줌 / pageSize 기본값 20 줌)
- 새로고침 버튼 클릭 시 새로 20명 조회
- 프로필 이미지, github Id, 팔로워 수 표시
- 유저 클릭 시 상세 페이지로 이동

----
검색 페이지.

 검색 페이지                                                                                                               |
----------------------------------------------------------------------------------------------------------------------|
 <img src="https://github.com/user-attachments/assets/229e5693-dea2-4e5b-92ad-565657dc7cbf" width="260" height="600"> |

- textCursorDrawable로 커서 색 변경
- 최근 검색어와 검색 날짜 표시
- 최근 검색어 추가, 삭제, 전체 삭제 기능
- 삭제 후 snackBar 표시

----
상세 페이지.

 상세 페이지                                                                                                               | 프로필 링크 연결                                                                                                            | 레포지토리 링크 연결                                                                                                          
----------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------
 <img src="https://github.com/user-attachments/assets/a3e9ca11-a807-41b7-830d-a302c524be85" width="260" height="600"> | <img src="https://github.com/user-attachments/assets/4cf40e49-af41-4447-8bb3-8bdc15ba62bc" width="260" height="600"> | <img src="https://github.com/user-attachments/assets/8bda38b7-06f7-4138-b784-ec0e5c0d55c7" width="260" height="600"> 

- 유저 프로필 사진, github id, location 조회
    - 링크 아이콘 클릭 시 깃허브 링크로 이동
- 레포지토리 목록 조회
    - 이름, description, language, visibility, createdAt, updatedAt 표시
    - description = null 일 때, visible gone 처리
    - most language별로 마커 색 표시
    - language = null일 때, visible gone 처리
    - 레포지토리 클릭 시 해당 레포지토리 깃허브 링크로 이동
    - fadingEdgeLength 속성을 통해 위 아래 리스트 페이드 효과 적용

----
