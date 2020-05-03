INSERT INTO user (login_name,password,create_by,create_time,last_modified_by,last_modified_time)
SELECT 'admin','KjxbmGG5LYpisyHFdJGPEw==','SYSTEM',NOW(),'SYSTEM',NOW() WHERE NOT EXISTS (
SELECT 1 FROM user WHERE user.login_name='admin');

INSERT INTO user_group (name,roles,create_by,create_time,last_modified_by,last_modified_time)
SELECT 'admin','[\"ADMINISTRATOR\"]','SYSTEM',NOW(),'SYSTEM',NOW() WHERE NOT EXISTS (
SELECT 1 FROM user_group WHERE name='admin');

INSERT INTO user_group_link (user_id,user_group_id) 
SELECT 1,1 WHERE NOT EXISTS (
SELECT 1 FROM user_group_link WHERE user_group_link.user_id = 1);