.mode csv
.output Courses_archive.csv
SELECT * FROM Courses;

.output Degrees_archive.csv
SELECT * FROM Degrees;

.output DegreeRequirements_archive.csv
SELECT * FROM DegreeRequirements;

.output Prerequisites_archive.csv
SELECT * FROM Prerequisites;

.output CreditConflicts_archive.csv
SELECT * FROM CreditConflicts;

.mode list