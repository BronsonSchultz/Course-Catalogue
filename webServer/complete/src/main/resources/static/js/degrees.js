$(document).on('click', '#dropdown-menu a', function() {
   $("#dropdown-menu a").removeClass("active");
   $(this).addClass("active");
});

$('#dropdown-menu a').on('click', function (e) {
  e.preventDefault()
  $(this).tab('show')
})