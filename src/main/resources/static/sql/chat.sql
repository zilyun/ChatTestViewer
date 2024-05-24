create table chatcontent (
                             chatnum     number primary key,
                             roomnumber  varchar2(500),
                             username    varchar2(100),
                             content     varchar2(1000)
);

create table chatroom (
                          roomnumber  NUMBER PRIMARY KEY,
                          roomname    VARCHAR2(100),
                          sessionid   VARCHAR2(300),
                          description VARCHAR2(500)
);