# room-booking-managment
Coding assignment for people10

# Prerequisites

•	Java 8 

•	Maven 3.5.3

•	Windows/Linux

•	Postman 5.5.4

•	Git

•	Docker (optional)

•	Jenkins (optional)

# Server Details
•	Embedded Apache Tomcat

# Technologies
•	Spring Boot 2.2.1
# Installation

Step 1: Download project

git clone https://github.com/prasadkarri1988/guide.git 
Step 2: mvn clean install 

Jar file will generate in target location

Step 3: java -jar guide.jar 
Spring boot application will run and load data in db.

Validation steps:- 

Open Swagger UI  using below URL:
http://localhost:8080/swagger-ui.html

Past all below resquest in swagger UI  and test all below senario.

1. Get All Trails.

   It is Get request.
   http://localhost:8080/avalableTrails

2. Hikers to create booking 
   
    Savebooking is put request for to create booking request.

    Copy this request in Swagger or post man etc.
   
   PUT URL : http://localhost:8080/booking/save 

    Request:- 

        {
	"bookingDate":"2020-03-03",
	"trailid":1,
	"hikers":[
		{
                        "name":"prasad",
			"dob":"1988-08-08",
			"emailID":"prasad.karri@gmail.com",
			"phoneNumber":"9866597538"
		},{
                       "name":"karri",
			"dob":"1989-08-08",
			"emailID":"prasad.karri@gmail.com",
			"phoneNumber":"9866597538"
		}
	]
}


3  Update exisitng Booking info.
   Hikers can update the bookings based booking info 

   URL : http://localhost:8080/booking/update
   
  Post Request:

   {
    "bookingID": 1,
    "bookingDate": "2020-03-03T00:00:00.000+0000",
    "trailid": 1,
    "bookingStatus": true,
    "hikers": [
        {
            "id": 1,
            "name": "ram",
            "dob": "1988-08-08",
            "emailID": "prasad.karri@gmail.com",
            "phoneNumber": "9866597538"
        },
        {
            "id": 2,
            "name": "karri",
            "dob": "1989-08-08",
            "emailID": "prasad.karri@gmail.com",
            "phoneNumber": "9866597538"
        }
    ]
}


4. Cancle booking.
  Hiker cancle booking based on booking id
  Post Request:
  
  URL: http://localhost:8080/booking/cancle?bookingId=1

5. GetBooking for specific bookingId 
    Hiker view booking based on booking id.

    Get Request:
    http://localhost:8080/booking/get?bookingId=1
   
6. GetBooking for Specific day 

George view booking for specific day

Post Request :

http://localhost:8080/booking/getBookingByDate?bookingDate=2020-03-02







    
    