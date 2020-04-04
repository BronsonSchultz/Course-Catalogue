PRAGMA foreign_keys = off;

DROP TABLE IF EXISTS Courses;
CREATE TABLE Courses(
        SubjectCode NCHAR(4) NOT NULL,
        CourseCode INTEGER NOT NULL
           CHECK(CourseCode BETWEEN 100 AND 999),
        CourseName TEXT,
        Description TEXT,
        PRIMARY KEY(SubjectCode, CourseCode)
);

DROP TABLE IF EXISTS CreditConflicts;
CREATE TABLE CreditConflicts (
        CreditConflictID INTEGER NOT NULL,
        SubjectCode NCHAR(4) NOT NULL,
        CourseCode INTEGER NOT NULL,
        ConflictSubjectCode NCHAR(4) NOT NULL,
        ConflictCourseCode INTEGER NOT NULL,
        ConflictType TEXT DEFAULT 'Regular'
           CHECK(ConflictType IN ('Regular', 'Previous Name', 'Other')),
        PRIMARY KEY(CreditConflictID),
        FOREIGN KEY(SubjectCode, CourseCode) REFERENCES Courses (SubjectCode, CourseCode)
           ON UPDATE CASCADE
           ON DELETE CASCADE,
        FOREIGN KEY(ConflictSubjectCode, ConflictCourseCode) REFERENCES Courses (SubjectCode, CourseCode)
           ON UPDATE NO ACTION
           ON DELETE NO ACTION
);

DROP TABLE IF EXISTS Degrees;
CREATE TABLE Degrees (
        ProgramName TEXT NOT NULL,
        Degree TEXT NOT NULL,
        SchoolingLevel TEXT
           CHECK(SchoolingLevel IN ('Undergraduate', 'Graduate', 'Non-Degree Certificate')),
        RequirementsType TEXT
           CHECK(RequirementsType IN ('ByYear', 'ByCategory')),
        CurrentlyOffered INTEGER NOT NULL DEFAULT 1
           -- 1 is yes, 0 is no
           CHECK(CurrentlyOffered IN (0, 1)),
        PRIMARY KEY(ProgramName, Degree)
);

DROP TABLE IF EXISTS DegreeRequirements;
CREATE TABLE DegreeRequirements(
        DegreeReqID INTEGER NOT NULL,
        ProgramName TEXT NOT NULL,
        Degree TEXT NOT NULL,
        SubjectCode NCHAR(4) NOT NULL,
        CourseCode INTEGER NOT NULL,
        RequirementsGroup TEXT,
        ReqStatus TEXT,
        PRIMARY KEY(DegreeReqID),
        FOREIGN KEY(ProgramName, Degree) REFERENCES Degrees (ProgramName, Degree)
           ON UPDATE CASCADE
           ON DELETE RESTRICT
);

DROP TABLE IF EXISTS Prerequisites;
CREATE TABLE Prerequisites (
        PrerequisiteID INTEGER NOT NULL,
        SubjectCode NCHAR(4) NOT NULL,
        CourseCode INTEGER NOT NULL,
        PrerequisiteSubjectCode NCHAR(4) NOT NULL,
        PrerequisiteCourseCode INTEGER NOT NULL,
        OneOf INTEGER,
        TwoOf INTEGER,
        Outliers TEXT,
        PRIMARY KEY(PrerequisiteID),
        FOREIGN KEY(SubjectCode, CourseCode) REFERENCES Courses (SubjectCode, CourseCode)
           ON UPDATE CASCADE
           ON DELETE CASCADE,
        FOREIGN KEY(PrerequisiteSubjectCode, PrerequisiteCourseCode) REFERENCES Courses (SubjectCode, CourseCode)
           ON UPDATE NO ACTION
           ON DELETE NO ACTION
);

DROP TABLE IF EXISTS Users;
CREATE TABLE Users (
        UserID INTEGER NOT NULL,
        Username TEXT NOT NULL UNIQUE,
        Password TEXT NOT NULL UNIQUE,
        PRIMARY KEY(UserID)
);

DROP TABLE IF EXISTS CompletedList;
CREATE TABLE TestCompletedList (
        CompletedCourseID INTEGER NOT NULL,
        SubjectCode NCHAR(4) NOT NULL,
        CourseCode INTEGER NOT NULL,
        UserID INTEGER NOT NULL,
        PRIMARY KEY(CompletedCourseID),
        FOREIGN KEY(SubjectCode, CourseCode) REFERENCES Courses (SubjectCode, CourseCode)
           ON UPDATE CASCADE
           ON DELETE CASCADE,
        FOREIGN KEY(UserID)
           ON UPDATE CASCADE
           ON DELETE CASCADE
);

DROP TABLE IF EXISTS FavouriteList;
CREATE TABLE TestFavouriteList (
        FavouriteID INTEGER NOT NULL,
        SubjectCode NCHAR(4) NOT NULL,
        CourseCode INTEGER NOT NULL,
        UserID INTEGER NOT NULL,
        PRIMARY KEY(FavouriteID),
        FOREIGN KEY(SubjectCode, CourseCode) REFERENCES Courses (SubjectCode, CourseCode)
           ON UPDATE CASCADE
           ON DELETE CASCADE,
        FOREIGN KEY(UserID)
           ON UPDATE CASCADE
           ON DELETE CASCADE
);

PRAGMA foreign_keys = on;