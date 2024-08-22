1. lombok을 프로젝트에 적용 (35행)
<dependency>
<!-- lombok 실행 코드 주입 -->
<!-- https://mvnrepository.com/artifact/org.projectlombok/lombok -->
    <groupId>org.projectlombok</groupId>
	    <artifactId>lombok</artifactId>
	    <version>1.18.24</version>
	    <scope>provided</scope>
</dependency>


2. spring-test 코드 주입
<dependency>
	<!-- spring-test 코드 주입 -> log를 작성 log4j를 log4j2로 변경-->
	<groupId>org.springframework</groupId>
	<artifactId>spring-test</artifactId>
	<version>${org.springframework-version}</version> <!-- 위에 정의된 버전 활용-->
</dependency>


4. spring은 system.out.println안씀 -> log.info (log4j2) -> resources 폴더에 log4.xml 삭제 -> log4j2.xml 교체
<dependency> 
	<!-- log4j2 활성화 : resources log4j2.xml 변경 https://logging.apache.org/log4j/2.x/maven-artifacts.html -->
	    <groupId>org.apache.logging.log4j</groupId>
	    <artifactId>log4j-api</artifactId>
	    <version>2.18.0</version>
</dependency>
<dependency>
	    <groupId>org.apache.logging.log4j</groupId>
	    <artifactId>log4j-core</artifactId>
	    <version>2.18.0</version>
</dependency>


6. junit 버전 상향 137행
<dependency>
	<!-- Test -->
	<!-- 메스드별 테스트 진행용 -->
	<groupId>junit</groupId>
	<artifactId>junit</artifactId>
	<version>4.12</version>
	<scope>test</scope>
</dependency> 

8. sts에서 pom.xml 첫줄 오류 해결 (plugins 아래쪽에 삽입)
<plugin>
<!-- https://mvnrepository.com/artifact/org.apache.maven.plugins/maven-war-plugin -->
	<groupId>org.apache.maven.plugins</groupId>
	<artifactId>maven-war-plugin</artifactId>
	<version>3.3.2</version>
</plugin>
