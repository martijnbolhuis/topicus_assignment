DROP TABLE medicines;
DROP TABLE medicine_forms;
DROP TABLE recipes;
DROP TABLE recipe_medicines;

CREATE TABLE medicines(
  id serial,
  name varchar,

  created_at timestamp,
  updated_at timestamp
);

CREATE TABLE medicine_forms(
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
  delivery_method varchar,

  created_at timestamp,
  updated_at timestamp
);

CREATE TABLE recipe_medicines(
  id serial,

  medicine_form_id int,
  recipe_id int,
  usage text,

  created_at timestamp,
  updated_at timestamp
);
