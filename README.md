# Assessment Project
A Simple Rest API Project for Assessment Test

[![Java CI with Gradle](https://github.com/brain-station-23/customer/actions/workflows/gradle.yml/badge.svg)](https://github.com/brain-station-23/customer/actions/workflows/gradle.yml)

## User Roles
Cardinity Users can have bellow Roles
* USER
* ADMIN

## Status
We have bellow status for the `Tasks` and `Projects`
* Open
* In Progress
* Closed

# Execution
* Run the application by executing `CardinityTaskManagerRestApiApplication.java`
* Import the Postman Collection to test the `API` endpoints


## Endpoints

* Welcome Url
    - Method `GET`
    - URL [localhost:8080/]()

* Transaction URL
    - Method `POST`
    - URL [localhost:8080/transaction]()
    - Request Body
        ```json
        {
            "requestId": "A32W4ER2341",
            "requester": "XYZ App",
            "transactionType": "VFJBTlNGRVI=",
            "sourceAccountNumber": "MzIzNDEyMDA5MjM0ODc=",
            "amount": "MTUwMC41MA==",
            "destinationAccountNumber": "MDAxMjQxMDA5MjExNDM5",
            "note": "Transferring amount"
        }
        ```
* Reverse Transaction
  - Method `POST`
  - URL [localhost:8080/transaction]()
  - Request Body
      ```json
      {
          "requestId": "A32W4ER2341",
          "requester": "XYZ App",
          "transactionType": "UkVWRVJTRQ==",
          "sourceAccountNumber": "MzIzNDEyMDA5MjM0ODc=",
          "amount": "MTUwMC41MA==",
          "destinationAccountNumber": "MDAxMjQxMDA5MjExNDM5",
          "note": "Reversing Transaction"
      }
      ```
    
## Contact

[![Gmail][gmail-shield]][email-address]
[![LinkedIn][linkedin-shield]][linkedin-url]

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/dipanjalmaitra/
[gmail-shield]: https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white
[email-address]: dipanjalmaitra@gmail.com