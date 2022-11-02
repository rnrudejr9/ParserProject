# ParserProject
병원정보 DB저장 + SpringBoot Controller사용

---

* IDE : IntelliJ 2022.02.03
* DataBase : MYSQL + aws ec2
* Language : Java 11 + SpringBoot
* csv : 전국병원정보.csv

csv파일 한글깨짐 현상 해결 : https://koopi.tistory.com/14 

---
* Architecture

![image](https://user-images.githubusercontent.com/49141751/199157313-d69d9d27-377e-4694-ae1d-c6e0198eb559.png)

![image](https://user-images.githubusercontent.com/49141751/199157383-5dc2622f-37be-4499-bbe1-23ad7e4e1b27.png)

---

DataBase

|no|제목|내용|설명|
|---|---|---|---|
|1|id(pk)|Int|번호|
|2|open_service_name|VARCHAR(10)|개방서비스명|
|3|open_local_government_code|int|개방자치단체코드|
|4|management_number(unique)|varchar(40)|관리번호|
|5|license_date|datetime|인허가일자|
|6|business_status|tinyint(2)|영업상태|
|7|business_status_code|tinyint(2)|영업상태코드|
|8|phone|varchar(20)|소재지전화|
|9|full_address|VARCHAR(200)|소재지전체주소|
|10|road_name_address|VARCHAR(200)|도로명전체주소|
|11|hospital_name|VARCHAR(20)|사업장명(병원이름)|
|12|business_type_name|VARCHAR(10)|업태구분명|
|13|healthcare_provider_count|tinyint(2)|의료인수|
|14|patient_room_count|tinyint(2)|입원실수|
|15|total_number_of_beds|tinyint(2)|병상수|
|16|total_area_size|float|총면적|

