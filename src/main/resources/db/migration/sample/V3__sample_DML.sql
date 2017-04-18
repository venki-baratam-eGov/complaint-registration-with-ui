insert into employee (id,email,mobile,name,address,createddate,lastmodifieddate,createdby,lastmodifiedby,version)
values(1,'venki@gmail.com','9898989898','venki','Bangalore',now(),now(),1,1,0);

insert into department (id,name,code,description,createddate,lastmodifieddate,createdby,lastmodifiedby,version)
values(1,'Engineering','E','The Municipal Engineering Department is under administrative control of Municipal Administration and Urban Development Department at the Secretariat level.',now(),now(),1,1,0);

insert into boundary (id,name,code,description,lat,lng,createddate,lastmodifieddate,createdby,lastmodifiedby,version)
values(1,'Bangalore','Bang','Bengaluru is the capital of the Indian state of Karnataka',198.999,123.987,now(),now(),1,1,0);

insert into complaintstatus (id,name,version)
values(1,'PROCESSING',0);

insert into complaintstatus (id,name,version)
values(2,'FORWARDED',0);

insert into complaintstatus (id,name,version)
values(3,'REGISTERED',0);

insert into complaintstatus (id,name,version)
values(4,'COMPLETED',0);

insert into complaintstatus (id,name,version)
values(5,'REJECTED',0);

insert into complaintstatus (id,name,version)
values(6,'NOTCOMPLETED',0);

insert into complaintstatus (id,name,version)
values(7,'WITHDRAWN',0);

insert into complaintstatus (id,name,version)
values(8,'CLOSED',0);

insert into complaintstatus (id,name,version)
values(9,'REOPENED',0);

insert into complainttype_category (id,name,description,version)
values(1,'Street Lighting','Street Lighting',0);

insert into complainttype_category (id,name,description,version)
values(2,'Water Supply','Water Supply',0);

insert into complainttype_category (id,name,description,version)
values(3,'Public Health and Sanitation','Public Health and Sanitation',0);

insert into complainttype_category (id,name,description,version)
values(4,'Administration','Administration',0);

insert into complainttype_category (id,name,description,version)
values(5,'Town Planning','Town Planning',0);

insert into complainttype_category (id,name,description,version)
values(6,'Revenue','Revenue',0);

insert into complainttype (id,name,department,category,code,isactive,description,createddate,lastmodifieddate,createdby,lastmodifiedby,version)
values(1,'Damage to the  Electric Pole',1,1,'DTTEP',true,'',now(),now(),1,1,0);

insert into complainttype (id,name,department,category,code,isactive,description,createddate,lastmodifieddate,createdby,lastmodifiedby,version)
values(2,'Electric Shock due to street light',1,1,'ESDTSL',true,'',now(),now(),1,1,0);

insert into complainttype (id,name,department,category,code,isactive,description,createddate,lastmodifieddate,createdby,lastmodifiedby,version)
values(3,'New Street light',1,1,'NSL',true,'',now(),now(),1,1,0);

insert into complainttype (id,name,department,category,code,isactive,description,createddate,lastmodifieddate,createdby,lastmodifiedby,version)
values(4,'Non Burning of Street Lights',1,1,'NBOSL',true,'',now(),now(),1,1,0);

insert into complainttype (id,name,department,category,code,isactive,description,createddate,lastmodifieddate,createdby,lastmodifiedby,version)
values(5,'Covering of Man holes of SWD',1,2,'COMHOSWD',true,'',now(),now(),1,1,0);

insert into complainttype (id,name,department,category,code,isactive,description,createddate,lastmodifieddate,createdby,lastmodifiedby,version)
values(6,'Desilting of Canal',1,2,'DOC',true,'',now(),now(),1,1,0);

insert into complainttype (id,name,department,category,code,isactive,description,createddate,lastmodifieddate,createdby,lastmodifiedby,version)
values(7,'Obstruction of water flow',1,2,'OOWF',true,'',now(),now(),1,1,0);