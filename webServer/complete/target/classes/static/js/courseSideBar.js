/* Set the width of the courseSideBar to 250px */
function openCourseSideBar(subjectCode, courseCode, courseName, description) {
   console.log("called")

  document.getElementById("favouriteCheckbox").checked = false;
  document.getElementById("completedCheckbox").checked = false;

  document.getElementById("courseSideBar").style.width = "275px";

  document.getElementById("subject").innerHTML = subjectCode;
  document.getElementById("courseCode").innerHTML = courseCode;
  document.getElementById("courseName").innerHTML = courseName;
  document.getElementById("description").innerHTML = description;

   document.getElementById("hiddenSubject").value = subjectCode;
   console.log(document.getElementById("hiddenSubject").value)
   document.getElementById("hiddenCourseCode").value = courseCode;


}

/* Set the width of the sidebar to 0  */
function closeCourseSideBar() {
  document.getElementById("courseSideBar").style.width = "0";
}
