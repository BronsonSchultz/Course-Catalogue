SELECT COUNT(DISTINCT SubjectCode||CourseCode)
FROM Courses;

SELECT COUNT(DISTINCT DegreeReqID)
FROM DegreeRequirements;

SELECT COUNT(DISTINCT CreditConflictID)
FROM CreditConflicts;

SELECT *
FROM Degrees;
