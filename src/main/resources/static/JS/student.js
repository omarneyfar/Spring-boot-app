function DeleteStudent(id) {
  $.ajax({
    url: "delete-ajax",
    type: "POST",
    data: { 'id': id },
    success: function () {
      swal({
        title: "Are you sure?",
        text: "Once deleted, you will not be able to recover this imaginary file!",
        icon: "warning",
        buttons: true,
        dangerMode: true,
      }).then((willDelete) => {
        if (willDelete) {
          swal("Poof! Your imaginary file has been deleted!", {
            icon: "success",
          }).then(() => {
            $("#" + id).remove(); // Remove the element only after successful deletion
          });
        } else {
          swal("Your imaginary file is safe!");
        }
      });
    }
  });
}