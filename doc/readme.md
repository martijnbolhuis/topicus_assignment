# Run server

gradle bootRun

# Seed medicines into database

gradle seed

# cURL
curl -v -H "Content-Type: application/json" -XPOST \
  --data '{"bsn_number":"123456","prescription_date":"2018-08-24","end_date":"2018-09-28","delivery_method":"pickup","medicines":[{"medicine_form_id":1,"usage":"Twee keer per dag"}]}' \
  http://localhost:8080/recipes

# TODO
X Rename table package
- Make a JSON model
X Query N+1
- Enums + validations
- Test fout post
