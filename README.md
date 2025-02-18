# Camunda BPMN API Integration

## Overview
This project demonstrates how to integrate external APIs into a BPMN workflow using Camunda 7. It defines a BPMN process that:
- Calls an external API
- Checks the API response
- Handles valid and error responses accordingly

## Features
- BPMN process for API calls
- Conditional handling for API responses
- Error handling within the workflow
- Integration with Java-based service tasks

## Technologies Used
- **Camunda 7** (Process Engine & Modeler)
- **Java** (Spring Boot integration)
- **Camunda Modeler** (For BPMN design)
- **Maven** (Build tool)

## Prerequisites
Ensure you have the following installed:
- Java 17+
- Maven 3+
- Camunda BPM Platform 7
- Camunda Modeler (for editing BPMN files)

## Setup Instructions
1. Clone this repository:
   ```sh
   git clone https://github.com/your-username/camunda-api-integration.git
   cd camunda-api-integration
   ```
2. Build the project:
   ```sh
   mvn clean install
   ```
3. Run the application:
   ```sh
   mvn spring-boot:run
   ```
4. Open Camunda web interface:
   - URL: `http://localhost:8080/camunda`
   - Default Credentials:
     - Username: `demo`
     - Password: `demo`

## BPMN Process Flow
1. **Start Event** → Triggers the workflow.
2. **Call API Service Task** → Calls an external API.
3. **Exclusive Gateway** → Checks the API response.
   - If valid, proceeds to processing.
   - If an error occurs, moves to error handling.
4. **Process Valid Response Task** → Handles valid API responses.
5. **Handle API Error Task** → Manages errors.
6. **End Event** → Marks the process completion.

## BPMN Diagram
You can find the BPMN diagram (`api-integration.bpmn`) in the `src/main/resources/bpmn` directory. Open it in **Camunda Modeler** to modify or visualize it.

## How to Deploy
- Place the `api-integration.bpmn` file in the `src/main/resources/bpmn` directory.
- Start the Camunda Engine and deploy the process using the REST API or the Camunda Web Modeler.

## Customization
- Modify `com.example.api.ApiCallTask` to call different APIs.
- Update BPMN conditions to match API response handling.
- Extend the workflow with additional service tasks or integrations.

## Contributing
Feel free to fork the repository and submit pull requests for improvements or new features!

## License
This project is licensed under the MIT License.

