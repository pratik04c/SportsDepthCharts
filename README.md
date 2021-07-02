Steps to run the application:
1. Download and unzip the project.
2. Go to root directory in command prompt.
3. Execute "mvn clean install". 
4. If it says "'mvn' is not recognized as an internal or external command", probably need to set path for maven.
5. Execute "mvn spring-boot:run"
6. Use following APIs for the services

POST
http://localhost:8080/addPlayer
{
  "playerId": 1,
  "name": "Tom",
  "league": "NFL",
  "position": "JB",
  "positionDepth": 0
}

DEL
http://localhost:8080/removePlayer
{
  "playerId": 1,
  "league": "NFL",
  "position": "WR"
}

GET
http://localhost:8080/getFullDepthChart

POST
http://localhost:8080/getPlayersUnderPlayer
{
  "playerId": 1,
  "league": "NFL",
  "position": "WR"
}

Assumtion:
1. Data is not stored in DB, we have one static store instead globalPlayerList; We can replace that with DB store as required.
2. LinkedList is used considering depth of reserve players won't be very high. If that is high we may consider using BST instead.
3. Use case not considered, while adding one player in depth chart not checking whether already present. We can add that in future if required, but that will increase complexity, as searching in linkedlist will have O(n) complexity
