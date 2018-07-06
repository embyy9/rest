# rest
rest api with spring boot, mysql


1. Import into eclipse as a maven project (I used eclipse photon along with Java 8) which will download all the dependent jars.
2. Turn on the local/remote mysql server.
3. Update the application.properties with the DB details (location: src/main/resources) 
4. Start the application by running BankApplication.java
5. For Post requests: - for creating/registering users url: /api/users                -use json format
                                   - for fetching all bank details use url: /users/banks       - use RequestHeader params (name and password)
                                   - for fetching user specific bank data use url: /users/banks/detail      - use RequestHeader params (name and password)
