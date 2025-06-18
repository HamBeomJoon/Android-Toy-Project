## 깃허브 유저 검색

메인 페이지.

 shimmerFrameLayout                                                                                                                           | 메인 페이지                                                                                                               
----------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------
 <img src="https://github.com/HamBeomJoon/Android-Toy-Project/assets/37996727/b0394b42-184d-408c-be00-42baa1605083" width="260" height="600"> | <img src="https://github.com/user-attachments/assets/56eed15f-a76a-407d-8eba-cebf9b350cbf" width="260" height="600"> 

- 20명 랜덤 프로필 가져오기 (since 매개변수로 해당 id 이후 사람들 조회 가능, 1부터 1억 사이 랜덤값 넣어 줌 / pageSize 기본값 20 줌)
- 프로필 이미지, github Id, 팔로워 수 표시

----
검색 페이지.

 검색 페이지                                                                                                               |
----------------------------------------------------------------------------------------------------------------------|
 <img src="https://github.com/user-attachments/assets/b901d007-16e3-4e46-b079-d128da4bd82a" width="260" height="600"> |

- (최근 검색어 RoomDB 사용해서 추가 예정)

----
상세 페이지.

 상세 페이지                                                                                                               | 프로필 링크 연결                                                                                                            | 레포지토리 링크 연결                                                                                                          
----------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------|----------------------------------------------------------------------------------------------------------------------
 <img src="https://github.com/user-attachments/assets/4f3555cc-06a4-40b9-aecb-7dba1191ccf9" width="260" height="600"> | <img src="https://github.com/user-attachments/assets/4cf40e49-af41-4447-8bb3-8bdc15ba62bc" width="260" height="600"> | <img src="https://github.com/user-attachments/assets/8bda38b7-06f7-4138-b784-ec0e5c0d55c7" width="260" height="600"> 

- 유저 프로필 사진, github id, location 조회
    - 링크 아이콘 클릭 시 깃허브 링크로 이동
- 레포지토리 목록 조회
    - 이름, description, language, visibility, createdAt, updatedAt 표시
    - description = null 일 때, visible gone 처리
    - most language별로 마커 색 표시
    - language = null일 때, visible gone 처리
    - 레포지토리 클릭 시 해당 레포지토리 깃허브 링크로 이동

----
