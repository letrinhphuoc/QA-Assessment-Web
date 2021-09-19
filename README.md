# Xendit - QA - Assessment: 

## I. FW Overview
 - Ability to execute the tests on different browsers.
 - Ability to execute all or selective tests (based on cucumber tag) through the command line.
 - Ability to share the data between the test steps.

### The test automation framework is comprised of following tools and libraries

- Cucumber-JVM + TestNG: BDD Framework
- Step definitions with lambda expressions (cucumber-java8)
- Page Object Pattern
- Selenium: Browser automation tool
- JAVA: Programming language
- Maven: Build and dependencies tool
- Google Guice: Dependency Injection
- Intellij: Integrated Development Environment
- Cucumber-report-plugin: Reporting
- OCR- Tesseract
### How to fix Tesseract on MacOS:
- I did implement two ways to get text from images to verify value.
- The fist way I'm using JavaScript executor 
- The second way I'm using Tesseract:
- Step By Step to fix the "Tess4j unsatisfied link error on mac OS X

`1:cd/Users/username/.m2/repository/net/sourceforge/tess4j/tess4j/4.5.4/`
  
`2 :mkdir darwin`
  
`3 : jar uf tess4j-4.5.4.jar darwin/`
 
`4 : brew info tesseract (here you can find path to libtesseract.4.dylib) `
  
`5 : cp /usr/local/Cellar/tesseract/4.1.1/lib/libtesseract.4.dylib darwin/libtesseract.dylib
  `
  
`6 : jar uf tess4j-4.5.4.jar darwin/libtesseract.dylib`
  
`7 : jar tf tess4j-4.5.4.jar`

- Video link:  https://www.youtube.com/watch?v=5DqW9KP-aQo
- Trained Data : https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbDNtN1FIUll3Z2pQOUM2RFVYaVhDb0JmMl9RQXxBQ3Jtc0trSjBGQnU4ZHloVWwwbXdMcHp2Y01lak1nRm5hdFFvRDc3Mk5GTWZQeTR5RndtQzVUVUFSVkVFSzc2QUE1bHM3N0g1THBoUF9RVzRYbnk4cE5aVmlySHFHcHhURmNXaUIwem9MTVNMaXJCa3VSYndBZw&q=https%3A%2F%2Fgithub.com%2Ftesseract-ocr%2Ftessdata
- tess4J : http://tess4j.sourceforge.net/
- Selenium 4 maven dependency: https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbW5rSk51blItTVFPZGdpUG85Yy10WmRzTTRnUXxBQ3Jtc0ttWkZzR0gzVmxvd1piaGMtMlAzNWFoMkhPSk13dDJhak1UQ3FTd0UyTnk4SGZBU1RBVndtVFZTbDJnc1V3STBsNkVRUG5rbjlMMTNrU1NROWt0dHMxWEtJWVVjLTBQUVduLWI2TFJLR05wQlJCZTl2aw&q=https%3A%2F%2Fmvnrepository.com%2Fartifact%2Forg.seleniumhq.selenium%2Fselenium-java%2F4.0.0-alpha-1
- Github: https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbjlSUjdCRkFDSU1yYjdCMWFoM21zM3lHMFkxd3xBQ3Jtc0trSTEzNmt6YnFnd0cteXJHYWxpYW1KWlpyN1VGV0VrclNqaGxTVzlBRDRqU2t2cVpFQkU1TDhiQ1pSMkdlVVJOSkcybE9GUDlkTTh4aEJCMnkwZFc1Q0xyZmVhS0FiVnJLMUJKbWtZV3pNT3JmUlBwaw&q=https%3A%2F%2Fgithub.com%2Ftesseract-ocr%2Ftesseract

## II. How to run Test
- **Run by maven command line:** 
  - run all regression tests
  > mvn clean verify
  - run test using **specified browser**: 
  > mvn -DWeb.browser="safari" verify (default is Chrome) 
- - **Run by Test runner in IDE**


  
  
  
  


