## BRAVI - TO DO LIST

### Prerequisites

* Maven
* Docker

### Steps to execute

* 1 - Open your preferred shell
* 2 - Go to the directory "back" inside the application
* 3 - Run the command "mvn clean install"
* 4 - Go to the "front" directory
* 5 - Run the command "docker build -t com.bravi.todo/front ."
* 6 - Go to the root directory and run "docker-compose up" and wait all services start
* 7 - Access the application by http://localhost:8888 in on chrome navigator