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

azure.activedirectory.tenant-id=

azure.activedirectory.client-id=

azure.activedirectory.client-secret=

Usage

Once you have the application running, you can access the protected resource by navigating to http://localhost:8080/home. You'll be redirected to the Azure AD login page, where you can enter your credentials. Once authenticated, you'll be redirected back to the protected resource and should see a success message.

Sample Access Token

"access_token": "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiIsIng1dCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyIsImtpZCI6Ii1LSTNROW5OUjdiUm9meG1lWm9YcWJIWkdldyJ9.eyJhdWQiOiIwMDAwMDAwMi0wMDAwLTAwMDAtYzAwMC0wMDAwMDAwMDAwMDAiLCJpc3MiOiJodHRwczovL3N0cy53aW5kb3dzLm5ldC9lZDE2ZmRkZi1kNmUxLTRkY2YtOGU3ZC04ZDRkN2IwYWNmZTUvIiwiaWF0IjoxNjgyNjAxODE3LCJuYmYiOjE2ODI2MDE4MTcsImV4cCI6MTY4MjYwNzI0OCwiYWNyIjoiMSIsImFpbyI6IkFUUUF5LzhUQUFBQUhoZjJ5ZUs2cWxXUFMvakcyOGhOY2FNMDFUWFhpbGNLaTZPRFZLdnJjM0R4TDUyaEZWQ3N4OWVWcVQ1Q1V6TWQiLCJhbXIiOlsicHdkIl0sImFwcGlkIjoiOGJiNDc4ZjgtNDcwMy00OTA5LThmN2MtYjRjYzU4MjNkOTgxIiwiYXBwaWRhY3IiOiIxIiwiZ2l2ZW5fbmFtZSI6Im5hdmVlbiIsImlwYWRkciI6IjEwMy4xNzIuMjA4LjExOCIsIm5hbWUiOiJuYXZlZW4iLCJvaWQiOiJmYmNlYzRjMi0wYzUyLTQyY2QtOTNjZC1iZjcxZTAwODU1NGYiLCJwdWlkIjoiMTAwMzIwMDI5OURDRDRGRiIsInJoIjoiMC5BVW9BM18wVzdlSFd6MDJPZlkxTmV3clA1UUlBQUFBQUFBQUF3QUFBQUFBQUFBQ0pBS3cuIiwic2NwIjoiQXV0aGVudGljYXRpb25Db250ZXh0LlJlYWQuQWxsIERpcmVjdG9yeS5SZWFkLkFsbCBlbWFpbCBvZmZsaW5lX2FjY2VzcyBvcGVuaWQgcHJvZmlsZSBVc2VyLlJlYWQiLCJzdWIiOiJSVmdVR1l5NnRZWVVhVEFRWUlMRGRBQ2QxR1pYbUo1dXgtUDlfcWpqT3BvIiwidGVuYW50X3JlZ2lvbl9zY29wZSI6IkFTIiwidGlkIjoiZWQxNmZkZGYtZDZlMS00ZGNmLThlN2QtOGQ0ZDdiMGFjZmU1IiwidW5pcXVlX25hbWUiOiJuYXZlZW5AeWV0aGlhenVyZXNhbXBsZWRpcmVjdG9yeS5vbm1pY3Jvc29mdC5jb20iLCJ1cG4iOiJuYXZlZW5AeWV0aGlhenVyZXNhbXBsZWRpcmVjdG9yeS5vbm1pY3Jvc29mdC5jb20iLCJ1dGkiOiJDTmxQeVctajBVaWdQZUdsS2pBZkFBIiwidmVyIjoiMS4wIn0.YYWBRX-eFiglpfT2pdVMJ3eu1hifm6beCvh0V48nyHmM2TyBiFiD0VnqcGrbvn2alWeC5kvq5YTNzfFkc8ILjbzymSpv8h2NovFvvZ2ZyrNDxBlwDvKHKibKCHCyMHXkxXm-Os6ZPNJLFeG5A9mHOpxR5SQRmoN5seD955rRVvx2fnMfi22YEZPZtPGgbmBxtvP1cku_gsjaerJYxwxnNd2EKKs2i1DuWpLUhS2fAWXUTt_AAwg6D3ajtP_bjWBaHMvnMJDZ_PEnBHvB6c7i1SDnaLjdi6e4QHT1Jeo8b3jsobyk_tfYp6IVMfMP7yS7R4CFKgMaST03aCvgUbMiWw",
   
