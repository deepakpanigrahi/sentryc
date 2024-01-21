Prerequisites:
- Java 17
- Docker
- maven 3.5 +

Steps to run :

- mvn clean install to run the unit tests and check everything is intact
- mvn spring-boot:run
- Navigare to http://localhost:8080/swagger-ui/index.html#/ hit the apis and operations mentioned
- //public enum State {
  REGULAR,
  WHITELISTED,
  GREYLISTED,
  BLACKLISTED;
- public enum SortValues {
- EXTERNAL_ID("externalId"), NAME("name"), MARKETPLACE_ID("marketPlace");
- use the above mentioned enums whereever necessary
- other default values are set
