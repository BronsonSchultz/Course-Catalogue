SELECT COUNT(DISTINCT SubjectCode||CourseCode)
FROM Courses;

SELECT COUNT(DegreeReqID)
FROM DegreeRequirements;

SELECT COUNT(CreditConflictID)
FROM CreditConflicts;

SELECT *
FROM Degrees;
