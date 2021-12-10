<h1 align="center">Welcome to REST Assured API Testing with <a href="https://www.npmjs.com/package/readme-md-generator">
     <img src="https://img.shields.io/badge/java-ED8B00?style=for-the-badge&logo=java&logoColor=white"/>
     </a>
 👋</h1>


This repository contains a collection of sample REST Assured services for Testing and validating REST API's. We used couple of dependencies like `REST Assured` framework it is Open source, `Test-NG` for Organizing code and make SUIT, `JSON Simple` to deal with JSON Data, `Extent Reports` used to generate Dynamic Reports. It includes NPM package like 'JSON-SERVER' which generates fake API's for better Hand's On examples some practical.

<br>

## Requirements ✨


-   <a href="https://www.oracle.com/java/technologies/downloads/">
     <img src="https://img.shields.io/badge/-JAVA JDK V1.8.x-red?logo=java&logoColor=black&"/>
     </a>

-   <a href="https://maven.apache.org/">
     <img src="https://img.shields.io/badge/-Maven Apache-red?logo=Apache%20Maven&logoColor=white"/>
     </a>

-   <a href="https://nodejs.org/en/download/">
     <img src="https://img.shields.io/badge/-NPM V14.7-red?logo=NPM&logoColor=white"/>
     </a>

-   <a href="https://rest-assured.io/">
     <img src="https://img.shields.io/badge/-Rest Assured V4.4-brightgreen?logo=REST&logoColor=white"/>
     </a>

-  <a href="https://testng.org/doc/">
    <img src="https://img.shields.io/badge/-TEST NG V7.4.2-%233178C6?logo=TestNG&logoColor=black" />
    </a>

-  <a href="https://www.eclipse.org/downloads/">    
    <img src="https://img.shields.io/badge/Eclipse -violet?logo=eclipse&logoColor=brightblack" />
    </a>

-  <a href="https://www.postman.com/">
    <img src="https://img.shields.io/badge/-PostMan-orange?logo=postman&logoColor=brightblack">
    </a>
    
    <br>
    

## 🚀 UsageGetting Started
1. Clone Repository
```bash
    git clone https://github.com/raj-k98/APITestingUsingRESTAssured.git
```
2. Import Project to you Local IDE.

3. Install Node JS.
```bash
npm install
```
4. Install JSON-Server for fake Server:
```bash
npm install json-server
```
5. Run Fake Server:
```bash
npm start
npx json-server --watch data.json
```
### API Sources:
    - Localhost: http://localhost:3000/student
    - Localhost: http://localhost:3000/subject
    - ReqRes API: https://reqres.in/

### Run Test:
    - Open Local IDE Eclipes or IntelliJ
    - Select `TestNG.xml` file Right Click.
    - Click on `Run TestNG Suit`.

### Report:
    - After running `Run TestNg Suit` Refresh (F5) the Root directory of your project
    - Idenetify `Report` Folder under `index.html` file open it on your Default Browser (Chrome, FireFox, MicroSoftEdge .....)