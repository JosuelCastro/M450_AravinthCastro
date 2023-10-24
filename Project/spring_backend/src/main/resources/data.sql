--USERS
INSERT INTO users (id, username, email, password)
VALUES ('e1446d5e-4e25-11ee-be56-0242ac120002', 'Micky Dai', 	'micky.dai@gmail.com', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6'),
       ('e14472d6-4e25-11ee-be56-0242ac120002', 'Samuel', 	'samuel@gmail.com', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6'),
       ('e14474e8-4e25-11ee-be56-0242ac120002', 'Luis', 	'luis@gmail.com', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6'),
       ('e14476c8-4e25-11ee-be56-0242ac120002', 'Josuel', 	'josuel@gmail.com', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6'),
       ('e1447876-4e25-11ee-be56-0242ac120002', 'Banane', 	'banane@gmail.com', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6'),
       ('e1447cc2-4e25-11ee-be56-0242ac120002', 'Luca', 	'samuel.scherrer@gmx.ch', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6'),
       ('e1447e8e-4e25-11ee-be56-0242ac120002', 'Loris', 	'loris@example.com', '$2a$10$TM3PAYG3b.H98cbRrHqWa.BM7YyCqV92e/kUTBfj85AjayxGZU7d6')
ON CONFLICT DO NOTHING;

--ROLES
INSERT INTO role(id, name)
VALUES ('d29e709c-0ff1-4f4c-a7ef-09f656c390f1', 'DEFAULT'),
('ab505c92-7280-49fd-a7de-258e618df074', 'ADMIN'),
('c6aee32d-8c35-4481-8b3e-a876a39b0c02', 'USER')
ON CONFLICT DO NOTHING;

--AUTHORITIES
INSERT INTO authority(id, name)
VALUES ('2ebf301e-6c61-4076-98e3-2a38b31daf86', 'DEFAULT'),
('76d2cbf6-5845-470e-ad5f-2edb9e09a868', 'USER_MODIFY'),
('21c942db-a275-43f8-bdd6-d048c21bf5ab', 'ADMIN_DELETE'),
('ba804cb9-fa14-42a5-afaf-be488742fc54', 'ADMIN_READ')
ON CONFLICT DO NOTHING;

--assign roles to users
insert into users_role (users_id, role_id)
values 
('e1446d5e-4e25-11ee-be56-0242ac120002', 'ab505c92-7280-49fd-a7de-258e618df074'),
('e14472d6-4e25-11ee-be56-0242ac120002', 'ab505c92-7280-49fd-a7de-258e618df074'),
('e14474e8-4e25-11ee-be56-0242ac120002', 'ab505c92-7280-49fd-a7de-258e618df074'),
('e14476c8-4e25-11ee-be56-0242ac120002', 'ab505c92-7280-49fd-a7de-258e618df074'),
('e1447876-4e25-11ee-be56-0242ac120002', 'ab505c92-7280-49fd-a7de-258e618df074'),
('e1447cc2-4e25-11ee-be56-0242ac120002', 'ab505c92-7280-49fd-a7de-258e618df074'),
('e1447e8e-4e25-11ee-be56-0242ac120002', 'ab505c92-7280-49fd-a7de-258e618df074')
 ON CONFLICT DO NOTHING;

--assign authorities to roles
INSERT INTO role_authority(role_id, authority_id)
VALUES ('d29e709c-0ff1-4f4c-a7ef-09f656c390f1', '2ebf301e-6c61-4076-98e3-2a38b31daf86'),
('ab505c92-7280-49fd-a7de-258e618df074', '76d2cbf6-5845-470e-ad5f-2edb9e09a868'),
('ab505c92-7280-49fd-a7de-258e618df074', '21c942db-a275-43f8-bdd6-d048c21bf5ab'),
('ab505c92-7280-49fd-a7de-258e618df074', 'ba804cb9-fa14-42a5-afaf-be488742fc54'),
('c6aee32d-8c35-4481-8b3e-a876a39b0c02', '21c942db-a275-43f8-bdd6-d048c21bf5ab')
 ON CONFLICT DO NOTHING;
 
-- USERPRFILES

INSERT INTO user_profile(id, user_id, address, birthdate, profile_picture)
VALUES ('0b87358e-4e25-11ee-be56-0242ac120002', 'e1446d5e-4e25-11ee-be56-0242ac120002', 'Bananenstrasse 23', 	'01.01.2000',  	'https://i1.sndcdn.com/artworks-XJdVplPCbvDvJlH7-jF9c4A-t500x500.jpg'),
       ('0b873886-4e25-11ee-be56-0242ac120002', 'e14472d6-4e25-11ee-be56-0242ac120002', 'Herostrasse 12', 	'08.12.1902', 	'https://i1.sndcdn.com/artworks-XJdVplPCbvDvJlH7-jF9c4A-t500x500.jpg'),
       ('0b8739da-4e25-11ee-be56-0242ac120002', 'e14474e8-4e25-11ee-be56-0242ac120002', 'Hundstrasse 21', 	'14.09.2001', 	'https://i1.sndcdn.com/artworks-XJdVplPCbvDvJlH7-jF9c4A-t500x500.jpg'),
       ('0b873b56-4e25-11ee-be56-0242ac120002', 'e14476c8-4e25-11ee-be56-0242ac120002', 'Zuerichstrasse 36',	'25.05.1983',  	'https://i1.sndcdn.com/artworks-XJdVplPCbvDvJlH7-jF9c4A-t500x500.jpg'),
       ('0b873cbe-4e25-11ee-be56-0242ac120002', 'e1447876-4e25-11ee-be56-0242ac120002', 'Rebenstrasse 22', 	'23.07.2006',  	'https://i1.sndcdn.com/artworks-XJdVplPCbvDvJlH7-jF9c4A-t500x500.jpg'),
       ('0b873e08-4e25-11ee-be56-0242ac120002', 'e1447cc2-4e25-11ee-be56-0242ac120002', 'Musterweg 7',     	'03.04.1995',  	'https://i1.sndcdn.com/artworks-XJdVplPCbvDvJlH7-jF9c4A-t500x500.jpg'),
       ('0b8742ea-4e25-11ee-be56-0242ac120002', 'e1447e8e-4e25-11ee-be56-0242ac120002', 'Hauptplatz 14',   	'11.08.1978',  	'https://i1.sndcdn.com/artworks-XJdVplPCbvDvJlH7-jF9c4A-t500x500.jpg');


