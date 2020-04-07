.read db_upkeep/non-userData_createTables.sql
.mode csv
.import db_upkeep/Archives/00-CurArchive/Courses_archive.csv Courses
.import db_upkeep/Archives/00-CurArchive/non-CMPTDegree_Courses_archive.csv Courses
.import db_upkeep/Archives/00-CurArchive/Degrees_archive.csv Degrees
.import db_upkeep/Archives/00-CurArchive/CreditConflicts_archive.csv CreditConflicts
.import db_upkeep/Archives/00-CurArchive/DegreeRequirements_archive.csv DegreeRequirements
.import db_upkeep/Archives/00-CurArchive/Prerequisites_archive.csv Prerequisites
.import db_upkeep/Archives/00-CurArchive/Users_archive.cs Users
.import db_upkeep/Archives/00-CurArchive/CompletedList_archive.csv CompletedList
.import db_upkeep/Archives/00-CurArchive/FavouriteList_archive.csv FavouriteList 
.mode list
