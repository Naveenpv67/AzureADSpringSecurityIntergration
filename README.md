# AzureADSpringSecurityIntergration

Azure AD Spring Security Integration
This project demonstrates how to integrate Azure Active Directory (AD) with Spring Security to authenticate and authorize users in a Spring Boot application.

Getting Started
To get started with this project, follow these steps:

Clone this repository to your local machine.
Configure your Azure AD tenant and register your Spring Boot application in Azure AD.
Update the application.properties file with your Azure AD tenant ID, client ID, and client secret.
Start the Spring Boot application.
Open a browser and navigate to http://localhost:8080 to see the application in action.
Prerequisites
Before running this project, you'll need the following:

A Microsoft Azure account
A Spring Boot development environment
Basic knowledge of Spring Security and Azure AD
Configuration
The application.properties file contains the configuration properties for this application. You'll need to update the following properties with your Azure AD information:

python
Copy code
azure.activedirectory.tenant-id=
azure.activedirectory.client-id=
azure.activedirectory.client-secret=
Usage
Once you have the application running, you can access the protected resource by navigating to http://localhost:8080/api/protected. You'll be redirected to the Azure AD login page, where you can enter your credentials. Once authenticated, you'll be redirected back to the protected resource and should see a success message.

License
This project is licensed under the MIT License - see the LICENSE.md file for details.

Acknowledgments
This project was inspired by the Microsoft documentation on Azure AD Spring Boot integration.
Thanks to the Spring and Azure AD communities for their support and contributions.
