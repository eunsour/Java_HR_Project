select * from employees;
drop table country cascade constraints;
drop table location cascade constraints;
drop table employees cascade constraints;
drop table department cascade constraints;
drop table jobs cascade constraints;
drop table job_history cascade constraints;

CREATE TABLE country (
    country_id    NUMBER(11) NOT NULL,
    country_name  VARCHAR2(40)
);

ALTER TABLE country ADD CONSTRAINT country_pk PRIMARY KEY ( country_id );

CREATE TABLE department (
    department_id         VARCHAR2(20) NOT NULL,
    department_name       VARCHAR2(60),
    location_location_id  NUMBER(11) NOT NULL
);

ALTER TABLE department ADD CONSTRAINT department_pk PRIMARY KEY ( department_id );

CREATE TABLE employees (
    employee_id               NUMBER(11) NOT NULL,
    employee_name             VARCHAR2(20),
    phone_number              VARCHAR2(20),
    hire_date                 VARCHAR2(20),
    jobs_job_id               VARCHAR2(10) NOT NULL,
    salary                    NUMBER(10),
    commission                NUMBER(10),
    department_department_id  NUMBER(11) NOT NULL
);

ALTER TABLE employees ADD CONSTRAINT employees_pk PRIMARY KEY ( employee_id );

CREATE TABLE job_history (
    employees_employee_id     NUMBER(11) NOT NULL,
    start_date                VARCHAR2(20),
    end_date                  VARCHAR2(20),
    jobs_job_id               VARCHAR2(10) NOT NULL,
    department_department_id  NUMBER(11) NOT NULL
);

CREATE TABLE jobs (
    job_id      VARCHAR2(10) NOT NULL,
    job_title   VARCHAR2(35),
    min_salary  NUMBER(10),
    max_salary  NUMBER(10)
);

ALTER TABLE jobs ADD CONSTRAINT jobs_pk PRIMARY KEY ( job_id );

CREATE TABLE location (
    location_id         NUMBER(11) NOT NULL,
    street_address      VARCHAR2(200),
    postal_code         VARCHAR2(12),
    city                VARCHAR2(30),
    country_country_id  NUMBER(11) NOT NULL
);

ALTER TABLE location ADD CONSTRAINT location_pk PRIMARY KEY ( location_id );

ALTER TABLE department
    ADD CONSTRAINT department_location_fk FOREIGN KEY ( location_location_id )
        REFERENCES location ( location_id );

ALTER TABLE employees
    ADD CONSTRAINT employees_department_fk FOREIGN KEY ( department_department_id )
        REFERENCES department ( department_id );

ALTER TABLE employees
    ADD CONSTRAINT employees_jobs_fk FOREIGN KEY ( jobs_job_id )
        REFERENCES jobs ( job_id );

ALTER TABLE job_history
    ADD CONSTRAINT job_history_department_fk FOREIGN KEY ( department_department_id )
        REFERENCES department ( department_id );

ALTER TABLE job_history
    ADD CONSTRAINT job_history_employees_fk FOREIGN KEY ( employees_employee_id )
        REFERENCES employees ( employee_id );

ALTER TABLE job_history
    ADD CONSTRAINT job_history_jobs_fk FOREIGN KEY ( jobs_job_id )
        REFERENCES jobs ( job_id );

ALTER TABLE location
    ADD CONSTRAINT location_country_fk FOREIGN KEY ( country_country_id )
        REFERENCES country ( country_id );


insert into country values(82,'�ѱ�');
insert into country values(1,'�̱�');
insert into country values(86,'�߱�');

--select * from location;
insert into location values(062,'���� ���� �۾Ϸ� 60 ���� CGI����', '61740', '����',82);
insert into location values(02,'����Ư���� ������ �����Ϸ�6�� 33 �ƿ�������Ÿ�� ', '04782','����',82);
insert into location values(042,'���������� �߱� ������ 246 �븲����', '34917','����',82);
insert into location values(052,'��걤���� �߱� ������ 345 ', '44538','���',82);
insert into location values(061,'���󳲵� ���ֽ� ��ȭ�� 227', '58326', '����',82);
insert into location values(1,'2121 7th Ave, Seattle, WA', '98121','�þ�Ʋ',1);
insert into location values(86,'11 N 3rd Ring Rd E, Chaoyang', '100029','�ϰ�',86);

