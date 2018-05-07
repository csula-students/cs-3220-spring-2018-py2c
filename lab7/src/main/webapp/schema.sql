
use cs3220stu33;
CREATE TABLE users(
  id INTEGER AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL 
);



INSERT INTO users VALUES(1,'admin','cs3220password');
INSERT INTO users VALUES(2,'me','notapassword');



CREATE TABLE generators(
id	INTEGER AUTO_INCREMENT PRIMARY KEY,
name VARCHAR (255) NOT NULL,	
description	TEXT,
rate INTEGER,
base_cost INTEGER,
unlock_at INTEGER,
created_by INTEGER,
FOREIGN KEY (created_by) REFERENCES users(id)
);

 
INSERT INTO generators VALUES(1,'Grandma','Grandma likes to make cookies',5,10,10,1);
INSERT INTO generators VALUES(2,'Factory','Factory to produce cookies',10,50,50,1);
INSERT INTO generators VALUES(3,'Mine','Mining cookies',20,200,200,2);


CREATE TABLE `events` (
id	INTEGER AUTO_INCREMENT PRIMARY KEY,
name VARCHAR (255) NOT NULL,	
description	TEXT,
trigger_at INTEGER,	
created_by INTEGER,
FOREIGN KEY (created_by) REFERENCES users(id)
);



INSERT INTO `events` VALUES (1,'Grandma shows up', 'You always know grandma likes to make cookies',10,1);
INSERT INTO `events` VALUES (2,'You can construct factory now!','Factory to produce cookies',50,	1);
INSERT INTO `events` VALUES (3,"We've found cookies in deep mountain ... in the mine?",'Mining cookies',200,2);
INSERT INTO `events` VALUES (4,'sample event','This is a sample event. Please delete me',99999,2);



CREATE TABLE quantities(
generator_id INTEGER NOT NULL, 	
token VARCHAR (255), 	
quantity INTEGER DEFAULT 0,
UNIQUE KEY (generator_id,quantity)
);
 



INSERT INTO quantities VALUES(1,'c7a69d44e0b9b415b2d9956cb26b944a',2);
INSERT INTO quantities VALUES(2,'c7a69d44e0b9b415b2d9956cb26b944a',1);
INSERT INTO quantities VALUES(1,'80516ce4663c3bd0c8385309a2fe226e',20);
INSERT INTO quantities VALUES(2,'80516ce4663c3bd0c8385309a2fe226e',30);



