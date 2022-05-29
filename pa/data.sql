CREATE TABLE IF NOT EXISTS testdb.users
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

CREATE TABLE IF NOT EXISTS testdb.orderitems
(
	item_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    ship_method TEXT NOT NULL,
    quantity INT NOT NULL,
    product_name TEXT NOT NULL,
	user_name TEXT NOT NULL
);

