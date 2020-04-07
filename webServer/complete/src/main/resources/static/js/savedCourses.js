$('#list-tab a:last-child').on('click', function (e) {
  e.preventDefault()
  console.log("called")
$('#list-tab a:last-child').tab('show')
})

$('#list-tab a:first-child').on('click', function (e) {
  e.preventDefault()
  console.log("called fav")
$('#list-tab a:first-child').tab('show')
})

$(document).on('click', '#list-tab a', function() {
   $("#list-tab a").removeClass("active");
   $(this).addClass("active");
});

function setData(subjectCode, courseCode){
    console.log("called")
   document.getElementById("hiddenSubject").value = subjectCode;
   document.getElementById("hiddenCourseCode").value = courseCode;
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