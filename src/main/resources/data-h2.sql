INSERT INTO countries (id, name) VALUES
(default, 'USA'),
(default, 'Canada'),
(default, 'Australia'),
(default, 'India'),
(default, 'Germany');

INSERT INTO family (id, name) VALUES
(default, 'Felines'),
(default, 'Canines'),
(default, 'Reptiles'),
(default, 'Predators'),
(default, 'Lagomorphs');

INSERT INTO types (id, name, family_id) VALUES
(default, 'Lion', 1),
(default, 'Tiger', 1),
(default, 'Leopard', 1),
(default, 'Fox', 2),
(default, 'Wolves', 2),
(default, 'Jackals', 2),
(default, 'Crocodiles', 3),
(default, 'Snakes', 3),
(default, 'Iguanas', 3),
(default, 'Otters', 4),
(default, 'Weasels', 4),
(default, 'Badgers', 4),
(default, 'Rabbits', 5),
(default, 'Hares', 5);


-- Cats
INSERT INTO animals (id, name, family_id, type_id, gender, country_id, arrival_date, photo_url) VALUES
(default, 'Simba', 1, 1, 'M', 2, '2025-01-01', 'https://example.com/simba.jpg'),
(default, 'Nala', 1, 2, 'W', 2, '2025-01-02', 'https://example.com/nala.jpg'),
(default, 'Leo', 1, 3, 'M', 3, '2025-01-03', 'https://example.com/leo.jpg');

-- Dogs
INSERT INTO animals (id, name, family_id, type_id, gender, country_id, arrival_date, photo_url) VALUES
(default, 'Wolfie', 2, 4, 'M', 1, '2025-01-04', 'https://example.com/wolfie.jpg'),
(default, 'Foxy', 2, 5, 'W', 4, '2025-01-05', 'https://example.com/foxy.jpg'),
(default, 'Shadow', 2, 4, 'M', 3, '2025-01-06', 'https://example.com/shadow.jpg');

-- Reptiles
INSERT INTO animals (id, name, family_id, type_id, gender, country_id, arrival_date, photo_url) VALUES
(default, 'Croco', 3, 6, 'M', 3, '2025-01-07', 'https://example.com/croco.jpg'),
(default, 'Lizzy', 3, 7, 'W', 5, '2025-01-08', 'https://example.com/lizzy.jpg'),
(default, 'Spike', 3, 6, 'M', 4, '2025-01-09', 'https://example.com/spike.jpg');

-- Predators
INSERT INTO animals (id, name, family_id, type_id, gender, country_id, arrival_date, photo_url) VALUES
(default, 'Hunter', 4, 8, 'M', 1, '2025-01-10', 'https://example.com/hunter.jpg'),
(default, 'Whiskers', 4, 9, 'W', 2, '2025-01-11', 'https://example.com/whiskers.jpg'),
(default, 'Claw', 4, 8, 'M', 3, '2025-01-12', 'https://example.com/claw.jpg');

-- Hares
INSERT INTO animals (id, name, family_id, type_id, gender, country_id, arrival_date, photo_url) VALUES
(default, 'Bunny', 5, 10, 'W', 4, '2025-01-13', 'https://example.com/bunny.jpg'),
(default, 'Hopper', 5, 11, 'M', 5, '2025-01-14', 'https://example.com/hopper.jpg'),
(default, 'Flopsy', 5, 10, 'W', 1, '2025-01-15', 'https://example.com/flopsy.jpg');

-- Additional Entries
INSERT INTO animals (id, name, family_id, type_id, gender, country_id, arrival_date, photo_url) VALUES
(default, 'Leo II', 1, 3, 'M', 2, '2025-01-16', 'https://example.com/leo2.jpg'),
(default, 'Zara', 2, 5, 'W', 4, '2025-01-17', 'https://example.com/zara.jpg'),
(default, 'Gator', 3, 6, 'M', 3, '2025-01-18', 'https://example.com/gator.jpg'),
(default, 'Otis', 4, 9, 'M', 5, '2025-01-19', 'https://example.com/otis.jpg'),
(default, 'Cottontail', 5, 11, 'W', 1, '2025-01-20', 'https://example.com/cottontail.jpg');

-- Mixed Additional Entries
INSERT INTO animals (id, name, family_id, type_id, gender, country_id, arrival_date, photo_url) VALUES
(default, 'Mufasa', 1, 1, 'M', 1, '2025-01-21', 'https://example.com/mufasa.jpg'),
(default, 'Scar', 1, 2, 'M', 3, '2025-01-22', 'https://example.com/scar.jpg'),
(default, 'Lassie', 2, 5, 'W', 4, '2025-01-23', 'https://example.com/lassie.jpg'),
(default, 'Viper', 3, 7, 'M', 5, '2025-01-24', 'https://example.com/viper.jpg'),
(default, 'Storm', 4, 8, 'M', 2, '2025-01-25', 'https://example.com/storm.jpg'),
(default, 'Dusty', 5, 10, 'W', 3, '2025-01-26', 'https://example.com/dusty.jpg'),
(default, 'Snowball', 5, 11, 'M', 4, '2025-01-27', 'https://example.com/snowball.jpg'),
(default, 'Fang', 1, 3, 'M', 5, '2025-01-28', 'https://example.com/fang.jpg'),
(default, 'Sheba', 1, 2, 'W', 1, '2025-01-29', 'https://example.com/sheba.jpg'),
(default, 'Chase', 2, 4, 'M', 2, '2025-01-30', 'https://example.com/chase.jpg');