--select * from department;
insert into department values(1,'network',62);
insert into department values(2,'network',62);
insert into department values(3,'network',62);
insert into department values(4,'front_end',62);
insert into department values(5,'front_end',42);
insert into department values(6,'front_end',61);
insert into department values(7,'back_end',62);
insert into department values(8,'back_end',2);
insert into department values(9,'back_end',1);
insert into department values(10,'database',52);
insert into department values(11,'database',86);
insert into department values(12,'database',42);
insert into department values(13,'ai',1);
insert into department values(14,'ai',2);
insert into department values(15,'ai',61);

--select * from jobs;
insert into jobs values(1,'��Ʈ��ũ������',45000000,80000000);
insert into jobs values(2,'��������',40000000,78000000);
insert into jobs values(3,'�� �����̳�',35000000,78000000);
insert into jobs values(4,'�����ͺ��̽�������',33000000,73000000);
insert into jobs values(5,'�ӽŷ��׿����Ͼ�',30000000,73000000);
insert into jobs values(6, '�����ͺм���', 2800, 5500);


--select * from employees;
insert into employees values(2051,'����','010-6742-8074','2005-03-01','1',80000000,5000000,1);
insert into employees values(2101,'������','010-9964-2401','2010-03-01','1',65000000,1000000,2);
insert into employees values(2151,'��ȯ��','010-3634-3240','2015-03-01','1',45000000,200000,3);
insert into employees values(2062,'������','010-3462-8254','2015-03-01','2',78000000,2000000,4);
insert into employees values(2112,'��ä��','010-2520-0890','2011-03-01','2',63000000,3000000,5);
insert into employees values(2162,'�̰���','010-4259-1061','2016-03-01','2',40000000,1000000,6);
insert into employees values(2073,'���ʷ�','010-7578-8467','2007-03-01','3',77000000,2000000,7);
insert into employees values(2112,'�����','010-9414-8535','2012-03-01','3',60000000,3000000,8);
insert into employees values(2162,'������','010-3279-7883','2017-03-01','3',35000000,0,9);
insert into employees values(2084,'������','010-2822-4314','2008-03-01','4',75000000,0,10);
insert into employees values(2134,'������','010-2524-5018','2013-03-01','4',55000000,1000000,11);
insert into employees values(2184,'������','010-5140-6513','2018-03-01','4',33000000,6000000,12);
insert into employees values(2095,'���μ�','010-1264-7569','2009-03-01','5',73000000,2000000,13);
insert into employees values(2145,'������','010-2741-4151','2014-03-01','5',50000000,3000000,14);
insert into employees values(2195,'����','010-4934-3540','2019-03-01','5',30000000,1000000,15);

--select * from job_history;
insert into job_history values(2051,'2010-03-02','2015-03-01','1',1);
insert into job_history values(2051,'2015-03-02','2020-03-01','3',7);
insert into job_history values(2101,'2010-03-02','2020-03-01','4',10);
insert into job_history values(2062,'2006-03-02','2011-03-01','5',13);
insert into job_history values(2062,'2011-03-02','2016-03-01','1',2);
insert into job_history values(2112,'2011-03-02','2016-03-01','5',14);
insert into job_history values(2073,'2007-03-02','2012-03-01','2',4);
insert into job_history values(2073,'2012-03-02','2017-03-01','4',11);
insert into job_history values(2123,'2012-03-02','2017-03-01','1',3);
insert into job_history values(2084,'2008-03-02','2013-03-01','3',8);
insert into job_history values(1111, '2015-03-02', '2020-03-01', 6, 16);
insert into job_history values(2084,'2013-03-02','2018-03-01','2',5);
insert into job_history values(2134,'2013-03-02','2018-03-01','5',15);
insert into job_history values(2095,'2009-03-02','2014-03-01','4',1);
insert into job_history values(2095,'2014-03-02','2019-03-01','3',9);
insert into job_history values(2145,'2014-03-02','2019-03-01','5',13);