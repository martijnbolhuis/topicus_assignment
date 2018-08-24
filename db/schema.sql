DROP TABLE medicines;
DROP TABLE packages;
DROP TABLE recipes;
DROP TABLE recipes_medicines;

CREATE TABLE medicines(
  id serial,
  name varchar,
  created_at timestamp,
  updated_at timestamp
);

CREATE TABLE packages(
  id serial,

  medicine_id int,
  name varchar,

  package_amount int,
  package_unit varchar,

  content_amount int,
  content_unit varchar,

  created_at timestamp,
  updated_at timestamp
);

CREATE TABLE recipes(
  id serial,

  bsn_number varchar,
  prescription_date date,
  end_date date,
  delivery_method varchar
);

CREATE TABLE recipe_medicines(
  id serial,

  package_id int,
  recipe_id int,
  usage text
);