"refresh_token":
 "0.AUoA3_0W7eHWz02OfY1NewrP5fh4tIsDRwlJj3y0zFgj2YGJAKw.AgABAAEAAAD--DLA3VO7QrddgJg7WevrAgDs_wUA9P-O-tMIyx_dASc0mmrMKVRVHJvMwzjwJky8m9w_XdWOOB9tUq5D93JkM4_64G-FICaLkB9p_B3EYYsX-KZDj74nLvxgr9COgK7eF-KuqkMlt0ISlWydLYp-8bBnSfj0fTKJkfE8AQqelAdH3f4JiPf7S6HN2FnJSDNWAdG_NOBmwdxXWgCDU_Fy1UgqFqSlSDUK8uJkN2B-cB9auyb1D_BXvwjww5OGjy--p_Ry-uB8BHp2dPJxLB8-gYJpSJDy3AiUEde7eaDig3NrzFLlWiSe3Hw6o43x4exJlWBUrZSCGGKD7iowaEIO4sRxWXyEoyEOk5odcI_Mp1Bk8hJaaT0GlGbAk5PmcKboR-PtEZulVEuD9lK0bZ4jlQmhu1XDOLwbzz3rmy2q-vwsBTIInujeg-Pq3MGkYOd-lp6NHMtwNhEXwOIsdaFVkC2wIKAZWIlCscTbLofrduZsWnD8Y8kGWh3Svq8HUy6hTsdSGHmucJ1dSYj4XXkRvmoO8dLijetJqAY4dQfK3qgwffCt9upzXtWwHodQ5GT2PaWdViU35fBOWrqet9z-n9TmnYmTAsxBzADSirgffydxTiCHtOkNi5IZbcNp6k7z87cmkNfbyjSvs6RoJnEWubw63PGOjF1I_lFLTepbn5d2Y6p4dfh9U3IfymA36BI"
 
 Curl Request to Generate the Access token
 
 curl --location 'https://login.microsoftonline.com/ed16fddf-d6e1-4dcf-8e7d-8d4d7b0acfe5/oauth2/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--header 'Cookie: buid=0.AUoApUY86s-8mkihuOOHGwjnwL0iBhZypeJEnMlPMgQlT6MqAAA.AQABAAEAAAD--DLA3VO7QrddgJg7WevrlAwOmCPnBQmJxh7wAH38G71SlVU-ykEcfbRQrwx-DuqeS0bx47-dYsFDpk6U7Niis_yWz6HTh2zPkGG8NZbTT-YYAUlKvFe21MNF2ZXT_R0gAA; fpc=AtdI5cz4hXZPliyO7aMzU2bVICMMAQAAAIVv3NsOAAAA; stsservicecookie=estsfd; x-ms-gateway-slice=estsfd' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'username=naveen@yethiazuresampledirectory.onmicrosoft.com' \
--data-urlencode 'password=Gavu1234' \
--data-urlencode 'client_id=8bb478f8-4703-4909-8f7c-b4cc5823d981' \
--data-urlencode 'client_secret=PuL8Q~MxTdO0ynKncAbZ4kFUhZUx-ZhfEWg61ceA' \
--data-urlencode 'resource=00000002-0000-0000-c000-000000000000'

Helpful Resource:
https://github.com/Azure-Samples/azure-spring-boot-samples/tree/main/aad/spring-cloud-azure-starter-active-directory/web-client-access-resource-server/aad-resource-server

Steps to Validate the AAD Access Token in Spring

1.Obtain the access token from the HTTP request header.

2.Use JwtDecoder to parse the access token into Jwt.

3.Verify aud, iss, nbf, exp claims in access token.

4.Extract information from JWT in AadOAuth2AuthenticatedPrincipal object after a successful verification.

5.Save the AADOAuth2AuthenticatedPrincipal into SecurityContext.

