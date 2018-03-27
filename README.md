This project is a monitoring system for machine of sewage treatment  by using spring boot fromwork.
It has three part:
1.Communication with the PLC controlling that machine. this use tcp to send and receive message, it programmed by
using socket,and then storing messages in a database, also reading information from the database then sending to PLC.

2.Communication with HTTP Client. Using "POST" or "GET" function. First, we should identity authentication, then it can
get, add, modify the messages you can access with your identity.

3.Make a front-end GUI for browser.Users can access the machine status and historical information about it,and add or modify
the messages about the machine and its component.
