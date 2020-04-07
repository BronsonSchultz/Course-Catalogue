.mode csv
.output Users_archive.csv
SELECT * FROM Users;

.output FavouriteList_archive.csv
SELECT * FROM FavouriteList;

.output CompletedList_archive.csv
SELECT * FROM CompletedList;

.mode list