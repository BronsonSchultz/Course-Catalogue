SELECT COUNT(DISTINCT SubjectCode||CourseCode)
FROM Courses;

SELECT COUNT(DISTINCT DegreeReqID)
FROM DegreeRequirements;

SELECT COUNT(DISTINCT CreditConflictID)
FROM CreditConflicts;

SELECT COUNT(DISTINCT PrerequisiteID)
FROM Prerequisites;

SELECT *
FROM Degrees;
