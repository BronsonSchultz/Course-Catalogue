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