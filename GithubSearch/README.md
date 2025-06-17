## 깃허브 유저 검색


shimmerFrameLayout 설정

<img src="https://github.com/HamBeomJoon/Android-Toy-Project/assets/37996727/b0394b42-184d-408c-be00-42baa1605083" width="260" height="600">

----
메인 페이지.
- 20명 랜덤 프로필 가져오기 (since 매개변수로 해당 id 이후 사람들 조회 가능, 1부터 1억 사이 랜덤값 넣어 줌 / pageSize 기본값 20 줌)
- 프로필 이미지, github Id 표시 (지역도 표시하려 했으나, 상세조회에 들어가야지 볼 수 있음. 추후에 해당 유저 상세페이지까지 호출해서 지역 얻어오는 등 추가 예정)
<img src="https://github.com/user-attachments/assets/56eed15f-a76a-407d-8eba-cebf9b350cbf" width="260" height="600">

----
검색 페이지. 
- (최근 검색어 RoomDB 사용해서 추가 예정)
<img src="https://github.com/user-attachments/assets/b901d007-16e3-4e46-b079-d128da4bd82a" width="260" height="600">

----
상세 페이지.
- 유저 프로필 사진, github id, location 조회
- 레포지토리 목록 조회
  - 이름, description, language, visibility, createdAt, updatedAt 표시
  - description = null 일 때, visible gone 처리
  - most language별로 마커 색 표시
  - language = null일 때, visible gone 처리
<img src="https://github.com/user-attachments/assets/18881a69-893c-40a6-a268-71823dada909" width="260" height="600">

----
