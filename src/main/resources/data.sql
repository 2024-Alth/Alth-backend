insert into authority (authority_name)values ('ROLE_USER');
insert into authority (authority_name)values ('ROLE_ADMIN');

insert into record(record_id, al_cnt, hang_over, record_memo, is_deleted) values (1, 2, 'ALIVE', 'test', false);

insert into alcohol (alcohol_id, alcohol_name, degree, price, volume, alcohol_type, record_id) values (1, '참이슬 오리지널(빨뚜)', 20.1, 1900, 360, 'SOJU', 1);
insert into alcohol (alcohol_id, alcohol_name, degree, price, volume, alcohol_type, record_id) values (2, '참이슬 후레쉬', 16.5, 1900, 360, 'SOJU', 1);
insert into alcohol (alcohol_id, alcohol_name, degree, price, volume, alcohol_type, record_id) values (3, '과일 소주', 13.0, 2000, 360, 'SOJU', 1);
insert into alcohol (alcohol_id, alcohol_name, degree, price, volume, alcohol_type, record_id) values (4, '매화수', 14.0, 2600, 300, 'SOJU', 1);
insert into alcohol (alcohol_id, alcohol_name, degree, price, volume, alcohol_type, record_id) values (5, '별빛 청하', 7.0, 2750, 295, 'SOJU', 1);
insert into alcohol (alcohol_id, alcohol_name, degree, price, volume, alcohol_type, record_id) values (6, '프리미엄 소주', 25.0, 13000, 375, 'SOJU', 1);

insert into alcohol (alcohol_id, alcohol_name, degree, price, volume, alcohol_type, record_id) values (7, '작은 캔', 4.6, 1580, 250, 'BEER', 1);
insert into alcohol (alcohol_id, alcohol_name, degree, price, volume, alcohol_type, record_id) values (8, '중간 캔', 4.6, 2250, 355, 'BEER', 1);
insert into alcohol (alcohol_id, alcohol_name, degree, price, volume, alcohol_type, record_id) values (9, '큰 캔', 4.6, 2800, 500, 'BEER', 1);
insert into alcohol (alcohol_id, alcohol_name, degree, price, volume, alcohol_type, record_id) values (10, '유리 병', 4.6, 3100, 640, 'BEER', 1);
insert into alcohol (alcohol_id, alcohol_name, degree, price, volume, alcohol_type, record_id) values (11, '페트 - 1L', 4.6, 5400, 1000, 'BEER', 1);
insert into alcohol (alcohol_id, alcohol_name, degree, price, volume, alcohol_type, record_id) values (12, '페트 - 1.6L', 4.6, 7900, 1600, 'BEER', 1);

insert into alcohol (alcohol_id, alcohol_name, degree, price, volume, alcohol_type, record_id) values (13, '장수 막걸리', 6.0, 1600, 750, 'MAKGEOLLI', 1);
insert into alcohol (alcohol_id, alcohol_name, degree, price, volume, alcohol_type, record_id) values (14, '생탁 막걸리', 6.0, 1600, 750, 'MAKGEOLLI', 1);
insert into alcohol (alcohol_id, alcohol_name, degree, price, volume, alcohol_type, record_id) values (15, '가평 잣 막걸리', 6.0, 2300, 750, 'MAKGEOLLI', 1);
insert into alcohol (alcohol_id, alcohol_name, degree, price, volume, alcohol_type, record_id) values (16, '우도 땅콩 막걸리', 6.0, 3900, 750, 'MAKGEOLLI', 1);
insert into alcohol (alcohol_id, alcohol_name, degree, price, volume, alcohol_type, record_id) values (17, '곰표 막걸리', 6.0, 4500, 500, 'MAKGEOLLI', 1);
insert into alcohol (alcohol_id, alcohol_name, degree, price, volume, alcohol_type, record_id) values (18, '국순당 막걸리', 6.0, 2200, 750, 'MAKGEOLLI', 1);

insert into alcohol (alcohol_id, alcohol_name, degree, price, volume, alcohol_type, record_id) values (19, '사용자 지정', 0.0, 0, 0, 'ETC', 1);

