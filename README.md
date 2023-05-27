# Genealogy
The aim of the project is to create an application for managing genealogy information about ancestors.

## Genealogy has following features:
- listing person, document, event, relation by id
- listing all persons, documents, events, relations
- adding a new person, document, event, relation
- updating existing person by id
- deleting existing person, document, event, relation by id
- listing all information about person by id (personal information, list of documents, list of events, list of relations)
- listing common ancestors for two people
- listing probability of the first name origin by country code

## Data validation in Genealogy:
- comments size in persons, documents, events, relations tables: max size = 255 characters
- sex: {"M", "F"}
- type of document: {"BIRTH_CERTIFICATE", "MARRIAGE_CERTIFICATE", "DEATH_CERTIFICATE", "ID_DOCUMENT", "OTHER_DOCUMENT"}
- type of event: {"BIRTH", "MARRIAGE", "DEATH"}
- type of relation: {"mother", "father", "wife", "husband", "children", "siblings"}
- event date in format: "yyyy-MM-dd"
- person first and second name: ^[A-ZĄĆĘŁŃÓŚŹŻa-ząćęłńóśźż]{3,20}$"
- person last na maiden name: ^[A-ZĄĆĘŁŃÓŚŹŻa-ząćęłńóśźż-]{3,20}$"

## To improve:
- verification whether people.sex fields are compatibility when adding new relationships

## Sample data:
- 200_create.http - requests POST data
- 200_delete.http - requests DELETE data
- 200_get.http - requests GET data
- 200_update.http - requests PUT data
- 404_delete.http - requests tries to DELETE id which no existing
- 404_get.http - requests tries to GET id which no existing
- 409_create.http - requests tries to add data that already exists
- 422_validation.http - requests tries to POST/PUT invalid data to check if the validation is working properly

## IDE:
IntelliJ IDEA 2022.2.2 (Ultimate Edition)
