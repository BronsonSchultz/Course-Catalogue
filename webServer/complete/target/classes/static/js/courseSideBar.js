/* Set the width of the courseSideBar to 275px */
function openCourseSideBar(subjectCode, courseCode, courseName, description) {

  document.getElementById("favouriteCheckbox").checked = false;
  document.getElementById("completedCheckbox").checked = false;

  document.getElementById("courseSideBar").style.width = "275px";

  document.getElementById("subject").innerHTML = subjectCode;
  document.getElementById("courseCode").innerHTML = courseCode;
  document.getElementById("courseName").innerHTML = courseName;
  document.getElementById("description").innerHTML = description;

   document.getElementById("hiddenSubject").value = subjectCode;
   document.getElementById("hiddenCourseCode").value = courseCode;
}

function closeCourseSideBar() {
  document.getElementById("courseSideBar").style.width = "0";
}


function openSimpleCourseSideBar(subjectCode, courseCode, courseName, description) {

  document.getElementById("simpleCourseSideBar").style.width = "275px";

  document.getElementById("subject").innerHTML = subjectCode;
  document.getElementById("courseCode").innerHTML = courseCode;
  document.getElementById("courseName").innerHTML = courseName;
  document.getElementById("description").innerHTML = description;
}

function closeSimpleCourseSideBar(){
  document.getElementById("simpleCourseSideBar").style.width = "0";
}
