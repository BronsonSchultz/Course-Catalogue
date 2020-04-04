/* Set the width of the courseSideBar to 250px */
function openCourseSideBar(subjectCode, courseCode, courseName, description) {
  document.getElementById("courseSideBar").style.width = "275px";

  document.getElementById("subjectCode").innerHTML = subjectCode;
  document.getElementById("courseCode").innerHTML = courseCode;
  document.getElementById("courseName").innerHTML = courseName;
  document.getElementById("description").innerHTML = description;

}

/* Set the width of the sidebar to 0  */
function closeCourseSideBar() {
  document.getElementById("courseSideBar").style.width = "0";
}
