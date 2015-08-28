CREATE KEYSPACE prsley
 WITH replication = {
	'class' : 'SimpleStrategy',
	'replication_factor' : 1
 };
