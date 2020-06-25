"# cultfilt-clone-account-service" 

This microservice is responsible for managing user accounts. User can create account and can register themselves as a coach. 
Currently, user has to login using email. That can be changed to mobile number or OTP based login in future.

================

User Endpoints:

POST /api/user ==> User Registration

GET /api/user/{userId} ==> Get specific user details. (TODO: need to be made secure so that other users can't access other user's details) 

Admin Endpoints:

GET /admin/api/users ==> Get list of all users

Token endpoints:

POST /auth/get-token ==> Get token based on email and password credentials

================

 Column  |          Type          | Collation | Nullable |             Default
 
----------+------------------------+-----------+----------+----------------------------------

 id       | integer                |           | not null | nextval('user_id_seq'::regclass)
 
 email    | character varying(50)  |           | not null |
 
 name     | character varying(50)  |           | not null |
 
 password | character varying(100) |           | not null |
 
 user_id  | character varying(255) |           | not null |
 
 is_coach | boolean                |           |          | false
 
Indexes:

    "user_email_key" UNIQUE CONSTRAINT, btree (email)


