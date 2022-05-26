CREATE SCHEMA IF NOT EXISTS shop;

CREATE TABLE IF NOT EXISTS shop.product
(
	product_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    price DECIMAL(5, 2) NOT NULL,
    color TEXT NOT NULL,
    description text NOT NULL,
    url text NOT NULL
);

CREATE TABLE IF NOT EXISTS shop.user
(
	user_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name TEXT NOT NULL,
    email TEXT NOT NULL,
    phone TEXT NOT NULL,
    address TEXT NOT NULL,
    city TEXT NOT NULL,
    state TEXT NOT NULL,
    zip_code TEXT NOT NULL,
    card_type TEXT NOT NULL,
    card_num TEXT NOT NULL,
    exp_date TEXT NOT NULL,
    cvc TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS shop.orderitem
(
	item_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ship_method TEXT NOT NULL,
    quantity INT NOT NULL,
    product_name TEXT NOT NULL,
	user_name TEXT NOT NULL
);

INSERT INTO shop.product(name, price, color, description, url) VALUES
('Air Jordan 1 Low', 101.99, 'Football Grey/White', 'The Air Jordan 1 Lows are the most talked about shoes on the planet right now.
                The Football Grey/White is a unique colorway that makes these special.
                These shoes are comfortable, iconic, and built with high-quality material.', '/AirJordan1Low.jpg'),
('Air Force 1', 84.99, 'White', 'The Nike Air Force 1 true white are the top sellers. It is a simple, but elegant look, that creates a shine never seen before.
                It is the perfect everyday shoe and mashes with any outfit you want to wear. The leather overlays compliment the shoes well
                and allow for a durability with tremendous amounts of support.', '/AirForce1.webp'),
('SB Nyjah', 79.99, 'Dutch Brown/Black', 'The Nike SB Nyjah is an elegant shoe that is very unique. These shoes keep your feet comfortable all day and cool them down during intensive workouts.
                The mesh panels offer a lot of breathability and the durability of this shoe is fantastic. The unique colorway is also
                one of its kind and its design allows for its slick look.', '/SBNyjah.webp'),
('Air Zoom Alphafly', 239.99, 'Steam Light Green', 'The Nike Air Zoom Alphafly are the best in stock running shoes. The colorway is only offered in light green.
               The material is durable and allows for elasticity while holding the maximum comfort with every stride. This shoe
               is one of the highly rated shoes in the running industry and has proven to break records.', '/AirZoomAlphafly.jpg'),
('React Live', 86, 'White/Orange', 'The Nike React Live shoe is the one of the best running shoes for comfortability and performance.
               Its flexible design lets runners exceed their expectations on any level. The colorway is a very unique orange
               and white. The material used for this colorway is unique and allows for a very pleasing look.', '/ReactLive.webp'),
('Metcon 4', 89.99, 'Space Black', 'The Nike Metcon4 are a unique shoe that go with any outfit. They are unique in the sense of their material and their looks. 
                It is a very popular shoe and one of our top sellers. This shoes are very comfortable and are everyday shoes. They have a lot of support and allow for 
                flexibility.', '/Metcon4.webp'),
('Airmax', 79.99, 'Bright Orange', 'The Nike Airmax are a classic look and a great everyday running shoe. They provide easy, comfortable, and durable running in all terains. The Nike Airmax
                design helps with fast paced running and is easily one of today favorite running shoes. The bright orange colorway adds to its uniqueness and vintange look.', '/Airmax.webp'),
('Mid Blazer', 99, 'Dark Black', 'The Nike Mid Blazers are one of the most astonishing shoes because of its uniqueness, affordability, and cushioning it provides. This shoe provides ankle support and is an everyday wearer that can look stylish with any outfit.
               These sneakers are flexible and are very breathable for any situation you run into.', '/MidBlazer.webp'),
('Zion 1', 70, 'Army Green', 'The Nike Zion 1 are named after the NBA basketball player Zion Williamson who is a high flyer and is unlike any other NBA player. The shoe is designed for uniqueness and allows you to be your own creator.
               This basketball shoe is designed for true athletes and has the durability to withstand anything. It has extremely well cushioning for comfort and its colorway is blended amazingly to make you shine on the court.', '/Zion1.webp'),
('Presto', 103, 'Lava Orange', 'The Nike Presto are offered in bright lava orange colorway which is a very unique colorway that only a few stores offer. Its elegant design offers maximum comfortability while still oferring the most unique look out there. 
                The ultra-soft foam helps with every stride you take and it will never get old.', '/Presto.webp'),
('Low Dunks', 89.99, 'Dark Green/Orange', 'The Nike Dunks are the iconic shoes that everyone wants. The colorway is one of the most unique out there and it has a very asthetic look to it. The design is unique and lowered to fit comfortability of all. 
               Every step you take in these will get you looks and make you feel like you own the place.', '/LowDunks.webp'),
('Court Vision', 59.99, 'Lava Red/Black/Orange', 'The Nike Court Vision is a shoe that is never forgotten. The make of this shoe is out of the world stylish and is way more comfortable than any other shoe on this planet. The cushioning is remarkable and focuses on
               applying comfortability for the wearer at all times. The design is unique with its insane colorway of lava black.', '/CourtVision.webp');

