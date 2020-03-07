DROP TABLE IF EXISTS Courses;
CREATE TABLE Courses(
        SubjectCode TEXT NOT NULL,
        CourseCode INTEGER NOT NULL,
        CourseName TEXT,
        Description TEXT,
        PRIMARY KEY(SubjectCode, CourseCode)
);

DROP TABLE IF EXISTS CreditConflicts;
CREATE TABLE CreditConflicts (
        CreditConflictID INTEGER NOT NULL,
        SubjectCode TEXT NOT NULL,
        CourseCode INTEGER NOT NULL,
        ConflictSubjectCode TEXT NOT NULL,
        ConflictCourseCode INTEGER NOT NULL,
        ConflictType TEXT,
        PRIMARY KEY(CreditConflictID)
);

DROP TABLE IF EXISTS DegreeRequirements;
CREATE TABLE DegreeRequirements(
        DegreeReqID INTEGER NOT NULL,
        ProgramName TEXT NOT NULL,
        Degree TEXT NOT NULL,
        SubjectCode TEXT NOT NULL,
        CourseCode INTEGER NOT NULL,
        RequirementType VARCHAR,
        ReqStatus VARCHAR,
        PRIMARY KEY(DegreeReqID)
);

DROP TABLE IF EXISTS Degrees;
CREATE TABLE Degrees (
        ProgramName TEXT NOT NULL,
        Degree TEXT NOT NULL,
        SchoolingLevel TEXT,
        RequirementsType TEXT,
        PRIMARY KEY(ProgramName, Degree)
);

DROP TABLE IF EXISTS Prerequisites;
CREATE TABLE Prerequisites (
        PrerequisiteID INTEGER NOT NULL,
        SubjectCode TEXT NOT NULL,
        CourseCode INTEGER NOT NULL,
        PrerequisiteSubjectCode TEXT NOT NULL,
        PrerequisiteCourseCode INTEGER NOT NULL,
        PRIMARY KEY(PrerequisiteID)
);

DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
        UserID INTEGER NOT NULL,
        Username TEXT NOT NULL UNIQUE,
        Password TEXT NOT NULL UNIQUE,
        PRIMARY KEY(UserID)
);

DROP TABLE IF EXISTS TestCompletedList;
CREATE TABLE TestCompletedList (
        CompletedCourseID INTEGER NOT NULL,
        SubjectCode TEXT NOT NULL,
        CourseCode INTEGER NOT NULL,
        PRIMARY KEY(CompletedCourseID)
);

DROP TABLE IF EXISTS TestFavouriteList;
CREATE TABLE TestFavouriteList (
        FavouriteID INTEGER NOT NULL,
        SubjectCode TEXT NOT NULL,
        CourseCode INTEGER NOT NULL,
        PRIMARY KEY(FavouriteID)
);