# SpringStudy
24.08 Spring start
관련 프로그램 설치

jdk(11버전) -> 환경변수(JAVA_HOME)
톰켓(9버전) -> 포트번호(ADMIN : 8000, HTTP 1.1 : 80)
이클립스 설치 안됨(마켓플레이스 SPRING 지원 종료) -> sts 3버전
lombok.jar(홈페이지에서 다운) -> d: 저장 -> cmd -> d: 엔터 -> java -jar lombok.jar -> 팝업에 install 클릭 -> close
sts 구동 -> d:\sts-workspace 경로 -> sts 구동 완료
new -> server 셋팅 -> tomcat 9.0 연동
프로젝트 생성시 처음 해야 할 것

이클립스 utf-8 인코딩(html, css, js)변경 -> 폰트 설치(d2 Coding 폰트)
mvc 프로젝트 생성 (프로젝트 우클릭 -> properties -> Resource (utf-8)) (sts인 경우 기존 프로젝트를 프로젝트 익스플로러에서 copy -> paste 프로젝명 변경 -> pom.xml에 8행 변경)
web.xml(2행)을 찾아서 톰켓 web.xml(17행)과 버전 일치
pom.xml을 찾아서 버전 관리
스프링 버전 5버전 이후로 설정 (12행)
jdk 버전 11버전 이후로 설정 (11, 141, 142행)
톰켓에 add -> 프로젝트 연결 -> 톰켓 더블클릭 -> Modules 탭에 / 컨텍스트패스 확인
톰켓 start -> 크롬 -> http://ip주소:포트/컨텍스트루트명(www) -> http://192.168.111.105/www (초기화면 나옴)
오라클 설치 -> 포트번호 1521 -> system/oracle -> cmd -> sqlplus system/oracle -> 사용할 계정 생성, 권한 부여 (이클립스에 있는 dataSource explorer를 활용)
프로젝트에 ojdbc8.jar 연결 -> 프로젝트 우클릭 -> Build Path -> Libraries -> Classpath : add -> Web DeploymentAssembly 확인
