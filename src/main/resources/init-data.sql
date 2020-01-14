INSERT INTO user_group (id,name,roles,create_time,create_by,modified_time,modified_by) 
SELECT 1,'admin','[\"admin\"]','system',datetime('now','localtime'),'system',datetime('now','localtime') WHERE NOT EXISTS (
SELECT 1 FROM user_group WHERE user_group.name='admin');

INSERT INTO user (id,login_name,password,create_time,create_by,modified_time,modified_by) 
SELECT 1,'admin','admin','system',datetime('now','localtime'),'system',datetime('now','localtime') WHERE NOT EXISTS (
SELECT 1 FROM user WHERE user.login_name='admin');

INSERT INTO user_group_link (user_id,user_group_id) 
SELECT 1,1 WHERE NOT EXISTS (
SELECT 1 FROM user_group_link WHERE user_group_link.user_id = 1);