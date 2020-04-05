/* Set the width of the courseSideBar to 250px */
function openCourseSideBar(subjectCode, courseCode, courseName, description) {

  document.getElementById("favouriteCheckbox").checked = false;
  document.getElementById("completedCheckbox").checked = false;

  document.getElementById("courseSideBar").style.width = "275px";

  document.getElementById("subject").innerHTML = subjectCode;
  document.getElementById("courseCode").innerHTML = courseCode;
  document.getElementById("courseName").innerHTML = courseName;
  document.getElementById("description").innerHTML = description;

   document.getElementById("hiddenSubject").value = subjectCode;
   document.getElementById("hiddenCourseCode").value = subjectCode;


}

/* Set the width of the sidebar to 0  */
function closeCourseSideBar() {
  document.getElementById("courseSideBar").style.width = "0";
}
