
#Go to acord-uganda/

cd acord-uganda/

mvn clean install

mvn clean dependency:copy-dependencies package

java -jar target/acord-uganda-1.0.0.jar 

mvn spring-boot:run
