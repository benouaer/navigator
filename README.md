# Navigator
- this application exposes two main APIs
  - a navigation API under ``/navigate``, which simulates a robot navigating through a rectangular grid
  - a persistence API under ``/navigations``, which retrieves records of previously run navigations

## To build the application
- run the following command in a terminal window
    ```
    ./mvnw clean verify
    ```
  
## To run the application
- run the following command in a terminal window

    ```
    ./mvnw spring-boot:run
    ```
- to test the navigation API, run the following command in a separate terminal window/tab.
    ```
    curl -X POST "http://localhost:8080/navigate" -H "accept: */*" -H "Content-Type: application/json" -d "{ \"roomSize\": [5,5], \"coords\": [1,2], \"patches\": [[1,0],[2,2],[2,3]], \"instructions\": \"NNESEESWNWW\"}"
    ```
  this should return the result of the operation in the form
  ```
  {"coords":[1,3],"patches":1}
  ```
- to test the persistence API, load either of the following URLs in a web browser:
  - single record url 
    ```
    http://localhost:8080/navigations/1
    ```
    where 1 is navigation ID. this should return a single navigation record (request, response) in the form
    ```
    {"id":1,"createdDate":[2022,12,13],"request":{"roomSize":[5,5],"coords":[1,2],"patches":[[1,0],[2,2],[2,3]],"instructions":"NNESEESWNWW"},"response":{"coords":[1,3],"patches":1}}
    ```
  - all records url
    ```
    http://localhost:8080/navigations
    ```
    this should return any navigation records that have been created in the form
    ```
    [{"id":1,"createdDate":[2022,12,13],"request":{"roomSize":[5,5],"coords":[1,2],"patches":[[1,0],[2,2],[2,3]],"instructions":"NNESEESWNWW"},"response":{"coords":[1,3],"patches":1}}]
    ```
