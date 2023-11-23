We want you to write a microservice with the following functions:
(1) persists this data in a table on a simple database (relational or no sql). We use Oracle but MariaDB
etc are fine or other persistence method. Should be implemented as an endpoint eg putNaceDetails()
(2) retrieves all the information for a given NACE code, the data can be retrieved in any format you want
though typically this is JSON. So below we call eg getNaceDetails(398481) and it returns the data:
Order Leve
l
Cod
e
Paren
t
Description This item includes This
item
also
include
s
Ruling
s
This item excludes Referenc
e to ISIC
Rev. 4

39848
1
1 A AGRICULTURE
, FORESTRY
AND FISHING

This section includes the exploitation of
vegetal and animal natural resources,
comprising the activities of growing of
crops, raising and breeding of animals,
harvesting of timber and other plants,
animals or animal products from a farm or
their natural habitats.

A

The microservice should also (3) expose the REST API, using Swagger library.
The project should be maven-based, with ability to build an executable jar. It should also have unit tests for
java services and integration tests covering database operations.