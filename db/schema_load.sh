#! /usr/bin/env bash
script_location="$(dirname $0)"
psql -f $script_location/schema.sql topicus_assignment martijn
