CREATE TABLE "user"
(
    user_pass VARCHAR(14) NOT NULL,
    user_name VARCHAR(120) NOT NULL,
    user_phone VARCHAR(14),
    email VARCHAR(75) PRIMARY KEY NOT NULL
);



CREATE TABLE "order"
(
    order_num SERIAL PRIMARY KEY NOT NULL,
    email VARCHAR(75) NOT NULL,
    order_date TIMESTAMP DEFAULT now() NOT NULL,
    address VARCHAR(250) NOT NULL,
    description VARCHAR(10000),
    CONSTRAINT order_user_email_fk FOREIGN KEY (email) REFERENCES "user" (email)
);

CREATE TABLE product
(
    flower_num SERIAL PRIMARY KEY NOT NULL,
    flower_name VARCHAR(200) NOT NULL,
    image_url VARCHAR(500) NOT NULL,
    description VARCHAR(10000),
    price INTEGER NOT NULL,
    consisting VARCHAR(2000) NOT NULL,
    width INTEGER NOT NULL,
    height INTEGER NOT NULL,
    full_image_url VARCHAR(500) NOT NULL,
    quantity INTEGER
);

CREATE TABLE orderitem
(
    order_num SERIAL NOT NULL,
    flower_num INTEGER NOT NULL,
    quantity INTEGER NOT NULL,
    total_price INTEGER NOT NULL,
    CONSTRAINT orderitem_order_num_flower_num_pk PRIMARY KEY (order_num, flower_num),
    CONSTRAINT orderitem_order_order_num_fk FOREIGN KEY (order_num) REFERENCES "order" (order_num),
    CONSTRAINT orderitem_product_flower_num_fk FOREIGN KEY (flower_num) REFERENCES product (flower_num)
);

CREATE TABLE translate
(
    russian VARCHAR(100000) NOT NULL,
    english VARCHAR(100000),
    hebrew VARCHAR(100000),
    language_key VARCHAR(250) PRIMARY KEY NOT NULL
);

CREATE FUNCTION update_quantity () RETURNS trigger
	LANGUAGE plpgsql
AS $$
  DECLARE
    flower INT;
  BEGIN
    flower = New.flower_num;
    UPDATE product SET quantity = quantity - New.quantity
    WHERE flower_num = flower;
    RETURN NEW;
  END;

$$;